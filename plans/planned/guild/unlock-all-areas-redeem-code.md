# Plan: Unlock All Dungeons and Raids Dev Redeem Code

## Status
- **State**: Planned
- **Category**: Guild / Developer Tooling
- **Target File**: `app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/game/redeem/RedeemCodes.kt`

---

## 1. Overview
Provide an instant dev redeem command (`UNLOCKALL` / `UNLOCK`) in the Redeem Code dialog that unlocks all dungeons and raids currently registered in the game, refreshes UI fragments and the bottom navigation bar immediately, and saves game state.

The code dynamically queries `Utils.compileDungeonRaidList()`, ensuring zero ongoing maintenance: whenever new dungeons or raids are added to the game, they are automatically unlocked without touching `RedeemCodes.kt`.

---

## 2. Architecture & Design

### In-Game Command Execution
In `RedeemCodes.kt`:
1. Register `"UNLOCK"` and `"UNLOCKALL"` in `DEV_CODES`.
2. When processed:
   - Call `Utils.compileDungeonRaidList()`.
   - For each `area`, invoke `UIUtils.unlockArea(area)`.
     - `UIUtils.unlockArea` sets `area.isUnlocked = true` and `area.triesAvailable = true`.
     - Unlocks story messages and Google Play achievements where applicable.
   - Update UI navigation:
     - `MainActivity.dungeonsFragment?.refreshDungeonVisibility()`
     - `MainActivity.raidsFragment?.refreshRaidVisibility()`
     - `(MainActivity.dungeonsFragment?.activity as? MainActivity)?.let { it.refreshRaidsFragmentVisibility(); it.refreshKingMessages() }`
   - Save via `FileManager.saveNow(context)`.
   - Return message `"All dungeons and raids unlocked!"`.

### CLI Tooling Companion (`save_manager.ps1`)
Add `unlock-areas` (and include in `unlock-all`) to inspect save JSON dynamically:
```powershell
foreach ($prop in $json.PSObject.Properties) {
    if ($prop.Value.adventureRecap -ne $null) {
        $prop.Value.unlocked = $true
        $prop.Value.triesAvailable = $true
    }
}
```

---

## 3. Verification Plan
- Unit test `UnlockAreasRedeemTest`:
  - Assert `RedeemCodes.isDevCode("UNLOCK")` and `RedeemCodes.isDevCode("UNLOCKALL")`.
  - Assert all areas in `Utils.compileDungeonRaidList()` have `isUnlocked == true` and `triesAvailable == true` after executing `RedeemCodes.process("UNLOCKALL", null)`.
- Execute `./gradlew testDebugUnitTest`.
