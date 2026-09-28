# Implementation Plan - Black Idol Evolution Line Rebalance

Perform a comprehensive overhaul and rebalance of the underperforming **Black Idol Branch** (Mage $\to$ Sorcerer $\to$ Necromancer $\to$ Lich Line $\to$ Black Idol).

---

## 1. Goal & Design Philosophy

- **Problem in Vanilla**:
  - Minions only spawn when an enemy dies, rendering the branch and its minion synergies virtually useless in single-boss fights.
  - Hard-capped at 1 minion total across the entire team, preventing any true "Necromancer army" fantasy.
  - 0 physical defense and 200 base HP makes Liches brittle glass.
  - `Withering Link` heals a minion that is never on the field during tough boss fights.
- **Rework: The Dread Lich & Soul Harvester**:
  - **Active Skill Summoning**: Active skills summon the Lich's undead servants directly during combat—no enemy death required.
  - **Expanded Summon Capacity**: The Lich can now command multiple minions simultaneously, scaling from **1 minion at T4–T5** up to **2 minions at T6–T7** and **3 minions at T8–T9**!
  - **Soul Tether**: Redirects $N\%$ of all incoming damage taken by the Lich distributed across their active minions, giving them massive survivability behind an undead meatshield vanguard.
  - **Soul Harvest on Cursed Death**: When cursed enemies die, all active minions absorb their soul, gaining permanent stacking stat buffs for the rest of the battle.

---

## 2. Confirmed Design Decisions

> [!NOTE]
> **User Review Confirmed**:
> 1. **Skill-Based Summoning**: Minions are summoned on **active skill cast**, rather than automatically at battle start.
> 2. **Expanded Max Summon Count**: The max summon cap scales by tier:
>    - **T4 (`Necromancer`) & T5 (`Demilich`)**: Max **1** minion
>    - **T6 (`Lich`) & T7 (`AncientLich`)**: Max **2** minions
>    - **T8 (`LorfOfDecay`) & T9 (`BlackIdol`)**: Max **3** minions
> 3. **Capacity & Healing Dynamic**: If active minions are below max capacity, skill casts summon a new minion. Once at max capacity, subsequent skill casts mend and heal all active minions for **35% of their Max HP**.
> 4. **Soul Tether Redirection**: Redirects $N\%$ of damage taken by the Lich distributed to their active summoned minions (scaling from 20% at T4 to 45% at T9).
> 5. **Soul Harvest on Cursed Death**: When any cursed enemy dies, all active minions permanently gain stat buffs (+Max HP, +Damage, +Defenses) for the duration of the combat.

---

## 3. Detailed Mechanics & Formulas

### 3.1 Defense & Soul Tether (Survivability)
- **Bone Armor**: Base Defense increased from 0 to **15 + (INT * 0.25)** (e.g. at 50 INT = 27 Defense).
- **Soul Tether (Passive)**: While one or more summoned minions are alive:
  - **$N\%$ of all damage taken by the Lich is redirected to their minions** (split evenly across living minions):
    - T4 (`Necromancer`): **20%** redirected (Max 1 minion)
    - T5 (`Demilich`): **25%** redirected (Max 1 minion)
    - T6 (`Lich`): **30%** redirected (Max 2 minions)
    - T7 (`AncientLich`): **35%** redirected (Max 2 minions)
    - T8 (`LorfOfDecay`): **40%** redirected (Max 3 minions)
    - T9 (`BlackIdol`): **45%** redirected (Max 3 minions)
  - With `Withering Link` (50% lifesteal healing both Lich and Minions), the Lich heals all active minions through damage dealt while the minions absorb incoming blows!
  - As long as minions have HP, the Lich cannot be easily burst down.

### 3.2 Skill-Based Minion Summoning & Capacity Scaling
- When the Lich casts their Active Skill (`ACTIVE_CURSE_I` through `ACTIVE_CURSE_V`):
  - **Summoning Check**:
    - If `activeMinions.size < maxSummons`: The Lich summons a new undead servant into the battle formation.
    - If `activeMinions.size >= maxSummons`: The dark energies mend all currently active minions, restoring **35% of their Max HP** and refreshing their combat focus.
  - **Tier Minion Servants**:
    - **T4 (`Necromancer`)**: **Zombie** (High CON/HP, frontline meatshield; Cap: 1).
    - **T5 (`Demilich`)**: **Skeleton** (Medium CON/DEF, retaliates with bone strikes; Cap: 1).
    - **T6 (`Lich`)**: **Bone Horror** (High HP/DEF, taunts enemies; Cap: 2).
    - **T7 (`AncientLich`)**: **Bone Nightmare** (High HP, physical & magic defense; Cap: 2).
    - **T8 (`LorfOfDecay`)**: **Bone Abomination** (High HP, poisons enemies on hit; Cap: 3).
    - **T9 (`BlackIdol`)**: **Bone Hydra** (Massive HP, multi-target bite attacks, revives; Cap: 3).

### 3.3 Soul Harvest: Permanent Minion Buffs on Cursed Death
- When any enemy afflicted with a curse dies while minions are on the battlefield:
  - **Every currently active minion** absorbs a portion of the dying enemy's lingering life essence.
  - Each minion gains a stacking **Soul Harvest** buff for the remainder of the battle:
    - **+15% Max HP** (and immediately heals for the gained amount).
    - **+15% Physical & Magical Attack**.
    - **+5 Physical Defense & Magic Defense**.
  - A full squad of 3 Bone Hydras or Bone Abominations can snowball into an unstoppable necrotic frontline in multi-wave dungeons and horde encounters!

---

## 4. Tier-by-Tier Evolution Summary

| Tier | Unit | Base Def & Soul Tether | Max Minions | Minion Companion (Summoned via Skill) | Active Skill Effect |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **T4** | `Necromancer` | 5 DEF, 20% Soul Tether | **1** | **Zombie** (High HP meatshield) | Death's Caress (250% Dark, inflicts Lesser Curse, summons/heals Zombie) |
| **T5** | `Demilich` | 8 DEF, 25% Soul Tether | **1** | **Skeleton** (Retaliation strikes) | Grave Spike (280% Dark, inflicts Curse, summons/heals Skeleton) |
| **T6** | `Lich` | 12 DEF, 30% Soul Tether | **2** | **Bone Horror** (Taunts enemies) | Soul Rupture (250% AoE Dark, inflicts Greater Curse, summons/heals Bone Horrors) |
| **T7** | `AncientLich` | 16 DEF, 35% Soul Tether | **2** | **Bone Nightmare** (High Def & MDef) | Miasma of Decay (260% AoE Dark, inflicts Ominous Curse, summons/heals Bone Nightmares) |
| **T8** | `LorfOfDecay` | 20 DEF, 40% Soul Tether | **3** | **Bone Abomination** (Poison on hit) | Grave Tyrant (280% AoE Dark, inflicts Abhorrent Curse, summons/heals Bone Abominations) |
| **T9** | `BlackIdol` | 25 DEF, 45% Soul Tether | **3** | **Bone Hydra** (Multi-target attacks, revives) | Abyssal Transmutation (320% AoE Dark, inflicts Abhorrent Curse, summons/heals Bone Hydras) |

---

## 5. Technical Architecture & File Additions

### 5.1 Combat Engine Hooks (`Area.kt` & `Entity.kt`)
1. **Multi-Minion Tracking in `Adventurer.kt`**:
   ```kotlin
   var maxMinions: Int = 1
   val minionsBound: MutableList<Adventurer> = mutableListOf()
   
   // Backwards-compatible getter for single-minion equipment checks
   open fun getMinionBound(): Adventurer? = minionsBound.firstOrNull()
   ```
2. **Skill Cast Minion Summoning (`Area.kt`)**:
   - In active skill dispatch (`ACTIVE_CURSE_I` through `ACTIVE_CURSE_V`):
     ```kotlin
     val livingMinions = caster.minionsBound.filter { it.currentHp > 0 }
     if (livingMinions.size < caster.maxMinions) {
         spawnMinionForLich(caster)
     } else {
         for (minion in livingMinions) {
             healAndMendMinion(minion)
         }
     }
     ```
3. **Soul Tether Damage Redirection (`Entity.kt`)**:
   - In `applyDamage(damage)`:
     ```kotlin
     val activeMinions = minionsBound.filter { it.currentHp > 0 }
     if (this.soulTetherPercent > 0.0 && activeMinions.isNotEmpty()) {
         val totalRedirected = (damage * soulTetherPercent).toInt()
         val perMinion = totalRedirected / activeMinions.size
         for (minion in activeMinions) {
             minion.applyDamage(perMinion)
         }
         val taken = damage - totalRedirected
         // apply remaining 'taken' to caster
     }
     ```
4. **Soul Harvest on Death (`Area.kt`)**:
   - In the enemy defeat hook:
     - Check if the fallen enemy had any active `CURSE` effect (`LESSER_CURSE`, `CURSE`, `GREATER_CURSE`, `OMINOUS_CURSE`, `ABHORRENT_CURSE`).
     - If so, retrieve the curse's causing adventurer. For each living minion in `caster.minionsBound`:
       ```kotlin
       minion.applySoulHarvestBuff()
       ```
5. **Minion Cleanup on Death (`Area.kt`)**:
   - When an individual minion dies: `caster.minionsBound.remove(minion)`.
   - When the Lich dies: all `caster.minionsBound` are instantly slain.

### 5.2 Adventurer Classes
- Update `Necromancer.kt`, `Demilich.kt`, `Lich.kt`, `AncientLich.kt`, `LorfOfDecay.kt`, and `BlackIdol.kt`:
  - Configure `baseDefense`, `soulTetherPercent`, and `maxMinions` (1, 2, or 3).
  - Specify `minionSummonClass` for skill cast resolution.

### 5.3 Resources & Localization
- String additions in `strings.xml`:
  - `passive_soul_tether_name` ("Soul Tether")
  - `passive_soul_tether_description` ("Redirects %d%% of damage taken distributed across active minions.")
  - `effect_soul_harvest_name` ("Soul Harvest")
  - `effect_soul_harvest_description` ("Empowered by fallen cursed souls: +15% HP, +15% ATK, +5 DEF per stack.")
  - Combat log string: `log_minion_damage_redirected` ("%s redirects %d damage across its undead minions!")

---

## 6. Verification & Test Plan

### Automated Unit Tests
- Create unit tests in `app/src/test/kotlin/it/paranoidsquirrels/idleguildmaster/`:
  1. **Multi-Minion Skill Summon Test**:
     - Verify casting `ACTIVE_CURSE_V` on a Black Idol spawns up to 3 `BoneHydra` units on subsequent casts.
     - Verify a 4th cast when 3 Hydras are alive heals all 3 Hydras instead of spawning a 4th.
  2. **Soul Tether Distributed Redirection Test**:
     - With 3 Bone Hydras active on a Black Idol (45% Soul Tether), inflict 120 damage to Black Idol.
     - Verify Black Idol takes 66 damage (55%), and each of the 3 Bone Hydras takes 18 damage (total 54 damage = 45%).
  3. **Soul Harvest Multi-Buff Test**:
     - Defeat an enemy afflicted with `ABHORRENT_CURSE` while 3 minions are active.
     - Verify all 3 minions gain +15% Max HP, +15% Attack, and +5 Defenses per cursed enemy killed.
  4. **Minion Lifeline Test**:
     - Verify that if the Black Idol dies, all 3 minions perish immediately.
     - Verify that individual minion deaths free up capacity for future skill summon casts.
