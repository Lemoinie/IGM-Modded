# Guild Chronicle: Seasonal Progression System

## Goal Description

The **Guild Chronicle** is the game's battle-pass equivalent. Every Chronicle **Chapter**
lasts **28 days**. During the chapter players earn **Chronicle Points (CP)** by completing
daily and weekly **Chronicle Missions** visible inside the Chronicle Ledger dialog.
CP fills a track of **30 tiers** (100 CP per tier; 3,000 CP total for Tier 30).

There are **three reward tracks**: Normal (free), Plus, and Premium.
Players unlock higher tracks by purchasing one of three **Chronicle bundles** in the Shop.
All rewards are **claimed manually** from the Chronicle Ledger — nothing is auto-granted.

At the end of each Chapter, all CP, tier progress, and bundle purchases reset.
Unclaimed rewards are forfeited.

**Naming:**
| Battle Pass Term | IGM Chronicle Term |
|---|---|
| Season | Chronicle Chapter |
| Battle Pass currency | Chronicle Points (CP) |
| Free / Silver / Gold tracks | Normal / Plus / Premium |
| UI | Chronicle Ledger (new top-bar icon) |

---

## Confirmed Design Decisions

- **Season duration**: 28 days (stored as `seasonEndTimestamp` in Data).
- **Track bundles**: reset each Chapter (purchasing again next Chapter).
- **CP earning**: via Chronicle Missions only — each mission is **one-time per day/week**
  and must be **manually claimed** from the Chronicle Ledger after being completed in-game.
- **Tier rewards**: manually claimed from the Chronicle Ledger dialog.
- **Entry point**: **Top-bar icon** — same row as Shop / Merchant / Black Market / Quests
  in `containerTooltips` (`activity_main.xml`). Always visible; appropriate for a
  time-sensitive seasonal feature.
  > _Nav-drawer_ (≡ hamburger panel with Settings / FAQ / Mod About) is for passive
  > reference. _Top-bar icons_ are the primary action surface — this is where Chronicle
  > belongs alongside Quests and Black Market.

---

## CP Economy

### Points Per Tier
`POINTS_PER_TIER = 100`. Reaching Tier 30 = **3,000 CP** over 28 days ≈ **107 CP/day**.

### How Mission Completion Is Tracked
Each mission maps to a boolean flag in `Data` (`chronicleDailyCompleted[index]`). Game
events at the relevant call sites (dungeon collect, quest complete, craft, sell) **set the
flag to true**. The Chronicle Ledger reads the flag and shows the **Claim** button.
The player taps **Claim** → CP is awarded → `chronicleDailyMissionsClaimed[index] = true`.
Flags reset to `false` each `tick24Hours()` (daily) or `tickWeek()` (weekly).

> [!NOTE]
> Only **completable actions** are missions. Actions gated by RNG you can't control
> (Black Market appearing) or resource limits (potions already full) are excluded.
> Missions must always be achievable through normal play on any given day.

### Chronicle Daily Missions (5 shown per day, pool of 5, reset via `tick24Hours`)
Each mission is **one-time per day**. The in-game action marks it claimable;
player goes to the Chronicle Ledger and taps **Claim** to receive CP.

| # | Mission | Tracked via | CP |
|---|---|---|---|
| 0 | Log in today | Auto-set by `tick24Hours()` | +10 |
| 1 | Complete 1 dungeon run | `collectDrops()` callback | +20 |
| 2 | Complete 1 raid run | Raid completion callback | +20 |
| 3 | Sell any item | `DialogSell` confirm | +15 |
| 4 | Craft any item | `DialogCraft` craft success | +15 |

All 5 missions are shown every day (no rotation). Total daily max = **80 CP**.

### Chronicle Weekly Missions (3 missions, reset via `tickWeek`)

| # | Mission | Tracked via | CP |
|---|---|---|---|
| 0 | Complete The Hunt | `GuildActivitiesManager` reward claim | +60 |
| 1 | Clear The Siege (any waves) | `GuildActivitiesManager` wave clear | +80 |
| 2 | Complete any Quest | `QuestsManager` quest complete | +80 |

All 3 shown every week. Total weekly max = **220 CP** = **~31 CP/day** averaged.

### CP Math
| Play style | Daily CP | 28-day total | Max Tier |
|---|---|---|---|
| Casual (login + craft or sell only) | ~40 | ~1,120 | ~11 |
| Regular (all daily, skip weekly) | ~80 | ~2,240 | ~22 |
| Active (all daily + all weekly) | ~111 | ~3,108 | **30+** |

Dedicated players can reach Tier 30 free. "Skip to Tier 20" bundles matter
for players who miss a week or more.

---

## Track System

Three parallel reward tracks per tier:

| Track | Unlock condition |
|---|---|
| **Normal** | Always free |
| **Plus** | Purchase a "Codex" bundle this Chapter |
| **Premium** | Purchase a "Tome" bundle (includes Plus) |

Purchasing Premium implicitly grants Plus as well (Premium ⊇ Plus).

---

## Full 30-Tier Reward Table

> [!IMPORTANT]
> Needs final sign-off before implementation. Item class names must match exactly those
> in `app/src/main/kotlin/…/storage/data/items/instances/`.
> Items marked *(planned)* depend on the Phoenix Pet or Weapon Forge plan being
> implemented first. If those plans are not yet merged, substitute with gems.

**Design principles applied:**
- **Normal** = Gems + stat potions. Useful at any game stage, no storage clutter.
- **Plus** = Consumables + mid-weight gear/materials (`ElixirOfLearning`, forge materials,
  `ScarletVeil`, `ReassemblingJacket`, `SeekingGlass`, `EternalHunger`). Solid mid-game
  value, not game-breaking for late-game players.
- **Premium** = Scarce items valid at all stages: `Evo22Vial`, `Evo23Vial2`,
  `ElixirOfLearning`, `VoidCore` (forge material), `ScarletStrand` (forge material),
  `MysticEgg` *(planned)*. Intentionally modest so missing tiers does not feel devastating.
- **No titles** (removed per user request).
- **No Dreamcatcher** (unsellable → storage problem).
- **No low-value late-game gear** (PatricianArmor, GhostRabbitCloak, DiamondAmulet,
  CottontailJacket removed).
- **Intercession moved to Premium-only** (sacred item, too powerful for free/plus).
  Free milestone tiers give `CeremonialCake` instead for the thematic feel.

| Tier | Normal (Free) | Plus | Premium |
|:---:|---|---|---|
| **1** | 50 Gems | 3× Dexterity Potion | 1× Evo22Vial |
| **2** | 3× Constitution Potion | 3× Intelligence Potion | 1× ElixirOfLearning |
| **3** | 75 Gems | 3× Health Potion | 1× ScarletVeil |
| **4** | 3× Agility Potion | 3× Defense Potion | 1× Evo22Vial |
| **5** | 100 Gems | 1× ElixirOfLearning | 1× Evo23Vial2 |
| **6** | 3× Intelligence Potion | 3× Viciousness Potion | 2× ElixirOfLearning |
| **7** | 125 Gems | 1× EternalHunger | 1× ReassemblingJacket |
| **8** | 3× Precision Potion | 3× Immunity Potion | 1× Evo22Vial + 1× ElixirOfLearning |
| **9** | 150 Gems | 1× ScarletVeil | 1× ScarletStrand *(forge material)* |
| **10** | 1× CeremonialCake | 1× SeekingGlass + 100 Gems | 1× Intercession + 1× Evo22Vial |
| **11** | 3× Viciousness Potion | 3× Precision Potion | 1× VoidCore *(forge material)* |
| **12** | 175 Gems | 2× ElixirOfLearning | 1× Evo23Vial2 |
| **13** | 3× Defense Potion | 1× ReassemblingJacket | 2× ElixirOfLearning + 1× ScarletStrand |
| **14** | 200 Gems | 3× Agility Potion | 1× Evo22Vial + 1× Evo23Vial2 |
| **15** | 300 Gems + 3× Constitution Potion | 1× Evo22Vial + 100 Gems | 1× MysticEgg *(planned)* + 1× Intercession |
| **16** | 3× Darkness Potion | 3× Viciousness Potion | 1× VoidCore + 1× ScarletStrand |
| **17** | 225 Gems | 2× ElixirOfLearning | 1× Evo23Vial2 + 1× ElixirOfLearning |
| **18** | 3× Immunity Potion | 1× EternalHunger | 1× Evo22Vial + 1× VoidCore |
| **19** | 250 Gems | 3× Darkness Potion | 2× ElixirOfLearning + 1× ScarletStrand |
| **20** | 400 Gems | 1× Evo23Vial2 + 150 Gems | 1× Intercession + 1× Evo23Vial2 |
| **21** | 3× MagicDefense Potion | 3× MagicDefense Potion | 2× VoidCore + 1× ElixirOfLearning |
| **22** | 275 Gems | 3× Immunity Potion | 1× Evo23Vial2 + 1× ScarletStrand |
| **23** | 3× Intelligence Potion | 1× ScarletVeil | 2× ElixirOfLearning + 1× VoidCore |
| **24** | 300 Gems | 2× ElixirOfLearning | 2× Evo22Vial + 1× Evo23Vial2 |
| **25** | 500 Gems | 1× SeekingGlass + 150 Gems | 1× MysticEgg *(planned)* + 1× Evo23Vial2 |
| **26** | 3× Health Potion | 3× Precision Potion | 2× ScarletStrand + 1× VoidCore |
| **27** | 350 Gems | 1× ReassemblingJacket | 1× Intercession + 2× ElixirOfLearning |
| **28** | 3× Agility Potion | 2× ElixirOfLearning | 2× Evo23Vial2 + 1× VoidCore |
| **29** | 500 Gems | 1× Evo23Vial2 + 1× Evo22Vial | 1× MysticEgg *(planned)* + 1× Intercession |
| **30 ★** | 1× CeremonialCake + 750 Gems | 1× EternalHunger + 1× SeekingGlass + 200 Gems | 2× Evo23Vial2 + 1× Intercession + 1× CeremonialCake |

**Tier 10 / 30 milestones (Normal)**: `CeremonialCake` — a meaningful trophy for
reaching the milestone, thematic and useful (food item).

**Premium *(planned)* items**: `MysticEgg` at tiers 15, 25, 29 depends on the
Phoenix Pet plan. If that plan is not yet implemented, substitute with `1× Evo22Vial`.

**Note on forge materials** (`VoidCore`, `ScarletStrand`): these already exist in
`items/instances/` and drop from raids. Including them in the Chronicle track gives players
an alternative acquisition path that is progression-friendly at all levels.

---

## Chronicle Bundles (new Shop Category: CHRONICLE)

> [!IMPORTANT]
> These bundles reset each Chapter — they are per-season purchases. The buy button
> re-enables after `rolloverSeason()` clears the flags.

| Bundle Name | Gem Cost | Unlocks | Skip to Tier 20 |
|---|:---:|---|:---:|
| **Chronicle Codex** | `500` | Plus track | ✗ |
| **Chronicle Codex: Ascendant** | `1,000` | Plus track | ✓ |
| **Chronicle Tome: Ascendant** | `1,500` | Premium track (incl. Plus) | ✓ |

### "Skip to Tier 20" mechanic
`Data.chronicleTierSkip: Int` (default 0). Ascendant bundles set `chronicleTierSkip = 20`.
Effective tier formula:
```kotlin
effectiveTier = min(MAX_TIERS, max(chroniclePoints / POINTS_PER_TIER, chronicleTierSkip))
```
Tiers ≤ `effectiveTier` are claimable. CP continues accumulating normally above T20.

---

## Proposed Changes

### New Game Logic

#### [NEW] `GuildChronicleManager.kt`
- Path: `app/src/main/kotlin/…/game/chronicle/GuildChronicleManager.kt`
- Kotlin `object` (mirrors `GuildActivitiesManager`).
- `rolloverSeason()` — increments season number, resets CP / tierSkip / all claim arrays /
  mission arrays / plus/premium flags, sets `endTimestamp = now + 28 × 86_400_000L`.
- `markDailyMissionComplete(index: Int)` — sets `chronicleDailyCompleted[index] = true`,
  notifies `MainActivity.shownDialogChronicle?.refresh()`.
- `markWeeklyMissionComplete(index: Int)` — same for weekly.
- `claimDailyMission(index: Int)` — if `completed && !claimed` → award CP, mark claimed, save.
- `claimWeeklyMission(index: Int)` — same.
- `claimTier(tier: Int, track: Track)` — validates earned + track unlocked + unclaimed →
  grants reward from static table → marks claimed → saves.
- `getCurrentEffectiveTier(): Int` — `min(30, max(data.chroniclePoints / 100, data.chronicleTierSkip))`.
- `getReward(tier: Int, track: Track): List<RewardEntry>` — static 30×3 lookup table.
- `RewardEntry` data class: `itemClass: String?, amount: Int = 1, gems: Int = 0`.
- `Track` enum: `NORMAL`, `PLUS`, `PREMIUM`.

#### [NEW] `GuildChronicleState.kt`
- Path: `app/src/main/kotlin/…/game/chronicle/GuildChronicleState.kt`
- Constants only: `POINTS_PER_TIER`, `MAX_TIERS`, `SEASON_DURATION_MS`, mission CP values.

---

### Data & Persistence

#### [MODIFY] [Data.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/Data.kt)
New fields:
```kotlin
@SerializedName("chroniclePoints")          var chroniclePoints: Int = 0
@SerializedName("chronicleTierSkip")        var chronicleTierSkip: Int = 0
@SerializedName("chronicleSeasonNumber")    var chronicleSeasonNumber: Int = 1
@SerializedName("chronicleSeasonEnd")       var chronicleSeasonEndTimestamp: Long = 0L
@SerializedName("isChroniclePlus")          var isChronicleTrackPlusPurchased: Boolean = false
@SerializedName("isChronicePremium")        var isChronicleTrackPremiumPurchased: Boolean = false
@SerializedName("chronicleClaimedNormal")   var chronicleTiersClaimedNormal: BooleanArray = BooleanArray(30)
@SerializedName("chronicleClaimedPlus")     var chronicleTiersClaimedPlus: BooleanArray = BooleanArray(30)
@SerializedName("chronicleClaimedPremium")  var chronicleTiersClaimedPremium: BooleanArray = BooleanArray(30)
@SerializedName("chronicleDailyDone")       var chronicleDailyCompleted: BooleanArray = BooleanArray(5)
@SerializedName("chronicleDailyClaimed")    var chronicleDailyMissionsClaimed: BooleanArray = BooleanArray(5)
@SerializedName("chronicleWeeklyDone")      var chronicleWeeklyCompleted: BooleanArray = BooleanArray(3)
@SerializedName("chronicleWeeklyClaimed")   var chronicleWeeklyMissionsClaimed: BooleanArray = BooleanArray(3)
```
`chronicleSeasonEndTimestamp = 0L` → first launch triggers `rolloverSeason()`.
Gson defaults handle all missing keys on old saves — no `DataDeserializer` migration.

---

### Integration Points

#### [MODIFY] [Utils.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/Utils.kt)
- `tick24Hours()`:
  - Season rollover check: if `endTimestamp > 0 && now >= endTimestamp` → `rolloverSeason()`.
  - Reset `chronicleDailyCompleted[0..4]` and `chronicleDailyMissionsClaimed[0..4]`.
  - Auto-complete daily mission #0 ("Log in today"): `markDailyMissionComplete(0)`.
- `tickWeek()`:
  - Reset `chronicleWeeklyCompleted[0..2]` and `chronicleWeeklyMissionsClaimed[0..2]`.

#### [MODIFY] [Area.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/Area.kt) / dungeon & raid completion path
- Dungeon run complete → `GuildChronicleManager.markDailyMissionComplete(1)` (index 1).
- Raid run complete → `GuildChronicleManager.markDailyMissionComplete(2)` (index 2).
  _(Exact hook site determined during implementation — likely the drop-collect callback.)_

#### [MODIFY] [GuildActivitiesManager.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/game/activities/GuildActivitiesManager.kt)
- Hunt reward claim → `markWeeklyMissionComplete(0)`.
- Siege any-wave-cleared → `markWeeklyMissionComplete(1)`.

#### [MODIFY] [QuestsManager.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/quests/QuestsManager.kt)
- Quest complete → `markWeeklyMissionComplete(2)`.

#### [MODIFY] [DialogSell.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogSell.kt)
- Sell confirm → `markDailyMissionComplete(3)` (index 3, "Sell any item").

#### [MODIFY] [DialogCraft.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogCraft.kt)
- Craft success → `markDailyMissionComplete(4)` (index 4, "Craft any item").

---

### UI

#### [NEW] `DialogChronicle.kt`
- Path: `app/src/main/kotlin/…/ui/dialogs/DialogChronicle.kt`
- Extends `CustomDialog`. Guard: `MainActivity.shownDialogChronicle`.
- Sections in the dialog:
  1. **Header** — "Chronicle Chapter N", `X days remaining`, CP progress bar.
  2. **Chronicle Daily Missions** (5 rows) — each row: mission label, CP badge,
     status `[incomplete | CLAIM | ✓]`. Tapping CLAIM → `claimDailyMission(idx)`.
  3. **Chronicle Weekly Missions** (3 rows) — same pattern.
  4. **Reward Track** — `RecyclerView` of 30 tier rows (one `layout_chronicle_tier.xml`
     per tier). Each row shows Normal / Plus / Premium reward slots with CLAIM buttons.
  5. **Bundle strip** (if bundles not all purchased) — inline buy buttons for the 3
     Chronicle bundles; tapping opens a `confirmAndPurchase` flow identical to `DialogShop`.

#### [NEW] `dialog_chronicle.xml`
- `NestedScrollView` > `LinearLayout` stacking header, daily missions card,
  weekly missions card, RecyclerView (tier rows), bundle strip.

#### [NEW] `layout_chronicle_tier.xml`
- Tier number label + three reward columns (Normal, Plus, Premium). Each column:
  icon `ImageView` + description `TextView` + CLAIM `Button` / ✓ `ImageView`.
  Plus and Premium columns are dimmed (`alpha = 0.3`) when respective track not unlocked.

#### [NEW] `layout_chronicle_mission.xml`
- Mission description + CP badge + CLAIM `Button` / ✓ `ImageView`.

#### [MODIFY] [activity_main.xml](file:///c:/Repositories/IGM-Modded/app/src/main/res/layout/activity_main.xml)
- Add `ImageView id="@id/chronicle"` after `@id/quests` in `containerTooltips`.
  Uses new `@drawable/chronicle_icon` (scroll/book sprite).
- Add `ImageView id="@id/chronicle_notification"` badge dot (brass circle) that
  shows when a mission is claimable or a new Chapter has started.

#### [MODIFY] [MainActivity.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/MainActivity.kt)
- Add `companion object` guard `shownDialogChronicle: DialogChronicle?`.
- Wire `binding.chronicle.setOnClickListener` → open `DialogChronicle`.
- `refreshIcons()` — show/hide `chronicle_notification` when any mission is claimable
  or any earned tier reward is unclaimed.

#### [MODIFY] [DialogShop.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogShop.kt)
- Add `Category.CHRONICLE` to the `Category` enum.
- Add `chipCategoryChronicle` and `containerChronicleBundle` with 3 pack cards
  (Codex 500💎, Codex Ascendant 1000💎, Tome Ascendant 1500💎).
- Each card: shows "This Chapter" note, buy button, and purchased checkmark.
  After `rolloverSeason()` the purchase flag is false → buy button re-enables.
- Purchase logic:
  - Codex → `isChronicleTrackPlusPurchased = true`
  - Codex Ascendant → `isChronicleTrackPlusPurchased = true`, `chronicleTierSkip = 20`
  - Tome Ascendant → `isChronicleTrackPlusPurchased = true`,
    `isChronicleTrackPremiumPurchased = true`, `chronicleTierSkip = 20`

#### [MODIFY] [strings.xml](file:///c:/Repositories/IGM-Modded/app/src/main/res/values/strings.xml)
- Chronicle UI strings: `chronicle_title`, `chronicle_chapter_n`, `chronicle_days_n`,
  `chronicle_cp_progress`, `chronicle_claim`, `chronicle_claimed`, `chronicle_locked`,
  `chronicle_normal`, `chronicle_plus`, `chronicle_premium`.
- Mission strings: `chronicle_mission_login`, `_dungeon`, `_raid`, `_potion`, `_sell`,
  `_craft`, `_black_market`, `_hunt`, `_siege`, `_quest`.
- Bundle strings: `shop_title_chronicle_codex`, `shop_title_chronicle_codex_ascendant`,
  `shop_title_chronicle_tome_ascendant`.

---

### Package Structure

```
game/
├── activities/     (existing)
└── chronicle/      (new)
    ├── GuildChronicleManager.kt
    └── GuildChronicleState.kt

ui/dialogs/
└── DialogChronicle.kt   (new)

res/layout/
├── dialog_chronicle.xml          (new)
├── layout_chronicle_tier.xml     (new)
└── layout_chronicle_mission.xml  (new)
```

---

### No Changes Required

| Component | Reason |
|---|---|
| `Formulas.kt` | No formula changes |
| `DataDeserializer.kt` | Gson defaults handle all new fields on old saves |
| `Area.kt` combat engine | CP awarded at mission level, not inside the combat tick |
| `build.gradle.kts` | No new dependencies |

---

## Verification Plan

### Automated Tests
New `GuildChronicleTest.kt` in `app/src/test/…/`:

- `testFirstLaunchInit()` — `endTimestamp == 0L` triggers rollover; verify timestamp
  is ~28 days from now, season == 1, all arrays false.
- `testEffectiveTier()` — 0 CP → T0; 250 CP → T2; 3000 CP → T30.
- `testTierSkipAscendant()` — 0 CP + `tierSkip=20` → effectiveTier == 20.
- `testMissionClaimFlow()` — mark complete, claim → CP awarded, claimed = true;
  claim again → no duplicate.
- `testClaimNormalTier()` — earn T3, claim Normal → reward received, flag set.
- `testClaimPlusBlockedWithoutBundle()` — earn T3, no Codex → Plus claim rejected.
- `testClaimPremiumBlockedWithoutTome()` — earn T3, no Tome → Premium rejected.
- `testSeasonRollover()` — set `endTimestamp = now - 1`, tick daily → CP/flags/missions
  reset, season++ , new endTimestamp ~28 days out.
- `testBundleResetAfterRollover()` — purchase Codex, rollover → `isChronicleTrackPlusPurchased = false`.

### Manual Verification
1. Launch → tap Chronicle top-bar icon → "Chronicle Chapter 1", 28 days, 0 CP.
2. Complete a dungeon → Daily Mission "Complete 1 dungeon" shows **CLAIM**.
   Tap → +20 CP shown in progress bar, mission ✓.
3. Earn 100 CP → Tier 1 Normal CLAIM button activates. Tap → gems credited.
4. Purchase Chronicle Codex (500💎) → Plus column unlocks for earned tiers.
5. Purchase Chronicle Tome Ascendant (1500💎) → Premium unlocked, tiers jump to T20;
   tiers 1–20 of all tracks claimable.
6. Simulate season end via save editor (`chronicleSeasonEnd` set to past, relaunch) →
   all progress resets, "Chronicle Chapter 2", bundle buy buttons re-enabled.

### Build Check
```powershell
.\gradlew.bat testDebugUnitTest
.\gradlew.bat assembleDebug
```
