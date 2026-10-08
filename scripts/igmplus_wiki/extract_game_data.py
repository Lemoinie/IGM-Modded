#!/usr/bin/env python3
"""Extract IGM-Modded game data from Kotlin sources into JSON for the mod wiki.

Stdlib-only (no third-party dependencies). See docs/scripts.md.

Outputs (default: <repo>/igmplus_wiki/data/):
  strings.json, skills.json, traits.json, doctrine_abilities.json, doctrines.json,
  units_adventurers.json, units_enemies.json, items.json, recipes.json,
  places.json, changelog.json, sprites.json, meta.json

Usage:
  python scripts/igmplus_wiki/extract_game_data.py [--repo ROOT] [--out DIR]
"""

from __future__ import annotations

import argparse
import json
import re
import sys
from pathlib import Path

# --------------------------------------------------------------------------
# Paths
# --------------------------------------------------------------------------

SCRIPT_DIR = Path(__file__).resolve().parent
DEFAULT_REPO = SCRIPT_DIR.parents[1]  # scripts/igmplus_wiki -> repo root
KOTLIN_BASE = Path(
    "app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster"
)
RES_BASE = Path("app/src/main/res")


def p(repo: Path, *parts: str) -> Path:
    return repo.joinpath(*parts)


# --------------------------------------------------------------------------
# Generic helpers
# --------------------------------------------------------------------------

def read_text(path: Path) -> str:
    return path.read_text(encoding="utf-8", errors="replace")


def write_json(out_dir: Path, name: str, data) -> None:
    out_dir.mkdir(parents=True, exist_ok=True)
    target = out_dir / name
    target.write_text(
        json.dumps(data, indent=2, ensure_ascii=False) + "\n",
        encoding="utf-8",
    )
    print(f"  wrote {target.name} ({_count(data)} entries)")


def _count(data) -> int:
    if isinstance(data, (dict, list)):
        return len(data)
    return 1


def extract_function_body(text: str, func: str) -> str | None:
    """Return the body of `fun <func>(...)`, supporting both brace and
    `= expression` bodies. Returns None when not found."""
    m = re.search(rf"\bfun\s+{re.escape(func)}\s*\(", text)
    if not m:
        return None
    i = m.end() - 1  # at '('
    depth = 0
    while i < len(text):
        if text[i] == "(":
            depth += 1
        elif text[i] == ")":
            depth -= 1
            if depth == 0:
                i += 1
                break
        i += 1
    rest = text[i:]
    # skip a return-type annotation (e.g. `: MutableList<Enemy>`) before body
    ann = re.match(r"\s*(?::\s*[^={;]+)", rest)
    if ann:
        rest = rest[ann.end() :]
    rest_l = rest.lstrip()
    if rest_l.startswith("{"):
        start = len(rest) - len(rest_l)
        depth = 0
        j = start
        while j < len(text):
            if text[j] == "{":
                depth += 1
            elif text[j] == "}":
                depth -= 1
                if depth == 0:
                    return text[start + 1 : j]
            j += 1
        return text[start + 1 :]
    if rest_l.startswith("="):
        expr = rest_l[1:]
        depth = 0
        for k, ch in enumerate(expr):
            if ch in "([{":
                depth += 1
            elif ch in ")]}":
                depth -= 1
            elif ch == "\n" and depth <= 0:
                return expr[:k]
        return expr.strip()
    return None


LITERAL_RE = re.compile(r"^(?P<val>-?\d+(?:\.\d+)?)[Ll]?$|^(?P<bool>true|false)$")


def parse_assignments(body: str | None) -> dict:
    """Parse simple `name = value` assignments from a Kotlin body."""
    out: dict = {}
    if not body:
        return out
    for raw in body.splitlines():
        line = raw.strip()
        m = re.match(r"^([A-Za-z_]\w*)\s*=\s*(.+?)(?:\s*//.*)?$", line)
        if not m:
            continue
        key, val = m.group(1), m.group(2).rstrip()
        if val.endswith(","):
            val = val[:-1].strip()
        lit = LITERAL_RE.match(val)
        if lit:
            if lit.group("bool"):
                out[key] = lit.group("bool") == "true"
            else:
                num = lit.group("val")
                out[key] = float(num) if "." in num else int(num)
        elif re.match(r"^[A-Za-z_][\w.]*$", val):
            out[key] = val  # enum-ish reference kept raw (Skills.X, R.string.y)
        # complex expressions are skipped (captured elsewhere when needed)
    return out



def parse_enum_string_pairs(text: str, enum_name: str) -> list[dict]:
    """Parse `NAME(R.string.x_name, R.string.x_description)` enum entries."""
    m = re.search(rf"enum\s+class\s+{enum_name}\b", text)
    if not m:
        return []
    body = text[m.end() :]
    entries = []
    pat = re.compile(
        r"^\s*([A-Z][A-Z0-9_]*)\s*\(\s*R\.string\.(\w+)\s*,\s*R\.string\.(\w+)\s*\)",
        re.M,
    )
    for em in pat.finditer(body):
        entries.append(
            {"key": em.group(1), "name_key": em.group(2), "desc_key": em.group(3)}
        )
    return entries


def unescape_android(s: str) -> str:
    s = s.replace("\\n", "\n").replace("\\t", "\t")
    s = s.replace('\\"', '"').replace("\\'", "'").replace("\\\\", "\\")
    return s


# --------------------------------------------------------------------------
# strings.xml
# --------------------------------------------------------------------------

def parse_strings(repo: Path) -> dict:
    text = read_text(p(repo, RES_BASE, "values", "strings.xml"))
    out: dict = {}
    cdata = re.compile(r"<!\[CDATA\[(.*?)\]\]>", re.S)
    plain = re.compile(r'<string name="([^"]+)"\s*>(.*?)</string>', re.S)
    for m in cdata.finditer(text):
        out[m.group(1)] = unescape_android(m.group(2).strip())
    stripped = cdata.sub("", text)
    for m in plain.finditer(stripped):
        key, val = m.group(1), m.group(2)
        val = re.sub(r"<[^>]+>", "", val)  # drop inline markup tags
        out[key] = unescape_android(val.strip())
    return out


def resolve(strings: dict, key: str | None) -> str | None:
    if not key:
        return None
    return strings.get(key)


# --------------------------------------------------------------------------
# Skills & Traits (enums with R.string pairs)
# --------------------------------------------------------------------------

def skill_kind(key: str) -> str:
    if key.startswith("ULTIMATE_"):
        return "ultimate"
    if key.startswith("ACTIVE_"):
        return "active"
    if key.startswith("PASSIVE_"):
        return "passive"
    return "other"


def parse_skills(repo: Path, strings: dict) -> list[dict]:
    text = read_text(p(repo, KOTLIN_BASE, "storage/data/entities/Skills.kt"))
    out = []
    for e in parse_enum_string_pairs(text, "Skills"):
        e["kind"] = skill_kind(e["key"])
        e["name"] = resolve(strings, e["name_key"]) or e["key"]
        e["description"] = resolve(strings, e["desc_key"])
        out.append(e)
    return out


def parse_traits(repo: Path, strings: dict) -> list[dict]:
    text = read_text(
        p(repo, KOTLIN_BASE, "storage/data/entities/adventurers/Trait.kt")
    )
    out = []
    for e in parse_enum_string_pairs(text, "Trait"):
        e["plus"] = e["key"].endswith("_PLUS")
        e["name"] = resolve(strings, e["name_key"]) or e["key"]
        e["description"] = resolve(strings, e["desc_key"])
        out.append(e)
    return out


STATUS_EFFECT_RE = re.compile(
    r"^\s*([A-Z][A-Z0-9_]*)\s*\(\s*"
    r"R\.string\.(\w+)\s*,\s*"
    r"R\.string\.(\w+)\s*,\s*"
    r"R\.drawable\.(\w+)\s*,\s*"
    r"(true|false)\s*,\s*(true|false)\s*\)",
    re.M,
)


def parse_status_effects(repo: Path, strings: dict, sprites: dict) -> list[dict]:
    text = read_text(
        p(repo, KOTLIN_BASE, "storage/data/entities/StatusEffectType.kt")
    )
    out = []
    for m in STATUS_EFFECT_RE.finditer(text):
        sprite = m.group(4)
        sprites.setdefault(sprite, []).append(f"status_effect:{m.group(1)}")
        out.append(
            {
                "key": m.group(1),
                "name_key": m.group(2),
                "desc_key": m.group(3),
                "sprite": sprite,
                "negative": m.group(5) == "true",
                "serialized": m.group(6) == "true",
                "name": resolve(strings, m.group(2)) or m.group(1),
                "description": resolve(strings, m.group(3)),
            }
        )
    return out


# --------------------------------------------------------------------------
# Doctrines
# --------------------------------------------------------------------------

DOCTRINE_ABILITY_RE = re.compile(
    r"^\s*([A-Z][A-Z0-9_]*)\s*\(\s*"
    r"R\.string\.(\w+)\s*,\s*"
    r"R\.string\.(\w+)\s*,\s*"
    r"R\.drawable\.(\w+)\s*,\s*"
    r"(-?\d+)\s*,\s*(-?\d+)\s*,\s*(-?\d+)\s*,\s*(-?\d+)\s*,\s*(-?\d+)\s*\)",
    re.M,
)


def parse_doctrine_abilities(repo: Path, strings: dict) -> list[dict]:
    text = read_text(
        p(
            repo,
            KOTLIN_BASE,
            "storage/data/entities/adventurers/doctrines/DoctrineAbilityType.kt",
        )
    )
    out = []
    for m in DOCTRINE_ABILITY_RE.finditer(text):
        out.append(
            {
                "key": m.group(1),
                "name_key": m.group(2),
                "desc_key": m.group(3),
                "sprite": m.group(4),
                "cost": int(m.group(5)),
                "increase_per_level": int(m.group(6)),
                "format_mode": int(m.group(7)),
                "max_level": int(m.group(8)),
                "row": int(m.group(9)),
                "name": resolve(strings, m.group(2)) or m.group(1),
                "description": resolve(strings, m.group(3)),
            }
        )
    return out


def parse_doctrines(repo: Path, strings: dict, sprites: dict) -> list[dict]:
    base = p(
        repo, KOTLIN_BASE, "storage/data/entities/adventurers/doctrines/instances"
    )
    out = []
    for path in sorted(base.glob("*.kt")):
        text = read_text(path)
        cm = re.search(r"class\s+(\w+)\s*:\s*Doctrine\s*\(", text)
        if not cm:
            continue
        key = cm.group(1)
        values_body = extract_function_body(text, "setupValues") or ""
        asg = parse_assignments(values_body)
        # also catch `idName = R.string.x` style (non-literal handled below)
        for field in ("idName", "idDescription", "idDescriptionShort"):
            m = re.search(rf"{field}\s*=\s*R\.string\.(\w+)", values_body)
            if m:
                asg[field] = f"R.string.{m.group(1)}"
        m = re.search(r"idImage\s*=\s*R\.drawable\.(\w+)", values_body)
        sprite = m.group(1) if m else None
        if sprite:
            sprites.setdefault(sprite, []).append(f"doctrine:{key}")
        ab_body = extract_function_body(text, "setupAbilities") or ""
        abilities = re.findall(r"DoctrineAbilityType\.([A-Z0-9_]+)", ab_body)
        name_key = _rstr(asg.get("idName"))
        desc_key = _rstr(asg.get("idDescription"))
        short_key = _rstr(asg.get("idDescriptionShort"))
        # effects: `override fun x(): T = getValue(...)` / boolean comparisons
        effects = {}
        for em in re.finditer(
            r"override\s+fun\s+(\w+)\s*\([^)]*\)(?:\s*:\s*[\w<>?]+)?\s*=\s*(.+)",
            text,
        ):
            effects[em.group(1)] = em.group(2).strip()
        out.append(
            {
                "key": key,
                "name_key": name_key,
                "description_key": desc_key,
                "description_short_key": short_key,
                "sprite": sprite,
                "name": resolve(strings, name_key) or key,
                "description": resolve(strings, desc_key),
                "description_short": resolve(strings, short_key),
                "abilities": abilities,
                "effects": effects,
            }
        )
    return out


def _rstr(val) -> str | None:
    if isinstance(val, str) and val.startswith("R.string."):
        return val[len("R.string.") :]
    return None


# --------------------------------------------------------------------------
# Units: adventurers (promotion graph, dynamic tiers) and enemies
# --------------------------------------------------------------------------

STAT_FIELDS = {
    "maxLevel", "baseMaxHp", "baseConstitution", "baseIntelligence",
    "baseDexterity", "baseDefense", "baseMagicDefense", "baseLifesteal",
    "attackSpeed", "counterattack", "criticalDamage", "criticalChance",
    "regeneration", "flatDodgeChance", "immunityToStatus",
    "darknessDamageAmplification", "retaliationPhysicalDamage",
    "retaliationMagicalDamage", "healingModifier",
}


def parse_adventurer_units(repo: Path, strings: dict, sprites: dict) -> dict:
    base = p(repo, KOTLIN_BASE, "storage/data/entities/adventurers/units")
    units: dict = {}
    for path in sorted(base.glob("*.kt")):
        text = read_text(path)
        cm = re.search(r"class\s+(\w+)\s*:\s*(\w+)\s*\(", text)
        if not cm:
            continue
        key, parent = cm.group(1), cm.group(2)
        body = extract_function_body(text, "configureStatistics") or ""
        asg = parse_assignments(body)
        stats = {k: v for k, v in asg.items() if k in STAT_FIELDS}
        m = re.search(r"imageId\s*=\s*R\.drawable\.(\w+)", body)
        sprite = m.group(1) if m else None
        if sprite:
            sprites.setdefault(sprite, []).append(f"unit:{key}")
        name_key = re.search(r"idName\s*=\s*R\.string\.(\w+)", body)
        desc_key = re.search(r"idDescription\s*=\s*R\.string\.(\w+)", body)
        active = re.search(r"activeSkill\s*=\s*Skills\.([A-Z0-9_]+)", body)
        passive = re.search(r"passiveSkill\s*=\s*Skills\.([A-Z0-9_]+)", body)
        weapon = re.search(r"weaponType\s*=\s*R\.string\.(\w+)", body)
        armor = re.search(r"armorType\s*=\s*R\.string\.(\w+)", body)
        potion = re.search(r"potionDrinkerType\s*=\s*(\w+)", body)
        next_classes = re.findall(r'nextClasses\.add\("(\w+)"\)', body)
        units[key] = {
            "key": key,
            "parent": parent,
            "sprite": sprite,
            "name_key": name_key.group(1) if name_key else None,
            "description_key": desc_key.group(1) if desc_key else None,
            "name": resolve(strings, name_key.group(1)) if name_key else key,
            "description": resolve(strings, desc_key.group(1)) if desc_key else None,
            "stats": stats,
            "max_level": stats.get("maxLevel"),
            "weapon_type": weapon.group(1) if weapon else None,
            "armor_type": armor.group(1) if armor else None,
            "potion_drinker_type": potion.group(1) if potion else None,
            "active_skill": active.group(1) if active else None,
            "passive_skill": passive.group(1) if passive else None,
            "next_classes": next_classes,
            "tier": None,
        }
    assign_tiers(units)
    return {"units": list(units.values()), "tiers": _tier_summary(units)}


def assign_tiers(units: dict) -> None:
    """Tier = BFS depth from unpromoted roots (units never listed as a
    promotion target). Dynamic: no hardcoded T1-T9."""
    targeted: set[str] = set()
    for u in units.values():
        targeted.update(u["next_classes"])
    roots = [k for k in units if k not in targeted]
    for mk in targeted - set(units):
        units[mk] = {"key": mk, "next_classes": [], "tier": None, "missing": True}
    for r in roots:
        units[r]["tier"] = 1
    changed = True
    guard = 0
    while changed and guard < 64:
        changed = False
        guard += 1
        for u in units.values():
            if u.get("tier") is None:
                continue
            for child in u.get("next_classes", []):
                cu = units.get(child)
                if cu is None:
                    continue
                ct = u["tier"] + 1
                if cu.get("tier") is None or ct > cu["tier"]:
                    cu["tier"] = ct
                    changed = True


def _tier_summary(units: dict) -> dict:
    out: dict = {}
    for u in units.values():
        t = u.get("tier")
        if t is None:
            continue
        out.setdefault(str(t), []).append(u["key"])
    for v in out.values():
        v.sort()
    return out


def parse_logger_constants(repo: Path) -> dict[str, int]:
    logger_path = p(repo, KOTLIN_BASE, "storage/data/places/Logger.kt")
    consts: dict[str, int] = {}
    if not logger_path.is_file():
        return consts
    text = read_text(logger_path)
    for m in re.finditer(r"const\s+val\s+(\w+)\s*(?::\s*\w+)?\s*=\s*([0-9]+)", text):
        name, val = m.group(1), int(m.group(2))
        consts[name] = val
        consts[f"Logger.{name}"] = val
        consts[f"`Logger.{name}`"] = val
    return consts


def parse_enemy_units(repo: Path, strings: dict, sprites: dict, logger_consts: dict | None = None) -> list[dict]:
    if logger_consts is None:
        logger_consts = parse_logger_constants(repo)
    base = p(repo, KOTLIN_BASE, "storage/data/entities/enemies/units")
    out = []
    for path in sorted(base.glob("*.kt")):
        text = read_text(path)
        cm = re.search(r"class\s+(\w+)\s*:\s*(\w+)\s*\(", text)
        if not cm:
            continue
        key, parent = cm.group(1), cm.group(2)
        body = extract_function_body(text, "configureStatistics") or ""
        asg = parse_assignments(body)
        stats = {k: v for k, v in asg.items() if k in STAT_FIELDS}
        for k, v in list(stats.items()):
            if isinstance(v, str) and v in logger_consts:
                stats[k] = logger_consts[v]
        m = re.search(r"imageId\s*=\s*R\.drawable\.(\w+)", body)
        sprite = m.group(1) if m else None
        if sprite:
            sprites.setdefault(sprite, []).append(f"enemy:{key}")
        name_key = re.search(r"idName\s*=\s*R\.string\.(\w+)", body)
        desc_key = re.search(r"idDescription\s*=\s*R\.string\.(\w+)", body)
        min_dmg = extract_function_body(text, "getMinDamage")
        max_dmg = extract_function_body(text, "getMaxDamage")
        min_dmg_clean = (min_dmg or "").strip()
        max_dmg_clean = (max_dmg or "").strip()
        for lk, lv in logger_consts.items():
            min_dmg_clean = min_dmg_clean.replace(lk, str(lv))
            max_dmg_clean = max_dmg_clean.replace(lk, str(lv))
        out.append(
            {
                "key": key,
                "parent": parent,
                "sprite": sprite,
                "name_key": name_key.group(1) if name_key else None,
                "description_key": desc_key.group(1) if desc_key else None,
                "name": resolve(strings, name_key.group(1)) if name_key else key,
                "description": resolve(strings, desc_key.group(1)) if desc_key else None,
                "stats": stats,
                "exp_given": asg.get("expGiven"),
                "rarity": asg.get("rarity"),
                "is_boss": bool(re.search(r"isBoss\s*=\s*true", text)),
                "min_damage": min_dmg_clean or None,
                "max_damage": max_dmg_clean or None,
                "drops": _parse_list_drops(text),
                "independent_drops": _parse_independent_drops(text),
            }
        )
    return out


DROP_PUT_RE = re.compile(
    r"ItemWrapper\.getInstance\(\"(\w+)\",\s*([0-9]+)\)\s*,\s*([0-9]+)\s*\)",
    re.S,
)


def _parse_list_drops(text: str) -> list[dict]:
    """Weighted drop table; weights are per-mille (out of 1000). The default
    rollDrops() picks a single entry from this weighted map."""
    body = extract_function_body(text, "listDrops") or ""
    return [
        {"item": m.group(1), "qty": int(m.group(2)), "weight": int(m.group(3))}
        for m in DROP_PUT_RE.finditer(body)
    ]


def _parse_independent_drops(text: str) -> list[dict]:
    """Boss overrides: `if (Utils.random() < 0.01) rolled.add(...getInstance("X", n))`"""
    out = []
    body = extract_function_body(text, "rollDrops") or ""
    pat = re.compile(
        r"Utils\.random\(\)\s*<\s*([0-9.]+)\s*\)[^\n]*?getInstance\(\"(\w+)\",\s*([0-9]+)\)",
        re.S,
    )
    for m in pat.finditer(body):
        out.append(
            {
                "item": m.group(2),
                "qty": int(m.group(3)),
                "chance": float(m.group(1)),
            }
        )
    return out


# --------------------------------------------------------------------------
# Items (instances + abstract class hierarchy) and Recipes
# --------------------------------------------------------------------------

def _parse_class_files(base: Path) -> dict:
    """Map class name -> parent class name for all .kt files under base."""
    out: dict = {}
    for path in base.rglob("*.kt"):
        text = read_text(path)
        m = re.search(r"(?:abstract\s+)?class\s+(\w+)\s*(?:\([^)]*\))?\s*:\s*(\w+)", text)
        if m:
            out[m.group(1)] = m.group(2)
    return out


OVERRIDE_ONE_LINER_RE = re.compile(
    r"override\s+fun\s+(\w+)\s*\([^)]*\)(?:\s*:\s*[\w<>?]+)?\s*=\s*(.+)"
)


def parse_items(repo: Path, strings: dict, sprites: dict) -> dict:
    items_base = p(repo, KOTLIN_BASE, "storage/data/items")
    abstract_base = items_base / "abstractClasses"
    instances_base = items_base / "instances"

    parents: dict = {}
    parents.update(_parse_class_files(abstract_base))
    parents.update(_parse_class_files(instances_base))
    parents["Item"] = None

    abstract_classes = []
    for path in sorted(abstract_base.glob("*.kt")):
        text = read_text(path)
        m = re.search(r"abstract\s+class\s+(\w+)\s*(?:\([^)]*\))?\s*(?::\s*(\w+))?", text)
        if not m:
            continue
        methods = {}
        for om in OVERRIDE_ONE_LINER_RE.finditer(text):
            methods.setdefault(om.group(1), om.group(2).strip())
        for om in re.finditer(
            r"(?:open|abstract)\s+fun\s+(\w+)\s*\([^)]*\)(?:\s*:\s*[\w<>?]+)?\s*=\s*(.+)",
            text,
        ):
            methods.setdefault(om.group(1), om.group(2).strip())
        abstract_classes.append(
            {"key": m.group(1), "parent": m.group(2), "defaults": methods}
        )

    abstract_set = {a["key"] for a in abstract_classes}

    items = []
    for path in sorted(instances_base.rglob("*.kt")):
        text = read_text(path)
        cm = re.search(r"class\s+(\w+)\s*(?:\([^)]*\))?\s*:\s*(\w+)", text)
        if not cm:
            continue
        key, parent = cm.group(1), cm.group(2)
        body = extract_function_body(text, "configureProperties") or ""
        asg = parse_assignments(body)
        sprite = None
        m = re.search(r"idImage\s*=\s*R\.drawable\.(\w+)", body)
        if m:
            sprite = m.group(1)
            sprites.setdefault(sprite, []).append(f"item:{key}")
        name_key = re.search(r"idName\s*=\s*R\.string\.(\w+)", body)
        desc_key = re.search(r"idDescription\s*=\s*R\.string\.(\w+)", body)
        stats = {
            k: v
            for k, v in asg.items()
            if isinstance(v, (int, float))
            and not isinstance(v, bool)
            and k not in ("price", "rarity", "stack", "gemValue")
        }
        flags = {
            k: v
            for k, v in asg.items()
            if isinstance(v, bool)
        }
        overrides = {}
        for om in OVERRIDE_ONE_LINER_RE.finditer(text):
            overrides.setdefault(om.group(1), om.group(2).strip())
        chain = _class_chain(key, parents)
        category = next(
            (c for c in chain[1:] if c in abstract_set), None
        )
        items.append(
            {
                "key": key,
                "parent": parent,
                "class_chain": chain,
                "category": category,
                "sprite": sprite,
                "name_key": name_key.group(1) if name_key else None,
                "description_key": desc_key.group(1) if desc_key else None,
                "name": resolve(strings, name_key.group(1)) if name_key else key,
                "description": resolve(strings, desc_key.group(1)) if desc_key else None,
                "price": asg.get("price"),
                "rarity": asg.get("rarity"),
                "stack": asg.get("stack"),
                "gem_value": asg.get("gemValue"),
                "stats": stats,
                "flags": flags,
                "overrides": overrides,
                "file": str(path.relative_to(repo)).replace("\\", "/"),
            }
        )
    return {"base_classes": abstract_classes, "items": items}


def _class_chain(start: str, parents: dict, limit: int = 16) -> list[str]:
    chain = [start]
    cur = parents.get(start)
    seen = {start}
    while cur and cur not in seen and len(chain) < limit:
        chain.append(cur)
        seen.add(cur)
        cur = parents.get(cur)
    return chain


RECIPE_RE = re.compile(r"^\s*(\w+)\s*\((.*)\)\s*,?\s*$")
RECIPE_ITEM_RE = re.compile(r"Item\.getInstance\(\"(\w+)\",\s*([^)]+)\)")


def parse_recipes(repo: Path) -> list[dict]:
    text = read_text(p(repo, KOTLIN_BASE, "storage/data/items/Recipes.kt"))
    m = re.search(r"enum\s+class\s+Recipes\b", text)
    if not m:
        return []
    body = text[m.end() :]
    out = []
    for line in body.splitlines():
        lm = RECIPE_RE.match(line)
        if not lm:
            continue
        key, args = lm.group(1), lm.group(2)
        if key == "Recipes" or "getInstance" not in args:
            continue
        ingredients = []
        for im in RECIPE_ITEM_RE.finditer(args):
            raw_qty = im.group(2).strip()
            qty: int | str
            try:
                qty = int(raw_qty)
            except ValueError:
                qty = raw_qty  # e.g. Logger.BARD_SHIELD constant
            ingredients.append({"item": im.group(1), "qty": qty})
        if ingredients:
            out.append(
                {"key": key, "output_item": key, "ingredients": ingredients}
            )
    return out


# --------------------------------------------------------------------------
# Places (areas / dungeons / merchants)
# --------------------------------------------------------------------------

def parse_places(repo: Path, strings: dict, sprites: dict) -> list[dict]:
    base = p(repo, KOTLIN_BASE, "storage/data/places")
    out = []
    for path in sorted(base.rglob("*.kt")):
        if path.name in ("Area.kt", "Event.kt", "Logger.kt"):
            continue
        text = read_text(path)
        cm = re.search(r"class\s+(\w+)\s*(?::\s*(\w+))?\s*(?:\(|\{|\s*$)", text)
        if not cm or not cm.group(2):
            continue  # skip parentless engine helpers (Action, AdventureRecap, ...)
        key, parent = cm.group(1), cm.group(2)
        name_m = re.search(
            r"fun\s+getName\s*\(\s*\)[^{=]*(?:=\s*R\.string\.(\w+))", text
        )
        summary_m = re.search(r"fun\s+getSummaryDrawable\s*\(\s*\)[^{=]*=\s*R\.drawable\.(\w+)", text)
        detail_m = re.search(r"fun\s+getDetailDrawable\s*\(\s*\)[^{=]*=\s*R\.drawable\.(\w+)", text)
        area_type_m = re.search(r"fun\s+getAreaType\s*\(\s*\)[^{=]*=\s*(\d+)", text)
        level_m = re.search(r"fun\s+getLevel\s*\(\s*\)[^{=]*=\s*(\d+)", text)
        for sprite, usage in (
            (summary_m.group(1) if summary_m else None, f"place:{key}:summary"),
            (detail_m.group(1) if detail_m else None, f"place:{key}:detail"),
        ):
            if sprite:
                sprites.setdefault(sprite, []).append(usage)
        name_key = name_m.group(1) if name_m else None
        enemies, encounter = _parse_roll_enemies(text)
        # Also discover any enemy spawned via events/scripts in the area file:
        all_file_enemies = set(re.findall(r'Enemy\.getInstance\("(\w+)"', text))
        existing_keys = {e["key"] for e in enemies}
        for ek in sorted(all_file_enemies - existing_keys):
            if ek != "TutorialWolf":  # skip dummy tutorial enemy
                enemies.append({"key": ek, "chance_permille": None})
        # Remove TutorialWolf if it was captured
        enemies = [e for e in enemies if e["key"] != "TutorialWolf"]
        items_mentioned = sorted(set(re.findall(r'Item\.getInstance\("(\w+)"', text)))
        out.append(
            {
                "key": key,
                "parent": parent,
                "file": str(path.relative_to(repo)).replace("\\", "/"),
                "name_key": name_key,
                "name": resolve(strings, name_key) if name_key else key,
                "summary_sprite": summary_m.group(1) if summary_m else None,
                "detail_sprite": detail_m.group(1) if detail_m else None,
                "area_type": int(area_type_m.group(1)) if area_type_m else None,
                "level": int(level_m.group(1)) if level_m else None,
                "enemies": enemies,
                "encounter_chance_permille": encounter,
                "items_mentioned": items_mentioned,
            }
        )
    return out


def _collect_statement(lines: list[str], start: int) -> tuple[str, int]:
    """Join a statement across lines until parens/brackets balance."""
    text = lines[start]
    depth = text.count("(") - text.count(")") + text.count("[") - text.count("]")
    i = start + 1
    while depth > 0 and i < len(lines):
        text += " " + lines[i].strip()
        depth += lines[i].count("(") - lines[i].count(")") + lines[i].count("[") - lines[i].count("]")
        i += 1
    return text, i


def _parse_roll_enemies(text: str) -> tuple[list[dict], int | None]:
    """Parse `rollEnemies()` threshold buckets into per-mille probabilities."""
    body = extract_function_body(text, "rollEnemies")
    if not body:
        return [], None
    # If the dungeon has a beginner branch (e.g. EnchantedForest QuartersCapacity <= 2),
    # strip it so we parse the full regular/endgame spawn pool in the else block.
    if "Formulas.getQuartersCapacity() <= 2" in body:
        body = re.sub(
            r"if\s*\(\s*Formulas\.getQuartersCapacity\(\)\s*<=\s*2\s*\)\s*\{[\s\S]*?\}\s*else\s*\{",
            "",
            body,
        )
    lines = body.splitlines()
    buckets: list[dict] = []
    special: list[str] = []
    pending_thresh: float | None = None
    i = 0
    while i < len(lines):
        line = lines[i]
        m = re.search(r"if\s*\(\s*dRandom\s*<\s*([0-9.]+)", line)
        if m:
            pending_thresh = float(m.group(1))
        stmt, consumed = _collect_statement(lines, i)
        i = max(consumed, i + 1)
        if "return" not in stmt:
            continue
        keys = re.findall(r'Enemy\.getInstance\("(\w+)"', stmt)
        if pending_thresh is not None:
            buckets.append({"threshold": pending_thresh, "enemies": keys})
            pending_thresh = None
        elif keys:
            special.extend(keys)  # event/scripted spawns outside dRandom flow
    # bucket probability = delta to previous threshold (code checks ascending)
    probs: dict[str, float] = {}
    prev = 0.0
    encounter = 0.0
    for b in buckets:
        delta = max(0.0, b["threshold"] - prev)
        prev = b["threshold"]
        encounter += delta
        for ek in b["enemies"]:
            if delta <= 0:
                continue
            probs[ek] = probs.get(ek, 0.0) + delta / max(1, len(b["enemies"]))
    enemies = [
        {"key": k, "chance_permille": round(v, 2)}
        for k, v in sorted(probs.items(), key=lambda kv: -kv[1])
    ]
    seen_keys = set(probs.keys())
    for sk in sorted(set(special)):
        if sk not in seen_keys:
            enemies.append({"key": sk, "chance_permille": None})
            seen_keys.add(sk)
    return enemies, int(round(encounter))


# --------------------------------------------------------------------------
# Changelog (version()/subpoints() blocks)
# --------------------------------------------------------------------------

def parse_changelog(repo: Path, strings: dict) -> list[dict]:
    """Parse ModChangelog*.kt ENTRIES lists, newest-first per file."""
    base = p(repo, KOTLIN_BASE, "ui/dialogs/changelog")
    files = sorted(base.glob("ModChangelog*.kt"))
    # active file first so newest versions lead the wiki page
    files.sort(key=lambda f: (0 if "Active" in f.name else 1, f.name))
    versions: list[dict] = []
    for path in files:
        text = read_text(path)
        if "ENTRIES" not in text:
            continue
        cur: dict | None = None
        group: list[str] | None = None

        def close_group():
            if cur is not None and group:
                cur["groups"].append(group)

        for raw in text.splitlines():
            line = raw.strip()
            if line.startswith("//"):
                continue
            if "version(" in line:
                if cur is not None:
                    close_group()
                    versions.append(cur)
                cur = {"version": None, "date": None, "groups": [], "source": path.name}
                group = None
                continue
            if cur is None:
                continue
            if "subpoints(" in line:
                close_group()
                group = []
                continue
            if line in ("),", ")"):
                if group is not None:
                    close_group()
                    group = None
                else:
                    versions.append(cur)
                    cur = None
                continue
            qm = re.findall(r'"((?:[^"\\]|\\.)*)"', line)
            if not qm:
                continue
            if cur["version"] is None and len(qm) >= 2:
                cur["version"], cur["date"] = qm[0], qm[1]
            elif cur["version"] is None and len(qm) == 1 and cur["date"] is None:
                cur["version"], cur["date"] = qm[0], None
            elif group is not None:
                group.append(unescape_android(qm[0]))
            else:
                cur["groups"].append([unescape_android(qm[0])])
        if cur is not None:
            close_group()
            versions.append(cur)
    return [v for v in versions if v.get("version")]


# --------------------------------------------------------------------------
# Main
# --------------------------------------------------------------------------

def main(argv: list[str] | None = None) -> int:
    ap = argparse.ArgumentParser(description=__doc__)
    ap.add_argument("--repo", type=Path, default=DEFAULT_REPO, help="repo root")
    ap.add_argument("--out", type=Path, default=None, help="output dir")
    args = ap.parse_args(argv)
    repo = args.repo.resolve()
    out_dir = (args.out or repo / "igmplus_wiki" / "data").resolve()

    if not p(repo, KOTLIN_BASE).is_dir():
        print(f"error: kotlin sources not found under {repo}", file=sys.stderr)
        return 1

    print(f"extracting game data from {repo}")
    sprites: dict[str, list[str]] = {}

    strings = parse_strings(repo)
    write_json(out_dir, "strings.json", strings)

    skills = parse_skills(repo, strings)
    write_json(out_dir, "skills.json", skills)

    traits = parse_traits(repo, strings)
    write_json(out_dir, "traits.json", traits)

    status_effects = parse_status_effects(repo, strings, sprites)
    write_json(out_dir, "status_effects.json", status_effects)

    doctrine_abilities = parse_doctrine_abilities(repo, strings)
    for da in doctrine_abilities:
        sprites.setdefault(da["sprite"], []).append(f"doctrine_ability:{da['key']}")
    write_json(out_dir, "doctrine_abilities.json", doctrine_abilities)

    doctrines = parse_doctrines(repo, strings, sprites)
    write_json(out_dir, "doctrines.json", doctrines)

    adventurers = parse_adventurer_units(repo, strings, sprites)
    write_json(out_dir, "units_adventurers.json", adventurers)

    enemies = parse_enemy_units(repo, strings, sprites)
    write_json(out_dir, "units_enemies.json", enemies)

    items = parse_items(repo, strings, sprites)
    write_json(out_dir, "items.json", items)

    recipes = parse_recipes(repo)
    write_json(out_dir, "recipes.json", recipes)

    places = parse_places(repo, strings, sprites)
    write_json(out_dir, "places.json", places)

    changelog = parse_changelog(repo, strings)
    write_json(out_dir, "changelog.json", changelog)

    write_json(out_dir, "sprites.json", dict(sorted(sprites.items())))

    meta = {
        "counts": {
            "strings": len(strings),
            "skills": len(skills),
            "traits": len(traits),
            "status_effects": len(status_effects),
            "doctrine_abilities": len(doctrine_abilities),
            "doctrines": len(doctrines),
            "adventurers": len(adventurers["units"]),
            "adventurer_tiers": len(adventurers["tiers"]),
            "enemies": len(enemies),
            "items": len(items["items"]),
            "item_base_classes": len(items["base_classes"]),
            "recipes": len(recipes),
            "places": len(places),
            "changelog_versions": len(changelog),
            "sprites": len(sprites),
        },
        "untiered_units": [
            u["key"] for u in adventurers["units"] if u.get("tier") is None
        ],
    }
    write_json(out_dir, "meta.json", meta)
    print("done.")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
