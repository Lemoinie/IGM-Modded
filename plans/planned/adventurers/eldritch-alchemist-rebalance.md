# Eldritch Alchemist Rebalance: Elemental Concoctions & Chemical Reactions

## Goal Description
Rework the **Eldritch Alchemist** (Tier 5/6 Archer capstone) from a passive "suicide bomber" into an active **multi-elemental controller and reaction catalyst**, while preserving her iconic *Thaumaturgy IV* on-death reanimation as an emergency safety net.

Currently, Eldritch Alchemist is dead weight while alive (weak attacks, negligible 1-turn poison) and players are incentivized to let her die immediately just to trigger her 10× barrage. This rework gives her a powerful, engaging active kit while maintaining her high-impact on-death identity.

---

## User Review Required

> [!IMPORTANT]
> ### 1. Active Flask Cycling (While Alive)
> Rather than firing standard arrows with a 40% 1-turn poison chance, Eldritch Alchemist's basic attacks throw **Volatile Alchemical Flasks** that cycle through three elements:
> 
> * **Turn 1 (Acid Flask)**: Inflicts **Poison** (2 turns) and 1 stack of **Corrosion** (+4% damage taken).
> * **Turn 2 (Cryo Flask)**: Inflicts **Frozen** (2 turns: target cannot dodge, takes extra physical damage).
> * **Turn 3 (Pyro Flask)**: Inflicts **Ablaze** (3 turns: magic burn).

---

> [!IMPORTANT]
> ### 2. Chemical Reactions Engine
> When Eldritch Alchemist attacks an enemy already afflicted with an alchemical status, she triggers a **Chemical Reaction**:
> 
> | Existing Status on Target | Triggering Flask | Chemical Reaction | Combat Effect |
> | :--- | :--- | :--- | :--- |
> | **Corrosion / Poison** | **Pyro Flask** | **Vaporize** | Instant explosive AoE burst dealing **$1.2 \times \text{INT}$ magic damage** to all enemies. |
> | **Corrosion / Poison** | **Cryo Flask** | **Brittle Toxin** | Target's armor crystallizes, increasing **Critical Strike Damage taken by +25%** for 2 turns. |
> | **Frozen** | **Pyro Flask** | **Thermal Shock** | Shatters the freeze instantly, dealing **150% physical + 150% magical damage** in a single strike. |

---

> [!IMPORTANT]
> ### 3. Thaumaturgy IV On-Death Trigger (Preserved & Polished)
> Her signature on-death explosion is **fully preserved**:
> * When she falls in battle, she unleashes her stored concoctions:
>   * Inflicts **Poison, Freeze, and Ablaze** on all enemies (5 turns).
>   * **Stuns** all enemies (1 turn).
>   * Confers **Anointed** (+20% stats) to all allies (10 turns).
>   * Reanimates with **Feeble Tether** (100% HP, 100 Mana) to cast **Barrage II with 10× Damage Amplification** one last time.
> * *Design Impact*: The death trigger remains a game-saving ultimate, but players no longer *need* her to die to get value out of her slot.

---

> [!IMPORTANT]
> ### 4. Stat & Scaling Adjustments
> * **Weapon Scaling**: Scaled at **60% DEX + 100% INT** (emphasizing heavy Intelligence/Thaumaturge scaling over pure Dexterity).
> * **Stats**: Retains Bow weapon proficiency and Medium Armor.

---

## Proposed Changes

### Class Implementation
#### [MODIFY] [EldritchAlchemist.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/adventurers/units/EldritchAlchemist.kt)
- Set `attackDexterityScaling = 0.6`, `attackIntelligenceScaling = 1.0`.
- Add flask cycle tracker state (Acid $\rightarrow$ Cryo $\rightarrow$ Pyro).
- Update `onTargetHit` to apply the active cycling flask effect.

---

### Combat & Reaction Execution
#### [MODIFY] [Area.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/Area.kt)
- In attack resolution: detect active Chemical Reactions (Vaporize, Brittle Toxin, Thermal Shock).
- Apply AoE burst for Vaporize and crit multiplier for Brittle Toxin.
- Maintain existing `reanimateAlchemistWithFeebleTether()` on-death logic.

---

### Strings & Resources
#### [MODIFY] [strings.xml](file:///c:/Repositories/IGM-Modded/app/src/main/res/values/strings.xml)
- Update `passive_thaumaturgy_iv_description` to document active flask cycling and chemical reactions alongside the on-death trigger.

---

## Verification Plan

### Automated Tests
- In `EldritchAlchemistTest.kt`:
  - `testFlaskCycleProgression()`: verify basic attacks cycle through Acid, Cryo, and Pyro in sequence.
  - `testVaporizeAoEReaction()`: verify hitting a poisoned target with Pyro flask triggers Vaporize AoE magic damage.
  - `testBrittleToxinReaction()`: verify hitting a poisoned target with Cryo flask increases critical damage taken.
  - `testThermalShockReaction()`: verify hitting a frozen target with Pyro flask shatters freeze for double damage.
  - `testOnDeathThaumaturgyPreserved()`: verify Alchemist still applies team buffs, enemy debuffs, and reanimates with Feeble Tether for 10× Barrage II.
