# Implementation Plan - Live Battle Status Effects Inspector

Implement a **Live Battle Status Effects Inspector** accessible during combat from the dungeon detail view. Currently, combat portraits only show up to 3 status effect icons at once, hiding any 4th+ active effects and making it impossible to see remaining turn durations. This feature adds a **"STATUS"** button in the bottom-left corner of the battle log to open a dedicated, live-updating dialog showing all active positive and negative status effects and their remaining turns for all allies and enemies.

---

## User Review Required

> [!IMPORTANT]
> **Button Placement**:
> In [dialog_dungeon_detail.xml](file:///c:/Repositories/IGM-Modded/app/src/main/res/layout/dialog_dungeon_detail.xml), the bottom row currently has:
> - `app:layout_constraintEnd_toEndOf="parent"`: **CLOSE**
> - `app:layout_constraintEnd_toStartOf="@id/exit"`: **RETREAT**
> - The new **STATUS** button will be placed at `app:layout_constraintStart_toStartOf="parent"` and `app:layout_constraintBottom_toBottomOf="parent"`, perfectly balancing the bottom navigation bar.

> [!NOTE]
> **Dynamic Synchronization**:
> The status inspector dialog will hook directly into `DialogDungeonDetail.refreshUnits()`. Whenever a combat turn finishes and units are refreshed, the status dialog will instantly update its list and turn counters in real time without needing to close and reopen.

---

## Architecture & Layout

### 1. Button in `dialog_dungeon_detail.xml`
```xml
<TextView
    android:textStyle="bold"
    android:id="@id/btn_status_effects"
    android:padding="8.0dip"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@string/btn_status_effects"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintStart_toStartOf="parent" />
```

### 2. Dialog Layout (`dialog_battle_status_effects.xml`)
- A scrollable two-section view:
  - **Allies Section**: Lists all active adventurers/minions currently exploring.
  - **Enemies Section**: Lists all active enemies currently in combat.
- For each unit row:
  - Unit portrait icon, name, and current HP/shield.
  - Complete list of all `positiveStatusEffects` (green tinted / buff icon) and `negativeStatusEffects` (red tinted / debuff icon).
  - For each effect:
    - Status icon (`effect.type.icon`)
    - Status name (`RESOURCES.getString(effect.type.idName)`)
    - Duration text:
      - If `turnsLeft >= 999`: `Permanent`
      - If `turnsLeft == 1`: `1 turn left`
      - Else: `N turns left`
    - Cause (who applied it, if applicable, e.g. "by Death Knight").

### 3. Dialog Class (`DialogBattleStatusEffects.kt`)
- Subclasses `CustomDialog`.
- Holds reference to `area: Area?`.
- Provides `refreshStatusList()` method called:
  - On dialog creation/initialization.
  - On every update notification from `DialogDungeonDetail.refreshUnits()` while visible.

---

## Proposed Changes

### UI & Layout

#### [MODIFY] [dialog_dungeon_detail.xml](file:///c:/Repositories/IGM-Modded/app/src/main/res/layout/dialog_dungeon_detail.xml)
- Add `@id/btn_status_effects` TextView in the bottom-left corner.

#### [NEW] [dialog_battle_status_effects.xml](file:///c:/Repositories/IGM-Modded/app/src/main/res/layout/dialog_battle_status_effects.xml)
- Layout for the status inspector with tabs/sections for Allies and Enemies.

#### [NEW] [item_unit_status_effects.xml](file:///c:/Repositories/IGM-Modded/app/src/main/res/layout/item_unit_status_effects.xml)
- View layout for a unit's row with their complete effect list and turn badges.

---

### Logic & Controllers

#### [NEW] [DialogBattleStatusEffects.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogBattleStatusEffects.kt)
- Dialog controller to bind, render, and live-update unit status effects.

#### [MODIFY] [DialogDungeonDetail.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogDungeonDetail.kt)
- In `attachListeners()`: attach click listener to `b.btnStatusEffects` to show `DialogBattleStatusEffects`.
- In `refreshUnits()`: notify `shownStatusDialog?.refreshStatusList()` so it updates dynamically with each turn.

#### [MODIFY] [strings.xml](file:///c:/Repositories/IGM-Modded/app/src/main/res/values/strings.xml)
- Add strings for `btn_status_effects` ("STATUS"), `status_turns_left`, `status_permanent`, etc.

---

## Verification Plan

### Automated Tests
- Unit test ensuring `positiveStatusEffects` and `negativeStatusEffects` collections expose accurate `turnsLeft` and formatting helpers.

### Manual Verification
- Enter a dungeon with debuff/buff heavy units (e.g. Inquisitor with Radiant Blessing, Bleed, Poison, Stun).
- Open the dungeon detail view, click the new **STATUS** button in the bottom-left corner.
- Confirm all 4+ effects are displayed with their icons, names, and remaining turn counts.
- Let the battle progress and verify turn counts decrease dynamically in real time.
