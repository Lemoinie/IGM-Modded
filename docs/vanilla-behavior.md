# Vanilla Behavior & Quirks

## Design Rule
Do not modify or refactor unexpected vanilla behavior if it is part of the original game logic. Only fix issues that are demonstrably decompilation errors or syntax impossibilities.

## Identified Vanilla Quirks
1. **Loot Cap & Storage**: Vanilla hardcaps dungeon loot chest at 2,000 (standard) or 3,000 (with upgrades).
2. **Offline Idle Time**: Vanilla calculates offline progress up to an 8-hour cap by comparing TrueTime NTP timestamps with local save timestamps.
3. **DataBinding vs Manual View Access**: Vanilla mixes generated DataBinding bindings with manual indViewById queries in certain dialogs.
4. **Enemy & Item Instantiation**: Every individual enemy and item type in the game is implemented as a standalone subclass (e.g. IronSword, GoblinScout) rather than data-driven config tables. This structure will be preserved during the baseline stage.
