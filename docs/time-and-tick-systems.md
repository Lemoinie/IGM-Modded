# Time & Tick Systems

This document describes the core timekeeping architecture, periodic tick cascades, offline progress simulation, and reset cycles in **Idle Guild Master**.

All primary game timekeeping logic resides in [`Utils.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/Utils.kt) with time thresholds defined in [`Formulas.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/Formulas.kt) and timestamps persisted in [`Data.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/Data.kt).

---

## 1. High-Level Architecture & Time Authority

The game relies on **TrueTime NTP** ([`TrueTimeUtils.millis()`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/TrueTimeUtils.kt#L23-L27)) as its authoritative clock to prevent device time tampering (e.g. changing device time to bypass raid timers or cooldowns). If network NTP is uninitialized or unavailable, it falls back to the device's monotonic/system clock.

### Time Cascades Overview

```text
MainActivity (1-second UI Handler loop: 1,000ms delay)
  └── Utils.nextTimeTick() (Active 1s tick)
        ├── Updates data.lastAccess (TrueTime)
        ├── progressTavernTime(1L)
        ├── progressMarketTime(1L)
        ├── progressWorkshopTime(1L)
        ├── area.tick() for all active Dungeons and Raids
        └── Utils.tick60() (Minute gatekeeper & sync)
              ├── checkDismissedAdventurersExpiration() (26h grace cleanup)
              ├── refreshCooldowns() (Updates UI countdowns)
              ├── In-App Review check
              ├── tickHour() (If > 1 hour since lastHourTriggered)
              ├── tick24Hours() (If > 24 hours since last24Triggered)
              └── tickWeek() (If > 7 days since lastWeekTriggered)
```

---

## 2. Active 1-Second Loop: `Utils.nextTimeTick()`

Driven by `MainActivity.handlerUI` posting a `Runnable` delayed by `1000L` on the main Looper:

```kotlin
@JvmStatic
fun nextTimeTick() {
    MainActivity.data.lastAccess = TrueTimeUtils.millis()
    progressTavernTime(1L)
    progressMarketTime(1L)
    progressWorkshopTime(1L)
    tick60()
    for (area in compileDungeonRaidList()) {
        area.tick()
    }
    MainActivity.shownDialogEntityDetail?.update()
    MainActivity.shownDialogQuests?.update()
    ...
}
```

- **Tavern**: Decrements `data.nextTavernVisit` (unless locked via `data.isTavernLocked`). Triggers `newTavernVisitor()` when reaching 0.
- **Market**: Increments `secondsPassed` on items listed for sale; completes listing when `secondsPassed > getSecondsToSell()`.
- **Workshop**: Increments `secondsPassed` on items in crafting queue; completes craft when `secondsPassed > getSecondsToCraft()`.
- **Dungeons & Raids**: Advances room exploration, combat rounds, Auto-Raid cycles, and loot stashing.
- **Minute Gate**: Invocates `tick60()`.

---

## 3. The 60-Second Gate & Clock Sync: `Utils.tick60()`

```kotlin
@JvmStatic
fun tick60() {
    val i = checks
    if (i < 60) {
        checks = i + 1
        return
    }
    val jMillis = TrueTimeUtils.millis()
    val calendar = Calendar.getInstance()
    calendar.time = Date(jMillis)
    checks = calendar.get(Calendar.SECOND) - 1
    checkDismissedAdventurersExpiration(jMillis)
    refreshCooldowns(jMillis)
    if (firstRunTriggered && MainActivity.data.isReviewTrigger && !MainActivity.data.isReviewShown) {
        MainActivity.data.isReviewShown = true
        showReviewCard()
    }
    if (jMillis - MainActivity.data.lastWeekTriggered > 604800000L) {
        tickWeek(jMillis)
    }
    if (jMillis - MainActivity.data.last24Triggered > ONE_DAY_IN_MILLISECONDS) {
        tick24Hours(jMillis)
    }
    if (jMillis - MainActivity.data.lastHourTriggered > ONE_HOUR_IN_MILLISECONDS) {
        tickHour(jMillis)
    }
    firstRunTriggered = true
}
```

### The `checks` Synchronization Mechanism
- `var checks: Int = 60` is initialized to `60` so that `tick60()` executes immediately on game startup.
- On execution, it samples `calendar.get(Calendar.SECOND) - 1`. For example, if current real time is second `14`, `checks` is set to `13`.
- For the next 47 seconds, `checks` increments (`14, 15, ..., 59`) and returns early without running expensive checks.
- When `checks` reaches `60`, the real-world clock has turned to second `00` of the new minute. From that point on, **`tick60()` fires precisely on the :00 second boundary of every real-world minute**.

### Subroutines Executed Every Minute
1. **Dismissed Adventurers Cleanup**:
   Calls [`checkDismissedAdventurersExpiration(jMillis)`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/Utils.kt#L847-L854).
   - Dismissed adventurers have a 26-hour retention window (`93,600,000L` ms).
   - If `jMillis - adventurer.timeWhenDismissed > 93600000L`, the adventurer is permanently purged from `data.dismissedAdventurers`.
2. **Cooldown & Countdown Timer Formatting**:
   Calls [`refreshCooldowns(jMillis)`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/Utils.kt#L857-L889).
   - Recomputes remaining days, hours, and minutes until weekly reset (`lastWeekTriggered + 7d`) and daily reset (`last24Triggered + 24h`).
   - Updates UI timer text in:
     - Raids tab (`raidRefreshTime`).
     - Guild tab (`guildHuntRefreshTime`, `guildSiegeRefreshTime`).
     - Open dialogs (`DialogMerchant`, `DialogQuests`, `DialogBlackMarket`).
3. **App Review Prompt**:
   If `isReviewTrigger` is set and hasn't been shown yet, presents the store review dialog.

---

## 4. Milestone Reset Ticks

### A. Hourly Tick: `tickHour(j: Long)`
- **Trigger**: `jMillis - data.lastHourTriggered > 3,600,000L` (1 hour).
- **Time Normalization**: Sets `MINUTE = 0, SECOND = 0` on the Calendar so `lastHourTriggered` tracks the top of the hour.
- **Action**: Triggers an automatic background cloud save backup via `FileManager.writeToCloud()`.

---

### B. Daily 24-Hour Tick: `tick24Hours(j: Long)`
- **Trigger**: `jMillis - data.last24Triggered > 86,400,000L` (24 hours).
- **Time Normalization**: Sets `HOUR_OF_DAY = 0, MINUTE = 0, SECOND = 0` (midnight).
- **Actions**:
  1. **Daily Guild Activity (The Hunt)**:
     Invokes `GuildActivitiesManager.ensureRequest(j)` to roll over the daily elite enemy hunt.
  2. **Raid Free Tries Reset**:
     Iterates all raids (`compileRaidList()`) and resets `triesAvailable = true` on raid types 1 (normal raid) and 2 (epic raid).
  3. **Traveling Merchant Regular Stock**:
     Calls `refreshMerchantRegularStock()` to generate 4 new regular stock offers matching the player's 4 latest unlocked dungeons.
  4. **Black Market Arrival Roll**:
     Calls `checkBlackMarketDailyArrival()` — 10% daily arrival chance (guaranteed after 6 consecutive days absent).
  5. **Ad Watch Reset**:
     Resets `data.adsWatched = 0` and pre-loads a fresh rewarded ad.
  6. **Epic Raid Self-Healing**:
     Calls `restoreErroneouslyCompletedEpicRaids()` to unstick any corrupted epic raid states.

---

### C. Weekly Tick: `tickWeek(j: Long)`
- **Trigger**: `jMillis - data.lastWeekTriggered > 604,800,000L` (7 days).
- **Time Normalization**: Aligns back to Sunday midnight (`DAY_OF_WEEK = 1, HOUR_OF_DAY = 0, MINUTE = 0, SECOND = 0`).
- **Actions**:
  1. **Weekly Guild Activity (The Siege)**:
     Calls `GuildActivitiesManager.ensureSiege(j)` to reset the 10-wave weekly defensive campaign.
  2. **King's Quests Extraction**:
     Calls `QuestsManager.extractQuests()` to generate a fresh set of King's Quests, and dismisses `DialogQuests` if currently open.
  3. **Traveling Merchant Special Reserve**:
     Calls `refreshMerchantSpecialReserve()` to roll weekly items (including the 55% chance for the Aegis shield).

---

## 5. Offline Catch-Up & Idle Simulation

When the game launches, `MainActivity.initializeThreads()` calculates the elapsed real-world time since last exit:

$$\Delta t = \text{TrueTimeUtils.millis()} - \text{data.lastAccess}$$

1. **Idle Time Clamping**:
   $\Delta t$ is converted to seconds and clamped against [`Formulas.getIdleTimeCapHours()`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/Formulas.kt#L185) (base vanilla 8h/12h; mod extended up to 168h / 7 days via Extended Vigil upgrades).
2. **Offline Simulation Thread (`IDLE_THREAD`)**:
   - Loops through elapsed seconds:
     - Steps workshop crafting (`progressWorkshopTime`).
     - Steps market listing sales (`progressMarketTime`).
     - Steps tavern timer and adds visitors (`progressTavernTime`).
     - Steps dungeon and raid exploration (`area.tick()`).
3. **Rollover Catches**:
   Once the idle loop finishes, `tick60()` is called, immediately firing `tickHour()`, `tick24Hours()`, or `tickWeek()` if their elapsed thresholds were crossed while offline.

---

## 6. Key Persisted Save Fields ([`Data.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/Data.kt))

| Field Name | Type | Description |
| :--- | :--- | :--- |
| `lastAccess` | `Long` | Timestamp (ms) of the last processed game tick. |
| `lastHourTriggered` | `Long` | Timestamp (ms) of the most recent hourly cloud backup tick. |
| `last24Triggered` | `Long` | Timestamp (ms) of the most recent daily midnight rollover. |
| `lastWeekTriggered` | `Long` | Timestamp (ms) of the most recent Sunday midnight rollover. |
| `nextTavernVisit` | `Long` | Seconds remaining until the next visitor arrives at the Tavern. |
| `isTavernLocked` | `Boolean` | When true, tavern timer does not advance and visitors are not pushed out. |
| `dismissedAdventurers` | `List<Adventurer>` | List of recently dismissed adventurers (retained for 26 hours). |
