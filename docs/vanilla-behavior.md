# Vanilla Behavior & Quirks

## Design Rule

Do not modify or refactor unexpected vanilla behavior if it is part of the original
game logic. Only fix issues that are demonstrably decompilation errors or syntax
impossibilities (see [known-uncertainties.md](known-uncertainties.md)).

This project is a **reconstruction with a mod layer**. Vanilla parity is the
baseline; intentional changes are mod features and should be gated or branded as mod
behavior (see "Mod Interface" below).

## Identified Vanilla Quirks & Verified Systems

1. **Loot Cap & Storage**: Vanilla hardcaps dungeon loot chest at 2,000 (standard)
   or 3,000 (with upgrades).

2. **Offline Idle Time**: Vanilla calculates offline progress up to an 8-hour cap by
   comparing TrueTime NTP timestamps with local save timestamps.

3. **DataBinding vs Manual View Access**: Vanilla mixes generated DataBinding
   bindings with manual `findViewById` queries in certain dialogs.

4. **Enemy & Item Instantiation**: Every individual enemy and item type is
   implemented as a standalone subclass (e.g. `IronSword`, `GoblinScout`) rather than
   data-driven config tables. The Kotlin port preserves this pattern
   (`entities/enemies/units/*.kt`, `items/instances/*.kt`, ...).

5. **Area Skill Target Modes**: String-based target selection modes —
   `"all"`, `"all_enemies"`, `"all_allies"`, `"all_except_self"`,
   `"lowest_relative_enemy"`, `"lowest_absolute_enemy"`, `"lowest_relative_ally"`,
   `"lowest_absolute_ally"`, `"random_enemy"`, `"random_ally"`,
   `"random_except_self"`, or integer strings `"2".."12"` indicating multi-hit
   barrage attacks.

6. **Damage Multipliers in `Area.dealDamage`**: The status-effect multiplier loop
   applies 2.0x for `DELIRIUM` and `SKELETON_KEY`, 1.3x for `FRENZY`, and 1.25x for
   `ANOINTED`, `INSPIRE`, or `EXALT`.

7. **Stat Calculation Hierarchy**: `Adventurer.calculateTotalStat(int statId)`
   applies base stat + constitution bonuses + traits + equipment stats + potions
   drunk (`PotionsDrank`) + doctrines.

8. **Skill Dispatcher (`Area.cast`)**: 100-case packed switch mapping `Skills`
   ordinals to execution logic, reproduced from smali with 92 fluent-builder cases
   and 8 custom-logic cases (see [known-uncertainties.md](known-uncertainties.md),
   item 1). Treat this as a faithful port — do not "simplify".

9. **Area Unlock Gating**: Area reachability is defined per-area via
   `listAreasUnlocked()` returning `Area -> threshold` pairs (e.g.
   `EnchantedForest` unlocks `TheDesert` at 80 and `TheSlimePond` at 150 in the
   vanilla balance). New mod areas should declare their own gates the same way.

10. **Save Rotation & Tolerant Loading**: `FileManager` alternates writes between
    `data.txt` and `databackup.txt`, and `DataDeserializer` loads only known keys —
    unknown/legacy JSON keys are ignored and missing fields take class defaults.
    The save file itself carries **no version field**.

11. **Dialog/UI Single-Instance Guards**: `MainActivity` keeps a `shownDialog*`
    reference for each dialog type; opening while one is already shown is skipped.
    The Kotlin port keeps this pattern in `MainActivity` and the fragment bindings.

12. **Flying Units & Melee Targeting**: In vanilla, attacks against flying targets
    (`isFlying() == true`) without ranged capability (`!isRanged() && !isFlying()`)
    are guaranteed to miss with 100% dodge (`DODGE_FLYING`). However, vanilla's
    target selectors (`selectEnemyTarget`, `selectLowestHpTarget`, `selectRandomTarget`)
    did not check reachability, causing melee units to repeatedly lock onto
    unreachable flying units even when valid ground targets were alive. Mod
    v1.3.5.1 adds reachability filtering to prioritize reachable ground targets
    whenever alive, falling back to flying units only if no ground targets remain.

## Mod Interface

Intentional deviations from vanilla are implemented as **native game code** in the
source tree (no injected patches). They are concentrated in a few places:

- `DebugToggles.kt` — compile-time flags (`MULTIPLY_ADVENTURERS_STATS_BY_50`,
  `ALWAYS_GRANT_MAX_IDLE_HOURS`, `INSTANT_LEVEL_UP`, `DISABLE_SHOP`,
  `CLEAN_SAVE_ON_START`, ...). Game logic branches on these.
- `game/redeem/RedeemCodes.kt` — the redeem-code console (REROLL/SHOP/QUEST/GOLD/
  STORAGE/IDLETIME/LOOTCAP/RESETCAPS/KILLS/SETKILLS/ITEM/HERO/PET), served by `DialogRedeemCode`.
- **Redeem-code lockdown (v1.3.8.17)** — the vanilla upgrade codes
  (`f3hqt045`, `g394te91`, `rotdrv9d`, `f1r29u15`, `brttr5g5`, `UNLOCKME`) are
  removed from `DialogRedeemCode` and now fall through to the unknown-code blink
  (treated as invalid). Only the gem codes (`g75nfkf4`, `fj9rf8hh`, `e44ttr7z`,
  `vrd75ywc`, `vrt4983y`), `DEBUG000` (save-share), and the mod `Z3gAAzrt`
  (lvl-100 Kitsune "Senko" pet) remain active (see `plans/working/guild/redeem-code-lockdown.md`).
- **Angel of War branch — AoE Row Defense (Shared Burden)** — when an enemy performs an
  AoE attack (`Area.isAoeAttack` detects active multi-target skills: `all`/`all_enemies`/
  `all_except_self`/integer barrage counts) against an adventurer, all alive Holy-Knight
  branch units in the **same row** (slot / 5) intercept the **highest-tier** percentage
  of the **pre-mitigation** raw damage, split evenly across the protectors: Holy Knight
  10%, Paladin 15%, Templar 20%, Inquisitor 25%, Justiciar 30%, Angel of War 35%.
  Each protector mitigates its slice through its own DEF/MDEF, flat damage reduction,
  Radiant Blessing flat DR and holy shields (`guard.applyDamage(...)`); a protector does
  not protect itself, but two protectors in one row cross-protect each other. Combat log:
  `[Protector] intercepted [N] damage for [Ally].` (`Logger.AOE_DAMAGE_INTERCEPTED`).
- `Data` progression knobs — `imperialKills`, `idleTimeCapHours`, `lootCap` are
  consumed by `TheGoldenCity`, `MainActivity.initializeThreads()`, and
  `Area.fullChest()` respectively (0 = vanilla behavior).
- **Mythic pets (v1.3.9.0)** — `Phoenix` ("Kiara") and `Kitsune` ("Senko") extend
  `Mythic` with a fixed trait pool (EXPERIENCE/DROPS/OPPORTUNIST/SAVAGE). `Pet.getInstance()`
  resolves the legacy `Semi`/`Senko` names to `Kitsune`, so old saves load cleanly.
  The Phoenix 5th trait **Solar Rebirth** revives a fallen ally at 1 HP or shields an ally
  from one lethal hit each combat turn (`Area.petSolarRebirth()` / `Area.dealDamage()`).
- **Sanguine Crucible (v1.3.10.0 → v1.3.10.2)** — new endgame raid `SanguineCrucible.kt` (14
  adventurers — the engine's max team slots, same as The Tower — `getAreaType() = 1`): the party wanders 5 to 15 randomly-rolled rooms
  (`event.progress` holds `5 + random(0..10)`) with 80% combat chambers spawning 1-5
  `CrimsonAcolyte`s and 20% atmospheric logs, then fights boss `ArchmagusValthex` (in
  the middle of his 4 `CrimsonAcolyte`s) at `progress >= event.progress`. Unlocks via
  `TheTower.listAreasUnlocked()` at floor 35, `Utils.collectItem` on first `ScarletStrand`,
  or `DataDeserializer` for saves that already own a Scarlet Strand. Base stats: Valthex
  120k HP / 200-250 damage / 600 INT / 150% crit / 50,000 XP with `ACTIVE_SCARLET_AEONIA`
  (AoE: Sinister Curse → 120% magic damage → Bloodflame) and `PASSIVE_BLOOD_CONVOCATION`
  (20% on-hit summon of a `CrimsonAcolyte` while `enemies.size < 5`, wired into
  `Area.dealDamage()`); Acolytes 6k HP / 100-200 damage / 250 DEX / 2,500 XP with
  `ACTIVE_SANGUINE_PYRE` (50% AoE + 3-turn Bloodflame) and `PASSIVE_MARTYRS_PACT`. Acolyte
  deaths apply permanent, stackable `SANGUINE_FERVOR` (+5% damage dealt per stack, no turn
  duration) to surviving enemies via `calculateOnDeathEffectsOnAllies()`; the stack
  **consolidates into a single status instance** (BLEED-style, count in `turnsLeft`, one
  icon) that skips decrement/removal in `Area.resolveStatus()` and feeds
  `statusDamageMultiplier` in `Area.dealDamage()`. Sinister Curse uses
  `icon_effect_sinister_curse`, amplifies incoming damage by 50% (`Area.dealDamage`), and
  when a cursed adventurer dies `Area.checkDeath` reaps their soul into an enemy
  `BoneNightmareEnemy` (8k HP / 300-400 melee / threat 6 / `PASSIVE_THREATENING_II`,
  registered `EnemyType.UNDEAD`) while the enemy formation has room. Drop tables moved to
  independent per-item rolls via `Enemy.rollDrops()` (default = vanilla single
  `rollFromWeightedMap`); Valthex/Acolyte roll each item independently (Scarlet Strand 1%,
  Esoteric Egg 5%, Eldritch Seal 35%, Black Hide 35%, Aberrant Fabric 45%) and `listDrops`
  lists every item for the Bestiary.
- Branding: `app_name` = "IGM Modded", launcher icon `@drawable/unit_balrog`,
  `versionName`/APK name from `app/build.gradle.kts`.
- **Claim all chests (v1.3.11.0)** — new `isSettingClaimAllChests` setting toggle
  (`settingClaimAllChests` save key). When ON, tapping any dungeon's loot chest calls
  `Utils.collectAllDungeonDrops()` instead of the single-drop `Utils.collectDrops()`:
  it gathers every active dungeon with loot, consolidates identical stacks via
  `Utils.consolidateDropsForClaim()`, runs the same full-inventory guard / pet
  auto-feeding as the single flow, merges all `AdventureRecap`s into one
  `Utils.mergeAdventureRecaps()` (duration = max, rooms/wipes/EXP = sums, kill counts
  combined), clears each collected dungeon's drops/recap, and shows one
  `DialogCollectDrops` titled "All Dungeons".
- **Battle Status Effects Inspector (v1.3.12.0)** — a STATUS button in the bottom-left
  of the dungeon-detail view opens `DialogBattleStatusEffects`, a live-updating
  inspector listing every active positive/negative status effect (icon, name, remaining
  turns — "Permanent" / "N turns left" — and cause) for all living allies and enemies.
  `DialogDungeonDetail.refreshUnits()` notifies the open inspector each combat turn so
  counts tick down in real time.
- Ads/IAP are stubbed and hidden from the UI (see
  [known-uncertainties.md](known-uncertainties.md), item 2).
- Save tooling (`scripts/save/`, `save_editor/`) operates on saved games outside
  the app; it never changes in-app logic.

When adding to the mod, keep vanilla behavior intact and layer mod behavior on top.