# Implementation Plan: The Forsaken Archives (Library Dungeon)

## Goal

Add a new dungeon — **The Forsaken Archives** — themed around an abandoned
ancient grand library. Adventurers explore crumbling reading halls, haunted
study chambers, and forbidden vaults populated by scholarly undead and arcane
constructs. Party size is 4.

Primary reward: **XP Books** (existing XPBook1 through XPBook10 items).
This is the first dungeon designed around XP acceleration, giving players a
dedicated grind location for levelling up adventurers.

---

## Design Notes & Suggestions

### Enemy Design Philosophy

**Recommendation: Medium HP, moderate dodge, high magic attack.**

Reasoning:
- Scholars aren't warriors — they're powerful mages. This creates a dungeon
  that punishes low-INT/low-MDEF parties and rewards casters and tanky builds.
- Enemies feel thematically distinct from other dungeons (casters rather than
  brutes), while not being unfairly hard if the player fields a balanced party.
- Complements the XP Book reward: grinding XP here requires an appropriately
  levelled party, so it's naturally gated.

### Enemy Roster

| Enemy | Type | Notes |
|---|---|---|
| ScholarPhantom | Ghost scholar, medium HP, magic attacks | Common |
| AnimatedTome | Flying book swarm, low HP, inflicts slow | Uncommon |
| LibraryGolem | Stone construct, high HP, low magic | Uncommon, melee tank |
| CorruptedArchivist | Elite undead scholar, high magic, medium HP | Rare |
| KeeperOfForbiddenWords | Miniboss-tier, high INT-based magic burst | Very rare random |

### Loot Table (XP Books as drops)

XP Books should drop from combat wins (not from searchRoom), with book tier
gated by room depth / dungeon progress:

| Enemy | Drop | Weight |
|---|---|---|
| ScholarPhantom | XPBook1, XPBook2 | Common |
| AnimatedTome | XPBook2, XPBook3 | Common |
| LibraryGolem | XPBook3, XPBook4 | Uncommon |
| CorruptedArchivist | XPBook4, XPBook5 | Rare |
| KeeperOfForbiddenWords | XPBook6, XPBook7 | Very rare (boss only) |

> XP Books 8–10 remain crafted or shop-bought for now, keeping them premium.

### Searchroom loot

searchRoom() finds: torn pages (MissingPage — already exists), old ink
(AlchemicPowder), occasionally a low-tier XPBook1 with low probability.
Flavour: *"Behind a collapsed shelf, the party finds a forgotten journal."*

---

## Unlock Condition

Unlocked after a late-mid-game dungeon (suggestion: **Hidden City of Larox** or
**Obsidian Mines**). This dungeon should feel like an endgame XP grind option,
not early access — players shouldn't reach it until they have a solid party.

---

## Proposed Changes

### [NEW] TheForskenArchives.kt
- getAreaType() = 0 (dungeon)
- dventurersNumber() = 4
- ollEnemies(): weighted table across 5 enemy types; KeeperOfForbiddenWords
  has ~2% roll chance as a rare random encounter
- searchRoom(): drops MissingPage, AlchemicPowder, or rare XPBook1
- 	riggerEvent("enter_dungeon"): *"The party pushes open iron doors, the air
  thick with dust and the smell of old ink."*
- 	riggerEvent("fight_start"): scholar-flavoured combat logs
- 	riggerEvent("kill_KeeperOfForbiddenWords"): rare event log
- listAreasUnlocked(): unlocks next appropriate area

### [NEW] Enemies
- ScholarPhantom.kt — ghost, medium HP, magic atk, drops XPBook1/XPBook2
- AnimatedTome.kt — low HP, inflicts debuff, drops XPBook2/XPBook3
- LibraryGolem.kt — high HP, melee, drops XPBook3/XPBook4
- CorruptedArchivist.kt — elite, high magic, drops XPBook4/XPBook5
- KeeperOfForbiddenWords.kt — boss-tier, drops XPBook6/XPBook7 + rare
  unique item (e.g. AncientCompendium — a craftable material or wearable)

### [NEW] Items
- AncientCompendium.kt — rare drop from Keeper; crafting material or accessory
  (decide during implementation)

> Note: MissingPage already exists. AlchemicPowder already exists.
> No new common-drop items needed.

### [NEW] Strings
- Dungeon name, enter log, room logs, fight encounter logs, boss event log

### [NEW] Drawables
- Dungeon summary and detail artwork
- Enemy sprites

### [MODIFY] Data.kt
- Add ar theForsakenArchives: TheForsakenArchives?

### [MODIFY] DataDeserializer.kt
- Deserialize 	heForsakenArchives

### [MODIFY] Dungeon that unlocks it
- Add TheForsakenArchives to listAreasUnlocked() in the appropriate
  preceding dungeon

### [MODIFY] UI layout (DungeonsFragment binding)
- Add LayoutDungeonBinding slot for the new dungeon

---

## Open Questions

- **Unlock dungeon**: which dungeon unlocks The Forsaken Archives?
  Suggestion: Hidden City of Larox (late-mid-game).
- **AncientCompendium**: crafting use (e.g. upgrades an item) or standalone
  equippable?
- **XP Book tier cap from drops**: cap at XPBook7 for now, or allow Book8?
- **Keeper drop rate**: 2% per run — confirm or adjust.

---

## Verification Plan

`
./gradlew assembleDebug
`

Manual checks:
1. Both dungeons appear in the Dungeons tab after unlock condition is met.
2. Party size locks to 4 for both.
3. Fish enemies blink/dodge visibly more often than standard dungeon enemies.
4. XP Books appear in inventory after library runs.
5. Rare boss encounters trigger with expected frequency over 20+ runs.
6. Saves correctly persist both dungeon states.
