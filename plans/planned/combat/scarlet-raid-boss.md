# Implementation Plan: Scarlet Raid & Dynamic Boss Encounter

## Goal Description
Introduce a new dedicated endgame Raid providing a prestigious, ultra-rare farmable source of [ScarletStrand](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/instances/ScarletStrand.kt) to supplement the Travelling Merchant.

Modeled after the dynamic exploration of [TheCultistRebels](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/raids/TheCultistRebels.kt), the raid sends the party into **The Sanguine Crucible**, where adventurers randomly wander through **5 to 50 rooms** facing wandering disciples before discovering the sanctum of **Archmagus Valthex** and his **4 Crimson Acolytes**.

---

## 1. Visual Assets & Entity Overview

Visual assets located in `app/src/main/res/drawable/`:
- `area_scarlet.png` — Raid banner & detail background.
- `scarlet_grand_mage.png` — Archmagus Valthex sprite.
- `scarlet_mage.png` — Crimson Acolyte sprite.
- `icon_effect_sanguine_fervor.png` — Sanguine Fervor status effect icon.

### Approved Final Names & UI Sizing:

| Element | Final Name | Asset | Notes / UI Length Handling |
| :--- | :--- | :--- | :--- |
| **Raid Area** | **The Sanguine Crucible** (`SanguineCrucible.kt`) | `area_scarlet.png` | 21 chars. Extends [Area](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/Area.kt), Raid Type (`getAreaType() = 1`). |
| **Boss** | **Archmagus Valthex** *(The Crimson Sovereign)* | `scarlet_grand_mage.png` | Display name: **`Archmagus Valthex`** (17 chars) to avoid UI clipping; "The Crimson Sovereign" in lore description. |
| **Minion** | **Crimson Acolyte** (`CrimsonAcolyte.kt`) | `scarlet_mage.png` | 15 chars. Wanders hallway rooms and spawns 4× with the boss. |
| **New Status** | **Sanguine Fervor** (`StatusEffectType.SANGUINE_FERVOR`) | `icon_effect_sanguine_fervor.png` | Stackable on-death buff from Acolytes: +5% damage per stack to surviving enemy allies. Permanent (no turn duration, stays until unit dies). |
| **Boss Skill** | **Scarlet Aeonia** (`ACTIVE_SCARLET_AEONIA`) | — | AoE magic: Sinister Curse (5 turns) $\rightarrow$ 120% magic dmg $\rightarrow$ Bloodflame (5 turns). |

---

## 2. Raid Exploration: The Sanguine Crucible

### 2.1 Wandering Corridor Structure (5 to 50 Rooms)
Modeled directly after the random hall exploration in [TheCultistRebels](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/raids/TheCultistRebels.kt):
- **Party Size**: `adventurersNumber() = 15`
- **Dynamic Pacing**:
  - Upon entering the raid (`progress == 1`), a target boss room threshold is randomly rolled:
    $$\text{bossRoomThreshold} = 5 + \text{random}(0 \dots 45) \quad \text{(Range: 5 to 50 rooms)}$$
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
  - **HP**: `5,000`
  - **Constitution**: `80`
  - **Dexterity**: `250`
  - **Intelligence**: `200`
  - **Attack Damage**: `500` – `600`
  - **Lifesteal**: `100%` (`baseLifesteal = 100`)
  - **Critical Chance**: `60%` (`calculateCriticalChance() = 0.60`)
  - **Critical Damage**: `200%` (`criticalDamage = 2.0`)
  - **Physical Defense**: `0` (`baseDefense = 0`)
  - **Magic Defense**: `60` (`baseMagicDefense = 60`)
  - **Status Immunity**: `60%` (`immunityToStatus = 0.60`)
- **Active Skill — Sanguine Pyre**:
  - Hits all adventurers for **50% damage** and inflicts **`BLOODFLAME`** (burns each turn and disables all healing).
- **Passive Skill — Martyr's Pact (On-Death Effect)**:
  - When a Crimson Acolyte dies, `calculateOnDeathEffectsOnAllies()` triggers.
  - Grants the positive status effect **`Sanguine Fervor`** (`StatusEffectType.SANGUINE_FERVOR`) to all surviving enemy allies.
  - **Mechanics**:
    - **Stackable**: Stacks infinitely; each slain Acolyte applies +1 stack (+5% damage dealt per stack).
    - **No Turn Duration / Permanent**: Has no turn countdown and persists indefinitely until the affected unit dies.
    - Slaying all 4 initial acolytes grants Archmagus Valthex a permanent **+20% damage boost** (4 stacks), and any subsequently slain Acolytes summoned via Blood Convocation add further stacks.

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
  - **HP**: `100,000`
  - **Constitution**: `100`
  - **Dexterity**: `300`
  - **Intelligence**: `600`
  - **Attack Damage**: `500` – `600`
  - **Lifesteal**: `200%` (`baseLifesteal = 200`)
  - **Critical Chance**: `100%` (`calculateCriticalChance() = 1.0`)
  - **Critical Damage**: `250%` (`criticalDamage = 2.5`)
  - **Physical Defense**: `10` (`baseDefense = 10`)
  - **Magic Defense**: `90` (`baseMagicDefense = 90`)
  - **Status Immunity**: `100%` (`immunityToStatus = 1.0`)
- **Active Skill — Scarlet Aeonia**:
  1. Inflicts all adventurers with **`SINISTER_CURSE`** (amplifies damage taken) for 5 turns.
  2. Hits all adventurers for **120% magic damage**.
  3. Inflicts all adventurers with **`BLOODFLAME`** for 5 turns.
  - *Log message*: `"%s unleashes Scarlet Aeonia, engulfing the raid in sinister curses and blooming crimson flames!"`
- **Passive Skill — Blood Convocation (On-Hit Summon)**:
  - Whenever Archmagus Valthex takes damage, there is a **50% chance** to summon a fresh **Crimson Acolyte** into the fight (if enemy formation has room, max 5).
  - Newly summoned Acolytes also grant +1 stack of permanent `Sanguine Fervor` (+5% damage, no turn duration) when slain, continuously escalating the boss's power if the encounter drags on.

---

## 4. Drop Table Implementation (Strict 1% / 99% No-Drop)

### 4.1 Vanilla Engine Architecture
In Idle Guild Master, [`Utils.rollFromWeightedMap()`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/Utils.kt#L1211) generates a random roll against a hardcoded base of `1000.0`:
```kotlin
val dRandom = random() * 1000.0
var iIntValue = 0
for ((key, value) in map) {
    iIntValue += value
    if (dRandom < iIntValue) {
        return key
    }
}
return null // Fell through: NO LOOT DROPPED
```

When an enemy's weight sum is less than `1000`, the remainder is automatically an empty roll returning `null` (no item). This is the exact pattern used by vanilla bosses:
- **[Cerebrum.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/enemies/units/Cerebrum.kt#L36)**: Has only `AbioticCore` with weight `100` (10% drop, 90% null).
- **[HeadlessKnight.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/enemies/units/HeadlessKnight.kt#L40)**: Has only `DreadfulMorningstar` with weight `75` (7.5% drop, 92.5% null).
- **[Oculus.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/enemies/units/Oculus.kt#L34)**: Has `ElasticMembrane` (400), `FluxLimiter` (3), `Scanner` (4) — total weight `407` (40.7% total drop, 59.3% null).
- **[SlimeKing.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/enemies/units/SlimeKing.kt#L43)**: Weights sum to `1000` (guaranteed drop): `SeekingGlass` has weight `10` (1%), `SlimeKingsCrown` has `30` (3%), and `GreenSlime` has `960` (96%).

### 4.2 Exact Kotlin Code for Archmagus Valthex
To achieve a **strict 1.0% drop chance with 99.0% nothing dropped**, `ArchmagusValthex.kt` contains ONLY the single 10-weight entry:
```kotlin
override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
    val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
    linkedHashMap.put(ItemWrapper.getInstance("ScarletStrand", 1), 10)
    return linkedHashMap
}
```

- **Roll < 10.0 (1.0%)**: Returns `ItemWrapper("ScarletStrand", 1)`.
- **Roll >= 10.0 (99.0%)**: `rollFromWeightedMap` returns `null` $\rightarrow$ no item dropped in [Area.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/Area.kt#L685).
- **Bestiary Cleanliness**: Because no dummy entries exist, [DialogEntityDetail.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogEntityDetail.kt#L104) renders only `ScarletStrand` in the enemy loot display.

---

## 5. Technical Integration Checklist

### 5.1 Storage & Raid Logic
- [NEW] `SanguineCrucible.kt` in `it.paranoidsquirrels.idleguildmaster.storage.data.places.raids`:
  - Implements randomized hallway wandering (5 to 50 rooms) with Acolyte skirmishes.
  - Spawns the 5-enemy encounter (Valthex + 4 Acolytes) at the final room.
- [NEW] `CrimsonAcolyte.kt` in `it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units`:
  - Stats, `Sanguine Pyre` active, and `calculateOnDeathEffectsOnAllies()` returning `SANGUINE_FERVOR`.
- [NEW] `ArchmagusValthex.kt` in `it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units`:
  - Stats, `Scarlet Aeonia` active, 1% drop table, and `PASSIVE_BLOOD_CONVOCATION`.

### 5.2 Status Effects & Skills
- [MODIFY] `StatusEffectType.kt`:
  - Add `SANGUINE_FERVOR`: Positive status buffing damage by +5% per stack. Stackable, permanent (no turn duration, stays forever until unit dies), linked to `R.drawable.icon_effect_sanguine_fervor`.
  - Add `SINISTER_CURSE`: Negative status applied by Scarlet Aeonia (5 turns).
- [MODIFY] `StatusEffect.kt` / `Entity.kt`:
  - Support stack tracking for `SANGUINE_FERVOR` upon receiving multiple instances (incrementing stack count or stacking instances).
- [MODIFY] `Area.kt`:
  - Exempt `SANGUINE_FERVOR` from turn duration decrement / expiration removal in `decrementStatusEffects()` so it stays active until unit death.
  - Handle `SANGUINE_FERVOR` in `statusDamageMultiplier`: `+ (stacks * 0.05)` damage bonus.
  - Handle `PASSIVE_BLOOD_CONVOCATION` in damage resolution: 5% chance on being damaged to spawn a `CrimsonAcolyte` if `enemies.size < 5`.
- [MODIFY] `Skills.kt`:
  - Add `ACTIVE_SCARLET_AEONIA` and `ACTIVE_SANGUINE_PYRE`.

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
  - `status_effect_sanguine_fervor_name`: "Sanguine Fervor"
  - `status_effect_sanguine_fervor_description`: "Infused with sacrificial blood essence. Damage dealt increased by 5% per stack. Stays until death."
  - `status_effect_sinister_curse_name`: "Sinister Curse"
  - `skill_scarlet_aeonia_name`: "Scarlet Aeonia"
  - `skill_sanguine_pyre_name`: "Sanguine Pyre"
  - Combat logs for Scarlet Aeonia, Sanguine Fervor, and Acolyte summons.

---

## 6. Verification & Balance Testing
1. **Dungeon Exploration Validation**:
   - Verify room generation: Party correctly wanders between 5 and 50 rooms before reaching the boss.
   - Verify hallway skirmishes with 1–3 Crimson Acolytes.
2. **Combat Mechanics**:
   - Slaying a Crimson Acolyte applies stackable `Sanguine Fervor` (+5% damage per stack, no turn duration / permanent until unit dies) to surviving enemies.
   - Valthex casts Scarlet Aeonia: applies Sinister Curse, deals 120% magic damage, and applies Bloodflame for 5 turns.
   - Valthex taking hits triggers a 5% chance to spawn an Acolyte if space permits.
3. **Loot Table**:
   - Automated roll simulation: Scarlet Strand verified at exactly 1.0% (Weight 10 / 1000), remaining 99% yielding no drop.
