# Implementation Plan: Bleed Rebalance & Hemorrhage System

## Goal Description
Rebalance the **Bleed** status effect to address its early-game front-load weakness, lack of crit synergy, and absence of pet scaling. This introduces:
1. **Armor Shred**: Bleeding targets have their Defense reduced by `0.1%` per Bleed stack (capped at `15%`, rounded down).
2. **Instant Hemorrhage (Proposal B - Elden Ring Style Blood Loss)**:
   - **Purely Additive Trigger**: Hemorrhage is added into `ACTIVE_THOUSAND_CUTS` and `ACTIVE_THOUSAND_CUTS_II` as an additional effect. **All existing features of these skills remain 100% unchanged** (3.0x critical amplification, damage-to-bleed conversion of `damage / 3.0` for T1 and `damage / 2.0` for T2, target selection, and execution mechanics are all preserved).
   - Triggered **instantly** right at the moment Thousand Cuts lands and applies its Bleed stacks.
   - Deals instant burst damage equal to **100% of current Bleed stacks**, multiplied by the party pet's `Bloodcrave` bonus.
   - Rolls for Critical Hit based on the individual **inflicter's** Critical Chance and Critical Damage.
   - Supports **Savage Super-Crit** tiering:
     - Normal hit: `"[Target] hemorrhaged. It lost [Dmg] damage!"`
     - Critical hit: `"[Target] hemorrhaged. It lost [Dmg] damage! Critical Hit!"`
     - Savage super-crit: `"[Target] hemorrhaged. It lost [Dmg] damage! Devastating Hit!"`
   - Bleed stacks are preserved on the target (not consumed), maintaining armor shred and turn-tick DoT pressure.
   - The 1,000-stack automatic rupture is **removed** (Hemorrhage applies exclusively as an added trigger on Thousand Cuts I & II).
3. **Pet Ability: `BLOODCRAVE`**:
   - Increases damage dealt by bleeding and hemorrhage by `floor(level * 0.5)%` (e.g. Level 100 = +50% bleed damage).
   - Replaces `Counterattack` in the `Wild` pet family guaranteed first ability pool: Wild pets now roll either `LIFESTEAL` (Bloodthirsty) or `BLOODCRAVE`.
   - Multiplies damage when bleed damage is dealt (both turn-start Bleed ticks and instant Hemorrhage procs), leaving stack application from weapons and skills unchanged.
4. **Two New Savage-Inspired Bleed Pet Abilities (Option C Selected - Both Implemented)**:
   - **`LACERATE` (Double Bleed Damage Tick)**: `0.6%` chance per level (`level * 0.6%`) that when Bleed deals damage on an enemy's turn, it deals damage **one additional time** without consuming an extra charge/stack, logging a custom event (`log_status_bleed_lacerate`).
   - **`SERRATED` (Double Bleed Infliction)**: `0.6%` chance per level (`level * 0.6%`) that when an ally inflicts Bleed (via attacks, skills, or items), it **inflicts bleed twice** (doubling the added stacks), logging a custom event (`log_bleed_serrated`).

---

## User Review Required

> [!NOTE]
> All design decisions confirmed:
> - **Thousand Cuts Preservation**: Existing properties (`setCriticalAmplification(3.0)`, `turnsLeft = damage / 3.0` or `/ 2.0`) are completely untouched. Hemorrhage is strictly an added trigger right after existing Bleed stacks are applied.
> - **Hemorrhage**: Proposal B instant Elden Ring-style blood loss on Thousand Cuts 1 & 2; auto-rupture removed.
> - **Hemorrhage Crits**: Tiered logging matches game conventions: rolls Critical Hit (`R.string.log_critical_hit`), and if pet has `Savage`, can roll Devastating Hit (`R.string.log_devastating_hit`).
> - **Pet Abilities**:
>   - `BLOODCRAVE`: `0.5%` per level damage multiplier, replaces `Counterattack` in `Wild` guaranteed pool.
>   - Option C selected: Both `LACERATE` (double tick) and `SERRATED` (double inflict) added at `0.6%` per level with custom proc combat logs.

---

## Detailed Mechanics & Formulas

### 1. Armor Shred Formula
- Target's Defense is reduced based on current Bleed stacks:
  $$\text{Armor Shred \%} = \min(15, \lfloor\text{bleedStacks} \times 0.1\rfloor)$$
- Integrated into [Entity.calculateTotalDefense()](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/Entity.kt) or [Entity.applyDamage()](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/Entity.kt).
- Example: 50 Bleed stacks = -5% DEF; 100 stacks = -10% DEF; 150+ stacks = -15% DEF (cap).

### 2. Hemorrhage Instant Damage & Tiered Crit Formula
- **Trigger**: Occurs immediately when a rogue lands `ACTIVE_THOUSAND_CUTS` or `ACTIVE_THOUSAND_CUTS_II`. 
  - **Unchanged Existing Logic**: Thousand Cuts first applies its normal damage with 3.0x critical amplification, then applies its normal added Bleed stacks (`damage / 3.0` for T1, `damage / 2.0` for T2, with potential `SERRATED` double-infliction).
  - **New Added Trigger**: Immediately after `applyStatus()` adds the bleed stacks, Hemorrhage evaluates the target's total Bleed stacks and deals instant damage.
- **Base Damage**:
  $$\text{Base Hemorrhage} = \text{target.currentBleedStacks} \times \left(1.0 + \frac{\text{pet.bloodcrave}}{100}\right)$$
- **Tiered Critical Strike Roll (matches Savage behavior)**:
  1. **Standard Crit Check**:
     $$\text{isCrit} = \text{random}(0, 100) < \text{inflicter.calculateCriticalChance()}$$
  2. **Savage Super-Crit Check**:
     $$\text{isSuperCrit} = \text{isCrit} \land (\text{pet.savage} > 0) \land (\text{random}(0, 100) < \text{pet.savage})$$
  3. **Multiplier & Log Tag**:
     - **Normal (critTier = 0)**:
       $$\text{Damage} = \text{Base Hemorrhage}$$
       Log: `"[Target] hemorrhaged. It lost [Dmg] damage!"`
     - **Critical Hit (critTier = 1)**:
       $$\text{Damage} = \text{Base Hemorrhage} \times \left(\frac{\text{inflicter.calculateCriticalDamage()}}{100.0}\right)$$
       Log: `"[Target] hemorrhaged. It lost [Dmg] damage! Critical Hit!"`
     - **Devastating Hit (critTier = 2)**:
       $$\text{Damage} = \text{Base Hemorrhage} \times \left(\frac{\text{inflicter.calculateCriticalDamage()}}{100.0}\right)^2$$
       *(or doubled multiplier, matching `Area.kt` lines 1820-1822)*
       Log: `"[Target] hemorrhaged. It lost [Dmg] damage! Devastating Hit!"`
- **Multi-inflicter Example**:
  - Spirit Engraver (200% crit dmg) and Hellish Sculptor (150% crit dmg):
    - Hellish Sculptor turn: crits for 150% (`Critical Hit!`).
    - Spirit Engraver turn: crits for 200% (`Critical Hit!`); if pet Savage rolls, becomes `Devastating Hit!`.

### 3. Pet Ability: `Bloodcrave`
- **Identifier**: `PetAbility.BLOODCRAVE`
- **Name / Description**: `"Bloodcrave"` / `"Increases bleed damage dealt by %s%%."`
- **Level Scaling**: `pet.bloodcrave = Math.floor(level * 0.5)` (Lv 100 = 50%).
- **Turn-Start Bleed Tick Multiplier**:
  $$\text{Bleed Tick Damage} = \text{round}\left((\text{turnsLeft} + 1) \times \left(1.0 + \frac{\text{pet.bloodcrave}}{100}\right)\right)$$
  (Enemy with 100 Bleed stacks facing Lv 100 Bloodcrave takes 150 damage on its turn).
- **Pet Distribution**: Replaces `COUNTERATTACK` in [Wild.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/pets/abstractClasses/Wild.kt) `guaranteedFirstAbility()`: pool becomes `[LIFESTEAL, BLOODCRAVE]`. Also added to [Utils.rollPetAbility()](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/Utils.kt).

### 4. Savage-Inspired Pet Abilities (0.6% per Level)

#### Ability A: `LACERATE` (Double Bleed Damage Tick)
- **Identifier**: `PetAbility.LACERATE`
- **Name / Description**: `"Lacerate"` / `"Bleed: %s%% chance to deal damage twice in a turn."`
- **Scaling**: `pet.lacerate = level * 0.6` (Lv 100 = 60.0%).
- **Execution in [Area.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/Area.kt)**:
  When an entity takes turn-start Bleed damage, if `pet.lacerate > 0` and `Utils.random() < pet.lacerate / 100.0`:
  - Deals `finalBleedDamage` a second time immediately without deducting an extra turn/stack.
  - Logs custom entry: `log_status_bleed_lacerate`:
    `"[Target] suffered a lacerating wound! It lost [Dmg] damage! Lacerate!"`

#### Ability B: `SERRATED` (Double Bleed Infliction)
- **Identifier**: `PetAbility.SERRATED`
- **Name / Description**: `"Serrated"` / `"Bleed infliction: %s%% chance to inflict bleed twice."`
- **Scaling**: `pet.serrated = level * 0.6` (Lv 100 = 60.0%).
- **Execution in [Area.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/Area.kt) / [Entity.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/Entity.kt)**:
  When an ally inflicts Bleed (attacks, weapon procs like `Kabelian Claws`, skills like `Thousand Cuts`), if `pet.serrated > 0` and `Utils.random() < pet.serrated / 100.0`:
  - Doubled applied stacks (`turnsAdded *= 2`).
  - Logs custom entry: `log_bleed_serrated`:
    `"[Inflicter] inflicted serrated wounds on [Target]! Bleed doubled (+[Stacks])!"`

---

## Proposed Changes

### Resources & Localization

#### [MODIFY] [strings.xml](file:///c:/Repositories/IGM-Modded/app/src/main/res/values/strings.xml)
- `status_effect_hemorrhage`: `"Hemorrhage"`
- `log_status_hemorrhage`: `"%s hemorrhaged. It lost %s damage!%s"`
- `pet_ability_bloodcrave_name`: `"Bloodcrave"`
- `pet_ability_bloodcrave_description`: `"Increases bleed damage dealt by %s%%."`
- `pet_ability_lacerate_name`: `"Lacerate"`
- `pet_ability_lacerate_description`: `"Bleed: %s%% chance to deal damage twice in a turn."`
- `log_status_bleed_lacerate`: `"%s suffered a lacerating wound! It lost %s damage! Lacerate!"`
- `pet_ability_serrated_name`: `"Serrated"`
- `pet_ability_serrated_description`: `"Bleed infliction: %s%% chance to inflict bleed twice."`
- `log_bleed_serrated`: `"%s inflicted serrated wounds on %s! Bleed doubled (+%s)!"`

---

### Pet System

#### [MODIFY] [PetAbility.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/pets/PetAbility.kt)
- Add enum entries:
  ```kotlin
  BLOODCRAVE(R.string.pet_ability_bloodcrave_name, R.string.pet_ability_bloodcrave_description),
  LACERATE(R.string.pet_ability_lacerate_name, R.string.pet_ability_lacerate_description),
  SERRATED(R.string.pet_ability_serrated_name, R.string.pet_ability_serrated_description)
  ```

#### [MODIFY] [Pet.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/pets/Pet.kt)
- Add transient ability fields:
  ```kotlin
  @JvmField @Transient var bloodcrave: Double = 0.0
  @JvmField @Transient var lacerate: Double = 0.0
  @JvmField @Transient var serrated: Double = 0.0
  ```
- In `configureAbilities()`:
  ```kotlin
  PetAbility.BLOODCRAVE -> this.bloodcrave = Math.floor(level * 0.5)
  PetAbility.LACERATE -> this.lacerate = level * 0.6
  PetAbility.SERRATED -> this.serrated = level * 0.6
  ```
- Add getters `getBloodcrave()`, `getLacerate()`, `getSerrated()`.

#### [MODIFY] [Wild.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/pets/abstractClasses/Wild.kt)
- Update guaranteed first ability:
  ```kotlin
  override fun guaranteedFirstAbility(): List<PetAbility> = 
      Arrays.asList(PetAbility.LIFESTEAL, PetAbility.BLOODCRAVE)
  ```

#### [MODIFY] [DialogPetDetail.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogPetDetail.kt)
- Add ability description formatters:
  ```kotlin
  PetAbility.BLOODCRAVE -> String.format(string, wrap(UIUtils.formatDouble2Decimals(p.bloodcrave)))
  PetAbility.LACERATE -> String.format(string, wrap(UIUtils.formatDouble2Decimals(p.lacerate)))
  PetAbility.SERRATED -> String.format(string, wrap(UIUtils.formatDouble2Decimals(p.serrated)))
  ```

#### [MODIFY] [Utils.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/Utils.kt)
- Include `PetAbility.BLOODCRAVE`, `PetAbility.LACERATE`, and `PetAbility.SERRATED` in `rollPetAbility()`.

---

### Combat Engine & Entities

#### [MODIFY] [Entity.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/Entity.kt)
- Add helper method `getBleedStacks(): Int`.
- In `applyDamage()`:
  Factor in Armor Shred:
  ```kotlin
  val bleedShred = Math.min(15.0, Math.floor(getBleedStacks() * 0.1)) * 0.01
  val effectiveArmorFactor = Math.min(1.0, (1.0 - d2) * (1.0 - bleedShred) * 0.01 * maxDef.toDouble())
  ```

#### [MODIFY] [Area.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/Area.kt)
1. **Bleed Turn-Start Tick (line 1024)**:
   - Multiply tick damage by pet Bloodcrave bonus.
   - If pet has `LACERATE`, roll chance `Utils.random() < pet.lacerate / 100.0`:
     - Deals damage again without deducting an extra turn/stack.
     - Logs via `Logger.STATUS_BLEED_LACERATE`.
2. **Bleed Infliction (Serrated)**:
   - When an ally applies Bleed stacks, roll `pet.serrated`:
     - If proc: `addedStacks *= 2`.
     - Logs via `Logger.STATUS_BLEED_SERRATED`.
3. **Thousand Cuts & Added Hemorrhage Trigger (lines 1895-1903)**:
   - **All existing Thousand Cuts logic is strictly preserved**:
     ```kotlin
     // 1. Existing Thousand Cuts stack calculation (UNCHANGED)
     if (entity.activeSkill == Skills.ACTIVE_THOUSAND_CUTS) {
         skill.statusEffect?.turnsLeft = Utils.round(iApplyDamage.toDouble() / 3.0)
     }
     if (entity.activeSkill == Skills.ACTIVE_THOUSAND_CUTS_II) {
         skill.statusEffect?.turnsLeft = Utils.round(iApplyDamage.toDouble() / 2.0)
     }
     // 2. Existing Bleed application to target (UNCHANGED)
     if (!skill.applyEffectOnDodge) {
         applyStatus(entity2, skill.statusEffect, entity.calculateIgnoreImmunityToStatus() * 0.01)
     }

     // 3. NEW ADDED TRIGGER: Hemorrhage activates right after stacks are applied
     if (entity.activeSkill == Skills.ACTIVE_THOUSAND_CUTS || entity.activeSkill == Skills.ACTIVE_THOUSAND_CUTS_II) {
         triggerHemorrhage(inflicter = entity, target = entity2)
     }
     ```
   - In `triggerHemorrhage`:
     - Evaluates target's total Bleed stacks (`entity2.getBleedStacks()`).
     - Base damage = `stacks * (1.0 + pet.bloodcrave * 0.01)`.
     - Rolls crit using the inflicter's stats:
       - Standard crit: `isCrit = Utils.random() * 100.0 < entity.calculateCriticalChance()`.
       - Super crit: `isSuperCrit = isCrit && pet != null && pet.savage > 0.0 && Utils.random() < pet.savage / 100.0`.
       - `critTier = if (isSuperCrit) 2 else if (isCrit) 1 else 0`.
       - Multiplies damage by crit damage multiplier accordingly.
     - Deals instant burst damage to target (preserving current Bleed stacks).
     - Logs via `Logger.STATUS_HEMORRHAGE` with `critTier` (0 = normal, 1 = Critical Hit, 2 = Devastating Hit).

#### [MODIFY] [Logger.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/Logger.kt)
- Add constants:
  ```kotlin
  const val STATUS_HEMORRHAGE = 120
  const val STATUS_BLEED_LACERATE = 121
  const val STATUS_BLEED_SERRATED = 122
  ```
- In `log()` dispatcher:
  - `STATUS_HEMORRHAGE`: Formats `R.string.log_status_hemorrhage`, appending `" " + getString(R.string.log_critical_hit)` if `critTier == 1`, or `" " + getString(R.string.log_devastating_hit)` if `critTier == 2`.
  - `STATUS_BLEED_LACERATE`: Formats `R.string.log_status_bleed_lacerate`.
  - `STATUS_BLEED_SERRATED`: Formats `R.string.log_bleed_serrated`.

---

## Verification Plan

### Automated JVM Tests
- Run unit test suite:
  ```powershell
  .\gradlew.bat testDebugUnitTest
  ```
- Add unit test case in `app/src/test/java/it/paranoidsquirrels/idleguildmaster/`:
  - Verify `ACTIVE_THOUSAND_CUTS` and `ACTIVE_THOUSAND_CUTS_II` retain their 3.0x critical amplification and exact damage-to-bleed stack conversion (`/3.0` and `/2.0`).
  - Verify Wild pet guaranteed ability rolls only `LIFESTEAL` or `BLOODCRAVE`.
  - Verify Pet abilities `BLOODCRAVE` (50% at Lv100), `LACERATE` (60% at Lv100), and `SERRATED` (60% at Lv100).
  - Verify Bleed turn tick with Bloodcrave Lv 100 deals 150 damage on 100 stacks.
  - Verify Lacerate proc deals damage twice without reducing stack count.
  - Verify Serrated proc doubles applied stacks.
  - Verify Hemorrhage instant trigger on Thousand Cuts executes immediately, crits with inflicter crit stats, and logs `Critical Hit!` or `Devastating Hit!`.
  - Verify Armor Shred caps at 15% at 150+ stacks.

### Build Verification
- Compile Debug APK:
  ```powershell
  .\gradlew.bat assembleDebug
  ```
- Verify clean compilation with zero warnings or resource errors.
