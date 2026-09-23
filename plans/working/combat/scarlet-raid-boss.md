# Implementation Plan: Scarlet Raid & Dynamic Boss Encounter

## Goal Description
Introduce a new dedicated endgame Raid providing a prestigious, ultra-rare farmable source of [ScarletStrand](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/instances/ScarletStrand.kt) to supplement the Travelling Merchant.

Modeled after the dynamic exploration of [TheCultistRebels](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/raids/TheCultistRebels.kt), the raid sends the party into **The Sanguine Crucible**, where adventurers randomly wander through **5 to 50 rooms** facing wandering disciples before discovering the sanctum of **Archmagus Valthex** and his **4 Crimson Acolytes**.

---

## 1. Visual Assets & Entity Overview

Visual assets located in `app/src/main/res/drawable/`:
- `summary_scarlet.png` — Raid banner (summary card).
- `area_scarlet.png` — Raid detail background.
- `scarlet_grand_mage.png` — Archmagus Valthex sprite.
- `scarlet_mage.png` — Crimson Acolyte sprite.
- `icon_effect_sanguine_fervor.png` — Sanguine Fervor status effect icon.

### Approved Final Names & UI Sizing:

| Element | Final Name | Asset | Notes / UI Length Handling |
| :--- | :--- | :--- | :--- |
| **Raid Area** | **The Sanguine Crucible** (`SanguineCrucible.kt`) | `summary_scarlet.png` (summary), `area_scarlet.png` (detail) | 21 chars. Extends [Area](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/Area.kt), Raid Type (`getAreaType() = 1`). |
| **Boss** | **Archmagus Valthex** *(The Crimson Sovereign)* | `scarlet_grand_mage.png` | Display name: **`Archmagus Valthex`** (17 chars) to avoid UI clipping; "The Crimson Sovereign" in lore description. |
| **Minion** | **Crimson Acolyte** (`CrimsonAcolyte.kt`) | `scarlet_mage.png` | 15 chars. Wanders hallway rooms and spawns 4× with the boss. |
| **New Status** | **Sanguine Fervor** (`StatusEffectType.SANGUINE_FERVOR`) | `icon_effect_sanguine_fervor.png` | Stackable on-death buff from Acolytes: +5% damage per stack to surviving enemy allies. Permanent (no turn duration, stays until unit dies). |
| **Boss Skill** | **Scarlet Aeonia** (`ACTIVE_SCARLET_AEONIA`) | — | AoE magic: Sinister Curse (5 turns) $\rightarrow$ 120% magic dmg $\rightarrow$ Bloodflame (5 turns). |
| **Minion Skill** | **Sanguine Pyre** (`ACTIVE_SANGUINE_PYRE`) | — | AoE magic: 50% damage $\rightarrow$ Bloodflame (3 turns). |

---

## 2. Raid Exploration: The Sanguine Crucible

### 2.1 Wandering Corridor Structure (5 to 15 Rooms)
Modeled directly after the random hall exploration in [TheCultistRebels](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/raids/TheCultistRebels.kt):
- **Party Size**: `adventurersNumber() = 14` (the engine's maximum team slots — same as The Tower; a size of 15 crashes `DialogSendTeam` because only 14 slot bindings exist)
- **Dynamic Pacing**:
  - Upon entering the raid (`progress == 1`), a target boss room threshold is randomly rolled:
    $$\text{bossRoomThreshold} = 5 + \text{random}(0 \dots 10) \quad \text{(Range: 5 to 15 rooms)}$$
  - In each exploration step, the party navigates a randomized chamber:
    - **Combat Chamber (80% chance)**: Spawns 1 to 5 wandering **Crimson Acolytes**.
    - **Atmospheric Chamber (20% chance)**: Flavor event/logs ("Whispers of forbidden crimson incantations echo through the twisting halls...", etc.).
  - Each cleared room advances exploration until the party breaches the inner sanctum at `bossRoomThreshold`.
- **Boss Chamber**:
  - The party confronts **Archmagus Valthex + 4 Crimson Acolytes** simultaneously. Archmagus Valthex is placed in the middle (3rd position. 2 Crimson Acolytes on its left and 2 Crimson Acolytes on its right)
  - Defeating the encounter marks the raid as completed (`terminationRequested = true`).
- **Refresh Cost**: standard raid refresh cost.
- **Unlock Condition**: Unlocked upon clearing [TheTower](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/raids/TheTower.kt) Floor 35 (The Machine) or upon first acquiring a Scarlet Strand.

---

## 3. Enemy Statistics & Combat Mechanics

### 3.1 Crimson Acolyte (`CrimsonAcolyte.kt`)
Fanatical ritualists who sustain the Archmagus and empower each other through martyrdom.

- **Base Statistics**:
  - **HP**: `6,000` (`baseMaxHp = 6000`)
  - **Constitution**: `80`
  - **Dexterity**: `250`
  - **Intelligence**: `200`
  - **Attack Damage**: `100` – `200` (`getMinDamage() = 100`, `getMaxDamage() = 200`)
  - **Lifesteal**: `100%` (`baseLifesteal = 100`)
  - **Critical Chance**: `60%` (`calculateCriticalChance() = 0.60`)
  - **Critical Damage**: `200%` (`criticalDamage = 2.0`)
  - **Physical Defense**: `0` (`baseDefense = 0`)
  - **Magic Defense**: `60` (`baseMagicDefense = 60`)
  - **Status Immunity**: `60%` (`immunityToStatus = 0.60`, with `StatusEffectType.BLEED` bypassing status immunity)
  - **Starting Mana**: `currentMana = 100` (casts Sanguine Pyre immediately on turn 1, like Bleak Disciple)
  - **Threat**: `4` (`threat = 4`)
  - **XP Drop**: `2,500 XP` (`expGiven = 2500`)
  - **Drop Table**:
    - **5%** Esoteric Egg (`EsotericEgg`)
    - **35%** Eldritch Seal (`EldritchSeal`)
    - **35%** Black Hide (`BlackHide`)
    - **45%** Aberrant Fabric (`AbherrantFabric`)
- **Active Skill — Sanguine Pyre**:
  - Hits all adventurers for **50% magic damage** and inflicts **`BLOODFLAME`** for 3 turns (burns each turn and disables all healing).
  - Tooltip includes standard `BLOODFLAME` explanation block.
- **Passive Skill — Martyr's Pact (On-Death Effect)**:
  - `passiveSkill = Skills.PASSIVE_MARTYRS_PACT`
  - When a Crimson Acolyte dies, `calculateOnDeathEffectsOnAllies()` triggers.
  - Grants the positive status effect **`Sanguine Fervor`** (`StatusEffectType.SANGUINE_FERVOR`) to all surviving enemy allies.
  - **Mechanics**:
    - **Single Icon Stacking (Bleed-style consolidation)**: Like `BLEED`, multiple applications consolidate into a single `StatusEffect` instance on the entity, storing the stack count in `turnsLeft`. This ensures **only 1 icon** appears in the combat UI (preventing 3 duplicate icons from consuming all 3 entity status slots).
    - **Damage Scaling**: Each stack increases damage dealt by +5% (`+ (effect.turnsLeft * 0.05)`).
    - **No Turn Duration / Permanent**: `resolveStatus()` exempts `SANGUINE_FERVOR` from duration decrement and expiration removal so the stack count remains until the unit dies.
    - Slaying all 4 initial acolytes grants Archmagus Valthex a permanent **+20% damage boost** (4 stacks), and any subsequently slain Acolytes summoned via Blood Convocation add further stacks.
  - **Description**: Explains both on-death trigger and Sanguine Fervor mechanics in the tooltip.

---

### 3.2 Archmagus Valthex (`ArchmagusValthex.kt`)
The Crimson Sovereign — supreme master of the Sanguine Crucible.

- **Boss Encounter Formation**:
  - Spawns surrounded by **4 Crimson Acolytes**:
    ```kotlin
    CopyOnWriteArrayList(listOfNotNull(
        Enemy.getInstance("CrimsonAcolyte"),
        Enemy.getInstance("CrimsonAcolyte"),
        Enemy.getInstance("ArchmagusValthex"),
        Enemy.getInstance("CrimsonAcolyte"),
        Enemy.getInstance("CrimsonAcolyte")
    ))
    ```
- **Base Statistics**:
  - **HP**: `120,000` (`baseMaxHp = 120000`)
  - **Constitution**: `100`
  - **Dexterity**: `300`
  - **Intelligence**: `600`
  - **Attack Damage**: `200` – `250` (`getMinDamage() = 200`, `getMaxDamage() = 250`)
  - **Lifesteal**: `200%` (`baseLifesteal = 200`)
  - **Critical Chance**: `100%` (`calculateCriticalChance() = 1.0`)
  - **Critical Damage**: `150%` (`criticalDamage = 1.5`)
  - **Physical Defense**: `10` (`baseDefense = 10`)
  - **Magic Defense**: `90` (`baseMagicDefense = 90`)
  - **Status Immunity**: `100%` (`immunityToStatus = 1.0`, with `StatusEffectType.BLEED` bypassing status immunity)
  - **Starting Mana**: `currentMana = 100` (casts Scarlet Aeonia immediately on turn 1, like Bleak Disciple)
  - **Threat**: `1` (standard boss threat)
  - **XP Drop**: `50,000 XP` (`expGiven = 50000`)
  - **Drop Table**:
    - **1%** Scarlet Strand (`ScarletStrand`)
    - **5%** Esoteric Egg (`EsotericEgg`)
    - **35%** Eldritch Seal (`EldritchSeal`)
    - **35%** Black Hide (`BlackHide`)
    - **45%** Aberrant Fabric (`AbherrantFabric`)
- **Active Skill — Scarlet Aeonia**:
  1. Inflicts all adventurers with **`SINISTER_CURSE`** for 5 turns (icon: `icon_effect_sinister_curse.png`).
     - **Option C Mechanics**: Amplifies incoming damage taken by **+50%**. If an afflicted adventurer dies while cursed, their soul is reaped into an enemy [BoneNightmareEnemy](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/enemies/units/BoneNightmareEnemy.kt) fighting on Valthex's team (if enemy formation has room, < 5).
  2. Hits all adventurers for **120% magic damage**.
  3. Inflicts all adventurers with **`BLOODFLAME`** for 5 turns.
  - Tooltip includes standard explanation blocks for both `SINISTER CURSE` and `BLOODFLAME`.
  - *Log message*: `"%s unleashes Scarlet Aeonia, engulfing the raid in sinister curses and blooming crimson flames!"`
- **Passive Skill — Blood Convocation (On-Hit Summon)**:
  - Whenever Archmagus Valthex takes damage, there is a **50% chance** to summon a fresh **Crimson Acolyte** into the fight (if enemy formation has room, max 5).
  - Newly summoned Acolytes also grant +1 stack of permanent `Sanguine Fervor` (+5% damage, no turn duration) when slain, continuously escalating the boss's power if the encounter drags on.

---

### 3.3 Enemy Minion: Cursed Bone Nightmare (`BoneNightmareEnemy.kt`)
Reanimated minion raised when a cursed adventurer falls under `SINISTER_CURSE`:
- Subclass of [Enemy](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/enemies/Enemy.kt), registered as `EnemyType.UNDEAD`.
- Uses `R.drawable.unit_bone_nightmare`.
- **Base Statistics**: HP `8,000`, CON `100`, DEX `150`, DEF `40`, MDEF `20`, Melee Damage `300–400`.
- **Threat**: `6` (`threat = 6`). High-threat frontline tank minion.
- **Passive**: `Skills.PASSIVE_THREATENING_II`.
- **XP**: `1,000 XP`.

---

## 4. Drop Table Architecture & Independent Rolls

### 4.1 Independent Roll Implementation
`Enemy.kt` introduces `open fun rollDrops(evKey: Int): List<ItemWrapper>`:
- Default behavior preserves vanilla single roll from `listDrops()`.
- `CrimsonAcolyte` and `ArchmagusValthex` override `rollDrops()` to roll each item independently:
  - **ScarletStrand** (Valthex only): 1.0% chance (`random() < 0.01`).
  - **EsotericEgg**: 5.0% chance (`random() < 0.05`).
  - **EldritchSeal**: 35.0% chance (`random() < 0.35`).
  - **BlackHide**: 35.0% chance (`random() < 0.35`).
  - **AbherrantFabric**: 45.0% chance (`random() < 0.45`).
- `listDrops(i)` on both entities returns all items as keys in `LinkedHashMap<ItemWrapper, Int>` so they all appear cleanly in the Bestiary and inspection UI ([DialogEntityDetail.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogEntityDetail.kt#L104)).

---

## 5. Technical Integration Checklist

### 5.1 Storage & Raid Logic
- [NEW] `SanguineCrucible.kt` in `it.paranoidsquirrels.idleguildmaster.storage.data.places.raids`:
  - Implements randomized hallway wandering (5 to 15 rooms) with Acolyte skirmishes.
  - Spawns the 5-enemy encounter (Valthex + 4 Acolytes) at the final room.
- [NEW] `CrimsonAcolyte.kt` in `it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units`:
  - Stats (`expGiven = 2500`), `Sanguine Pyre` active, `passiveSkill = Skills.PASSIVE_MARTYRS_PACT`, and `calculateOnDeathEffectsOnAllies()` granting permanent `SANGUINE_FERVOR`.
- [NEW] `ArchmagusValthex.kt` in `it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units`:
  - Stats (`expGiven = 50000`), `Scarlet Aeonia` active, 1% drop table, and `PASSIVE_BLOOD_CONVOCATION`.
- [NEW] `BoneNightmareEnemy.kt` in `it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units`:
  - Stats (`expGiven = 1000`), `passiveSkill = Skills.PASSIVE_THREATENING_II`, sprite `R.drawable.unit_bone_nightmare`.
  - Registered as `EnemyType.UNDEAD` in `EnemyTypeRegistry.kt`.

### 5.2 Status Effects & Skills
- [MODIFY] `StatusEffectType.kt`:
  - `SANGUINE_FERVOR`: Positive status buffing damage by +5% per stack. Stackable, permanent (no turn duration, stays until unit dies), linked to `R.drawable.icon_effect_sanguine_fervor`. Custom log string: `status_effect_sanguine_fervor_log_description`.
  - `SINISTER_CURSE`: Negative status applied by Scarlet Aeonia (5 turns). Linked to `R.drawable.icon_effect_sinister_curse`.
- [MODIFY] `StatusEffect.kt` / `Entity.kt`:
  - Support stack tracking for `SANGUINE_FERVOR` upon receiving multiple instances (incrementing stack count or stacking instances).
  - Return `999` in `addStatusEffect()` for `SANGUINE_FERVOR` to use clean log format ("%s is %s.").
- [MODIFY] `Area.kt`:
  - Exempt `SANGUINE_FERVOR` from turn duration decrement / expiration removal in `resolveStatus()` so it stays active until unit death.
  - Handle `SANGUINE_FERVOR` in `statusDamageMultiplier`: `+ (stacks * 0.05)` damage bonus.
  - Handle `SINISTER_CURSE` in `statusDamageMultiplier`: `* 1.5` (+50% damage taken).
  - Handle `SINISTER_CURSE` in adventurer death handling (`checkDeath`): if dying adventurer is cursed, spawn `BoneNightmareEnemy` into `this.enemies` and `this.fightingGroup` (if `enemies.size < 5`).
  - Handle `PASSIVE_BLOOD_CONVOCATION` in damage resolution: 50% chance on being damaged to spawn a `CrimsonAcolyte` if `enemies.size < 5`.
- [MODIFY] `Skills.kt`:
  - Add `ACTIVE_SCARLET_AEONIA`, `ACTIVE_SANGUINE_PYRE`, and `PASSIVE_MARTYRS_PACT`.
- [MODIFY] `Logger.kt`:
  - Add `SINISTER_CURSE_REANIMATE` log format.

### 5.3 UI & Registration
- [MODIFY] [`fragment_raids.xml`](file:///c:/Repositories/IGM-Modded/app/src/main/res/layout/fragment_raids.xml):
  - Add `<include android:id="@+id/sanguine_crucible" layout="@layout/layout_dungeon" .../>`
- [MODIFY] [`RaidsFragment.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/raids/RaidsFragment.kt):
  - Bind `sanguine_crucible` in `refresh()`.
- [MODIFY] [`Data.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/Data.kt):
  - Add `@SerializedName("sanguineCrucible") var sanguineCrucible: SanguineCrucible? = SanguineCrucible()`
- [MODIFY] [`DataDeserializer.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/DataDeserializer.kt):
  - Register `sanguineCrucible` deserialization.
- [MODIFY] [`Utils.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/Utils.kt):
  - Register in `compileRaidList()`.

### 5.4 Strings & Localization
- [MODIFY] `strings.xml`:
  - `raid_name_sanguine_crucible`: "The Sanguine Crucible"
  - `enemy_archmagus_valthex_name`: "Archmagus Valthex"
  - `enemy_archmagus_valthex_description`: "Known as The Crimson Sovereign. Masters the forbidden arts of blood and strand within the Crucible."
  - `enemy_crimson_acolyte_name`: "Crimson Acolyte"
  - `enemy_crimson_acolyte_description`: "A fanatical ritualist whose death fuels their allies with dark zealotry."
  - `passive_martyrs_pact_name`: "Martyr's Pact"
  - `passive_martyrs_pact_description`: Explaining on-death Sanguine Fervor stack and what Sanguine Fervor does (+5% damage, stays until death).
  - `status_effect_sanguine_fervor_name`: "Sanguine Fervor"
  - `status_effect_sanguine_fervor_description`: "Infused with sacrificial blood essence. Damage dealt increased by 5% per stack. Stays until death."
  - `status_effect_sanguine_fervor_log_description`: "empowered by Sanguine Fervor"
  - `status_effect_sinister_curse_name`: "Sinister Curse"
  - `status_effect_sinister_curse_description`: "A malign crimson curse. Increases damage taken by 50%. If the afflicted dies while cursed, their soul is reaped into an enemy Bone Nightmare."
  - `skill_scarlet_aeonia_name`: "Scarlet Aeonia"
  - `skill_scarlet_aeonia_description`: Description including Sinister Curse and Bloodflame explanation blocks.
  - `skill_sanguine_pyre_name`: "Sanguine Pyre"
  - `skill_sanguine_pyre_description`: Description including Bloodflame explanation block.
  - `enemy_cursed_bone_nightmare_description`: "A grotesque skeletal war-steed risen from the soul of a cursed adventurer."
  - `log_sinister_curse_reanimate`: "%s falls under the Sinister Curse and is reanimated as a Bone Nightmare to serve the enemy!"
  - Combat logs for Scarlet Aeonia, Sanguine Fervor, and Acolyte summons.

---

## 6. Verification & Balance Testing
1. **Dungeon Exploration Validation**:
   - Verify room generation: Party correctly wanders between 5 and 15 rooms before reaching the boss.
   - Verify hallway skirmishes with 1–5 Crimson Acolytes awarding 2,500 XP each.
2. **Combat Mechanics**:
   - Slaying a Crimson Acolyte applies stackable `Sanguine Fervor` (+5% damage per stack, no turn duration / permanent until unit dies) to surviving enemies with clean battle logs.
   - Valthex casts Scarlet Aeonia: applies Sinister Curse (with `icon_effect_sinister_curse`), deals 120% magic damage, and applies Bloodflame for 5 turns.
   - When an adventurer afflicted with Sinister Curse dies, an enemy `BoneNightmareEnemy` is reanimated onto Valthex's team.
   - Valthex taking hits triggers a 50% chance to spawn an Acolyte if space permits.
   - Slaying Archmagus Valthex awards 50,000 XP.
3. **Loot Table**:
   - Automated roll simulation: Scarlet Strand verified at exactly 1.0% (Weight 10 / 1000), remaining 99% yielding no drop.
