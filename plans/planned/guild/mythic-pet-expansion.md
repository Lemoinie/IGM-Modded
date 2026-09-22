# Implementation Plan: Mythic Pet Type Expansion (11 Mythic Companions)

## Goal Description
Expand the **Mythic Pet** ecosystem from the initial foundation ([Phoenix & Kitsune](file:///c:/Repositories/IGM-Modded/plans/working/guild/phoenix-pet-and-egg.md)) into a full, diverse endgame roster of **11 Mythic Companions**.

Each Mythic pet possesses a unique, combat-defining **5th trait** active from Level 1 that scales with pet level, while adhering strictly to the clean architectural decoupling rule: **generic species code classes** underneath, with **modular display names** and **replaceable sprites** in the presentation layer.

---

## 1. Design Analysis: Preventing Pool Dilution & Power Creep

### The Risks of Adding 11 Mythic Pets:
1. **Egg Pool Dilution (1/11 RNG Trap)**:
   - If all 11 pets are dropped into a single `MythicEgg`, rolling a specific pet drops to **~9%**. Since pet progression requires merging duplicates or farming specific companions, a single bloated egg pool will frustrate players.
2. **Normal Pet Obsolescence (Power Creep)**:
   - If every Mythic pet provides game-breaking combat power, standard pets (Wild, Beast, Elemental, etc.) risk becoming completely obsolete.
3. **Combat Simulation Complexity**:
   - `Area.kt` runs thousands of turns a minute in idle simulation. Combat hooks must be clean, deterministic, and modular.

### Solutions in This Design:
1. **Themed Origins / Targeted Eggs**:
   - Pets are split across distinct origin eggs (Celestial, Abyssal, Primal, Astral) and direct raid/promotional vouchers. Players never face a bloated 1/11 random pull.
2. **Archetype Synergies, Not Raw Stat Creep**:
   - Standard pets remain superior for raw general farming (e.g. maxed merged standard pets with pure Drop/Exp/Gold traits).
   - Mythic pets act as **party archetype keystones**:
     - *Cerberus*: Basic-attack multi-strike teams.
     - *Chronos Beast*: Skill recast / burst caster setups.
     - *Dragon*: 2-target Cleave + Opportunist execution stacking.
     - *Dryad*: Massive Max HP survivability buffer.
     - *Orca*: First-hit ambush burst for fast dungeon speedruns.
     - *Moon Rabbit*: Raid boss super-crit gambling & double loot.

---

## 2. Complete Roster: Species vs. Display Presentation

| Species Class (Code Layer) | Display Name (`strings.xml`) | Emoji / Flavor | Combat Archetype / Role | Unique 5th Trait Name |
| :--- | :--- | :---: | :--- | :--- |
| **`Kitsune`** (`Kitsune.kt`) | **Senko** | 🦊 | Healing & Party Sustain Multiplier | *Kitsune Spirit Blessing* |
| **`Phoenix`** (`Phoenix.kt`) | **Kiara** | 🔥 | Resurrection & Lethal Damage Intercept | *Solar Rebirth* |
| **`Cerberus`** (`Cerberus.kt`) | **Korone** | 🐺 | Multi-Strike & Crit Frenzy | *Triple Rend* |
| **`Dragon`** (`Dragon.kt`) | **Coco** | 🐉 | 2-Target Cleave & Opportunist Execution Aura | *Dragon's Cleave* |
| **`ChronosBeast`** (`ChronosBeast.kt`) | **Kronii** | ⏳ | Active Skill Recast at `n%` Combined Damage | *Temporal Echo* |
| **`Reaper`** (`Reaper.kt`) | **Calliope** | ☠️ | On-Kill Barrier & Combat Damage Ramp | *Grim Harvest* |
| **`Leviathan`** (`Leviathan.kt`) | **Gura** | 🌊 | Bleed Synergy & Extra Bleed Procs | *Abyssal Frenzy* |
| **`SacredOwl`** (`SacredOwl.kt`) | **Mumei** | 🦉 | EXP Boost & Party +% Intelligence Aura | *Civilization's Wisdom* |
| **`Dryad`** (`Dryad.kt`) | **Fauna** | 🌳 | Party Max HP Multiplier (Anti-Burst Buffer) | *Tree of Life* |
| **`Orca`** (`Orca.kt`) | **Chloe** | 🐙 | Ambush Burst (+% Damage on First Hit) | *Apex Ambush* |
| **`MoonRabbit`** (`MoonRabbit.kt`) | **Pekora** | 🌙 | Chaotic Gambit, Explosive Super-Crits | *Chaotic Fortune* |

---

## 3. Detailed Pet Mechanics & 5th Trait Specifications

### Wave 1: The Foundations (Currently in progress)
* **Kitsune (`Senko`)**: Multiplies healing dealt by party adventurers by `(1 + level * 0.6%)`.
* **Phoenix (`Kiara`)**: Revives fallen allies at 1 HP or intercepts lethal damage with `SOLAR_REBIRTH` (`(level * 0.15)%` chance per turn, targets `1 + floor(level / 50)` allies).

---

### Wave 2: The Physical & Cleave Titans

#### 3. Cerberus (`Korone`) — Multi-Strike & Crit Frenzy
- **Class**: `Cerberus.kt : Mythic()`
- **Asset**: `res/drawable/pet_cerberus.png` (64×64)
- **Role**: Physical multi-attack multiplier.
- **5th Trait: `Triple Rend` (`TRIPLE_REND`)**:
  - Whenever an adventurer lands a basic attack, there is a **`5% + (level * 0.2)%` chance** to immediately strike an additional time (extra basic attack hit).
  - When any ally lands a Critical Hit, all allies gain **`+(level * 0.1)%` attack damage** for 2 turns (stackable up to 3 times).

#### 4. Dragon (`Coco`) — Cleave & Opportunist Execution Aura
- **Class**: `Dragon.kt : Mythic()`
- **Asset**: `res/drawable/pet_dragon.png` (64×64)
- **Role**: Cleave wave-clearer & execution synergy.
- **5th Trait: `Dragon's Cleave` (`DRAGONS_CLEAVE`)**:
  - **2-Target Cleave**: Single-target attacks from party members splash **`15% + (level * 0.25)%` damage** to **up to 2 nearby/adjacent enemies**.
  - **Additive Opportunist Execution**: Adds **`+(5% + level * 0.15)%`** to the execution threshold of the **Opportunist** trait. *(e.g. 20% from Adventurer/Pet Opportunist + 20% from Dragon Aura = 40% Execution Threshold!)*.

#### 5. Leviathan (`Gura`) — Apex Bleed Predator
- **Class**: `Leviathan.kt : Mythic()`
- **Asset**: `res/drawable/pet_leviathan.png` (64×64)
- **Role**: Bleed amplifier and sustained physical attrition.
- **5th Trait: `Abyssal Frenzy` (`ABYSSAL_FRENZY`)**:
  - Attacks against bleeding targets deal **`+(10% + level * 0.3%)` bonus damage**.
  - Whenever an ally applies Bleed, there is a **`20% + (level * 0.2)%` chance** to apply an extra stack of Bleed.

---

### Wave 3: Arcane & Survivability (Recast, HP & Wisdom)

#### 6. Chronos Beast (`Kronii`) — Active Skill Recast (Additive Combined Damage)
- **Class**: `ChronosBeast.kt : Mythic()`
- **Asset**: `res/drawable/pet_chronos_beast.png` (64×64)
- **Role**: Active skill recast multiplier that combines into satisfying single big numbers.
- **5th Trait: `Temporal Echo` (`TEMPORAL_ECHO`)**:
  - Whenever an adventurer casts an active skill, triggers an automatic **Recast / Echo** dealing **`20% + (level * 0.3)%`** of the skill's damage.
  - **Clean Additive Stacking**: Designed to stack additively with Recast gear (e.g. 40% from Kronii + 40% from Staff = 80% total single combined echo hit), avoiding log spam and creating massive, satisfying numbers.

#### 7. Dryad (`Fauna`) — Tree of Life (Max HP Multiplier)
- **Class**: `Dryad.kt : Mythic()`
- **Asset**: `res/drawable/pet_dryad.png` (64×64)
- **Role**: Extreme party survivability and anti-burst defense.
- **5th Trait: `Tree of Life` (`TREE_OF_LIFE`)**:
  - Increases the **Max HP** of all party members by **`15% + (level * 0.5%)`** (e.g. at Lv 50: **+40% Max HP**, at Lv 100: **+65% Max HP**).
  - Protects glass-cannon DPS and supports from getting one-shot in deep dungeons and raids.

#### 8. Sacred Owl (`Mumei`) — Civilization's Wisdom (EXP & Intelligence)
- **Class**: `SacredOwl.kt : Mythic()`
- **Asset**: `res/drawable/pet_sacred_owl.png` (64×64)
- **Role**: Idle leveling acceleration & spellcaster scaling.
- **5th Trait: `Civilization's Wisdom` (`CIVILIZATIONS_WISDOM`)**:
  - Boosts party Adventurer EXP gained by **`+(15% + level * 0.5%)`**.
  - Grants all party members **`+(10% + level * 0.2%)` bonus Intelligence**, directly scaling magic attacks, healing, and magic defense.

---

### Wave 4: Ambush, Ramp & Gambits

#### 9. Orca (`Chloe`) — Apex Ambush (First-Hit Burst)
- **Class**: `Orca.kt : Mythic()`
- **Asset**: `res/drawable/pet_orca.png` (64×64)
- **Role**: Fast-paced dungeon speedrunning.
- **5th Trait: `Apex Ambush` (`APEX_AMBUSH`)**:
  - The **first attack or skill hit** landed by each adventurer in every combat encounter deals **`+(50% + level * 1.0%)` bonus damage** (e.g. at Lv 50: **+100% damage**, at Lv 100: **+150% damage**).
  - Shreds dungeon trash waves in the opening seconds.

#### 10. Reaper (`Calliope`) — Soul Harvest & Kill Shields
- **Class**: `Reaper.kt : Mythic()`
- **Asset**: `res/drawable/pet_reaper.png` (64×64)
- **Role**: Wave snowballing and no-healer idle sustain.
- **5th Trait: `Grim Harvest` (`GRIM_HARVEST`)**:
  - Whenever an enemy is slain, grants all allies a Barrier equal to **`3% + (level * 0.08)%`** of the slain enemy's Max HP.
  - Slaying an enemy permanently grants the party **+1% damage** for the remainder of that combat encounter (stacks up to `5 + floor(level / 10)` times).

#### 11. Moon Rabbit (`Pekora`) — Chaotic Fortune (High-Stakes Gambits)
- **Class**: `MoonRabbit.kt : Mythic()`
- **Asset**: `res/drawable/pet_moon_rabbit.png` (64×64)
- **Role**: Raid boss burst and duplicate loot gambits.
- **5th Trait: `Chaotic Fortune` (`CHAOTIC_FORTUNE`)**:
  - Critical hits have a **`10% + (level * 0.2)%` chance** to trigger an **Explosive Super-Crit** dealing **`300% + (level * 2)%`** damage.
  - Dungeon and raid loot drops have a **`(level * 0.1)%` chance** to duplicate (roll twice).

---

## 4. Acquisition & Partitioned Egg Distribution

To permanently prevent the 1/11 RNG trap, Mythic Pets are obtained through thematic origins:

| Origin Egg / Method | Accessible Pets | Dropped From / Source |
| :--- | :--- | :--- |
| **Celestial Mythic Egg** | `Phoenix`, `Kitsune`, `MoonRabbit` | Celestial Raid & Celestial Shop |
| **Abyssal Mythic Egg** | `Leviathan`, `Orca`, `Reaper` | Deep Water / Abyssal Dungeons (D5/D8) |
| **Primal Mythic Egg** | `Cerberus`, `Dragon`, `Dryad` | Sanguine Crucible & Late-game Raids |
| **Astral Mythic Egg** | `ChronosBeast`, `SacredOwl` | Tower Floor 40+ / Special Events |
| **Direct Promos / Bundles** | Guaranteed Specific Pet | Shop Bundles & Milestone Redeem Codes |

---

## 5. Technical Integration Architecture

### Class Architecture:
```text
storage/data/pets/
├── abstractClasses/
│   └── Mythic.kt          (Shared trait pool: EXPERIENCE, DROPS, OPPORTUNIST, SAVAGE)
└── instances/
    ├── Phoenix.kt         (Solar Rebirth)
    ├── Kitsune.kt         (Kitsune Spirit Blessing)
    ├── Cerberus.kt        (Triple Rend)
    ├── Dragon.kt          (Dragon's Cleave)
    ├── ChronosBeast.kt    (Temporal Echo)
    ├── Reaper.kt          (Grim Harvest)
    ├── Leviathan.kt       (Abyssal Frenzy)
    ├── SacredOwl.kt       (Civilization's Wisdom)
    ├── Dryad.kt           (Tree of Life)
    ├── Orca.kt            (Apex Ambush)
    └── MoonRabbit.kt      (Chaotic Fortune)
```

### Combat Loop Hooks in [`Area.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/Area.kt):
1. **Recast Handling (`Temporal Echo`)**:
   - In `castSkill()`: Checks `pet.getTemporalEcho()`. Adds recast damage modifier additively to weapon/staff recast modifiers and applies combined damage with a single log entry.
2. **Cleave Handling (`Dragon's Cleave`)**:
   - In `dealDamage()`: If `isAoe == false`, splashes `pet.getDragonsCleave()` damage to adjacent targets in enemy formation.
3. **Execution Handling**:
   - In `dealDamage()`: When checking `executionThreshold`, sums `adventurer.executionThreshold + pet.getDragonsExecutionAura()`.
4. **First-Hit Ambush (`Apex Ambush`)**:
   - Tracks `firstHitMap: MutableSet<Int>` in `Area`. The first hit from each adventurer applies the ambush damage multiplier, then clears at battle end.
5. **Max HP & Stat Auras (`Tree of Life` & `Civilization's Wisdom`)**:
   - Checked dynamically in `Adventurer.calculateTotalMaxHp()` and `Adventurer.calculateTotalIntelligence()`.
