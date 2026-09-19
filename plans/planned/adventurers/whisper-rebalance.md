# Implementation Plan - Whisper Evolution Line Rebalance

Perform a comprehensive overhaul and rebalance of the underperforming **Whisper Branch** (Thief $\to$ Rogue $\to$ Shadow $\to$ Assassin $\to$ Spire Line $\to$ Whisper).

---

## Goal & Design Philosophy

- **Problem**: Zero combat-relevant passives (only trap disarm and target selection); dagger scaling is pure DEX/CON with low base damage; `Eclipse` execution threshold (<25%) and on-kill recasting are completely ineffective in prolonged boss fights.
- **Rework**: Transform into the ultimate **Phantom Executioner / Crit Assassin**. Gains combat passives (Crit Chance, Armor Piercing, Missing-HP Damage Amplification), and an active `Eclipse` rework that deals escalating damage against wounded targets and executes without being dead weight on bosses.

---

## User Review Required

> [!IMPORTANT]
> **Whisper Scaling Philosophy**:
> - **Missing HP Scaling**: Whisper gains up to **+75% bonus damage** based on how low the target's HP is (`1.0 + 0.75 * missingHp%`), with guaranteed Critical Strikes on targets below 25% HP.

---

## Detailed Mechanics & Formulas

### 1. Stat & Scaling Profile
- **Weapon Scaling**: Daggers scale with **100% DEX + 60% CON**.
- **Innate Trait**: Retains `saboteur = true` and `flatDodgeChance = 0.15` (stealth avoidance).

### 2. Combat Passives Rework
- **T4 (`Assassin`)**: **Shadow Stalker I** (+10% Crit Chance, ignores 20% Enemy DEF).
- **T5 (`SpireInitiate`)**: **Shadow Stalker II** (+15% Crit Chance, ignores 25% Enemy DEF).
- **T6 (`SpireAcolyte`)**: **Cull the Weak I** (+15% Crit Chance, ignores 30% Enemy DEF, attacks deal up to **+30% damage** against targets with missing HP: $\text{dmg} \times (1.0 + 0.3 \times \text{missingHP\%})$).
- **T7 (`SpireLeader`)**: **Cull the Weak II** (+20% Crit Chance, ignores 35% Enemy DEF, up to **+45% damage** against missing HP).
- **T8 (`SpireSage`)**: **Phantom Lethality I** (+20% Crit Chance, ignores 40% Enemy DEF, up to **+60% damage** against missing HP, trap disarm retained).
- **T9 (`Whisper`)**: **Phantom Lethality II**:
  - **+25% Crit Chance**, **ignores 50% Enemy DEF**, trap disarm retained.
  - **Execution Stance**: Attacks deal up to **+75% damage** scaled by missing HP. Targets below 25% HP suffer guaranteed Critical Strikes that bypass all shields.

### 3. Active Skill: `ACTIVE_ECLIPSE` Rework
Instead of being a dead skill until 25% HP:
- **Damage**: Deals **300% Physical Damage** with **3.0x Critical Amplification**.
- **Culling Strike**: Deals $+1\%$ extra damage per $1\%$ missing target HP (up to 2x damage on low HP).
- **Execute & Chain**: If target's HP is below threshold (T5: 10%, T6: 15%, T7: 20%, T8: 25%, T9: 30%), the target is instantly executed. If killed, recasts on the next lowest HP target.
- **Boss Synergy**: If the target does not die, grants Whisper **Shadow Cloak** for 1 turn (100% dodge against next attack) and refunds 50% cooldown.

---

## Tier-by-Tier Evolution Summary

| Tier | Unit | Weapon Scaling | Passive | Active Skill |
| :--- | :--- | :--- | :--- | :--- |
| **T4** | `Assassin` | 100% DEX, 50% CON | Shadow Stalker I (+10% Crit, 20% Armor Pen) | Backstab III (3.0x crit amp) |
| **T5** | `SpireInitiate` | 100% DEX, 50% CON | Shadow Stalker II (+15% Crit, 25% Armor Pen) | Eclipse I (250% dmg, execute <10%) |
| **T6** | `SpireAcolyte` | 100% DEX, 60% CON | Cull the Weak I (+15% Crit, 30% Armor Pen, +30% vs wounded) | Eclipse II (275% dmg, execute <15%) |
| **T7** | `SpireLeader` | 100% DEX, 60% CON | Cull the Weak II (+20% Crit, 35% Armor Pen, +45% vs wounded) | Eclipse III (300% dmg, execute <20%) |
| **T8** | `SpireSage` | 100% DEX, 60% CON | Phantom Lethality I (+20% Crit, 40% Armor Pen, +60% vs wounded, Trap Disarm) | Eclipse III (325% dmg, execute <25%) |
| **T9** | `Whisper` | 100% DEX, 60% CON | Phantom Lethality II (+25% Crit, 50% Armor Pen, +75% vs wounded, True Execute <25%) | Eclipse IV (350% dmg, execute <30%, recast on kill) |

---

## Proposed Changes

### Resources & Localization
- Add string resources in `strings.xml`:
  - `passive_shadow_stalker_i_name` / `_description`
  - `passive_cull_the_weak_i_name` / `_description`
  - `passive_phantom_lethality_name` / `_description`

### Skills & Enums
- Add in `Skills.kt`:
  - `PASSIVE_SHADOW_STALKER_I`, `PASSIVE_SHADOW_STALKER_II`
  - `PASSIVE_CULL_THE_WEAK_I`, `PASSIVE_CULL_THE_WEAK_II`
  - `PASSIVE_PHANTOM_LETHALITY_I`, `PASSIVE_PHANTOM_LETHALITY_II`

### Adventurer Units
- Assign new passives, base stats, and weapon scalings in `Assassin.kt`, `SpireInitiate.kt`, `SpireAcolyte.kt`, `SpireLeader.kt`, `SpireSage.kt`, and `Whisper.kt`.

### Combat Engine (`Area.kt` & `Entity.kt`)
- In `Area.kt`: implement missing-HP damage amplification, defense ignore calculation, and Eclipse execution chaining in `cast()`.

---

## Verification Plan

### Automated Tests
- Unit tests in `app/src/test/kotlin/`:
  - Verify missing-HP damage scaling against targets at various HP levels.
  - Verify 50% defense penetration on Whisper.
  - Verify Eclipse instant execution and recast-on-kill chaining.
