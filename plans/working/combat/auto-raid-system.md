# Implementation Plan: Auto-Raid System

> **Status**: Planned  
> **Category**: Combat / Raids  
> **Target Files**:
> - `app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/Area.kt`
> - `app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/DataDeserializer.kt`
> - `app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/raids/RaidsFragment.kt`
> - `app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogSendTeam.kt`
> - `app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogDungeonDetail.kt`
> - `app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogAutoRaidConfig.kt` [NEW]
> - `app/src/main/res/layout/dialog_send_team.xml`
> - `app/src/main/res/layout/dialog_dungeon_detail.xml`
> - `app/src/main/res/layout/dialog_auto_raid_config.xml` [NEW]
> - `app/src/main/res/layout/layout_dungeon.xml`
> - `app/src/main/res/values/strings.xml`

---

## 1. Goal & Problem Overview

### 1.1 The Problem in Vanilla
In *Idle Guild Master*, farming normal raids (e.g. *The Tower*, *The Lost Expedition*, *The Cultist Rebels*, *Sleeping Planet*, *Kaunis*) is an extremely repetitive, manual ordeal:
1. Tap raid $\rightarrow$ buy 1 try for 15 or 30 gems (`DialogRefillRaidTry`).
2. Tap raid again $\rightarrow$ open `DialogSendTeam`.
3. Select or confirm heroes $\rightarrow$ click Send.
4. Wait 1–3 minutes for the raid to finish.
5. Team wipes or beats boss $\rightarrow$ team is recalled to Quarters.
6. Player must tap chest to claim loot, tap raid to buy try again, tap raid again to dispatch team again.
7. Repeating this 20–50 times requires constant phone monitoring and hundreds of repetitive taps.

### 1.2 The Proposed Solution: Auto-Raid System
An automated raid dispatch and refill loop powered by gems:
- Players configure Auto-Raid with a desired run count (e.g. 5, 10, 25, or Unlimited until out of gems) and safety stop conditions (stop on wipe, stop on full storage).
- When a raid run concludes, the game automatically:
  1. Stashes earned loot into inventory and auto-feeds favorite pets (protecting against loot-cap overflow).
  2. Evaluates stop conditions.
  3. Automatically deducts `costToRefresh()` gems from the guild treasury (or consumes a free daily try if available).
  4. Immediately re-dispatches the saved team (`savedAdventurersIds` + `savedPetId`).
  5. Continues cycling seamlessly in foreground **and** during offline idle progress.

---

## 2. Supported Raid Targets

Auto-Raid operates exclusively on repeatable normal raids:
- **Eligible Areas (`getAreaType() == 1` and `canRefillWithGems() == true`)**:
  - *The Tower* (15 gems/run)
  - *Sleeping Planet* (15 gems/run)
  - *Kaunis* (15 gems/run)
  - *The Slime Pond* (30 gems/run)
  - *The Lost Expedition* (30 gems/run)
  - *The Cultist Rebels* (30 gems/run)
  - *Celestial Mothership* (30 gems/run)
  - *Ancient Grave Digging* (30 gems/run)
  - *The Sanguine Crucible* (Scarlet Raid Boss, 30 gems/run)
- **Excluded**:
  - Dungeons (`getAreaType() == 0`): Already run infinitely for free.
  - Epic Raids (`getAreaType() == 2`): Weekly one-time progression encounters.
  - Guild Activities (`canRefillWithGems() == false`): Limited daily/weekly guild tickets, no gem refills allowed.

---

## 3. Auto-Raid Lifecycle & Control Flow

```mermaid
graph TD
    A[Raid Run Completes: Boss Defeated or Team Wiped] --> B{isAutoRaidActive?}
    B -->|NO| C[Normal Vanilla Termination: Return to Quarters, Loot in Chest]
    B -->|YES| D{Did Party Wipe AND stopOnWipe == true?}
    D -->|YES| E[Stop Auto-Raid: Reason Party Wiped]
    D -->|NO| F{Runs Remaining == 0?}
    F -->|YES| G[Stop Auto-Raid: Reason Target Runs Reached]
    F -->|NO| H{Area Loot Chest Full?}
    H -->|YES| I[Stop Auto-Raid: Reason Storage Full — collect the chest to continue]
    H -->|NO| K{Free Try Available?}
    K -->|YES| L[Consume Free Try: triesAvailable = false]
    K -->|NO| M{Gems >= costToRefresh?}
    M -->|NO| N[Stop Auto-Raid: Reason Insufficient Gems]
    M -->|YES| O[Deduct Gems: MainActivity.data.gems -= costToRefresh]
    L --> P[Re-dispatch Team: savedAdventurersIds + savedPetId]
    O --> P
    P --> Q[Reset Action, HP, and Start Room 1 on Next Tick]
    E --> C
    G --> C
    I --> C
    N --> C
```

> v1.3.13.2 change: the loop no longer auto-stashes loot into the guild inventory.
> Drops accumulate in the raid's chest (`area.drops`) and Auto-Raid halts when the
> chest reaches the area loot cap (`fullChest()`). Stopped sessions record their
> attempts / gems / stop reason for the chest's AUTO RAID REPORT button; stop text is
> no longer printed on the after-run summary.

---

## 4. Detailed Component Design

### 4.1 State & Persistence in `Area.kt`

Add Auto-Raid fields directly to the base `Area` class:
```kotlin
// Auto-Raid State
var isAutoRaidActive: Boolean = false
var autoRaidRunsRemaining: Int = -1      // -1 = Unlimited (until out of gems), or positive count
var autoRaidRunsCompleted: Int = 0       // Session counter
var autoRaidStopOnWipe: Boolean = true   // Safety: stop if team dies to prevent wasting gems
var autoRaidGemsSpent: Int = 0           // Session gem expense tracking
var autoRaidStopReasonRes: Int = 0       // Stop reason shown in the AUTO RAID REPORT (0 = none)
```

#### Serialization (`DataDeserializer.kt`)
Persist these fields in `getArea(...)` so Auto-Raid continues uninterrupted across app restarts and saves:
```kotlin
if (asJsonObject.has("isAutoRaidActive")) {
    tNewInstance.isAutoRaidActive = asJsonObject.get("isAutoRaidActive").asBoolean
}
if (asJsonObject.has("autoRaidRunsRemaining")) {
    tNewInstance.autoRaidRunsRemaining = asJsonObject.get("autoRaidRunsRemaining").asInt
}
if (asJsonObject.has("autoRaidRunsCompleted")) {
    tNewInstance.autoRaidRunsCompleted = asJsonObject.get("autoRaidRunsCompleted").asInt
}
if (asJsonObject.has("autoRaidStopOnWipe")) {
    tNewInstance.autoRaidStopOnWipe = asJsonObject.get("autoRaidStopOnWipe").asBoolean
}
```

---

### 4.2 Combat Loop Hook (`Area.kt`)

In `Area.tick()` where `terminationRequested` is processed:
```kotlin
if (this.terminationRequested) {
    if (this.isAutoRaidActive && handleAutoRaidCycle()) {
        return // Next run successfully dispatched
    }
    terminate()
    return
}
```

#### Auto-Raid Cycle Method (`Area.handleAutoRaidCycle()`):
```kotlin
private fun handleAutoRaidCycle(): Boolean {
    if (!isAutoRaidActive || getAreaType() != 1 || savedAdventurersIds.isEmpty()) {
        isAutoRaidActive = false
        return false
    }

    val wiped = adventurersAlive() == 0

    // 1. Stop on Wipe Check
    if (wiped && autoRaidStopOnWipe) {
        stopAutoRaid(R.string.auto_raid_report_reason_wipe)
        return false
    }

    // 2. Decrement Run Counter
    if (autoRaidRunsRemaining > 0) {
        autoRaidRunsRemaining--
        if (autoRaidRunsRemaining == 0) {
            stopAutoRaid(R.string.auto_raid_report_reason_completed)
            return false
        }
    }

    // 3. Stop when the Area Loot Chest is Full (v1.3.13.2: no more auto-stash — drops
    //    accumulate in this area's chest and must be collected before more runs queue).
    if (fullChest()) {
        stopAutoRaid(R.string.auto_raid_report_reason_storage_full)
        return false
    }

    // 4. Verify & Deduct Gems
    if (!this.triesAvailable) {
        val cost = costToRefresh()
        if (MainActivity.data.gems < cost) {
            stopAutoRaid(R.string.auto_raid_report_reason_no_gems)
            return false
        }
        MainActivity.data.gems -= cost
        autoRaidGemsSpent += cost
        (MainActivity.raidsFragment?.activity as? MainActivity)?.refreshGems()
    } else {
        this.triesAvailable = false
    }

    // 5. Re-dispatch Team
    autoRaidRunsCompleted++
    Logger.log(this, 105, autoRaidRunsCompleted) // Log auto-dispatch in raid history

    this.adventurersExploringIds = CopyOnWriteArrayList(this.savedAdventurersIds)
    this.petExploringId = this.savedPetId
    this.terminationRequested = false
    this.progress = 0
    this.action = null // Triggers fresh Action(0) and resetAdventurers(true) on next tick

    setupAdventurers(MainActivity.data.adventurers, MainActivity.data.pets)
    refreshActionDisplayed()
    refreshAdventurers()
    refreshTries()
    return true
}

private fun stopAutoRaid(reasonResId: Int) {
    if (!this.isAutoRaidActive) return
    this.isAutoRaidActive = false
    this.autoRaidStopReasonRes = reasonResId      // recorded for the AUTO RAID REPORT
    (MainActivity.raidsFragment?.activity as? MainActivity)?.runOnUiThread {
        MainActivity.raidsFragment?.refresh()
    }
}
```

---

### 4.3 Auto-Raid Loot & Report (v1.3.13.2)

Auto-Raid **no longer stashes drops directly** (`Area.stashDropsDirectly` was removed).
Each finished run's loot stays in `area.drops` (the raid's chest), and the cycle stops
once the chest is full (`fullChest()` — area loot cap). The player collects the chest
later via `Utils.collectDrops`, whose `DialogCollectDrops` surfaced an **AUTO RAID
REPORT** button (attempts / gems spent / stop reason) whenever the session recorded a
stop. The report data lives on `Area` (`autoRaidRunsCompleted`, `autoRaidGemsSpent`,
`autoRaidStopReasonRes`) and is cleared once it is handed to the collect dialog.

---

### 4.4 User Interface Integration

#### A. Direct Configuration Dialog: `DialogAutoRaidConfig.kt` [NEW]
A dedicated dialog opened when tapping **"AUTO-RAID"** in `DialogSendTeam` or on the raid card:
- **Title**: `Auto-Raid: [Raid Name]`
- **Information Panel**:
  - Current Gems: `💎 [gems]`
  - Cost per Run: `💎 [costToRefresh]`
  - Max Affordable Runs: `[gems / cost]`
- **Run Limit Selector**:
  - Preset Chips: `[5 Runs]`, `[10 Runs]`, `[25 Runs]`, `[Unlimited / All Gems]`
  - Stepper buttons (`-` / `+`) to fine-tune exact count.
- **Safety Toggles**:
  - `Stop on Team Wipe`: a `CheckBox` toggle (default ON). v1.3.13.2 replaced the YES/NO
    picker with `SwitchCompat`, but the vanilla release ships no Material switch-thumb
    drawable, so that class crashes on inflate (`abc_switch_thumb_material`
    NotFoundException) — v1.3.13.3 switched it to the game's own `CheckBox` widget.
- **Buttons**:
  - `Cancel`
  - `Start Auto-Raid` (Highlighted in Brass)

#### B. `DialogSendTeam.kt` Integration
- Add an `AUTO-RAID` button next to `send`:
  - When `area.getAreaType() == 1`, `b.autoRaid.visibility = View.VISIBLE`.
  - Tapping `autoRaid` checks if at least 1 adventurer is selected; then opens `DialogAutoRaidConfig` with the chosen team.

#### C. `DialogDungeonDetail.kt` Integration
- The `[AUTO: ON/OFF]` toggle was **removed** (v1.3.13.2 — it looked cluttered and the
  run now has a clean stop path): while an Auto-Raid is active the **RETREAT** button
  stops it (recording "Stopped manually" for the report) in addition to ending the run.

#### D. Raid Card Visuals (`RaidsFragment` / `layout_dungeon.xml`)
- When `area.isAutoRaidActive`:
  - A glowing brass badge `[AUTO]` displays in top-right next to `raid_try_available`.
  - The action progress text stays the plain action name (v1.3.13.2: the "runs left /
    Unlimited" suffix was removed from the display; run counts live in the AUTO RAID
    REPORT dialog).

---

### 4.5 Streamlined Refill Flow (Bypassing Double-Tapping)

In vanilla, tapping an empty raid without tries opens `DialogRefillRaidTry`, which only buys 1 try and closes, forcing the player to tap the raid a second time to reach `DialogSendTeam`.

With Auto-Raid:
- In `UIUtils.clickArea`:
  If `!area.triesAvailable && area.canRefillWithGems()`:
  - If `area.savedAdventurersIds.isNotEmpty()`:
    - Add an **"Auto-Raid"** option directly in `DialogRefillRaidTry`, or allow opening `DialogSendTeam` directly where the player can see both "Send (X 💎)" and "Auto-Raid".
  - This eliminates the awkward double-dialog tap flow!

> v1.3.13.4 restored payment but deducted the gems silently; v1.3.13.5 shows the vanilla
> "Buy extra chance for 30 gems" confirmation popup first: `Area.needsPaidTryDispatch()`
> detects the spent free try on the Send button and the first Auto-Raid dispatch, and both
> open `DialogRefillRaidTry` (cost + "Not enough gems" inline error) — the team only
> dispatches after the player confirms the purchase. The Auto-Raid loop charges every
> later run itself. This fixed raids silently becoming free after the daily free try had
> been used.

---

## 5. Offline & Background Simulation

Because `MainActivity.kt` executes:
```kotlin
for (area in list) {
    area.tick()
}
```
for every offline idle second up to the player's idle cap:
- **Offline Auto-Raids work 100% out of the box!**
- A player can queue 20 runs, exit the app, and offline progression ticks the encounters, defeats bosses, deducts gems, and re-dispatches runs until the target count, a wipe, a full raid chest, or a gem shortage stops the loop (v1.3.13.2: loot stays in the raid's chest instead of being auto-stashed to the inventory).
- Upon re-opening the app, the player sees:
  - The total attempts / gems spent / stop reason via the chest's AUTO RAID REPORT.
  - All rare items, equipment, and materials safely waiting in the raid's chest.
  - Accurate gem deduction.
  - Hero levels and EXP updated.

---

## 6. Strings & Localization (`strings.xml`)

```xml
<string name="auto_raid_title">Auto-Raid</string>
<string name="auto_raid_start">START AUTO-RAID</string>
<string name="auto_raid_stop">STOP AUTO-RAID</string>
<string name="auto_raid_badge">AUTO</string>
<string name="auto_raid_cost_per_run">Cost per run: %d gems</string>
<string name="auto_raid_affordable_runs">Max affordable: %d runs</string>
<string name="auto_raid_stop_on_wipe">Stop on party wipe:</string>
<string name="auto_raid_report_title">AUTO RAID REPORT</string>
<string name="auto_raid_report_attempts">Attempts: %d</string>
<string name="auto_raid_report_gems_spent">Gems spent: %d</string>
<string name="auto_raid_report_stopped_reason">Reason stopped: %s</string>
<string name="auto_raid_report_reason_completed">All target runs finished.</string>
<string name="auto_raid_report_reason_wipe">Team was defeated.</string>
<string name="auto_raid_report_reason_no_gems">Insufficient gems.</string>
<string name="auto_raid_report_reason_storage_full">Guild storage is full.</string>
<string name="auto_raid_report_reason_manual">Stopped manually.</string>
```
> v1.3.13.2 dropped `auto_raid_runs_remaining`, `auto_raid_runs_unlimited`,
> `auto_raid_stopped_*` and the `auto_raid_dungeon_on/off` strings from display:
> nothing is printed on the after-run summary anymore, and run counts/stop reasons
> are only surfaced by the AUTO RAID REPORT button.

---

## 7. Verification Plan

### 7.1 Automated Unit Tests
- `AutoRaidTest.kt`:
  - Test run counter decrements correctly.
  - Test gems are deducted exactly by `costToRefresh()` per run.
  - Test free daily try is consumed first before gems.
  - Test wipe with `autoRaidStopOnWipe = true` halts auto-raid and does not spend subsequent gems.
  - Test storage full condition halts auto-raid immediately without item loss.
  - Test `stashDropsDirectly` correctly deposits items and feeds favorite pets.

### 7.2 Manual Playtest
1. **Starting Auto-Raid**: Open *The Tower* $\rightarrow$ Select team $\rightarrow$ Tap "AUTO-RAID" $\rightarrow$ Select 3 runs $\rightarrow$ Start.
2. **Foreground Execution**: Watch Run 1 complete $\rightarrow$ Verify gems decrease by 15 $\rightarrow$ Verify Run 2 dispatches automatically with same team $\rightarrow$ Run 3 completes $\rightarrow$ Auto-Raid stops.
3. **Loot Verification**: Verify all drops from the 3 runs are present in guild inventory.
4. **Mid-Fight Toggle**: Start Auto-Raid $\rightarrow$ Open `DialogDungeonDetail` $\rightarrow$ Tap "STOP AUTO" $\rightarrow$ Verify current run finishes normally and does not re-dispatch.
5. **Offline Test**: Queue 5 runs on *The Cultist Rebels* $\rightarrow$ Close app $\rightarrow$ Wait 10 minutes $\rightarrow$ Re-open app $\rightarrow$ Verify all 5 runs simulated, gems deducted, and loot stashed.
