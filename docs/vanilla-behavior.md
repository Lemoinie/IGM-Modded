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

## Mod Interface

Intentional deviations from vanilla are concentrated in a few places:

- `DebugToggles.kt` — compile-time flags (`MULTIPLY_ADVENTURERS_STATS_BY_50`,
  `ALWAYS_GRANT_MAX_IDLE_HOURS`, `INSTANT_LEVEL_UP`, `DISABLE_SHOP`,
  `CLEAN_SAVE_ON_START`, ...). Game logic branches on these.
- Branding: `app_name` = "IGM Modded", launcher icon `@drawable/unit_balrog`,
  `versionName`/APK name from `app/build.gradle.kts`.
- Ads/IAP are stubbed and hidden from the UI (see
  [known-uncertainties.md](known-uncertainties.md), item 2).
- Save tooling (`scripts/save/`, `save_editor/`) operates on saved games outside
  the app; it never changes in-app logic.

When adding to the mod, keep vanilla behavior intact and layer mod behavior on top.