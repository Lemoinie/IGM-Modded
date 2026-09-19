# Implementation Plan - Wyrm Rider Evolution Line Rebalance

Perform a comprehensive overhaul and rebalance of the underperforming **Wyrm Rider Branch** (Archer $\to$ Hunter $\to$ Tamer $\to$ Wolf Rider $\to$ Drake Line $\to$ Wyrm Rider).

---

## Goal & Design Philosophy

- **Problem**: Mount attacks deal static flat damage (e.g. Wyrm deals 100 flat damage in endgame where bosses have 10,000+ HP); stats give 20 INT but bows only scale with DEX; active skills randomly alternate between physical barrage, corrosive spit, and subzero magic with no cohesive beastmaster fantasy.
- **Rework**: Transform into a **Hybrid Dragoon / Beast Commander**. Mount attacks dynamically scale with the Rider's DEX + INT and darkness; bows gain hybrid scaling; active skills become coordinated beast strikes unleashing draconic breath weapons (Fire, Ice, Acid) and aerial arrow volleys.

---

## User Review Required

> [!IMPORTANT]
> **Wyrm Rider Mount Scaling**:
> - Mount end-of-turn attack deals hybrid damage: **120% DEX + 120% INT** as Magic Dragon Breath to all enemies, rolling Critical Strikes with the Rider's stats.

---

## Detailed Mechanics & Formulas

### 1. Stat & Scaling Profile
- **Stat Split**: High DEX (40 at T9) and high INT (20 at T9).
- **Hybrid Weapon Scaling**:
  ```kotlin
  attackDexterityScaling = 1.0
  attackIntelligenceScaling = 0.5
  ```
  (Bows wielded by Riders channel both precise archery and draconic elemental mana).

### 2. Mount End-of-Turn Attack Overhaul
Replace static flat damage in `EndOfTurnAction.kt` with **stat-scaling beast attacks**:
- **T4 (`WolfRider` - `RIDER_II`)**: Wolf Bite deals Physical Damage equal to **60% Rider DEX**, rolls Crit.
- **T5 (`WorgRider` - `RIDER_III`)**: Worg Maul deals Physical Damage equal to **80% Rider DEX**, applies Bleed (15 stacks).
- **T6 (`SpitfangRider` - `RIDER_IV`)**: Spitfang Acid deals Magic Damage equal to **60% DEX + 60% INT**, applies Poison (3 turns).
- **T7 (`DrakeRider` - `RIDER_V`)**: Drake Fire Breath deals Magic Damage equal to **75% DEX + 75% INT** to front row, applies Ablaze (2 turns).
- **T8 (`GoldenRider` - `RIDER_VI`)**: Golden Drake Breath deals Magic Damage equal to **90% DEX + 90% INT** to front row, applies Ablaze + reduces enemy Accuracy by 15%.
- **T9 (`WyrmRider` - `RIDER_VII`)**: **Cataclysmic Wyrm Breath**:
  - Deals Magic Damage equal to **120% DEX + 120% INT** to **all enemies**.
  - Rolls Critical Strikes with Rider's Crit stats.
  - Inflicts Frostbite & Burn: applies both **Ablaze** (2 turns) and **Frozen** (1 turn).

### 3. Active Skills Rework: Coordinated Draconic Assaults
- **T4 (`WolfRider`)**: `ACTIVE_BARRAGE_II` $\to$ Piercing Volley (2x 150% phys damage).
- **T5 (`WorgRider`)**: `ACTIVE_BARRAGE_III` $\to$ Vicious Volley (3x 160% phys damage, bleed synergy).
- **T6 (`SpitfangRider`)**: `ACTIVE_CORROSIVE_SHOT` $\to$ 3x 180% damage, reduces target Armor by 20%.
- **T7 (`DrakeRider`)**: `ACTIVE_DRAGONFIRE_VOLLEY` $\to$ 220% fire damage to all enemies, burns targets.
- **T8 (`GoldenRider`)**: `ACTIVE_SOLAR_SALVO` $\to$ 260% radiant fire damage to all enemies, blinds targets for 2 turns.
- **T9 (`WyrmRider`)**: `ACTIVE_SUBLIMATE_II`:
  - Rider looses an astral volley dealing **250% Physical damage** to all enemies.
  - Wyrm releases subzero dragonfire dealing **250% Magic damage** to all enemies.
  - Synergizes with the party by applying Ablaze and Frozen simultaneously.

---

## Tier-by-Tier Evolution Summary

| Tier | Unit | Weapon Scaling | Mount Attack (End-of-Turn) | Active Skill |
| :--- | :--- | :--- | :--- | :--- |
| **T4** | `WolfRider` | 100% DEX, 30% INT | Wolf Bite (60% DEX Phys) | Piercing Volley (2x 150% phys) |
| **T5** | `WorgRider` | 100% DEX, 35% INT | Worg Maul (80% DEX Phys + Bleed) | Vicious Volley (3x 160% phys) |
| **T6** | `SpitfangRider`| 100% DEX, 40% INT | Spitfang Acid (60% DEX + 60% INT Magic + Poison) | Corrosive Salvo (3x 180% phys, -20% armor) |
| **T7** | `DrakeRider` | 100% DEX, 45% INT | Drake Fire (75% DEX + 75% INT Magic + Ablaze) | Dragonfire Volley (220% AoE Fire) |
| **T8** | `GoldenRider`| 100% DEX, 50% INT | Golden Breath (90% DEX + 90% INT Magic + Ablaze + Blind) | Solar Salvo (260% AoE Radiant) |
| **T9** | `WyrmRider` | 100% DEX, 50% INT | Wyrm Breath (120% DEX + 120% INT Magic to All + Ablaze + Frozen) | Draconic Sublimation (250% Phys + 250% Magic to All) |

---

## Proposed Changes

### Resources & Localization
- Add in `strings.xml`:
  - `log_wyrm_breath`: `"%s's Wyrm unleashes cataclysmic subzero dragonfire for %s damage!"`

### Skills & Enums
- Add updated active skills in `Skills.kt`: `ACTIVE_DRAGONFIRE_VOLLEY`, `ACTIVE_SOLAR_SALVO`.
- In `EndOfTurnAction.kt`: add dynamic scaling flags and DEX/INT scaling percentages to `RIDER_I` through `RIDER_VII`.

### Adventurer Units
- Update `WolfRider.kt` through `WyrmRider.kt`: set `attackDexterityScaling = 1.0`, `attackIntelligenceScaling = 0.5`. Wire active skills and mount actions.

### Combat Engine (`Area.kt`)
- In `Area.kt`: calculate mount end-of-turn damage using the Rider's DEX and INT instead of flat integer constants.

---

## Verification Plan

### Automated Tests
- Unit tests in `app/src/test/kotlin/`:
  - Verify hybrid DEX/INT weapon damage scaling.
  - Verify dynamic mount breath damage calculations across all tiers.
  - Verify status application (Ablaze + Frozen) from T9 Wyrm Breath.
