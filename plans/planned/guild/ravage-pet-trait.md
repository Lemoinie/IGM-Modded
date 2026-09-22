# Implementation Plan: New Pet Trait — "Ravage"

## Goal Description
Introduce a new pet trait named **Ravage** (`PetAbility.RAVAGE`).
- **In-Game Text**: `"Looting is (level * 0.5)% more efficient."`
- **Effect**: Multiplies the base drop chances of items in drop tables by $(1.0 + \text{ravageMultiplier})$.
- **Example**: A level 100 pet with Ravage grants **+50% looting efficiency** (`ravage = 50.0%`). An item with a base 1.0% drop chance (such as [ScarletStrand](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/instances/ScarletStrand.kt) from Archmagus Valthex) will drop with a **1.5% chance**.

---

## 1. Mathematical Mechanics & Architecture

### 1.1 Trait Scaling
- **Formula**:
  $$\text{ravageMagnitude} = \text{level} \times 0.5$$
  - At Level 20: $+10.0\%$ efficiency ($1.10\times$ drop rate)
  - At Level 50: $+25.0\%$ efficiency ($1.25\times$ drop rate)
  - At Level 100: $+50.0\%$ efficiency ($1.50\times$ drop rate)
- **Multiplier**:
  $$\text{ravageMultiplier} = 1.0 + (\text{ravageMagnitude} \times 0.01)$$

### 1.2 Weighted Map Drop Multiplier in `Utils.rollFromWeightedMap`
In Idle Guild Master, drop tables use [`Utils.rollFromWeightedMap()`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/Utils.kt#L1211) against a fixed `1000.0` roll ceiling:

```kotlin
fun <T> rollFromWeightedMap(map: Map<T, Int>?, multiplier: Double = 1.0): T? {
    if (map == null || map.isEmpty()) return null
    if (multiplier <= 1.0) {
        val dRandom = random() * 1000.0
        var iIntValue = 0
        for ((key, value) in map) {
            iIntValue += value
            if (dRandom < iIntValue) return key
        }
        return null
    }

    // Ravage Multiplier active:
    // Sort entries ascending by weight so rare drops get their full multiplied bonus first
    val sortedEntries = map.entries.sortedBy { it.value }
    val dRandom = random() * 1000.0
    var currentThreshold = 0.0

    for (entry in sortedEntries) {
        val baseWeight = entry.value.toDouble()
        val scaledWeight = baseWeight * multiplier
        val effectiveWeight = Math.min(scaledWeight, Math.max(0.0, 1000.0 - currentThreshold))
        currentThreshold += effectiveWeight
        if (dRandom < currentThreshold) {
            return entry.key
        }
    }
    return null
}
```

### 1.3 How This Solves All Drop Scenarios
1. **Single Rare Drop with High Blank / Null Chance (e.g. Archmagus Valthex, Headless Knight, Cerebrum)**:
   - Archmagus Valthex: `{ "ScarletStrand": 10 }`
   - With Ravage 100 ($1.5\times$): Scaled weight becomes **15.0**.
   - Roll range is $[0.0, 1000.0)$. Roll $< 15.0$ has probability $15.0 / 1000.0 = \mathbf{1.5\%}$!
   - Blank / Null chance shrinks from 99.0% to 98.5%.
2. **Multiple Rare Drops with Blank Chance (e.g. Oculus)**:
   - Flux Limiter (3) $\rightarrow 4.5$ ($0.45\%$)
   - Scanner (4) $\rightarrow 6.0$ ($0.60\%$)
   - Elastic Membrane (400) $\rightarrow 600.0$ ($60.0\%$)
   - Every individual item scales proportionally by $+50\%$.
3. **Full 1000-Weight Guaranteed Drops (e.g. Slime King)**:
   - Seeking Glass (10) $\rightarrow$ scales to 15 ($1.5\%$)
   - Slime King's Crown (30) $\rightarrow$ scales to 45 ($4.5\%$)
   - Green Slime (960) $\rightarrow$ absorbs the remaining 940 weight ($94.0\%$)
   - Rare loot rates increase at the direct expense of common junk, exactly fulfilling "more efficient looting".
4. **Vanilla Synergy with "Curious" (`PetAbility.DROPS`)**:
   - `Curious` grants a $\%$ chance to roll the loot table a **second time**.
   - `Ravage` increases the **quality/drop rate of each individual roll**.
   - A pet with both Curious and Ravage has higher drop rates *and* a chance for double drops.

---

## 2. Technical Implementation Checklist

### 2.1 Pet Ability Definitions
- [MODIFY] [`PetAbility.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/pets/PetAbility.kt):
  - Add `RAVAGE(R.string.pet_ability_ravage_name, R.string.pet_ability_ravage_description)` to the enum.

### 2.2 Pet Class Properties & Scaling
- [MODIFY] [`Pet.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/pets/Pet.kt):
  - Add `@JvmField @Transient var ravage: Double = 0.0`.
  - In `configureAbility(petAbility: PetAbility, level: Int)`:
    ```kotlin
    PetAbility.RAVAGE -> this.ravage = d * 0.5
    ```
  - Add getter:
    ```kotlin
    open fun getRavage(): Double = ravage
    ```

### 2.3 Egg Hatching Probability
- [MODIFY] [`Utils.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/Utils.kt):
  - Update `rollPetAbility(list: List<PetAbility>)`:
    - Expand pool to 17 abilities with equal probability slices ($1/17 \approx 0.0588$), adding a branch for `PetAbility.RAVAGE`.

### 2.4 Loot Integration
- [MODIFY] [`Utils.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/Utils.kt):
  - Update `rollFromWeightedMap(map: Map<T, Int>?, multiplier: Double = 1.0): T?` to support the Ravage multiplier.
- [MODIFY] [`Area.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/Area.kt):
  - In `loot()`:
    ```kotlin
    val pet = this.petExploring
    val ravageMultiplier = if (pet != null && pet.ravage > 0.0) 1.0 + (pet.ravage * 0.01) else 1.0
    val itemWrapper2 = Utils.rollFromWeightedMap(enemy.listDrops(ev?.key ?: 0), ravageMultiplier) as? ItemWrapper
    ```
    (and apply `ravageMultiplier` to the second roll if Curious procs).

### 2.5 UI & Tooltips
- [MODIFY] [`DialogPetDetail.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogPetDetail.kt):
  - In `formatPetAbilityDescription()`:
    ```kotlin
    PetAbility.RAVAGE -> String.format(string, wrap(UIUtils.formatDouble2Decimals(p.ravage)))
    ```

### 2.6 Localization Strings
- [MODIFY] `res/values/strings.xml`:
  - `<string name="pet_ability_ravage_name">Ravage</string>`
  - `<string name="pet_ability_ravage_description">Looting is %s%% more efficient.</string>`

---

## 3. Save File Compatibility
- `PetAbility` is an enum serialized via `petAbility.toString()`.
- [DataDeserializer.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/DataDeserializer.kt#L475) uses `PetAbility.fromString()`.
- Existing pets in existing saves remain 100% compatible.
- Newly rolled pets with `RAVAGE` serialize as `"RAVAGE"` and deserialize seamlessly.

---

## 4. Verification Plan

### 4.1 Automated Unit Tests
1. **Formula Verification**:
   - Verify `configureAbility(PetAbility.RAVAGE, 100)` yields `ravage == 50.0`.
   - Verify `configureAbility(PetAbility.RAVAGE, 20)` yields `ravage == 10.0`.
2. **Drop Multiplier Math Simulation**:
   - Run 100,000 simulated rolls on Archmagus Valthex drop table (`ScarletStrand: 10`):
     - Without Ravage: ~1,000 drops ($\approx 1.0\%$).
     - With Ravage 100 ($1.5\times$): ~1,500 drops ($\approx 1.5\%$).
   - Run 100,000 simulated rolls on Slime King drop table:
     - Verify `SeekingGlass` increases from ~1.0% to ~1.5%.
     - Verify `SlimeKingsCrown` increases from ~3.0% to ~4.5%.
     - Verify total drop sum remains exactly 100%.

### 4.2 UI Manual Verification
1. Open Pet Details dialog on a pet with `Ravage`:
   - Verify trait name displays as "Ravage" in brass color.
   - Verify description displays "Looting is 50.00% more efficient." (or formatted level-based value).
