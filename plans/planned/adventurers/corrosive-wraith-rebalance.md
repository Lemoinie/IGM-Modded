# Corrosive Wraith Rebalance & Corrosion Status System

## Goal Description
Rebalance the **Corrosive Wraith** (Tier 5/6 Archer capstone) and introduce a dedicated stackable status effect: **Corrosion** (`StatusEffectType.CORROSION`).

Currently, Corrosive Wraith is held back by vanilla Poison being a pure 20–25% attack debuff with zero damage over time. This rework transforms her into a premier **single-target boss executioner and damage vulnerability debuffer** that scales with her own gear while preventing raid % max HP exploits.

---

## User Review Required

> [!IMPORTANT]
> ### 1. The Stackable `CORROSION` Status Effect
> 
> * **Stack Mechanics**: Stacks up to **5 times**. Lasts **3 turns**. Applying a new stack increments the stack count and refreshes the duration back to 3 turns.
> * **Effect 1: Universal Damage Vulnerability (+% Damage Taken)**:
>   * Target takes **+4% damage from all sources per stack** (**+20% max at 5 stacks**).
>   * *Why this solves the 0 DEF boss problem*: Unlike percentage armor shred (which does $0 \times 4\% = 0$ on 0 DEF bosses), Damage Vulnerability multiplies final incoming damage directly:
>     $$\text{Final Damage} = \text{Damage} \times (1.0 + \text{stacks} \times 0.04)$$
> * **Effect 2: Stat-Scaled Neurotoxin DoT (No Raid % HP Cheese)**:
>   * Each turn, deals magic damage equal to:
>     $$\text{Tick Damage} = \text{stacks} \times \left(0.25 \times \text{DEX}_{\text{applier}} + 0.25 \times \text{INT}_{\text{applier}}\right)$$
>   * *Raid Safety*: Scales with the player's gear and stats, never dealing broken 50,000 damage ticks on high-HP raid bosses.

---

> [!IMPORTANT]
> ### 2. Temporary Stat Reduction Engine (`ENFEEBLE`)
> 
> * **Status Effect**: `StatusEffectType.ENFEEBLE`
> * **Duration**: 2 turns.
> * **Combat Impact**:
>   * Reduces target's **CON, DEX, and INT by 15%** (multiplicatively: $\text{Stat} \times 0.85$).
>   * **On Adventurers**: Reduces damage scaling, flat DR, and hit/crit calculations.
>   * **On Enemies / Bosses**: Reduces raw attack power, ability scaling, and special combat checks.

---

> [!IMPORTANT]
> ### 3. Corrosive Wraith Kit Rework
> 
> * **Base Stat Scaling**: Weapon damage scales with **100% DEX + 50% INT** (rewarding mixed Archer potion and gear investment).
> * **Passive (*Corrosive Blood*)**:
>   * Attacks always hit (`alwaysHits = true`).
>   * Basic attacks apply **1 stack of Corrosion** (100% chance on critical strike, 40% chance on normal hit).
>   * Complete immunity to Poison and Corrosion.
> * **Active (*Focused Barrage*)**:
>   * Fires a 3-arrow barrage into the focused target.
>   * If the target has **5 Corrosion stacks**:
>     * **Acid Rupture**: Deals an instant bonus burst equal to 2 turns of Corrosion DoT without removing the stacks.
>     * Inflicts **Enfeeble** (−15% CON, DEX, and INT for 2 turns).

---

## Proposed Changes

### Status Effect System
#### [MODIFY] [StatusEffectType.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/StatusEffectType.kt)
- Add `CORROSION` (negative, stackable, icon: acid drop / green skull).
- Add `ENFEEBLE` (negative, temporary stat reduction, icon: broken sword).

#### [MODIFY] [StatusEffect.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/StatusEffect.kt)
- Add `var stacks: Int = 1`.
- Add `var statReductionPct: Double = 0.0`.

#### [MODIFY] [Entity.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/Entity.kt)
- Update `addStatusEffect()`: handle `CORROSION` stacking (increment `stacks` up to 5, refresh `turnsLeft` to 3).
- Add helper `getCorrosionStacks(): Int`.
- Update `applyDamage()`:
  $$\text{damageAfterArmor} \times= (1.0 + \text{getCorrosionStacks()} \times 0.04)$$
- Add `getStatReductionMultiplier(): Double` into `calculateTotalStat()` and enemy stat getters.

---

### Class Implementation
#### [MODIFY] [CorrosiveWraith.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/adventurers/units/CorrosiveWraith.kt)
- Set `attackDexterityScaling = 1.0`, `attackIntelligenceScaling = 0.5`.
- Update `onTargetHit` to apply `StatusEffectType.CORROSION`.
- Attach updated passive `Skills.PASSIVE_CORROSIVE_BLOOD`.

---

### Combat & Turn Execution
#### [MODIFY] [Area.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/Area.kt)
- Add turn-start DoT tick for `StatusEffectType.CORROSION` scaling with applier's DEX and INT.
- In `executeSkill()` for `ACTIVE_FOCUSED_BARRAGE`: check for 5 Corrosion stacks to trigger Acid Rupture burst and apply Enfeeble.

---

### Strings & Resources
#### [MODIFY] [strings.xml](file:///c:/Repositories/IGM-Modded/app/src/main/res/values/strings.xml)
- Update `passive_corrosive_blood_description`.
- Add name and description for `status_effect_corrosion` and `status_effect_enfeeble`.

---

## Verification Plan

### Automated Tests
- In `CorrosiveWraithTest.kt`:
  - `testCorrosionStackCapAndRefresh()`: verify stacks increment up to 5 and duration resets to 3 turns on hit.
  - `testDamageVulnerabilityOnZeroDefTarget()`: verify an enemy with 0 DEF takes exactly +20% damage at 5 stacks.
  - `testCorrosionDoTStatScaling()`: verify DoT tick damage matches `(0.25 DEX + 0.25 INT) * stacks` and does not scale with enemy max HP.
  - `testEnfeebleStatReduction()`: verify target's CON, DEX, and INT are reduced by 15% during Enfeeble duration.
  - `testAcidRuptureOnFocusedBarrage()`: verify 5-stack target triggers bonus burst damage.
