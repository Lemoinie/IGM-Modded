# Implementation Plan: The Slumbering Shallows (Fishing Pond Dungeon)

## Goal

Add a new dungeon — **The Slumbering Shallows** — themed around a murky,
enchanted fishing pond where adventurers dispatch to catch creatures rather than
fight conventional enemies. Party size is 4. Thematic tone: peaceful, pastoral,
but hiding something ancient underneath.

Primary reward: **fish-drop materials** (cooking ingredients, sell fodder) with
a rare boss encounter that drops exclusive loot.

---

## Design Notes & Suggestions

### Fish Enemy Design Philosophy

**Recommendation: Low HP, high dodge.**

Reasoning:
- High HP + high stat fish are frustrating in an idle game — long fights with
  poor payoff feel like the dungeon is stuck.
- Low HP + high dodge fish feel thematically correct (fish are slippery,
  hard to catch) and gameplay-mechanically interesting — DEX-heavy parties
  will perform significantly better here, making it the first dungeon with a
  meaningful stat specialization.
- Small drop rate per kill is consistent with fishing (you don't always keep
  the fish).

This also creates natural build-pressure: players will want a dedicated DEX party
to "fish" effectively, which is a nice identity for the dungeon.

### Fish Enemy Roster

| Enemy | HP | Dodge | Drop | Notes |
|---|---|---|---|---|
| Minnow | Very low | Medium | FreshMinnow (new) | Abundant, fast to kill |
| Perch | Low | Medium | FreshSalmon (reuse) | Common |
| Carp | Low | High | FreshTuna (reuse) | Uncommon |
| GiantCatfish | Medium | Very high | AbyssalSeashell (reuse) | Rare encounter |
| GlowingJellyfish | Low | Medium | Pearl (reuse) | Uncommon |
| AncientSerpentEel | Boss | Medium | Unique loot | ~2–3% chance per run |

### Boss: The Ancient Serpent Eel
- Appears as a rare random encounter (~2–3% roll in ollEnemies()), NOT a
  guaranteed room-end boss — it randomly replaces a normal fight.
- Thematic: you cast a line and reel in something enormous.
- On kill: drops a unique item (e.g. SerpentEelScale — a new material usable
  in crafting, or a piece of pond-themed gear).
- Log event: distinctive message like *"The water erupts — something enormous
  takes the line!"*

---

## Unlock Condition

Unlocked after clearing a mid-game dungeon (suggestion: after
**The Southern Grove** or **Barren Wastelands**).
Accessible early-mid game — low floor, relaxed difficulty.

---

## Proposed Changes

### [NEW] TheSlumberingShallows.kt
- getAreaType() = 0 (dungeon)
- dventurersNumber() = 4
- ollEnemies(): weighted table with low-HP/high-dodge fish and ~2–3% chance
  of AncientSerpentEel boss roll
- searchRoom(): occasionally finds FreshMinnow, Pearl, or AbyssalSeashell
  on the ground (simulating a catch without a fight)
- 	riggerEvent("enter_dungeon"): flavour log — *"The party reaches a quiet
  pond. The water is still, but something stirs beneath."*
- 	riggerEvent("fight_start"): fish-specific flavour logs
- 	riggerEvent("kill_AncientSerpentEel"): special event message
- listAreasUnlocked(): unlocks next appropriate area

### [NEW] Enemies
- Minnow.kt — low HP, medium dodge, drops FreshMinnow
- Perch.kt — low HP, medium-high dodge, drops FreshSalmon
- Carp.kt — low HP, high dodge, drops FreshTuna
- GiantCatfish.kt — medium HP, very high dodge, drops AbyssalSeashell
- GlowingJellyfish.kt — low HP, medium dodge, drops Pearl
- AncientSerpentEel.kt — boss-tier HP, medium dodge, drops SerpentEelScale

### [NEW] Items
- FreshMinnow.kt — common fish drop, cook ingredient, small sell value
- SerpentEelScale.kt — rare boss drop, crafting material or sell-only
  (decide during implementation)

### [NEW] Strings
- Dungeon name, enter log, room logs, fight logs, boss event logs

### [NEW] Drawables
- Dungeon summary and detail artwork
- Enemy sprites (or reuse existing aquatic sprites where available)

### [MODIFY] Data.kt
- Add ar theSlumberingShallows: TheSlumberingShallows?

### [MODIFY] DataDeserializer.kt
- Deserialize 	heSlumberingShallows

### [MODIFY] Dungeon that unlocks it
- Add TheSlumberingShallows to listAreasUnlocked() in the appropriate
  preceding dungeon

### [MODIFY] UI layout (DungeonsFragment binding)
- Add LayoutDungeonBinding slot for the new dungeon

---

## Open Questions

- **Unlock dungeon**: which dungeon should unlock The Slumbering Shallows?
  Suggestion: Southern Grove (mid-game).
- **SerpentEelScale usage**: crafting material for future pond-themed gear, or
  pure sell item to start?
- **FreshMinnow**: add a cooking recipe using it, or leave as sell-only?
- **Boss drop rate**: 2–3% per run feels right — confirm or adjust.
