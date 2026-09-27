# Implementation Plan: Pet Abilities Expansion

## 1. Goal Description

Revamp and expand the **Pet Ability System** in *Idle Guild Master* by introducing dedicated offensive, defensive, economic, and attribute auras.

This plan addresses five core design constraints:
1. **Leave Vanilla `Protective` Untouched**: Vanilla `Protective` (`PetAbility.BARRIER`) remains in its original form as a flat damage buffer.
2. **Dedicated Defensive Mitigation (`Bulwark` & `Spellward`)**: Introduce percentage-based physical damage reduction (`Bulwark`) and magic damage reduction (`Spellward`) to handle late-game scaling.
3. **No Trait Rarity in this Plan**: Trait rarity (Common vs. Rare tiers with colored borders) is explicitly excluded from this plan and will be designed in a separate dedicated plan.
4. **Renamed Economic Keystone (`Scavenger`)**: The looting efficiency mechanic (multiplying base drop rates in weighted tables, previously designated as *Ravage*) is named **`Scavenger`** (`PetAbility.SCAVENGER`). The previous stack-harvesting concept is removed.
5. **Clean Stat & Combat Auras**:
   - `Precision` (+Party Crit Chance)
   - `Fleetfoot` (+Party Dodge Chance)
   - `Arcane Surge` (+Party Magic Damage Amp)
   - `Brawn` (+Party CON)
   - `Finesse` (+Party DEX)
   - `Wisdom` (+Party INT)
   - Max HP buffs remain exclusive to Mythic companions (Fauna's *Tree of Life*), and darkness is handled by vanilla `Bright`.

---

## 2. Expanded Trait Roster & Mechanics

| Trait | Enum Key | Category | Scaling Formula | Lv 20 / 50 / 100 Value | In-Game Description |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **Bulwark** | `BULWARK` | Defense | `level * 0.15%` | `3.0%` / `7.5%` / `15.0%` | *"Reduces physical damage taken by party members by %s%%."* |
| **Spellward** | `SPELLWARD` | Defense | `level * 0.15%` | `3.0%` / `7.5%` / `15.0%` | *"Reduces magic damage taken by party members by %s%%."* |
| **Scavenger** | `SCAVENGER` | Economy | `level * 0.50%` | `10.0%` / `25.0%` / `50.0%` | *"Looting is %s%% more efficient."* |
| **Precision** | `PRECISION` | Offense | `level * 0.15%` | `3.0%` / `7.5%` / `15.0%` | *"Increases party Critical Strike chance by %s%%."* |
| **Fleetfoot** | `FLEETFOOT` | Defense | `level * 0.15%` | `3.0%` / `7.5%` / `15.0%` | *"Increases party Dodge chance by %s%%."* |
| **Arcane Surge** | `ARCANE_SURGE` | Offense | `level * 0.35%` | `7.0%` / `17.5%` / `35.0%` | *"Increases all magic damage dealt by allies by %s%%."* |
| **Brawn** | `BRAWN` | Attribute | `level * 0.20` | `+4` / `+10` / `+20` | *"Increases party Constitution by %s."* |
| **Finesse** | `FINESSE` | Attribute | `level * 0.20` | `+4` / `+10` / `+20` | *"Increases party Dexterity by %s."* |
| **Wisdom** | `WISDOM` | Attribute | `level * 0.20` | `+4` / `+10` / `+20` | *"Increases party Intelligence by %s."* |

---

## 3. Mathematical Mechanics

### 3.1 `Bulwark` & `Spellward` Damage Reduction
In [`Entity.applyDamage()`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/Entity.kt):
- If `isMagic == false` and the exploring pet has `bulwark > 0.0`:
  $$\text{effectiveDamage} = \text{rawDamage} \times (1.0 - \text{pet.bulwark} \times 0.01)$$
- If `isMagic == true` and the exploring pet has `spellward > 0.0`:
  $$\text{effectiveDamage} = \text{rawDamage} \times (1.0 - \text{pet.spellward} \times 0.01)$$

### 3.2 `Scavenger` Loot Efficiency
In [`Utils.rollFromWeightedMap()`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/Utils.kt#L1211):
- Uses `multiplier = 1.0 + (pet.scavenger * 0.01)`.
- Rare items (sorted ascending by weight) have their drop chances boosted against the 1000.0 blank roll threshold, granting up to $+50\%$ drop rate at Level 100.

### 3.3 Attribute Auras (`Brawn`, `Finesse`, `Wisdom`)
Evaluated in party attribute calculation methods in [`Adventurer.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/adventurers/Adventurer.kt):
- `calculateTotalConstitution()`: includes `pet?.brawn ?: 0`
- `calculateTotalDexterity()`: includes `pet?.finesse ?: 0`
- `calculateTotalIntelligence()`: includes `pet?.wisdom ?: 0`

---

## 4. Technical Implementation Steps

### 4.1 Enum Additions in [`PetAbility.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/pets/PetAbility.kt)
Add the 9 new abilities to the enum:
```kotlin
BULWARK(R.string.pet_ability_bulwark_name, R.string.pet_ability_bulwark_description),
SPELLWARD(R.string.pet_ability_spellward_name, R.string.pet_ability_spellward_description),
SCAVENGER(R.string.pet_ability_scavenger_name, R.string.pet_ability_scavenger_description),
PRECISION(R.string.pet_ability_precision_name, R.string.pet_ability_precision_description),
FLEETFOOT(R.string.pet_ability_fleetfoot_name, R.string.pet_ability_fleetfoot_description),
ARCANE_SURGE(R.string.pet_ability_arcane_surge_name, R.string.pet_ability_arcane_surge_description),
BRAWN(R.string.pet_ability_brawn_name, R.string.pet_ability_brawn_description),
FINESSE(R.string.pet_ability_finesse_name, R.string.pet_ability_finesse_description),
WISDOM(R.string.pet_ability_wisdom_name, R.string.pet_ability_wisdom_description);
```

### 4.2 Property Fields & Scaling in [`Pet.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/pets/Pet.kt)
Declare transient fields:
```kotlin
@JvmField @Transient var bulwark: Double = 0.0
@JvmField @Transient var spellward: Double = 0.0
@JvmField @Transient var scavenger: Double = 0.0
@JvmField @Transient var precision: Double = 0.0
@JvmField @Transient var fleetfoot: Double = 0.0
@JvmField @Transient var arcaneSurge: Double = 0.0
@JvmField @Transient var brawn: Int = 0
@JvmField @Transient var finesse: Int = 0
@JvmField @Transient var wisdom: Int = 0
```

In `configureAbility(petAbility: PetAbility, level: Int)`:
```kotlin
PetAbility.BULWARK -> this.bulwark = d * 0.15
PetAbility.SPELLWARD -> this.spellward = d * 0.15
PetAbility.SCAVENGER -> this.scavenger = d * 0.50
PetAbility.PRECISION -> this.precision = d * 0.15
PetAbility.FLEETFOOT -> this.fleetfoot = d * 0.15
PetAbility.ARCANE_SURGE -> this.arcaneSurge = d * 0.35
PetAbility.BRAWN -> this.brawn = Utils.round(d * 0.20)
PetAbility.FINESSE -> this.finesse = Utils.round(d * 0.20)
PetAbility.WISDOM -> this.wisdom = Utils.round(d * 0.20)
```

### 4.3 Updating Pet Ability Rolling in [`Utils.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/Utils.kt#L230)
Update `rollPetAbility(list: List<PetAbility>)` to include all 25 abilities (16 vanilla + 9 new) with equal uniform weighting ($1/25 = 0.04$ per ability), looping until a unique ability not in `list` is selected.

### 4.4 Formatting Descriptions in [`DialogPetDetail.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogPetDetail.kt)
Add formatting cases in `formatPetAbilityDescription(petAbility: PetAbility)`:
- `BULWARK`: Format percentage reduction `p.bulwark`
- `SPELLWARD`: Format percentage reduction `p.spellward`
- `SCAVENGER`: Format efficiency percentage `p.scavenger`
- `PRECISION`: Format crit chance percentage `p.precision`
- `FLEETFOOT`: Format dodge chance percentage `p.fleetfoot`
- `ARCANE_SURGE`: Format magic amp percentage `p.arcaneSurge`
- `BRAWN`: Format flat stat `p.brawn`
- `FINESSE`: Format flat stat `p.finesse`
- `WISDOM`: Format flat stat `p.wisdom`

### 4.5 Combat & Exploration Integrations
1. **`BULWARK` & `SPELLWARD`**: Integrated in `Entity.applyDamage()` before damage subtraction.
2. **`PRECISION` & `FLEETFOOT`**: Integrated in `Adventurer.calculateCriticalChance()` and `Adventurer.calculateTotalFlatDodgeChance()`.
3. **`ARCANE_SURGE`**: Integrated in damage dealing when `isMagic == true`.
4. **`SCAVENGER`**: Passed into `Utils.rollFromWeightedMap()` when resolving area drop tables.
5. **`BRAWN`, `FINESSE`, `WISDOM`**: Added to `Adventurer` stat calculation routines.

### 4.6 String Resources in `strings.xml`
Add localized string pairs for each ability (`name` and `description` with `%s` / `%.1f` placeholders).

---

## 5. Verification & Test Plan

1. **Physical & Magic Mitigation**:
   - Verify ally takes 15% less physical damage with a Lv 100 Bulwark pet.
   - Verify ally takes 15% less magic damage with a Lv 100 Spellward pet.
2. **Scavenger Drop Multiplier**:
   - Verify drop rates scale proportionally up to $+50\%$ without exceeding ceiling.
3. **Attribute Auras**:
   - Verify adventurer CON, DEX, INT increase by $+20$ with a Lv 100 Brawn/Finesse/Wisdom pet exploring with them.
4. **Roll Uniqueness & Stability**:
   - Hatch pets and verify abilities roll from all 25 traits with no duplicate slots.
5. **Full Unit Test Pass**:
   - `./gradlew.bat testDebugUnitTest` runs green.
