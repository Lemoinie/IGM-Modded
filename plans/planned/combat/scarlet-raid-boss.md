# Implementation Plan: Scarlet Raid & 1-Room Boss Encounter

## Goal Description
Introduce a new dedicated Raid providing a farmable source of [ScarletStrand](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/instances/ScarletStrand.kt) to supplement the Travelling Merchant.

The raid features a streamlined **1-room direct Boss fight** against an endgame boss equipped with overwhelming, devastating combat mechanics ("crazy skill") and high-tier loot drops.

---

## 1. Raid Overview: The Scarlet Sanctum

### 1.1 Structure
- **Class**: `ScarletSanctum` (or `TheCrimsonSanctum`) extends [Area](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/Area.kt)
- **Type**: Raid (`getAreaType() = 1`)
- **Party Size**: `adventurersNumber() = 8` to `14` (configurable)
- **Single-Room Flow**:
  - `progress == 1`: The Boss encounter begins immediately.
  - `progress == 2`: Raid cleared! Rewards tallied and `terminationRequested = true`.
- **Refresh Cost**: `15` to `20` gems (standard raid refresh cost).
- **Unlock Condition**: Unlocked upon clearing [TheTower](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/raids/TheTower.kt) (Floor 35 - The Machine) or upon first acquiring a Scarlet Strand.

---

## 2. Boss Design: The Crimson Weaver (or Scarlet Empress)

### 2.1 Proposed Boss Identity
- **Name**: `The Crimson Weaver` / `Scarlet Sovereign`
- **Theme**: An occult deity weaving the strands of fate and flesh from the dark void.
- **Base Attributes**:
  - Titanic HP pool (e.g. `25,000` - `50,000` HP, challenging a full raid party).
  - High Defense and Magic Defense.
  - Immunity to crowd control (`immunityToStatus = 0.8` or `1.0`).

### 2.2 Proposed "Crazy Skill" Mechanics
1. **Active Skill — Cataclysmic Strand Burst (Full Mana)**:
   - Strikes all heroes for massive magical damage.
   - Inflicts `BLOODFLAME` + `SILENCE` or `CURSE` across the frontline.
2. **On-Hit Passive — Entangling Strands**:
   - Basic attacks apply multi-status on target (e.g. `BLEED` + `TAUNT` or `STUN`).
3. **Enrage / Death Threshold**:
   - When dropping below 30% HP, damage ramps up by +50% or summons elite Scarlet minions to overwhelm tanks.

---

## 3. Drop Table & Probability Math

In Idle Guild Master, `Enemy.listDrops()` uses [`Utils.rollFromWeightedMap()`](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/Utils.kt#L1211), which rolls against a total weight of `1000.0`:

$$\text{Chance} = \frac{\text{Weight}}{1000}$$

### Probability Comparison for Scarlet Strand:
- **Option A (Literal 0.1% - Weight 1 / 1000)**:
  - 1 in 1,000 daily runs (~2.7 years of daily raids per 1 strand). Ultra-rare lottery jackpot.
- **Option B (1.0% - Weight 10 / 1000)**:
  - 1 in 100 daily runs (~3 months per strand). Rare raid unique rate (matches Seeking Glass in Slime Pond).
- **Option C (10.0% - Weight 100 / 1000 - Recommended for "farming")**:
  - 1 in 10 daily runs (~1 strand every 10 days). Enables deliberate farming to craft the Scarlet set over weeks.

### Secondary Drops (Consolation Rewards):
When Scarlet Strand does not roll, the boss awards valuable endgame materials:
- `AncestralBlood`: 2–4× (weight ~300)
- `MysteriousCog`: 2–3× (weight ~300)
- `HeartOfDarkness`: 3–5× (weight ~300)
- `ScarletStrand`: 1× (weight 1, 10, or 100 based on choice)

---

## 4. Technical Integration

### 4.1 New Classes & Entities
1. `ScarletSanctum.kt`: In `it.paranoidsquirrels.idleguildmaster.storage.data.places.raids`.
2. `CrimsonWeaver.kt`: In `it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units`.

### 4.2 UI & Layout Registration
1. **Fragment Raids ([`fragment_raids.xml`](file:///C:/Repositories/IGM-Modded/app/src/main/res/layout/fragment_raids.xml))**:
   - Add `<include android:id="@+id/scarlet_sanctum" layout="@layout/layout_dungeon" .../>` into the Raids ScrollView.
2. **Raids Fragment ([`RaidsFragment.kt`](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/raids/RaidsFragment.kt))**:
   - Bind layout in `refresh()`.
3. **Data Storage ([`Data.kt`](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/Data.kt))**:
   - Add `@SerializedName("scarletSanctum") var scarletSanctum: ScarletSanctum? = ScarletSanctum()`.
4. **Raid Compilation ([`Utils.compileRaidList()`](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/Utils.kt))**:
   - Add `MainActivity.data.scarletSanctum` to the raid list.

---

## 5. Verification Plan
- Unit test verifying raid instantiation, 1-room progression cycle, enemy rolling, and drop resolution.
- Verify raid layout appears in Raids tab with correct title, art, and refresh cooldown.
- Simulate combat to ensure boss skills execute and defeat grants appropriate loot.
