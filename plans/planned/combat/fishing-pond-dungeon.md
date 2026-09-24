# Implementation Plan: The Slumbering Shallows (Fishing Pond Dungeon)

## Goal Description

Introduce a unique, atmospheric new dungeon — **The Slumbering Shallows** — themed around an enchanted, murky fishing pond where adventurers cast lines to catch elusive aquatic creatures rather than battling conventional monsters.

- **Party Size**: 4 adventurers.
- **Area Type**: Dungeon (`getAreaType() = 0`).
- **Core Theme**: A deceptively tranquil, pastoral fishing pond hiding the cursed, scythe-wielding specter of the deep — **Chorus the Drowned**.
- **Primary Rewards**: 
  - **"Catch the Fish Itself" System**: Every fish creature caught drops itself as an inventory [`Food`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/abstractClasses/Food.kt) item, usable for pet feeding (with auto-feed support) or market trade.
  - Rare pearls, shark teeth, and ancient hydrothermal relics.
  - Exclusive boss artifacts from the drowned reaper.

---

## 1. Combat & Design Philosophy

### 1.1 The Fish: Very Low Damage, Low HP, Extreme Dodge
Every standard aquatic creature adheres to a strict design rule:
> **"Very, very low damage, low HP, but very high dodge."**

1. **Thematically Authentic**: Fish do not hit hard; they thrash, nibble, and slip off the hook. Catching them is a test of precision and agility.
2. **Dexterity Specialization**: Dexterity-heavy parties (Rogues, Rangers, Bards, Dex-scaling pets) dramatically outperform slow strength tanks. Low-DEX heroes will constantly swing and miss, while high-DEX heroes reel in fish with ease.
3. **Zero Frustration from Damage**: Fish attacks deal only **1–3 damage**, so party wipes during normal rooms are practically impossible. The challenge is clearing speed and catch efficiency.

### 1.2 The Final Boss: Chorus the Drowned — *"This One Will Hit Hard"*
In stark contrast to the gentle, evasive fish, the final chamber awakens the ancient reaper of the drowned: **Chorus the Drowned** ([`R.drawable.chorus_the_drowned`](file:///c:/Repositories/IGM-Modded/app/src/main/res/drawable/chorus_the_drowned.png)).
- **Thematic Climax**: Adventurers believe they are simply on a relaxing fishing trip. But at the bottom of the pond, the water churns with sunken shipwrecks and drowning fog. Chorus rises with his colossal barnacle-encrusted scythe and glowing lantern.
- **Heavy Combat**: Unlike the fish, **Chorus the Drowned hits devastatingly hard** (70–100 damage), cleaving through the party with reaping strikes that test actual frontline defense and healing sustain.

### 1.3 Hit Chance & Dodge Formula
From [`Area.kt:1462`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/Area.kt#L1462):

$$\text{hitChance} = \frac{\text{attackerDex}}{\text{attackerDex} + \frac{\text{targetDex}}{5.0}}$$

#### Hit-Rate Comparison Across DEX Tiers:
| Encounter | Target DEX | Against Tank (20 DEX) | Against Ranger/Rogue (120 DEX) |
| :--- | :---: | :---: | :---: |
| **Perch** | 60 | $62.5\%$ hit (37.5% dodge) | **$90.9\%$ hit** (9.1% dodge) |
| **Blue Trout** | 90 | $52.6\%$ hit (47.4% dodge) | **$87.0\%$ hit** (13.0% dodge) |
| **Angelfish** | 120 | $45.4\%$ hit (54.6% dodge) | **$83.3\%$ hit** (16.7% dodge) |
| **Winged Ray** *(Flying)* | 160 | $38.5\%$ hit (61.5% dodge) | **$78.9\%$ hit** (21.1% dodge) |
| **Blue Shark** | 220 | $31.2\%$ hit (68.8% dodge) | **$73.1\%$ hit** (26.9% dodge) |
| **Magma Shark** *(Mini-Boss)* | 300 | $25.0\%$ hit (75.0% dodge) | **$66.7\%$ hit** (33.3% dodge) |
| **Chorus the Drowned** *(Boss)* | 45 | **$69.0\%$ hit** (Low dodge) | **$93.0\%$ hit** (Heavy combat focus) |

---

## 2. Artwork & Roster Mapping

### 2.1 Dungeon Artwork
- **Detail View Background**: [`R.drawable.area_fishing_pond`](file:///c:/Repositories/IGM-Modded/app/src/main/res/drawable/area_fishing_pond.png)
- **Dungeon Card Summary Banner**: [`R.drawable.summary_fishing_pond`](file:///c:/Repositories/IGM-Modded/app/src/main/res/drawable/summary_fishing_pond.png)

### 2.2 Complete Encounter Roster

All seven combat units are mapped to custom pixel-art assets in `app/src/main/res/drawable/`:

| Unit Class | Sprite Asset | Max HP | Damage | DEX | Role & Combat Behavior |
| :--- | :--- | :---: | :---: | :---: | :--- |
| **`Perch`** | `R.drawable.perch` | **16** | **1–2** | **60** | Common shallow fish. Plentiful, easily caught. |
| **`BlueTrout`** | `R.drawable.blue_trout` | **24** | **1–2** | **90** | Agile river swimmer with rapid evasive turns. |
| **`Angelfish`** | `R.drawable.angelfish` | **20** | **1–2** | **120** | Delicate ornamental fish. Gracefully slips past weapons. |
| **`WingedRay`** | `R.drawable.winged_ray` | **45** | **2–3** | **160** | Gliding ray. **Flying trait** (`isFlying = true`) requires ranged/flying hits. |
| **`BlueShark`** | `R.drawable.blue_shark` | **85** | **2–4** | **220** | Rapid predator of the shallows. Extremely agile and slippery. |
| **`MagmaShark`** | `R.drawable.magma_shark` | **260** | **4–7** | **300** | **Rare Deep-Catch Mini-Boss (~2.5% spawn roll)**. An elusive thermal-vent beast. Extreme dodge, modest damage. |
| **`ChorusTheDrowned`** | `R.drawable.chorus_the_drowned` | **1,850** | **70–100** | **45** | **Final Dungeon Boss**. The Reaper of the Shallows. **Hits devastatingly hard** with his heavy nautical scythe. |

---

## 3. "Catch The Fish Itself" Drop System & Resource Economy

When an adventurer defeats a fish, the fish drops **itself as an item** sharing the exact same pixel art. All caught fish inherit from [`Food`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/abstractClasses/Food.kt), so they can be fed directly to pets or automatically consumed by the auto-feed system during chest collection.

### 3.1 Enemy Drops Table
* **`Perch`** (`Enemy`):
  - Primary: **`Perch`** (`Food`, Feed Power: 10, Weight: 750, ~75%) — Sprite: `R.drawable.perch`.
* **`BlueTrout`** (`Enemy`):
  - Primary: **`BlueTrout`** (`Food`, Feed Power: 18, Weight: 700, ~70%) — Sprite: `R.drawable.blue_trout`.
  - Secondary: `Pearl` (Weight: 50, ~5%) — Reusable vanilla gem.
* **`Angelfish`** (`Enemy`):
  - Primary: **`Angelfish`** (`Food`, Feed Power: 25, Weight: 650, ~65%) — Sprite: `R.drawable.angelfish`.
  - Secondary: `Pearl` (Weight: 100, ~10%).
* **`WingedRay`** (`Enemy`):
  - Primary: **`WingedRay`** (`Food` / Material, Feed Power: 35, Weight: 600, ~60%) — Sprite: `R.drawable.winged_ray`.
  - Secondary: `AbyssalSeashell` (Weight: 80, ~8%).
* **`BlueShark`** (`Enemy`):
  - Primary: **`BlueShark`** (`Food` / Trophy, Feed Power: 60, Weight: 500, ~50%) — Sprite: `R.drawable.blue_shark`.
  - Secondary: `SharkTooth` (Material, Weight: 350, ~35%).
* **`MagmaShark`** *(Mini-Boss Enemy)*:
  - Primary: **`MagmaShark`** (Legendary Catch, Feed Power: 150, Weight: 800, guaranteed) — Sprite: `R.drawable.magma_shark`.
  - Secondary: `Kindlequartz` (Weight: 200, 20%).
  - Secondary: `MagmaCore` (Weight: 50, 5%).
* **`ChorusTheDrowned`** *(Final Boss)*:
  - Guaranteed: `DrownedLantern` (Accessory, Weight: 1000) — Unique relic granting Darkness Reduction and bonus loot finding.
  - Rare Weapon: `ChorusScythe` (Weight: 200, 20%) — Massive two-handed physical/bleed weapon.
  - Secondary: `Pearl` x3 (Weight: 400, 40%).

### 3.2 Idle Room Gathering (`searchRoom()`)
While waiting between ripples, the party occasionally nets ambient catches without a fight:
* `Perch` (Common catch)
* `Pearl` (Uncommon)
* `AbyssalSeashell` (Rare)

---

## 4. Boss Encounter Architecture

### 4.1 Mini-Boss: The Magma Shark
- **Trigger**: Rare random pack replacement ($2.5\%$ roll) in deep waters.
- **Log text**: `"[EVENT] The pond boils and turns crimson — a Magma Shark breaches from the thermal vent!"`

### 4.2 Dungeon Boss: Chorus the Drowned
- **Trigger**: Spawns on the final room of the run (100% floor boss).
- **Combat Mechanics**:
  - **Heavy Cleaving Damage**: Swings for **70–100 damage**.
  - **Reaper's Sweep**: Active skill hitting front-row heroes with bonus Bleed.
  - **Tidal Drowning**: Passive reducing party healing effectiveness by 20%.
- **Atmospheric Logs**:
  - Start: `"[BOSS] The peaceful waters turn black and cold. From the sunken wreckage, Chorus the Drowned raises his barnacled scythe: 'All lines cast into my waters must pay their toll.'"`
  - Defeat: `"[VICTORY] Chorus dissolves into sea foam, leaving his glowing lantern behind."`

---

## 5. Technical Implementation Steps

### 5.1 Enemy Classes (`storage/data/entities/enemies/units/`)
Implement 7 Kotlin classes extending [`Enemy`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/enemies/Enemy.kt):
1. [`Perch.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/enemies/units/Perch.kt)
2. [`BlueTrout.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/enemies/units/BlueTrout.kt)
3. [`Angelfish.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/enemies/units/Angelfish.kt)
4. [`WingedRay.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/enemies/units/WingedRay.kt) (`override fun isFlying() = true`)
5. [`BlueShark.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/enemies/units/BlueShark.kt)
6. [`MagmaShark.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/enemies/units/MagmaShark.kt)
7. [`ChorusTheDrowned.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/enemies/units/ChorusTheDrowned.kt) (Boss stats, heavy damage, scythe skills)

### 5.2 Item Classes (`storage/data/items/instances/`)
1. `Perch.kt` (extends `Food`, `idImage = R.drawable.perch`, `feedPower = 10`)
2. `BlueTrout.kt` (extends `Food`, `idImage = R.drawable.blue_trout`, `feedPower = 18`)
3. `Angelfish.kt` (extends `Food`, `idImage = R.drawable.angelfish`, `feedPower = 25`)
4. `WingedRay.kt` (extends `Food`, `idImage = R.drawable.winged_ray`, `feedPower = 35`)
5. `BlueShark.kt` (extends `Food`, `idImage = R.drawable.blue_shark`, `feedPower = 60`)
6. `MagmaShark.kt` (extends `Food`, `idImage = R.drawable.magma_shark`, `feedPower = 150`)
7. `SharkTooth.kt` (extends `Material`)
8. `DrownedLantern.kt` (extends `Accessory`)
9. `ChorusScythe.kt` (extends `Weapon`)

### 5.3 Dungeon Class (`storage/data/places/dungeons/`)
- Create `TheSlumberingShallows.kt`:
  - `adventurersNumber() = 4`
  - `rollEnemies()` with depth-weighted encounters, rare Magma Shark rolls, and Chorus the Drowned at the final floor.
  - `searchRoom()` with ambient pond gathering.
  - Flavour log events.

### 5.4 Data Registration & Layout Integration
- **`Data.kt`**: Add `var theSlumberingShallows: TheSlumberingShallows?`.
- **`DataDeserializer.kt`**: Deserialize `theSlumberingShallows`.
- **Unlock Trigger**: Add to `listAreasUnlocked()` in **The Southern Grove** (or mid-game dungeon).
- **UI Layout**: Add `the_slumbering_shallows` entry to `fragment_dungeons.xml` and bind in `DungeonsFragment.kt`.
- **Strings**: Add enemy names, item names/descriptions, dungeon title, and atmospheric battle logs to `strings.xml`.

---

## 6. Verification Checklist

- [ ] Gradle build succeeds (`./gradlew compileDebugKotlin`).
- [ ] All 7 enemy sprites load properly in combat and bestiary.
- [ ] Defeating a Perch/Trout/Shark drops the corresponding item with matching pixel art.
- [ ] Caught fish can be fed to pets in the shelter or consumed by the auto-feed system.
- [ ] Fish deal very low damage (1–3 hp per strike) with high evasion.
- [ ] Chorus the Drowned hits hard (70–100 dmg) and presents a serious frontline challenge.
- [ ] Chorus drops `DrownedLantern` upon defeat.
