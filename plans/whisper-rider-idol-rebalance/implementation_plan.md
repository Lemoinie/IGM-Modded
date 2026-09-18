# Implementation Plan: Whisper, Wyrm Rider & Black Idol Evolution Rebalance

## Goal Description
Perform a comprehensive overhaul and rebalance of three underperforming Tier 4 -> Tier 9 evolution branches in the game:
1. **Whisper Branch (Thief -> Rogue -> Shadow -> Assassin -> Spire Line -> Whisper)**:
   - *Problem*: Zero combat-relevant passives (only trap disarm and target selection); dagger scaling is pure DEX/CON with low base damage; `Eclipse` execution threshold (<25%) and on-kill recasting are completely ineffective in prolonged boss fights.
   - *Rework*: Transform into the ultimate **Phantom Executioner / Crit Assassin**. Gains combat passives (Crit Chance, Armor Piercing, Missing-HP Damage Amplification), and an active `Eclipse` rework that deals escalating damage against wounded targets and executes without being dead weight on bosses.
2. **Wyrm Rider Branch (Archer -> Hunter -> Tamer -> Wolf Rider -> Drake Line -> Wyrm Rider)**:
   - *Problem*: Mount attacks deal static flat damage (e.g. Wyrm deals 100 flat damage in endgame where bosses have 10,000+ HP); stats give 20 INT but bows only scale with DEX; active skills randomly alternate between physical barrage, corrosive spit, and subzero magic with no cohesive beastmaster fantasy.
   - *Rework*: Transform into a **Hybrid Dragoon / Beast Commander**. Mount attacks dynamically scale with the Rider's DEX + INT and darkness; bows gain hybrid scaling; active skills become coordinated beast strikes unleashing draconic breath weapons (Fire, Ice, Acid) and aerial arrow volleys.
3. **Black Idol Branch (Mage -> Sorcerer -> Necromancer -> Lich Line -> Black Idol)**:
   - *Problem*: Curses are purely on-death triggers that do nothing to living targets (completely useless in single-boss fights); 0 physical defense and 200 base HP makes them brittle glass; `Withering Link` heals a minion that never spawns against bosses.
   - *Rework*: Transform into a **Dread Lich / Soul Harvester**. Curses actively torment living targets (stat shred, dark DoT, and life leech); gains active/battle-start minion summoning (does not require enemy death); gains `Soul Tether` / `Bone Armor` allowing the Lich to redirect incoming damage to their minion.

---

## User Review Required

> [!IMPORTANT]
> **Key Design Decisions for Review**:
> 1. **Whisper Scaling Philosophy**:
>    - *Proposal A (Recommended)*: **Missing HP Scaling**. Whisper gains up to **+75% bonus damage** based on how low the target's HP is (`1.0 + 0.75 * missingHp%`), with guaranteed Critical Strikes on targets below 25% HP.
>    - *Proposal B*: **Deathmark Vulnerability**. Whisper's attacks mark the target, increasing all party damage against them by +20% and amplifying Whisper's own crit multiplier.
> 2. **Wyrm Rider Mount Scaling**:
>    - *Proposal A (Recommended)*: Mount end-of-turn attack deals hybrid damage: **120% DEX + 120% INT** as Magic Dragon Breath to all enemies, rolling Critical Strikes with the Rider's stats.
>    - *Proposal B*: Mount attack is a single-target physical bite (150% DEX) followed by an AoE elemental breath (100% INT).
> 3. **Black Idol Minion Summoning & Defense**:
>    - *Proposal A (Recommended)*: Lich automatically summons a minion at battle-start (Zombie -> Skeleton -> Bone Horror -> Bone Nightmare -> Bone Hydra based on tier), and redirects **40% of damage taken** to the minion (`Soul Tether`). When cursed enemies die, the minion gains permanent stat buffs for the rest of the battle.
>    - *Proposal B*: Active skill `Abyssal Transmutation` summons the minion if none exists, and explodes the minion for massive AoE damage when recast.

---

## Detailed Mechanics & Formulas

### 1. Whisper Branch Overhaul (Single-Target Phantom Assassin)

#### Stat & Scaling Profile:
- **Weapon Scaling**: Daggers scale with **100% DEX + 60% CON**.
- **Innate Trait**: Retains `saboteur = true` and `flatDodgeChance = 0.15` (stealth avoidance).
- **Combat Passives Rework**:
  - T4 (`Assassin`): **Shadow Stalker I** (+10% Crit Chance, ignores 20% Enemy DEF).
  - T5 (`SpireInitiate`): **Shadow Stalker II** (+15% Crit Chance, ignores 25% Enemy DEF).
  - T6 (`SpireAcolyte`): **Cull the Weak I** (+15% Crit Chance, ignores 30% Enemy DEF, attacks deal up to **+30% damage** against targets with missing HP: $\text{dmg} \times (1.0 + 0.3 \times \text{missingHP\%})$).
  - T7 (`SpireLeader`): **Cull the Weak II** (+20% Crit Chance, ignores 35% Enemy DEF, up to **+45% damage** against missing HP).
  - T8 (`SpireSage`): **Phantom Lethality I** (+20% Crit Chance, ignores 40% Enemy DEF, up to **+60% damage** against missing HP, trap disarm retained).
  - T9 (`Whisper`): **Phantom Lethality II**:
    - **+25% Crit Chance**, **ignores 50% Enemy DEF**, trap disarm retained.
    - **Execution Stance**: Attacks deal up to **+75% damage** scaled by missing HP. Targets below 25% HP suffer guaranteed Critical Strikes that bypass all shields.

#### Active Skill: `ACTIVE_ECLIPSE` Rework:
- Instead of being a dead skill until 25% HP:
  - **Damage**: Deals **300% Physical Damage** with **3.0x Critical Amplification**.
  - **Culling Strike**: Deals $+1\%$ extra damage per $1\%$ missing target HP (up to 2x damage on low HP).
  - **Execute & Chain**: If target's HP is below threshold (T5: 10%, T6: 15%, T7: 20%, T8: 25%, T9: 30%), the target is instantly executed. If killed, recasts on the next lowest HP target.
  - **Boss Synergy**: If the target does not die, grants Whisper **Shadow Cloak** for 1 turn (100% dodge against next attack) and refunds 50% cooldown.

---

### 2. Wyrm Rider Branch Overhaul (Hybrid Dragoon Beastmaster)

#### Stat & Scaling Profile:
- **Stat Split**: High DEX (40 at T9) and high INT (20 at T9).
- **Hybrid Weapon Scaling**:
  ```kotlin
  attackDexterityScaling = 1.0
  attackIntelligenceScaling = 0.5
  ```
  (Bows wielded by Riders channel both precise archery and draconic elemental mana).

#### Mount End-of-Turn Attack Overhaul:
Replace static flat damage in [EndOfTurnAction.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/EndOfTurnAction.kt) with **stat-scaling beast attacks**:
- **T4 (`WolfRider` - `RIDER_II`)**: Wolf Bite deals Physical Damage equal to **60% Rider DEX**, rolls Crit.
- **T5 (`WorgRider` - `RIDER_III`)**: Worg Maul deals Physical Damage equal to **80% Rider DEX**, applies Bleed (15 stacks).
- **T6 (`SpitfangRider` - `RIDER_IV`)**: Spitfang Acid deals Magic Damage equal to **60% DEX + 60% INT**, applies Poison (3 turns).
- **T7 (`DrakeRider` - `RIDER_V`)**: Drake Fire Breath deals Magic Damage equal to **75% DEX + 75% INT** to front row, applies Ablaze (2 turns).
- **T8 (`GoldenRider` - `RIDER_VI`)**: Golden Drake Breath deals Magic Damage equal to **90% DEX + 90% INT** to front row, applies Ablaze + reduces enemy Accuracy by 15%.
- **T9 (`WyrmRider` - `RIDER_VII`)**: **Cataclysmic Wyrm Breath**:
  - Deals Magic Damage equal to **120% DEX + 120% INT** to **all enemies**.
  - Rolls Critical Strikes with Rider's Crit stats.
  - Inflicts Frostbite & Burn: applies both **Ablaze** (2 turns) and **Frozen** (1 turn).

#### Active Skills Rework: Coordinated Draconic Assaults:
- T4 (`WolfRider`): `ACTIVE_BARRAGE_II` -> Piercing Volley (2x 150% phys damage).
- T5 (`WorgRider`): `ACTIVE_BARRAGE_III` -> Vicious Volley (3x 160% phys damage, bleed synergy).
- T6 (`SpitfangRider`): `ACTIVE_CORROSIVE_SHOT` -> 3x 180% damage, reduces target Armor by 20%.
- T7 (`DrakeRider`): `ACTIVE_DRAGONFIRE_VOLLEY` -> 220% fire damage to all enemies, burns targets.
- T8 (`GoldenRider`): `ACTIVE_SOLAR_SALVO` -> 260% radiant fire damage to all enemies, blinds targets for 2 turns.
- T9 (`WyrmRider`): `ACTIVE_SUBLIMATE_II`:
  - Rider looses an astral volley dealing **250% Physical damage** to all enemies.
  - Wyrm releases subzero dragonfire dealing **250% Magic damage** to all enemies.
  - Synergizes with the party by applying Ablaze and Frozen simultaneously.

---

### 3. Black Idol Branch Overhaul (Dread Lich & Soul Harvester)

#### Defense & Survivability Overhaul:
- **Bone Armor**: Base Defense increased from 0 to **15 + (INT * 0.25)** (e.g. at 50 INT = 27 Defense).
- **Soul Tether (Passive)**: While a summoned minion is alive:
  - **40% of all damage taken by the Lich is redirected to the minion**.
  - With `Withering Link` (50% lifesteal healing both Lich and Minion), the Lich sustains the minion while the minion shields the Lich from fatal damage!
  - Lich cannot be one-shot while minion has HP remaining.

#### Independent Minion Summoning:
- At the start of combat, if no minion exists, the Lich automatically summons their tier's undead servant:
  - T4 (`Necromancer`): **Zombie** (High CON/HP, meatshield).
  - T5 (`Demilich`): **Skeleton** (Medium CON/DEF, retaliates).
  - T6 (`Lich`): **Bone Horror** (High HP/DEF, taunts enemies).
  - T7 (`AncientLich`): **Bone Nightmare** (High HP, physical & magic defense).
  - T8 (`LorfOfDecay`): **Bone Abomination** (High HP, poisons enemies on hit).
  - T9 (`BlackIdol`): **Bone Hydra** (Massive HP, multi-target bite attacks, 3 lives/revives).
- **Corpse Empowerment**: When any cursed enemy dies during combat, the active minion absorbs their soul, permanently gaining **+10% Max HP, +10% Attack, and full HP heal**.

#### Active Curse Overhaul: Active Torment & Debuffs:
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

### Branch 1: Whisper Line
| Tier | Unit | Weapon Scaling | Passive | Active Skill |
| :--- | :--- | :--- | :--- | :--- |
| **T4** | `Assassin` | 100% DEX, 50% CON | Shadow Stalker I (+10% Crit, 20% Armor Pen) | Backstab III (3.0x crit amp) |
| **T5** | `SpireInitiate` | 100% DEX, 50% CON | Shadow Stalker II (+15% Crit, 25% Armor Pen) | Eclipse I (250% dmg, execute <10%) |
| **T6** | `SpireAcolyte` | 100% DEX, 60% CON | Cull the Weak I (+15% Crit, 30% Armor Pen, +30% vs wounded) | Eclipse II (275% dmg, execute <15%) |
| **T7** | `SpireLeader` | 100% DEX, 60% CON | Cull the Weak II (+20% Crit, 35% Armor Pen, +45% vs wounded) | Eclipse III (300% dmg, execute <20%) |
| **T8** | `SpireSage` | 100% DEX, 60% CON | Phantom Lethality I (+20% Crit, 40% Armor Pen, +60% vs wounded, Trap Disarm) | Eclipse III (325% dmg, execute <25%) |
| **T9** | `Whisper` | 100% DEX, 60% CON | Phantom Lethality II (+25% Crit, 50% Armor Pen, +75% vs wounded, True Execute <25%) | Eclipse IV (350% dmg, execute <30%, recast on kill) |

### Branch 2: Wyrm Rider Line
| Tier | Unit | Weapon Scaling | Mount Attack (End-of-Turn) | Active Skill |
| :--- | :--- | :--- | :--- | :--- |
| **T4** | `WolfRider` | 100% DEX, 30% INT | Wolf Bite (60% DEX Phys) | Piercing Volley (2x 150% phys) |
| **T5** | `WorgRider` | 100% DEX, 35% INT | Worg Maul (80% DEX Phys + Bleed) | Vicious Volley (3x 160% phys) |
| **T6** | `SpitfangRider`| 100% DEX, 40% INT | Spitfang Acid (60% DEX + 60% INT Magic + Poison) | Corrosive Salvo (3x 180% phys, -20% armor) |
| **T7** | `DrakeRider` | 100% DEX, 45% INT | Drake Fire (75% DEX + 75% INT Magic + Ablaze) | Dragonfire Volley (220% AoE Fire) |
| **T8** | `GoldenRider`| 100% DEX, 50% INT | Golden Breath (90% DEX + 90% INT Magic + Ablaze + Blind) | Solar Salvo (260% AoE Radiant) |
| **T9** | `WyrmRider` | 100% DEX, 50% INT | Wyrm Breath (120% DEX + 120% INT Magic to All + Ablaze + Frozen) | Draconic Sublimation (250% Phys + 250% Magic to All) |

### Branch 3: Black Idol Line
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

#### [MODIFY] [strings.xml](file:///c:/Repositories/IGM-Modded/app/src/main/res/values/strings.xml)
- Add new passive names & descriptions:
  - `passive_shadow_stalker_i_name` / `_description`
  - `passive_cull_the_weak_i_name` / `_description`
  - `passive_phantom_lethality_name` / `_description`
  - `passive_soul_tether_name` / `_description`
- Add updated Rider mount logs & active skill strings:
  - `log_wyrm_breath`: `"%s's Wyrm unleashes cataclysmic subzero dragonfire for %s damage!"`
  - `log_minion_damage_redirected`: `"%s redirects %s damage to its summoned minion!"`

---

### Skills & Enums

#### [MODIFY] [Skills.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/Skills.kt)
- Add new passives:
  - `PASSIVE_SHADOW_STALKER_I`, `PASSIVE_SHADOW_STALKER_II`
  - `PASSIVE_CULL_THE_WEAK_I`, `PASSIVE_CULL_THE_WEAK_II`
  - `PASSIVE_PHANTOM_LETHALITY_I`, `PASSIVE_PHANTOM_LETHALITY_II`
  - `PASSIVE_SOUL_TETHER`
- Add updated active skills:
  - `ACTIVE_DRAGONFIRE_VOLLEY`, `ACTIVE_SOLAR_SALVO`

#### [MODIFY] [EndOfTurnAction.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/EndOfTurnAction.kt)
- Update `RIDER_I` through `RIDER_VII` with dynamic scaling flags:
  - Add `scalesWithRiderStats = true`, scaling percentages for DEX and INT.

---

### Adventurer Units

#### [MODIFY] Whisper Branch:
- [Assassin.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/adventurers/units/Assassin.kt): Assign `PASSIVE_SHADOW_STALKER_I`.
- [SpireInitiate.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/adventurers/units/SpireInitiate.kt): Assign `PASSIVE_SHADOW_STALKER_II`.
- [SpireAcolyte.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/adventurers/units/SpireAcolyte.kt): Assign `PASSIVE_CULL_THE_WEAK_I`.
- [SpireLeader.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/adventurers/units/SpireLeader.kt): Assign `PASSIVE_CULL_THE_WEAK_II`.
- [SpireSage.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/adventurers/units/SpireSage.kt): Assign `PASSIVE_PHANTOM_LETHALITY_I`.
- [Whisper.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/adventurers/units/Whisper.kt): Assign `PASSIVE_PHANTOM_LETHALITY_II`, set base stats and weapon scaling.

#### [MODIFY] Wyrm Rider Branch:
- Update [WolfRider.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/adventurers/units/WolfRider.kt) through [WyrmRider.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/adventurers/units/WyrmRider.kt):
  - Set `attackDexterityScaling = 1.0`, `attackIntelligenceScaling = 0.5`.
  - Wire upgraded active skills and mount end-of-turn actions.

#### [MODIFY] Black Idol Branch:
- Update [Necromancer.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/adventurers/units/Necromancer.kt) through [BlackIdol.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/adventurers/units/BlackIdol.kt):
  - Set adjusted base Defense values.
  - Set `soulTetherPercent` (20% -> 40%).
  - Set `battleStartMinionClass` name for automatic minion deployment.

---

### Combat Engine (`Area.kt` & `Entity.kt`)

#### [MODIFY] [Entity.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/Entity.kt) & [Adventurer.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/adventurers/Adventurer.kt)
- Add `soulTetherPercent: Double` and damage redirection logic in `applyDamage()`.
- Add `missingHpDamageMultiplier(target: Entity): Double` for Whisper passives.

#### [MODIFY] [Area.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/Area.kt)
- **Mount Damage Scaling**: In `tick()` when executing `endOfTurnAction`, calculate damage using Rider's DEX and INT instead of flat integer constants.
- **Curse Turn Tick**: In `StatusEffectType.LESSER_CURSE` .. `ABHORRENT_CURSE` turn processing, apply active % max HP damage and stat reduction.
- **Battle-Start Minions**: In `initializeFight()`, if an adventurer has `battleStartMinionClass`, automatically spawn their minion companion.
- **Eclipse Execution Scaling**: In `cast()`, implement missing-HP damage amplification and execution chaining.

---

## Verification Plan

### Automated JVM Tests
- Run test suite:
  ```powershell
  .\gradlew.bat testDebugUnitTest
  ```
- Add unit tests in `app/src/test/java/it/paranoidsquirrels/idleguildmaster/`:
  - **WhisperTest**: Verify missing-HP damage scaling, 50% defense penetration, and Eclipse execution.
  - **WyrmRiderTest**: Verify hybrid DEX/INT weapon scaling and dynamic mount breath damage calculations.
  - **BlackIdolTest**: Verify battle-start minion summoning, Soul Tether damage redirection, and Curse DoT/stat debuffs on living targets.

### Compilation Check
- Verify clean build:
  ```powershell
  .\gradlew.bat assembleDebug
  ```
