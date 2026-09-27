# Implementation Plan - Adventurer Traits Expansion

## 1. Overview
Expand the adventurer trait pool by introducing **4 new Basic (Common) Traits** (each with an Evo-22 PLUS upgrade) and **5 new Rare Traits** (`DEADEYE`, `SUNDERING`, `FORTIFIED`, `RECKLESS`, and `LONE_WOLF`). This resolves the limitation where hybrid classes are penalized by existing single-stat traits, and introduces key tactical niches (Critical Chance, Armor Penetration, Battle-Start Shielding, Glass-Cannon Burst, and Dynamic Solo/Clutch Scaling).

---

## 2. Design & Architecture

### Current Trait System
- **Common Traits** (`Adventurer.getStat()`):
  - Base stats modified: CON (0), INT (1), DEX (2).
  - Existing pool: `BOOKWORM` (+10% INT, -5% CON/DEX), `BRUTE` (+10% CON, -5% INT/DEX), `FERAL` (+10% DEX, -5% CON/INT).
  - Existing Evo-22 PLUS upgrades: `BOOKWORM_PLUS` (+20% INT), `BRUTE_PLUS` (+20% CON), `FERAL_PLUS` (+20% DEX).
  - *Design Goal:* Provide hybrid (dual-stat) and all-rounder (tri-stat) traits with balanced stat budgets so multi-role classes are no longer penalized.
- **Rare Traits** (`Adventurer.kt`, `Entity.kt`, `Area.kt`):
  - Grant unique combat passives (Lifesteal, Dodge, Counterattack, Threat, Darkness, Initiative, Crit Damage, Status Duration via Mindful, % Damage Reduction via Dragon Blood).
  - *Design Goal:* Fill missing mechanical gaps without overlapping existing traits like `DRAGON_BLOOD` (% damage reduction) or `MINDFUL` (status duration).

---

## 3. Trait Specifications

### A. Basic (Common) Traits (Base + Evo-22 PLUS)

| Trait | Base Effect | Evo-22 PLUS Form | PLUS Effect | Target Archetypes |
| --- | --- | --- | --- | --- |
| **`VERSATILE`** | **+4% CON, +4% INT, +4% DEX** (No penalty) | **`VERSATILE_PLUS`** | **+7% CON, +7% INT, +7% DEX** (No penalty) | All-rounders, Spellblades, Hybrids |
| **`ZEALOUS`** | **+5% CON, +5% INT**, -10% DEX | **`ZEALOUS_PLUS`** | **+10% CON, +10% INT** (No DEX penalty) | Holy Knight, Paladin, Cleric, Dark Knight |
| **`CUNNING`** | **+5% DEX, +5% INT**, -10% CON | **`CUNNING_PLUS`** | **+10% DEX, +10% INT** (No CON penalty) | Trickster, Shadow Dancer, Arcane Archer |
| **`ATHLETIC`** | **+5% CON, +5% DEX**, -10% INT | **`ATHLETIC_PLUS`** | **+10% CON, +10% DEX** (No INT penalty) | Brawler, Swashbuckler, Berserker, Ranger |

#### Stat Multiplier Math in `Adventurer.getStat(i)`:
```kotlin
when (tc) {
    // Existing Single-Stat Base & PLUS
    Trait.BOOKWORM -> if (i == 1) d = 1.1 else if (i == 0 || i == 2) d = 0.95
    Trait.FERAL -> if (i == 2) d = 1.1 else if (i == 0 || i == 1) d = 0.95
    Trait.BRUTE -> if (i == 0) d = 1.1 else if (i == 1 || i == 2) d = 0.95
    Trait.BOOKWORM_PLUS -> if (i == 1) d = 1.2
    Trait.FERAL_PLUS -> if (i == 2) d = 1.2
    Trait.BRUTE_PLUS -> if (i == 0) d = 1.2

    // Tri-Stat All-Rounder
    Trait.VERSATILE -> d = 1.04
    Trait.VERSATILE_PLUS -> d = 1.07

    // Dual-Stat Base
    Trait.ZEALOUS -> if (i == 0 || i == 1) d = 1.05 else if (i == 2) d = 0.90
    Trait.CUNNING -> if (i == 1 || i == 2) d = 1.05 else if (i == 0) d = 0.90
    Trait.ATHLETIC -> if (i == 0 || i == 2) d = 1.05 else if (i == 1) d = 0.90

    // Dual-Stat PLUS (Evo-22 Upgrades)
    Trait.ZEALOUS_PLUS -> if (i == 0 || i == 1) d = 1.10
    Trait.CUNNING_PLUS -> if (i == 1 || i == 2) d = 1.10
    Trait.ATHLETIC_PLUS -> if (i == 0 || i == 2) d = 1.10

    else -> {}
}
```

---

### B. New Rare Traits

| Trait | Category | Effect | Combat Hook |
| --- | --- | --- | --- |
| **`DEADEYE`** | Offensive | **+12% Critical Strike Chance** | `Adventurer.calculateCriticalChance()` |
| **`SUNDERING`** | Offensive / Utility | **Ignores 20% of target's Defense and Magic Defense** | `Adventurer.getArmorIgnored()` |
| **`FORTIFIED`** | Defensive / Tempo | **Starts every battle with a Shield equal to 25% of Max HP** | `Area.initializeFight()` |
| **`RECKLESS`** | Offensive / Glass Cannon | **Deals +15% Attack Damage, takes +15% more damage** | `Adventurer.calculateMinAttackDamage()`, `Adventurer.calculateMaxAttackDamage()`, `Entity.applyDamage()` |
| **`LONE_WOLF`** | Offensive / Solo & Clutch | **Gains +5% damage for each unoccupied or fallen ally slot in the area** | `Area.dealDamage()` |

#### Detailed Mechanics:
1. **`DEADEYE`**:
   - In `Adventurer.calculateCriticalChance()`:
     ```kotlin
     if (traitRare == Trait.DEADEYE) cc += 0.12
     ```
2. **`SUNDERING`**:
   - In `Adventurer.getArmorIgnored()`:
     ```kotlin
     override fun getArmorIgnored(): Double {
         val base = armorIgnored + ((doctrine?.ignoreArmorPercentage() ?: 0).toDouble() * 0.01)
         return if (traitRare == Trait.SUNDERING) base + 0.20 else base
     }
     ```
3. **`FORTIFIED`**:
   - In `Area.initializeFight()`:
     ```kotlin
     for (adventurer in this.adventurersExploring) {
         if (adventurer.currentHp > 0 && adventurer.traitRare == Trait.FORTIFIED) {
             val shieldAmount = Utils.round(adventurer.calculateTotalMaxHp() * 0.25)
             adventurer.currentShield = maxOf(adventurer.currentShield, shieldAmount)
         }
     }
     ```
4. **`RECKLESS`**:
   - **Outgoing Attack Damage (+15%)** in `Adventurer.kt`:
     ```kotlin
     override fun calculateMinAttackDamage(): Int {
         val w = weapon ?: return 1
         val con = Utils.round(calculateTotalConstitution() * attackConstitutionScaling)
         val int = Utils.round(calculateTotalIntelligence() * attackIntelligenceScaling)
         val dex = Utils.round(calculateTotalDexterity() * attackDexterityScaling)
         var damageModifier = w.getDamageModifier(con, int, dex).toFloat()
         if (w is SerpentBite) damageModifier *= getThreat().toFloat()
         if (traitRare == Trait.RECKLESS) damageModifier *= 1.15f
         return Utils.round(damageModifier.toDouble() * (1.0 - w.damageDelta()))
     }

     override fun calculateMaxAttackDamage(): Int {
         val w = weapon ?: return 1
         val con = Utils.round(calculateTotalConstitution() * attackConstitutionScaling)
         val int = Utils.round(calculateTotalIntelligence() * attackIntelligenceScaling)
         val dex = Utils.round(calculateTotalDexterity() * attackDexterityScaling)
         var damageModifier = w.getDamageModifier(con, int, dex).toFloat()
         if (w is SerpentBite) damageModifier *= getThreat().toFloat()
         if (traitRare == Trait.RECKLESS) damageModifier *= 1.15f
         return Utils.round(damageModifier.toDouble() * (w.damageDelta() + 1.0))
     }
     ```
   - **Incoming Damage Taken (+15%)** in `Entity.applyDamage()`:
     ```kotlin
     if (this is Adventurer && traitRare == Trait.DRAGON_BLOOD) {
         val tier = maxLevel / 5
         damageAfterArmor *= Math.max(0.0, 1.0 - (tier.toDouble() * 0.01))
     }
     if (this is Adventurer && traitRare == Trait.RECKLESS) {
         damageAfterArmor *= 1.15
     }
     ```
5. **`LONE_WOLF`**:
   - Scales dynamically with the area's maximum slots (`adventurersNumber()`) and living team status.
   - Activates both when brought solo AND dynamically in combat whenever allies fall.
   - In `Area.dealDamage()`:
     ```kotlin
     if (entity is Adventurer && entity.traitRare == Trait.LONE_WOLF) {
         val livingAllies = this.adventurersExploring.count { it !== entity && it.currentHp > 0 }
         val missingAllySlots = maxOf(0, adventurersNumber() - 1 - livingAllies)
         if (missingAllySlots > 0) {
             livingCompanionBonusDamage *= (1.0 + (missingAllySlots * 0.05))
         }
     }
     ```
   - **Scaling Examples**:
     - Standard 4-man dungeon: Full team = 0%; 1 dead = +5%; 2 dead = +10%; Solo / Last survivor = +15%.
     - 8-man raid (e.g. Celestial Mothership): 3 dead = +15%; Solo runner = +35%.
     - 14-man epic raid (e.g. Sanguine Crucible): 3 dead = +15%; 6 dead = +30%; Solo runner = +65%.

---

## 4. Recruitment Rolling Probabilities

### Common Trait Rolling (`Utils.rollCommonTrait`):
Overall chance remains **40.0%** across 7 common traits (~5.714% each):
- `dRandom < 0.0571`: `Trait.BOOKWORM`
- `dRandom < 0.1143`: `Trait.BRUTE`
- `dRandom < 0.1714`: `Trait.FERAL`
- `dRandom < 0.2286`: `Trait.VERSATILE`
- `dRandom < 0.2857`: `Trait.ZEALOUS`
- `dRandom < 0.3429`: `Trait.CUNNING`
- `dRandom < 0.4000`: `Trait.ATHLETIC`
- `dRandom >= 0.4000`: `null` (60% no common trait)

### Rare Trait Rolling (`Utils.rollRareTrait`):
Overall chance remains **20.0%** spread across 19 rare traits (~1.053% each):
1. `EMPATHETIC`
2. `GIFTED`
3. `INTIMIDATING`
4. `FOCUSED`
5. `DRAGON_BLOOD`
6. `CURSED`
7. `REACTIVE`
8. `NOCTURNAL`
9. `MINDFUL`
10. `TROLL_BLOOD`
11. `RUTHLESS`
12. `BLESSED`
13. `ALERT`
14. `NIMBLE`
15. `DEADEYE` *(New)*
16. `SUNDERING` *(New)*
17. `FORTIFIED` *(New)*
18. `RECKLESS` *(New)*
19. `LONE_WOLF` *(New)*

---

## 5. Scope & Touchpoints

| File | Change Type | Purpose |
| --- | --- | --- |
| [`app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/adventurers/Trait.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/adventurers/Trait.kt) | Modify | Add `VERSATILE`, `VERSATILE_PLUS`, `ZEALOUS`, `ZEALOUS_PLUS`, `CUNNING`, `CUNNING_PLUS`, `ATHLETIC`, `ATHLETIC_PLUS`, `DEADEYE`, `SUNDERING`, `FORTIFIED`, `RECKLESS`, `LONE_WOLF` |
| [`app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/adventurers/Adventurer.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/adventurers/Adventurer.kt) | Modify | Implement stat modifiers in `getStat()`, `calculateCriticalChance()`, `getArmorIgnored()`, and attack damage scaling (+15%) |
| [`app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/Entity.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/Entity.kt) | Modify | Implement incoming damage multiplier (+15%) in `applyDamage()` for `RECKLESS` |
| [`app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/Area.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/Area.kt) | Modify | Apply 25% Max HP shield in `initializeFight()` for `FORTIFIED`; apply dynamic missing-slot damage scaling in `dealDamage()` for `LONE_WOLF` |
| [`app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/Utils.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/Utils.kt) | Modify | Update `rollCommonTrait()` (7 traits) and `rollRareTrait()` (19 traits) |
| [`app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogChangeTraitCommon.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogChangeTraitCommon.kt) | Modify | Add Evo-22 Vial upgrade mappings for `VERSATILE`, `ZEALOUS`, `CUNNING`, `ATHLETIC` |
| [`app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogChangeTraitRare.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogChangeTraitRare.kt) | Modify | Add `DEADEYE`, `SUNDERING`, `FORTIFIED`, `RECKLESS`, `LONE_WOLF` to rare trait selection list |
| [`app/src/main/res/values/strings.xml`](file:///c:/Repositories/IGM-Modded/app/src/main/res/values/strings.xml) | Modify | Add names and descriptions for all new traits |
| [`app/src/test/kotlin/it/paranoidsquirrels/idleguildmaster/ModFeaturesTest.kt`](file:///c:/Repositories/IGM-Modded/app/src/test/kotlin/it/paranoidsquirrels/idleguildmaster/ModFeaturesTest.kt) | Modify | Unit tests verifying stat math, combat passives, incoming/outgoing damage scaling, dynamic Lone Wolf scaling across area sizes, Evo-22 upgrade paths, and JSON serialization |

---

## 6. Verification Plan

### Automated Tests
Run `./gradlew testDebugUnitTest` covering:
1. **Stat Scaling**:
   - `VERSATILE`: CON +4%, INT +4%, DEX +4% (no penalty).
   - `VERSATILE_PLUS`: CON +7%, INT +7%, DEX +7% (no penalty).
   - `ZEALOUS`: CON +5%, INT +5%, DEX -10%.
   - `ZEALOUS_PLUS`: CON +10%, INT +10%, no DEX penalty.
   - `CUNNING`: DEX +5%, INT +5%, CON -10%.
   - `CUNNING_PLUS`: DEX +10%, INT +10%, no CON penalty.
   - `ATHLETIC`: CON +5%, DEX +5%, INT -10%.
   - `ATHLETIC_PLUS`: CON +10%, DEX +10%, no INT penalty.
2. **Combat Hooks**:
   - `DEADEYE`: +0.12 crit chance.
   - `SUNDERING`: +0.20 armor ignored.
   - `FORTIFIED`: gains `Utils.round(maxHp * 0.25)` shield in `initializeFight()`.
   - `RECKLESS`: +15% attack damage in `calculateMinAttackDamage()` / `calculateMaxAttackDamage()`, and +15% incoming damage in `Entity.applyDamage()`.
   - `LONE_WOLF`:
     - In 4-man dungeon with 0 living allies: +15% damage bonus.
     - In 14-man raid with 3 fallen allies: +15% damage bonus.
     - In 14-man raid solo (13 empty slots): +65% damage bonus.
     - In full party with all allies alive: +0% damage bonus.
3. **Evo-22 Vial Upgrades**:
   - Test upgrading each new common trait to its PLUS form via `DialogChangeTraitCommon`.
4. **Serialization & Deserialization**:
   - Verify all new trait enum entries correctly serialize and deserialize through `Trait.fromString()`.

### Build Verification
```powershell
./gradlew assembleDebug
```
Ensure zero compilation errors and all string resources compile cleanly.
