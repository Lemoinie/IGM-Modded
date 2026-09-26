# Implementation Plan - Whisper Evolution Line Rebalance

Perform a comprehensive overhaul and rebalance of the underperforming **Whisper Branch** (starting at **Tier 5 `SpireInitiate`** up to **Tier 9 `Whisper`**).

---

## 1. Goal & Design Philosophy

- **Problem in Vanilla**: 
  - Zero offensive combat passives (only trap disarm and target selection).
  - `Eclipse` execution threshold (<25%) and on-kill recasting are completely ineffective in prolonged boss fights.
  - As a squishy melee assassin, Whisper takes heavy retaliation damage when attacking bosses without defensive tools.
- **Rework Identity: Phantom Duelist & Riposte Assassin**:
  - **Branch Scope**: Starts at **Tier 5 (`SpireInitiate`)**, leaving **Tier 4 `Assassin`** untouched so its shared branch into `RedStalker` remains vanilla.
  - **New Status Effect: Riposte**: Instead of passive damage reduction, the Spire/Whisper line dodges incoming attacks by 100% and immediately counter-attacks, stacking up to 5 times.
  - **Synergy with Doctrine of Illusion**: Because Riposte triggers as a genuine dodge, it allows dodge-based mechanics like **False Life** (from the Doctrine of Illusion) to trigger.
  - **No Crit Bloat**: Crit chance is removed from passives; damage relies on weapon stats, natural DEX crit scaling, armor penetration, and missing-HP damage amplification.
  - **Controlled Active Scaling**: `ACTIVE_ECLIPSE` increases by exactly **10% (+0.10x) per tier** (1.10x $\to$ 1.40x) with built-in **3.0x Critical Amplification**.

---

## 2. Targeting Behavior Clarification

> [!NOTE]
> ### How "Lowest Health Enemy" Works in the Combat Engine
> In `Area.kt` (lines 987–988, 3093, and 3297–3302), `PASSIVE_DESPISE_WEAKNESS` sets target selection to `TARGET_LOWEST_RELATIVE_ENEMY`:
> ```kotlin
> // Area.kt selectLowestHpTarget:
> candidate.currentHp.toDouble() / candidate.calculateTotalMaxHp().toDouble() < 
>     entity2.currentHp.toDouble() / entity2.calculateTotalMaxHp().toDouble()
> ```
> This is strictly **Relative Percentage HP (% HP)**, NOT flat HP.
> - **Example**: An Elite Boss at **500 / 1,000 HP** (**50%**) will be targeted before a minion with **70 / 100 HP** (**70%**), even though the minion has fewer flat hit points.
> - This ensures the Whisper line systematically finishes off the most wounded enemy.

---

## 3. Stat & Scaling Profile

### 3.1 Dagger Scaling (Vanilla Baseline Kept)
- In `Dagger.kt`:
  ```kotlin
  override fun getDamageModifier(i: Int, i2: Int, i3: Int): Int = i + i3
  ```
  Where `i = CON` and `i3 = DEX`.
- **Daggers inherently scale off 100% Constitution + 100% Dexterity**.
- This plan **maintains 100% CON + 100% DEX** dagger scaling without alteration.

### 3.2 Innate Avoidance & Sabotage
- `saboteur = true` (Trap disarm retained from T5 through T9).
- `flatDodgeChance = 0.15` (Innate +15% dodge chance representing phantom evasion).

---

## 4. New Status Effect: Riposte

### 4.1 Riposte Mechanics
- **Definition**: A positive status effect (`StatusEffectType.RIPOSTE`), stacking up to **5 stacks** (stored in `turnsLeft`).
- **On Incoming Attack**:
  1. **100% Dodge**: Attack is automatically dodged (`dodge(...)` returns `true`).
  2. **Dodge Synergy**: Counts as an authentic dodge event, permitting synergies like Doctrine of Illusion's `False Life` on dodge and quest progress (`hitOrMiss`).
  3. **Immediate Counterattack**: The defender counter-attacks the attacker with a basic attack:
     ```kotlin
     dealDamage(defender, attacker, null, null)
     ```
  4. **Stack Consumption**: Consumes exactly 1 stack of Riposte. The effect is removed when stacks reach 0.

### 4.2 Gaining Riposte (Whisper Branch T5–T9)
- **On Skill Use (`Eclipse`)**: +1 stack of Riposte.
- **On Enemy Kill**: +1 stack of Riposte.
- **Chaining Examples**:
  - Cast `Eclipse` on an enemy and kill it: +1 (skill) + +1 (kill) = **2 stacks**.
  - `Eclipse` recasts on a second enemy and kills it: +1 (recast) + +1 (kill) = +2 stacks (total **4 stacks**).
  - If the second enemy survives: +1 (recast only) = total **3 stacks**.
  - Maximum cap: **5 stacks**.

---

## 5. Combat Passives Rework (T5 through T9)

No passive crit chance bloat. Passives grant **Relative % HP Targeting**, **DEF Ignore**, **Missing-HP Damage Amplification**, and **Riposte on Kill**:

- **T4 (`Assassin`)**: **UNTOUCHED (Vanilla)**
  - Retains `PASSIVE_INFILTRATOR` and `ACTIVE_BACKSTAB_III`.
- **T5 (`SpireInitiate`)**: **Phantom Instinct I**
  - Targets lowest relative % HP enemy.
  - Ignores **20% Enemy DEF**.
  - Attacks deal up to **+45% bonus damage** scaled by missing target HP ($\text{dmg} \times (1.0 + 0.45 \times \text{missingHP\%})$).
  - On enemy kill: gains **+1 stack of Riposte** (max 5).
  - Trap disarm (`saboteur = true`).
- **T6 (`SpireAcolyte`)**: **Phantom Instinct II**
  - Targets lowest relative % HP enemy.
  - Ignores **25% Enemy DEF**.
  - Attacks deal up to **+50% bonus damage** scaled by missing target HP.
  - On enemy kill: gains **+1 stack of Riposte** (max 5).
  - Trap disarm (`saboteur = true`).
- **T7 (`SpireLeader`)**: **Phantom Instinct III**
  - Targets lowest relative % HP enemy.
  - Ignores **30% Enemy DEF**.
  - Attacks deal up to **+55% bonus damage** scaled by missing target HP.
  - On enemy kill: gains **+1 stack of Riposte** (max 5).
  - Trap disarm (`saboteur = true`).
- **T8 (`SpireSage`)**: **Phantom Lethality I**
  - Targets lowest relative % HP enemy.
  - Ignores **35% Enemy DEF**.
  - Attacks deal up to **+60% bonus damage** scaled by missing target HP.
  - On enemy kill: gains **+1 stack of Riposte** (max 5).
  - Trap disarm (`saboteur = true`).
- **T9 (`Whisper`)**: **Phantom Lethality II**
  - Targets lowest relative % HP enemy.
  - Ignores **40% Enemy DEF**.
  - Attacks deal up to **+70% bonus damage** scaled by missing target HP.
  - On enemy kill: gains **+1 stack of Riposte** (max 5).
  - Trap disarm (`saboteur = true`).

---

## 6. Active Skill: `ACTIVE_ECLIPSE` (+10% per Tier)

Base damage increases by strictly **10% (+0.10x) per tier**, featuring **3.0x Critical Amplification** and granting **Riposte**:

- **`ACTIVE_ECLIPSE_I` (T5 `SpireInitiate`)**:
  - **1.10x Physical Damage**, **3.0x Critical Amplification**.
  - Grants **+1 stack of Riposte** on cast (plus +1 if it kills).
  - Executes targets below **10% HP**, recasts on kill.
- **`ACTIVE_ECLIPSE_II` (T6 `SpireAcolyte`)**:
  - **1.20x Physical Damage** (+10%), **3.0x Critical Amplification**.
  - Grants **+1 stack of Riposte** on cast.
  - Executes targets below **15% HP**, recasts on kill.
- **`ACTIVE_ECLIPSE_III` (T7 `SpireLeader` & T8 `SpireSage`)**:
  - **1.30x Physical Damage** (+10%), **3.0x Critical Amplification**.
  - Grants **+1 stack of Riposte** on cast.
  - Executes targets below **20% HP**, recasts on kill.
- **`ACTIVE_ECLIPSE_IV` (T9 `Whisper`)**:
  - **1.40x Physical Damage** (+10%), **3.0x Critical Amplification**.
  - Grants **+1 stack of Riposte** on cast.
  - Executes targets below **25% HP**, recasts on kill.

---

## 7. Tier-by-Tier Evolution Summary

| Tier | Unit | Weapon Scaling | Passive Ability | Active Skill |
| :--- | :--- | :--- | :--- | :--- |
| **T4** | `Assassin` | 100% DEX + 100% CON | *Vanilla Untouched* (`PASSIVE_INFILTRATOR`) | `ACTIVE_BACKSTAB_III` |
| **T5** | `SpireInitiate` | 100% DEX + 100% CON | Phantom Instinct I (Lowest % HP, 20% DEF ignore, +45% vs wounded, Riposte on kill) | Eclipse I (1.10x dmg, 3.0x crit amp, +1 Riposte, execute <10%) |
| **T6** | `SpireAcolyte` | 100% DEX + 100% CON | Phantom Instinct II (Lowest % HP, 25% DEF ignore, +50% vs wounded, Riposte on kill) | Eclipse II (1.20x dmg, 3.0x crit amp, +1 Riposte, execute <15%) |
| **T7** | `SpireLeader` | 100% DEX + 100% CON | Phantom Instinct III (Lowest % HP, 30% DEF ignore, +55% vs wounded, Riposte on kill) | Eclipse III (1.30x dmg, 3.0x crit amp, +1 Riposte, execute <20%) |
| **T8** | `SpireSage` | 100% DEX + 100% CON | Phantom Lethality I (Lowest % HP, 35% DEF ignore, +60% vs wounded, Riposte on kill) | Eclipse III (1.30x dmg, 3.0x crit amp, +1 Riposte, execute <20%) |
| **T9** | `Whisper` | 100% DEX + 100% CON | Phantom Lethality II (Lowest % HP, 40% DEF ignore, +70% vs wounded, Riposte on kill) | Eclipse IV (1.40x dmg, 3.0x crit amp, +1 Riposte, execute <25%, recast on kill) |

---

## 8. Implementation Checklist

### Phase 1: Status Effect & Strings
- [ ] Add `RIPOSTE` to `StatusEffectType`:
  - `status_effect_riposte` ("Riposte")
  - `status_effect_riposte_description` ("Dodges the next incoming attack by 100% and immediately counter-attacks. Stacks up to 5.")
  - Vector/drawable icon `icon_effect_riposte`.
- [ ] Add passive strings for `Phantom Instinct I–III` and `Phantom Lethality I–II` in `strings.xml`.
- [ ] Register new passives in `Skills.kt`.

### Phase 2: Combat Engine (`Area.kt`)
- [ ] **Riposte Resolution in `dealDamage()` / `dodge()`**:
  - If defender has `StatusEffectType.RIPOSTE`:
    - Automatically succeeds dodge check (`100%`).
    - Consumes 1 stack of Riposte (removes if stacks == 0).
    - Triggers counterattack: `dealDamage(defender, attacker, null, null)`.
    - Triggers dodge hooks (e.g. Doctrine of Illusion's False Life).
- [ ] **Riposte Gain Hooks**:
  - In `cast()` for `ACTIVE_ECLIPSE_I..IV`: Add +1 stack of Riposte to caster (cap 5).
  - In `checkDeath()` / on kill: If killer has `Phantom Instinct` or `Phantom Lethality`, add +1 stack of Riposte (cap 5).
- [ ] **Active Eclipse Damage Multipliers**:
  - `1.10x` (T5), `1.20x` (T6), `1.30x` (T7/T8), `1.40x` (T9).

### Phase 3: Unit Configuration
- [ ] Configure `SpireInitiate.kt`, `SpireAcolyte.kt`, `SpireLeader.kt`, `SpireSage.kt`, and `Whisper.kt`.
- [ ] Leave `Assassin.kt` untouched.

### Phase 4: Unit Tests
- [ ] Unit tests for:
  - Riposte stack capping (max 5).
  - Guaranteed dodge and immediate counterattack on incoming attack.
  - Stack accumulation on skill use and on kill (1 kill = 2 stacks, 2 kills via recast = 4 stacks).
  - Doctrine of Illusion False Life triggering from Riposte dodge.
  - Active damage progression (+10% per tier).
