# Implementation Plan - Black Idol Evolution Line Rebalance

Perform a comprehensive overhaul and rebalance of the underperforming **Black Idol Branch** (Mage $\to$ Sorcerer $\to$ Necromancer $\to$ Lich Line $\to$ Black Idol).

---

## Goal & Design Philosophy

- **Problem**: Curses are purely on-death triggers that do nothing to living targets (completely useless in single-boss fights); 0 physical defense and 200 base HP makes them brittle glass; `Withering Link` heals a minion that never spawns against bosses.
- **Rework**: Transform into a **Dread Lich / Soul Harvester**. Curses actively torment living targets (stat shred, dark DoT, and life leech); gains active/battle-start minion summoning (does not require enemy death); gains `Soul Tether` / `Bone Armor` allowing the Lich to redirect incoming damage to their minion.

---

## User Review Required

> [!IMPORTANT]
> **Black Idol Minion Summoning & Defense**:
> - Lich automatically summons a minion at battle-start (Zombie $\to$ Skeleton $\to$ Bone Horror $\to$ Bone Nightmare $\to$ Bone Hydra based on tier), and redirects **40% of damage taken** to the minion (`Soul Tether`). When cursed enemies die, the minion gains permanent stat buffs for the rest of the battle.

---

## Detailed Mechanics & Formulas

### 1. Defense & Survivability Overhaul
- **Bone Armor**: Base Defense increased from 0 to **15 + (INT * 0.25)** (e.g. at 50 INT = 27 Defense).
- **Soul Tether (Passive)**: While a summoned minion is alive:
  - **40% of all damage taken by the Lich is redirected to the minion**.
  - With `Withering Link` (50% lifesteal healing both Lich and Minion), the Lich sustains the minion while the minion shields the Lich from fatal damage!
  - Lich cannot be one-shot while minion has HP remaining.

### 2. Independent Minion Summoning
- At the start of combat, if no minion exists, the Lich automatically summons their tier's undead servant:
  - **T4 (`Necromancer`)**: **Zombie** (High CON/HP, meatshield).
  - **T5 (`Demilich`)**: **Skeleton** (Medium CON/DEF, retaliates).
  - **T6 (`Lich`)**: **Bone Horror** (High HP/DEF, taunts enemies).
  - **T7 (`AncientLich`)**: **Bone Nightmare** (High HP, physical & magic defense).
  - **T8 (`LorfOfDecay`)**: **Bone Abomination** (High HP, poisons enemies on hit).
  - **T9 (`BlackIdol`)**: **Bone Hydra** (Massive HP, multi-target bite attacks, 3 lives/revives).
- **Corpse Empowerment**: When any cursed enemy dies during combat, the active minion absorbs their soul, permanently gaining **+10% Max HP, +10% Attack, and full HP heal**.

### 3. Active Curse Overhaul: Active Torment & Debuffs
Curses are no longer passive death triggers! While active on an enemy:
- **Lesser Curse** (T4): Reduces enemy Attack by 10%. Deals 3% max HP per turn as Dark Magic.
- **Curse** (T5): Reduces enemy Attack & DEF by 15%. Deals 4% max HP per turn.
- **Greater Curse** (T6): Reduces enemy Attack, DEF, and MDEF by 20%. Deals 5% max HP per turn.
- **Ominous Curse** (T7): Reduces enemy stats by 25%. Deals 6% max HP per turn, heals Lich for 50% of damage.
- **Abhorrent Curse** (T8-T9):
  - Reduces enemy Attack, DEF, and MDEF by **30%**.
  - Deals **8% max HP per turn** as Dark Magic damage.
  - Siphons 50% of tick damage as healing to Black Idol and the Bone Hydra.

---

## Tier-by-Tier Evolution Summary

| Tier | Unit | Defense / Shielding | Minion Companion | Active Skill & Curse Effect |
| :--- | :--- | :--- | :--- | :--- |
| **T4** | `Necromancer` | 5 DEF, 20% Soul Tether | Zombie (Summoned at battle start) | Death's Caress (250% Dark, Lesser Curse: -10% stats, 3% DoT) |
| **T5** | `Demilich` | 8 DEF, 25% Soul Tether | Skeleton (Summoned at battle start) | Grave Spike (280% Dark, Curse: -15% stats, 4% DoT) |
| **T6** | `Lich` | 12 DEF, 30% Soul Tether | Bone Horror (Summoned at battle start) | Soul Rupture (250% AoE Dark, Greater Curse: -20% stats, 5% DoT) |
| **T7** | `AncientLich` | 16 DEF, 35% Soul Tether | Bone Nightmare (Summoned at battle start) | Miasma of Decay (260% AoE Dark, Ominous Curse: -25% stats, 6% DoT) |
| **T8** | `LorfOfDecay` | 20 DEF, 40% Soul Tether | Bone Abomination (Summoned at battle start) | Grave Tyrant (280% AoE Dark, Abhorrent Curse: -30% stats, 8% DoT) |
| **T9** | `BlackIdol` | 25 DEF, 40% Soul Tether | Bone Hydra (Summoned at battle start, revives) | Abyssal Transmutation (320% AoE Dark, Abhorrent Curse, Life Siphon) |

---

## Proposed Changes

### Resources & Localization
- Add strings in `strings.xml`:
  - `passive_soul_tether_name` / `_description`
  - `log_minion_damage_redirected`: `"%s redirects %s damage to its summoned minion!"`

### Skills & Enums
- Add `PASSIVE_SOUL_TETHER` to `Skills.kt`.

### Adventurer Units
- Update `Necromancer.kt` through `BlackIdol.kt`:
  - Adjusted base Defense.
  - `soulTetherPercent` (20% $\to$ 40%).
  - `battleStartMinionClass` name for automatic minion deployment.

### Combat Engine (`Area.kt` & `Entity.kt`)
- In `Entity.kt`: add `soulTetherPercent: Double` and damage redirection in `applyDamage()`.
- In `Area.kt`:
  - In `initializeFight()`: spawn minion if hero has `battleStartMinionClass`.
  - In turn status resolution: apply active % max HP damage and stat shred for curses on living targets.

---

## Verification Plan

### Automated Tests
- Unit tests in `app/src/test/kotlin/`:
  - Verify battle-start minion summoning.
  - Verify Soul Tether damage redirection to minion.
  - Verify Curse DoT ticks and stat debuffs on living targets.
