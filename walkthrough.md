# Walkthrough: Guild Activities (Daily Request & Weekly Siege) & Shadow in IGM-Modded

We have implemented the Daily Request and Weekly Siege guild activities in **`C:\Repositories\IGM-Modded`**, along with the custom boss enemy **Shadow**, Bestiary integration under an "Other" category filter, and optimized area artwork.

---

## Key Changes

### 1. New Enemy: Shadow
- Added [`Shadow.kt`](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/enemies/units/Shadow.kt) extending `Enemy()`:
  - **Attributes**: 100 Constitution, 100 Dexterity, 100 Intelligence.
  - **Damage**: 100 Min Damage, 1000 Max Damage.
  - **Critical**: 50% Critical Chance (`calculateCriticalChance() = 0.50`), 200% Critical Damage (`criticalDamage = 2.0`).
  - **Defenses**: 50 Defense, 50 Magic Defense, 100% Status Immunity (`calculateImmunityToStatus() = 1.0`), 20% flat dodge (`calculateTotalFlatDodgeChance() = 0.20`), 1000 Max HP.
  - **Type**: Melee and Magic (`isRanged() = false`, `isMagic() = true`).
  - **Skills**: No passive or active skills (`Skills.PASSIVE_NONE`, `Skills.ACTIVE_NONE`).
  - **Artwork**: Uses [`shadow.png`](file:///C:/Repositories/IGM-Modded/app/src/main/res/drawable/shadow.png) (`R.drawable.shadow`).

### 2. Daily Request
- Added [`GuildRequestArea.kt`](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/raids/GuildRequestArea.kt):
  - Up to 12 adventurers (`adventurersNumber() = 12`).
  - Encounter wave spawns **1 Shadow** and **2 Void Slimes** (`units.VoidSlime`).
  - **Artwork**: Detail image is [`area_request.png`](file:///C:/Repositories/IGM-Modded/app/src/main/res/drawable/area_request.png) (`R.drawable.area_request`), summary image is `test_area_image_summary_forest`.
  - **Dynamic Reward**: Awards Gems equal to current Reputation (`reputation` Gems) upon victory once per daily period.
  - **Rollover**: If uncompleted at midnight rollover, replaces the daily request without penalty. If party is actively exploring, rollover is deferred until combat concludes.

### 3. Weekly Siege
- Added [`GuildSiegeArea.kt`](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/raids/GuildSiegeArea.kt):
  - Up to 12 defenders (`adventurersNumber() = 12`).
  - 10 sequential waves of 5–10 non-boss monsters dynamically pulled from unlocked player areas (`rarity < 2`, bosses excluded).
  - **Artwork**: Detail image is [`area_the_siege.png`](file:///C:/Repositories/IGM-Modded/app/src/main/res/drawable/area_the_siege.png) (`R.drawable.area_the_siege`), summary image is `test_area_image_summary_forest`.
  - **Reputation Penalty**: Defeat/party wipe or expiration while uncompleted at weekly rollover deducts **-10 Reputation** (clamped to `[0, 100]`).

### 4. Guild Activities Engine & State
- Added [`GuildActivitiesState.kt`](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/game/activities/GuildActivitiesState.kt) and [`GuildActivitiesManager.kt`](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/game/activities/GuildActivitiesManager.kt):
  - Manages boundaries, status tracking, rewards, failure deductions, and active combat deferral.
  - Hooked into [`Data.kt`](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/Data.kt), [`DataDeserializer.kt`](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/DataDeserializer.kt), and [`Utils.kt`](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/Utils.kt) (`tick24Hours()`, `tickWeek()`, `refreshCooldowns()`, `compileRaidList()`).

### 5. Bestiary Integration
- Updated [`dialog_bestiary.xml`](file:///C:/Repositories/IGM-Modded/app/src/main/res/layout/dialog_bestiary.xml) and [`DialogBestiary.kt`](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogBestiary.kt):
  - Added an **"Other"** radio button category filter.
  - Selecting "Other" displays `GuildRequestArea` (containing `Shadow` and `VoidSlime`) and `GuildSiegeArea`, allowing the player to view Shadow's portrait and statistics.

### 6. Area Artwork Optimization
- Resized [`area_request.png`](file:///C:/Repositories/IGM-Modded/app/src/main/res/drawable/area_request.png) and [`area_the_siege.png`](file:///C:/Repositories/IGM-Modded/app/src/main/res/drawable/area_the_siege.png) from 2048x2048 down to 400x400 using bicubic resampling.
- Reduced asset size from ~12.3 MB down to ~720 KB total, preventing Android memory spikes and matching standard game texture dimensions.

---

## Verification Results

### 1. JVM Automated Tests
Ran Gradle unit tests via:
```powershell
& 'C:\Repositories\IGM-Modded\gradlew.bat' -p 'C:\Repositories\IGM-Modded' testDebugUnitTest
```
**Results**:
- `GuildActivitiesTest`: All 8 tests passed:
  - `testShadowStatsAndInstantiation`: PASS (verified all stats: 100 con/dex/int, 100-1000 dmg, 50% crit, 200% crit dmg, 50 def/mdef, 100% status immunity, 1000 hp, melee + magic, 20% dodge).
  - `testGuildRequestAreaEncounter`: PASS (verified 12 slots, 1 Shadow + 2 Void Slimes).
  - `testGuildSiegeAreaConfiguration`: PASS (verified 12 slots, 5-10 non-boss enemies per wave).
  - `testRequestDynamicGemReward`: PASS (verified dynamic gem payout matching reputation).
  - `testSiegeFailureReputationPenalty`: PASS (verified -10 penalty on defeat).
  - `testSiegeRolloverPenaltyWhenUncompleted`: PASS (verified -10 penalty on uncompleted weekly rollover).
  - `testReputationClamping`: PASS (verified [0, 100] clamp).
  - `testUtilsCompileRaidListIncludesGuildActivities`: PASS.
- Total suites: 4 passed (`GuildActivitiesTest`, `ModFeaturesTest`, `FunctionalParityTest`, `FileManagerEncodingTest`).

### 2. APK Compilation
Ran:
```powershell
& 'C:\Repositories\IGM-Modded\gradlew.bat' -p 'C:\Repositories\IGM-Modded' assembleDebug
```
**Result**: `BUILD SUCCESSFUL in 14s` generating `IdleGuildMaster_v2.148_mod_v1.3.0.3.apk` in `app/build/outputs/apk/debug/`.
