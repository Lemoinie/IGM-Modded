# Vanilla Behavior & Quirks

## Design Rule
Do not modify or refactor unexpected vanilla behavior if it is part of the original game logic. Only fix issues that are demonstrably decompilation errors or syntax impossibilities.

## Identified Vanilla Quirks & Verified Systems
1. **Loot Cap & Storage**: Vanilla hardcaps dungeon loot chest at 2,000 (standard) or 3,000 (with upgrades).
2. **Offline Idle Time**: Vanilla calculates offline progress up to an 8-hour cap by comparing TrueTime NTP timestamps with local save timestamps.
3. **DataBinding vs Manual View Access**: Vanilla mixes generated DataBinding bindings with manual findViewById queries in certain dialogs.
4. **Enemy & Item Instantiation**: Every individual enemy and item type in the game is implemented as a standalone subclass (e.g. IronSword, GoblinScout) rather than data-driven config tables.
5. **Area Skill Target Modes**: String-based target selection modes ("all", "all_enemies", "all_allies", "all_except_self", "lowest_relative_enemy", "lowest_absolute_enemy", "lowest_relative_ally", "lowest_absolute_ally", "random_enemy", "random_ally", "random_except_self", or integer strings "2".."12" indicating multi-hit barrage attacks).
6. **Damage Multipliers in Area.dealDamage**: Status effect multiplier loop applies 2.0x for `DELIRIUM` and `SKELETON_KEY`, 1.3x for `FRENZY`, and 1.25x for `ANOINTED`, `INSPIRE`, or `EXALT`.
7. **Stat Calculation Hierarchy**: `Adventurer.calculateTotalStat(int statId)` applies base stat + constitution bonuses + traits + equipment stats + potions drunk (`PotionsDrank`) + doctrines.
