# Corrupted Dungeons & Challenge Mutator System

## Goal Description
Introduce **Corrupted Dungeons**, an endgame progression system featuring harder, corrupted counterparts of all **11 vanilla dungeons**.

To maintain codebase hygiene and strictly preserve vanilla behavior (as mandated in `AGENTS.md`), each corrupted dungeon is implemented as an **independent subclass** rather than injecting conditional flags into vanilla dungeon code.

### Core Pillars
1. **11 Dedicated Corrupted Dungeons**: Independent area classes mirroring each vanilla dungeon.
2. **Baseline Difficulty Boost**: All monsters in Corrupted Dungeons automatically have **+50% HP, +50% Attack, and +50% Defense/Magic Defense**.
3. **Opt-in Challenge Mutators**: Players can toggle special challenge modifiers before sending a team to multiply risk and rewards.
4. **Enhanced Rewards**: Increased drop quantities, exclusive Corrupted Essences, double rare item rates, and guaranteed Geodes (Gems).

---

## User Review Required

> [!IMPORTANT]
> ### 1. The 11 Corrupted Dungeons List & Architecture
> To keep vanilla dungeon implementations pristine, 11 new classes extend an abstract `CorruptedDungeonArea`:
> 
> | # | Vanilla Dungeon | Corrupted Counterpart | Base Theme & Unlock Condition |
> | :-: | :--- | :--- | :--- |
> | 1 | `EnchantedForest` | `CorruptedForest` | Beats vanilla Enchanted Forest |
> | 2 | `BarrenWastelands` | `CorruptedWastelands` | Beats vanilla Barren Wastelands |
> | 3 | `TheDesert` | `CorruptedDesert` | Beats vanilla The Desert |
> | 4 | `TheSouthernGrove` | `CorruptedSouthernGrove` | Beats vanilla The Southern Grove |
> | 5 | `TheGoldenCity` | `CorruptedGoldenCity` | Beats vanilla The Golden City |
> | 6 | `FrostbitePeaks` | `CorruptedFrostbitePeaks` | Beats vanilla Frostbite Peaks |
> | 7 | `ObsidianMines` | `CorruptedObsidianMines` | Beats vanilla Obsidian Mines |
> | 8 | `TheLostExpedition` | `CorruptedLostExpedition` | Beats vanilla The Lost Expedition |
> | 9 | `TheDireDescent` | `CorruptedDireDescent` | Beats vanilla The Dire Descent |
> | 10 | `TheDreadfulAscent` | `CorruptedDreadfulAscent` | Beats vanilla The Dreadful Ascent |
> | 11 | `SleepingPlanet` / `LostLands` | `CorruptedLostLands` | Beats vanilla Lost Lands |

---

> [!IMPORTANT]
> ### 2. Baseline Stat Scaling (+50%)
> In `CorruptedDungeonArea.kt`, enemy generation wraps vanilla spawns with a 1.5× baseline multiplier:
> * $\text{HP}_{\text{corrupted}} = \lfloor \text{HP}_{\text{base}} \times 1.5 \rfloor$
> * $\text{ATK}_{\text{corrupted}} = \lfloor \text{ATK}_{\text{base}} \times 1.5 \rfloor$
> * $\text{DEF}_{\text{corrupted}} = \lfloor \text{DEF}_{\text{base}} \times 1.5 \rfloor$
> * $\text{MDEF}_{\text{corrupted}} = \lfloor \text{MDEF}_{\text{base}} \times 1.5 \rfloor$

---

> [!IMPORTANT]
> ### 3. Challenge Mutators (Opt-In Risk & Reward)
> When opening the expedition dispatch dialog (`DialogSendTeam`), players can toggle up to 2 active Challenge Mutators:
> 
> | Mutator Name | Penalty / Enemy Hazard | Reward Bonus |
> | :--- | :--- | :--- |
> | **Midnight Shroud** | +15 Darkness, enemies deal +25% Magic Damage | **+50% Material & Item Drop Quantities** |
> | **Frenzied Swarm** | Enemies gain +20% Attack Speed & +15% Crit Chance | **+50% Gold & Copper Drop Value** |
> | **Hardened Carapace**| Enemies gain +30% Physical Armor & Damage Reduction | **2× Chance for Rare Equipment Drops** |
> | **Blood Curse** | Enemy basic attacks inflict **Bloodflame** (5% max HP burn) | **Guaranteed Geode (Gems) on Dungeon Clear** |

---

## Proposed Changes

### UI & Presentation
#### [MODIFY] [fragment_dungeons.xml](file:///c:/Repositories/IGM-Modded/app/src/main/res/layout/fragment_dungeons.xml)
- Add a toggle switch or top tab bar: `[ Normal Dungeons ]` | `[ Corrupted Dungeons ]`.
- Corrupted dungeon cards feature a distinct crimson/purple border tint and a corrupted skull indicator.

#### [MODIFY] [dialog_send_team.xml](file:///c:/Repositories/IGM-Modded/app/src/main/res/layout/dialog_send_team.xml)
- Add a "Challenge Modifiers" collapsible section for Corrupted Dungeons with checkboxes for the 4 mutators.

---

### Combat & Dungeon Classes
#### [NEW] [CorruptedDungeonArea.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/dungeons/corrupted/CorruptedDungeonArea.kt)
- Abstract base class extending `DungeonArea`.
- Automatically applies the 1.5× stat multiplier to all spawned enemies.
- Applies active mutator effects to combat rooms and loot generation.

#### [NEW] 11 Corrupted Dungeon Instances
Under package `it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.corrupted`:
- `CorruptedForest.kt`
- `CorruptedWastelands.kt`
- `CorruptedDesert.kt`
- `CorruptedSouthernGrove.kt`
- `CorruptedGoldenCity.kt`
- `CorruptedFrostbitePeaks.kt`
- `CorruptedObsidianMines.kt`
- `CorruptedLostExpedition.kt`
- `CorruptedDireDescent.kt`
- `CorruptedDreadfulAscent.kt`
- `CorruptedLostLands.kt`

---

### Data & Persistence
#### [MODIFY] [Data.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/Data.kt)
- Add serialized fields for the 11 corrupted dungeon states:
  ```kotlin
  @SerializedName("corruptedForest") var corruptedForest: CorruptedForest? = CorruptedForest()
  // ... (11 instances total)
  ```
- Add unlocked flags for corrupted mode.

---

## Verification Plan

### Automated Tests
- In `CorruptedDungeonTest.kt`:
  - `testStatMultiplierApplied()`: verify monster HP, ATK, and DEF are exactly 1.5× vanilla baseline.
  - `testChallengeMutatorApplication()`: verify selecting Midnight Shroud increases darkness and material drops.
  - `testVanillaIsolation()`: verify vanilla dungeon areas are completely unaffected by corrupted dungeon code and mutators.
  - `testSavePersistence()`: verify corrupted dungeon progress and team state save and load correctly.
