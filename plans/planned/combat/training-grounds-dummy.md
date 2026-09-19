# Implementation Plan - Training Grounds & Target Dummies

Create a dedicated **Training Grounds** testing area with unkillable/high-HP **Target Dummies** on **both sides** (Enemy and Ally). This allows players to test single-target damage, AoE skills, heals, shields, buffs (Inspire, Radiant Blessing, Exalt), cleanses, and defensive mechanics (like Angel of War row defense) in a controlled environment without death penalties or turn limits.

---

## Architecture & Mechanics

### 1. Enemy Target Dummy (`TrainingDummyEnemy`)
- **Unkillable / Massive HP**:
  - `maxHp = 100_000_000` (100M HP).
  - Overridden `applyDamage()` resets HP if reduced to 0, ensuring the fight never accidentally ends due to dummy death:
    ```kotlin
    override fun applyDamage(d: Double, z: Boolean, i: Int, d2: Double): Int {
        val dmg = super.applyDamage(d, z, i, d2)
        if (currentHp <= 0) currentHp = calculateTotalMaxHp()
        return dmg
    }
    ```
- **Training Profiles (Selectable or Staged)**:
  1. **Punching Bag Dummy**: 0 attack, passes turn (pure DPS testing).
  2. **Striking Dummy**: 100 single-target physical/magical hit each turn (tests armor, shields, parry, dodge).
  3. **AoE Spitter Dummy**: Casts a 100 damage AoE attack each turn (tests mass heals, party shields, and Angel of War AoE row defense).

### 2. Ally Target Dummy (`TrainingDummyAlly`)
- **Temporary Adventurer**:
  - Subclasses `Adventurer` with `summonedMinion = true` so it is never saved to the player's persistent guild data, gains no permanent XP, and cleanly disappears upon exiting.
- **Auto-Fill Empty Party Slots**:
  - In `TrainingGrounds.initializeFight()`, if the player brings fewer than 5 adventurers, the remaining slots in the row are filled with `TrainingDummyAlly` units.
  - Starts at 50% HP so healers (Cleric, Paladin, Angel of War) can immediately test their healing mechanics.
  - Takes damage, receives buffs, can be cleansed, and triggers same-row AoE defense for testing frontline synergies.
  - Passes its own turn (0 damage attack) so it does not interfere with the player's damage tracking.

### 3. Training Grounds Area (`TrainingGrounds : Area`)
- **Area Type**: `getAreaType() = 1` (Raid type: no XP lost, no death penalty).
- **Infinite Battle**: Bypasses the 400-turn limit in `Area.kt` so players can test uninterrupted.
- **Clean Exit**: The standard "RETREAT" button allows players to exit anytime without consequences.

---

## Proposed Changes

### Core Game & Entities

#### [NEW] [TrainingDummyEnemy.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/enemies/units/TrainingDummyEnemy.kt)
- High HP enemy with damage reset logic and customizable attack modes.

#### [NEW] [TrainingDummyAlly.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/adventurers/units/TrainingDummyAlly.kt)
- Temporary ally dummy (`summonedMinion = true`) with configurable HP to test heals and buffs.

#### [NEW] [TrainingGrounds.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/raids/TrainingGrounds.kt)
- Custom raid area that spawns enemy dummies and fills empty party slots with ally dummies.

---

### UI & Strings

#### [MODIFY] [strings.xml](file:///c:/Repositories/IGM-Modded/app/src/main/res/values/strings.xml)
- Add names and descriptions for Training Grounds, Enemy Dummy, and Ally Dummy.

---

## Verification Plan

### Automated Tests
- Unit tests verifying:
  - Dummy enemy cannot die in combat (`applyDamage` resets HP).
  - Ally dummies auto-fill empty slots when entering with 1 player adventurer.
  - Heals and buffs successfully target ally dummies.
  - Exiting the area leaves player guild data untainted.
