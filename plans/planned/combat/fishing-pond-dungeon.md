# Implementation Plan: The Slumbering Shallows (Guild Fishing Activity)

## Goal Description

Introduce a unique, atmospheric new guild activity — **The Slumbering Shallows** — housed in the **Guild Activities tab** (alongside The Hunt and The Siege). The activity is themed around an enchanted, murky fishing pond where adventurers cast lines to catch elusive aquatic creatures rather than battling conventional dungeon monsters.

- **Location**: **Guild Activities tab** (`GuildActivitiesFragment`), NOT the Dungeons tab.
- **Party Size**: 4 adventurers.
- **Area Architecture**: Continuous fishing activity with ambient room searching (`searchRoom()`). There is **no final boss chamber** and no floor completion cutoff; the party fishes continuously until recalled or wiped.
- **Core Theme**: A deceptively tranquil fishing pond where players catch aquatic food creatures. However, deep beneath the surface lurks an ultra-rare, terrifying specter — **Chorus the Drowned** — who has a 0.1% chance to be hooked on any cast.
- **Strict Drop Economy**:
  - **"Fish Only Drop The Fish"**: Every fish creature drops strictly **itself** as a [`Food`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/abstractClasses/Food.kt) item sharing the exact same pixel art. No fictional pearls, shark teeth, kindlequartz, or magma cores.
  - **No Made-Up Boss Equipment**: No fictional items for Chorus the Drowned (no `DrownedLantern`, no `ChorusScythe`). Chorus drops a vanilla [`CoinPurse`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/instances/CoinPurse.kt) or standard bounty reward.
  - **Idle Room Gathering**: In idle search rooms (`searchRoom()`), adventurers can fish up ambient `Perch` or hook a sunken [`CoinPurse`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/instances/CoinPurse.kt).

---

## 1. Combat & Design Philosophy

### 1.1 The Fish: Very Low Damage, Low HP, Extreme Dodge
Every standard aquatic creature adheres to a strict design rule:
> **"Very, very low damage, low HP, but very high dodge."**

1. **Thematically Authentic**: Fish do not hit hard; they thrash, nibble, and slip off the hook. Catching them is a test of precision and agility.
2. **Dexterity Specialization**: Dexterity-heavy parties (Rogues, Rangers, Bards, Dex-scaling pets) dramatically outperform slow strength tanks. Low-DEX heroes will constantly swing and miss, while high-DEX heroes reel in fish with ease.
3. **Zero Frustration from Damage**: Fish attacks deal only **1–3 damage**, so party wipes during normal fishing are practically impossible. The challenge is clearing speed and catch efficiency.

### 1.2 Ultra-Rare Hazard: Chorus the Drowned (0.1% Hook Chance)
There is **no final room boss**. Instead, every wave rolled has a tiny **0.1% chance (`Utils.random() < 0.001`)** to hook the ancient phantom of the depths: **Chorus the Drowned** ([`R.drawable.chorus_the_drowned`](file:///c:/Repositories/IGM-Modded/app/src/main/res/drawable/chorus_the_drowned.png)).
- **"This One Will Hit Hard"**: In stark contrast to the gentle fish, **Chorus the Drowned hits devastatingly hard (70–100 damage)**. If a frail, pure-DEX fishing team hooks him without adequate frontline protection or sustain, they risk getting wiped.
- **Flavor & Surprise**: Players sending an unarmored fishing squad run the calculated risk of hooking the reaper of the deep.

### 1.3 Hit Chance & Dodge Formula
From [`Area.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/Area.kt):

$$\text{hitChance} = \frac{\text{attackerDex}}{\text{attackerDex} + \frac{\text{targetDex}}{5.0}}$$

#### Hit-Rate Comparison Across DEX Tiers:
| Encounter | Target DEX | Against Tank (20 DEX) | Against Ranger/Rogue (120 DEX) |
| :--- | :---: | :---: | :---: |
| **Perch** | 60 | $62.5\%$ hit (37.5% dodge) | **$90.9\%$ hit** (9.1% dodge) |
| **Blue Trout** | 90 | $52.6\%$ hit (47.4% dodge) | **$87.0\%$ hit** (13.0% dodge) |
| **Angelfish** | 120 | $45.4\%$ hit (54.6% dodge) | **$83.3\%$ hit** (16.7% dodge) |
| **Winged Ray** *(Flying)* | 160 | $38.5\%$ hit (61.5% dodge) | **$78.9\%$ hit** (21.1% dodge) |
| **Blue Shark** | 220 | $31.2\%$ hit (68.8% dodge) | **$73.1\%$ hit** (26.9% dodge) |
| **Magma Shark** | 300 | $25.0\%$ hit (75.0% dodge) | **$66.7\%$ hit** (33.3% dodge) |
| **Chorus the Drowned** *(0.1% Rare)* | 45 | **$69.0\%$ hit** (Low dodge) | **$93.0\%$ hit** (Heavy combat focus) |

---

## 2. Artwork & Roster Mapping

### 2.1 Area Artwork
- **Detail View Background**: [`R.drawable.area_fishing_pond`](file:///c:/Repositories/IGM-Modded/app/src/main/res/drawable/area_fishing_pond.png)
- **Card Summary Banner**: [`R.drawable.summary_fishing_pond`](file:///c:/Repositories/IGM-Modded/app/src/main/res/drawable/summary_fishing_pond.png)

### 2.2 Complete Encounter Roster

All seven combat units map strictly to verified assets existing in `app/src/main/res/drawable/`:

| Unit Class | Sprite Asset | Max HP | Damage | DEX | Role & Combat Behavior |
| :--- | :--- | :---: | :---: | :---: | :--- |
| **`Perch`** | `R.drawable.perch` | **16** | **1–2** | **60** | Common shallow fish. Plentiful, easily caught. |
| **`BlueTrout`** | `R.drawable.blue_trout` | **24** | **1–2** | **90** | Agile river swimmer with rapid evasive turns. |
| **`Angelfish`** | `R.drawable.angelfish` | **20** | **1–2** | **120** | Delicate ornamental fish. Gracefully slips past weapons. |
| **`WingedRay`** | `R.drawable.winged_ray` | **45** | **2–3** | **160** | Gliding ray. **Flying trait** (`isFlying = true`) requires ranged/flying hits. |
| **`BlueShark`** | `R.drawable.blue_shark` | **85** | **2–4** | **220** | Swift predator of the shallows. Extremely agile and slippery. |
| **`MagmaShark`** | `R.drawable.magma_shark` | **260** | **4–7** | **300** | Deep-dwelling thermal shark (regular high-tier fish, not a miniboss). Extreme dodge. |
| **`ChorusTheDrowned`** | `R.drawable.chorus_the_drowned` | **1,850** | **70–100** | **45** | **Ultra-rare 0.1% hook**. The Reaper of the Shallows. Hits devastatingly hard. |

---

## 3. Drop System & Economy

### 3.1 Strict "Fish Only Drop The Fish" Rule
Every fish creature drops exclusively **itself** as a [`Food`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/abstractClasses/Food.kt) item. All caught fish can be fed directly to pets or automatically consumed by the pet auto-feed system during loot processing.

* **`Perch`** (`Enemy`) -> drops **`Perch`** (`Food`, Feed Power: 10, Weight: 800, ~80%)
* **`BlueTrout`** (`Enemy`) -> drops **`BlueTrout`** (`Food`, Feed Power: 18, Weight: 750, ~75%)
* **`Angelfish`** (`Enemy`) -> drops **`Angelfish`** (`Food`, Feed Power: 25, Weight: 700, ~70%)
* **`WingedRay`** (`Enemy`) -> drops **`WingedRay`** (`Food`, Feed Power: 35, Weight: 650, ~65%)
* **`BlueShark`** (`Enemy`) -> drops **`BlueShark`** (`Food`, Feed Power: 60, Weight: 600, ~60%)
* **`MagmaShark`** (`Enemy`) -> drops **`MagmaShark`** (`Food`, Feed Power: 150, Weight: 600, ~60%)
* **`ChorusTheDrowned`** (`Enemy`) -> drops **`CoinPurse`** (`Item`, Weight: 1000, guaranteed 1x). *No made-up equipment or artifacts.*

### 3.2 Idle Room Gathering (`searchRoom()`)
When the party is searching/resting between casts, they occasionally pull ambient items from the water:
* **`Perch`** (`Food`) — Common catch hooked while idling.
* **`CoinPurse`** ([`R.drawable.coin_purse`](file:///c:/Repositories/IGM-Modded/app/src/main/res/drawable/coin_purse.png)) — Sunken gold purse retrieved from the pondbed.

---

## 4. Encounter Generation Architecture

### 4.1 Spawning Mechanics (`rollEnemies()`)
- **No Final Floor**: There is no room limit or boss floor trigger.
- **Roll Sequence**:
  1. **Chorus Check**: Roll `if (Utils.random() < 0.001)` (0.1% chance). If triggered:
     - Spawns single `ChorusTheDrowned`.
     - Logs: `"[EVENT] The calm waters churn violently! Chorus the Drowned surfaces with his scythe!"`
  2. **Standard Fish Cast**: Otherwise, roll 1–3 fish based on depth/rarity weights:
     - Common tier: `Perch`, `BlueTrout`
     - Intermediate tier: `Angelfish`, `WingedRay`
     - Rare tier: `BlueShark`, `MagmaShark`

---

## 5. Technical Implementation Steps

### 5.1 Enemy Classes (`storage/data/entities/enemies/units/`)
Implement 7 Kotlin classes extending [`Enemy`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/enemies/Enemy.kt):
1. `Perch.kt`
2. `BlueTrout.kt`
3. `Angelfish.kt`
4. `WingedRay.kt` (`override fun isFlying() = true`)
5. `BlueShark.kt`
6. `MagmaShark.kt` (Standard high-tier fish)
7. `ChorusTheDrowned.kt` (0.1% rare hazard, heavy damage 70–100, drops `CoinPurse`)

### 5.2 Item Classes (`storage/data/items/instances/`)
Implement 6 new food items extending [`Food`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/abstractClasses/Food.kt):
1. `Perch.kt` (`idImage = R.drawable.perch`, `feedPower = 10`)
2. `BlueTrout.kt` (`idImage = R.drawable.blue_trout`, `feedPower = 18`)
3. `Angelfish.kt` (`idImage = R.drawable.angelfish`, `feedPower = 25`)
4. `WingedRay.kt` (`idImage = R.drawable.winged_ray`, `feedPower = 35`)
5. `BlueShark.kt` (`idImage = R.drawable.blue_shark`, `feedPower = 60`)
6. `MagmaShark.kt` (`idImage = R.drawable.magma_shark`, `feedPower = 150`)

*(Note: `CoinPurse.kt` already exists in `storage/data/items/instances/CoinPurse.kt` and is reused directly).*

### 5.3 Area Class (`storage/data/places/raids/TheSlumberingShallowsArea.kt`)
- Extends [`Area`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/Area.kt):
  - `adventurersNumber() = 4`
  - `getAreaType() = 0` (or activity mode with continuous looping)
  - `getLayout()` binds to `MainActivity.guildActivitiesFragment.binding!!.theSlumberingShallows`
  - `getDetailDrawable()` = `R.drawable.area_fishing_pond`
  - `getSummaryDrawable()` = `R.drawable.summary_fishing_pond`
  - `rollEnemies()`: 0.1% Chorus roll, otherwise standard fish wave
  - `searchRoom()`: rolls ambient `Perch` or `CoinPurse`
  - `canRefillWithGems()` = false (always accessible guild activity)

### 5.4 Guild Activities Tab Integration
- **`fragment_guild_activities.xml`**:
  Add third activity card `<include android:id="@+id/the_slumbering_shallows" layout="@layout/layout_dungeon" ... />` inside the scroll container beneath `guild_siege`.
- **`GuildActivitiesFragment.kt`**:
  Bind `the_slumbering_shallows` card and refresh its state.
- **`Data.kt` & `DataDeserializer.kt`**:
  Add `var theSlumberingShallows: TheSlumberingShallowsArea? = null` with save/load persistence.
- **`strings.xml`**:
  Add names, descriptions, and log messages for all 6 fish, Chorus, and The Slumbering Shallows.

---

## 6. Verification Checklist

- [ ] Gradle build succeeds (`./gradlew compileDebugSources`).
- [ ] The Slumbering Shallows appears in the **Guild Activities tab** (not Dungeons).
- [ ] All 7 unit sprites (`perch`, `blue_trout`, `angelfish`, `winged_ray`, `blue_shark`, `magma_shark`, `chorus_the_drowned`) render properly.
- [ ] Defeating any fish drops **only that fish** as a Food item.
- [ ] No made-up items exist: no `DrownedLantern`, `ChorusScythe`, `AbyssalSeashell`, or `SharkTooth`.
- [ ] `searchRoom()` yields ambient `Perch` or `CoinPurse`.
- [ ] Magma Shark functions as a standard high-tier fish, not a mini-boss.
- [ ] There is no final room or floor boss; Chorus the Drowned has a strict 0.1% chance to spawn on any cast and deals 70–100 damage.
- [ ] Unit tests pass (`./gradlew testDebugUnitTest`).
