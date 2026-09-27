# Implementation Plan: Tavern Instant Visitor & Dev Code

## 1. Goal Description

Provide players and developers with direct control over Tavern visitor arrivals:
1. **Player Feature**: An **"Attract Guest"** action inside the Tavern dialog that allows players to immediately summon a new Level 1 adventurer (`Utils.newTavernVisitor()`) for a flat **50 Gems** instead of waiting for the 8-hour (or upgraded) arrival timer.
2. **Dev Feature**: A `TAVERN [N]` console redeem code that immediately forces $N$ new tavern visitors into the tavern (defaulting to the tavern's current capacity level $N = \text{getTavernCapacity()}$).

---

## 2. Gem Cost Model: Flat 50 Gems

Per design selection (Option B), summoning a Tavern visitor instantly has a fixed, predictable cost:
$$\text{gemCost} = 50\text{ Gems}$$

- **Constant Cost**: Always costs 50 Gems regardless of tavern speed level, capacity, or elapsed time on the arrival timer.
- **Constant Definition**:
  ```kotlin
  const val TAVERN_RUSH_GEM_COST: Int = 50
  ```

---

## 3. Player Feature Architecture (Tavern UI)

### 3.1 UI Layout (`dialog_tavern.xml`)
Add an **"Attract Guest"** button row directly underneath the arrival progress bar and next-visitor label:

```xml
<!-- Attract Guest Immediately (Gem Rush) -->
<androidx.constraintlayout.widget.ConstraintLayout
    android:id="@+id/button_attract_guest"
    android:background="@drawable/object_border_dim_white"
    android:padding="6.0dip"
    android:layout_width="0.0dip"
    android:layout_height="wrap_content"
    android:layout_marginTop="8.0dip"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toBottomOf="@id/progressBar">

    <TextView
        android:textSize="14.0sp"
        android:textStyle="bold"
        android:textColor="@color/dim_white"
        android:id="@+id/text_attract_guest"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/headquarters_tavern_attract_guest"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <LinearLayout
        android:gravity="center_vertical"
        android:orientation="horizontal"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="parent">

        <TextView
            android:textSize="14.0sp"
            android:textStyle="bold"
            android:textColor="@color/brass_filler"
            android:id="@+id/attract_guest_price"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginEnd="4.0dip"
            android:text="50" />

        <ImageView
            android:layout_width="16.0dip"
            android:layout_height="16.0dip"
            android:src="@drawable/gem" />
    </LinearLayout>
</androidx.constraintlayout.widget.ConstraintLayout>
```

### 3.2 Logic Flow in [`DialogTavern.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogTavern.kt)

1. **Button Setup & State**:
   ```kotlin
   b.attractGuestPrice.text = Formulas.TAVERN_RUSH_GEM_COST.toString()
   ```

2. **On Button Tap**:
   - **Gems Check**: If `MainActivity.data.gems < Formulas.TAVERN_RUSH_GEM_COST`, display a dialog notifying the player they have insufficient gems.
   - **Tavern Lock Warning**: If `MainActivity.data.isTavernLocked`, prompt the player that the tavern is locked, allowing them to proceed or cancel.
   - **Full Capacity Warning**: If `MainActivity.data.tavernGuests.size >= Formulas.getTavernCapacity()`, warn the player that the oldest guest at the bottom of the tavern list will be pushed out.
   - **Confirmation Dialog**:
     ```kotlin
     UIUtils.getActionDialog(
         context,
         R.string.headquarters_tavern_attract_guest_confirm_title,
         String.format(getString(R.string.headquarters_tavern_attract_guest_confirm_body), Formulas.TAVERN_RUSH_GEM_COST),
         R.string.yes
     ) { dialogInterface, _ ->
         executeAttractGuest(Formulas.TAVERN_RUSH_GEM_COST)
         dialogInterface.dismiss()
     }.show()
     ```

3. **Execution**:
   ```kotlin
   private fun executeAttractGuest(cost: Int) {
       val data = MainActivity.data ?: return
       if (data.gems < cost) return
       data.gems -= cost
       Utils.newTavernVisitor()
       // Reset arrival timer for the next cycle
       data.nextTavernVisit = Formulas.getTavernVisitorInterval() / 1000L
       refreshAdventurers()
       refreshProgressBar()
       (activity as? MainActivity)?.refresh()
       FileManager.saveNow(context)
   }
   ```

---

## 4. Dev Redeem Code Feature (`TAVERN [count]`)

### 4.1 Specification in [`RedeemCodes.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/game/redeem/RedeemCodes.kt)

Add `TAVERN` to `DEV_CODES`:
```kotlin
val DEV_CODES = setOf(
    "REROLL", "BLACK", "SHOP", "QUEST", "GOLD", "STORAGE",
    "IDLETIME", "LOOTCAP", "RESETCAPS", "KILLS", "SETKILLS", "ITEM", "HERO", "PET",
    "TAVERN"
)
```

### 4.2 Command Processing
Syntax:
- `TAVERN`: Forces $N$ visitors, where $N = \text{Formulas.getTavernCapacity()}$ (fills the entire tavern capacity).
- `TAVERN <count>`: Forces specifically `<count>` visitors (clamped between 1 and 50).

```kotlin
if (upper.startsWith("TAVERN")) {
    val parts = upper.split(" ").filter { it.isNotBlank() }
    val defaultCount = Formulas.getTavernCapacity()
    val count = if (parts.size > 1) {
        parts[1].toIntOrNull()?.coerceIn(1, 50) ?: defaultCount
    } else {
        defaultCount
    }

    repeat(count) {
        Utils.newTavernVisitor()
    }

    MainActivity.shownDialogTavern?.refreshAdventurers()
    MainActivity.shownDialogTavern?.refreshProgressBar()
    MainActivity.headquartersFragment?.refresh()
    FileManager.saveNow(context)

    return "Summoned $count new Tavern visitor(s)!"
}
```

---

## 5. String Resources (`strings.xml`)

```xml
<string name="headquarters_tavern_attract_guest">Attract Guest</string>
<string name="headquarters_tavern_attract_guest_confirm_title">Attract Visitor</string>
<string name="headquarters_tavern_attract_guest_confirm_body">Spend %d Gems to summon a new adventurer to the Tavern immediately?</string>
<string name="headquarters_tavern_attract_guest_full_warning">Your Tavern is currently full. Summoning a new visitor will discard the oldest guest (%s). Proceed?</string>
```

---

## 6. Verification & Automated Test Plan

1. **Dev Code Execution**:
   - Execute `RedeemCodes.process("TAVERN", context)` $\to$ verify `tavernGuests.size == Formulas.getTavernCapacity()`.
   - Execute `RedeemCodes.process("TAVERN 1", context)` $\to$ verify exactly 1 new guest arrives and is placed at index 0.
2. **Gem Deduction (Flat 50)**:
   - Verify `executeAttractGuest(50)` subtracts exactly 50 gems from `MainActivity.data.gems`.
   - Verify attempt fails gracefully when `gems < 50`.
3. **Timer Reset**:
   - Verify `nextTavernVisit` resets to full duration after summoning.
4. **Queue Overflow (FIFO)**:
   - When tavern is full, verify the newest adventurer is added at index 0 and the oldest guest is removed.
5. **Unit Test Pass**:
   - Run `./gradlew.bat testDebugUnitTest` to ensure all existing and new test suites pass cleanly.
