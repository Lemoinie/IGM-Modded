# Shop UI Rules & Conventions

This document defines the strict UI and architectural conventions for the in-game Shop (`dialog_shop.xml` and `DialogShop.kt`). All AI agents and contributors adding or modifying shop packs **MUST** follow these rules to maintain visual consistency and avoid common layout bugs.

---

## 1. Core Principles

1. **Vanilla Parity**: Every pack card must replicate the layout geometry, view hierarchy, drawables, and text sizing established in the original vanilla packs.
2. **Fixed Frame Geometry**: Pack cards, buy buttons, and borders have fixed dimensions. Do not guess or invent custom button heights, paddings, or margins.
3. **No Standalone Random Layouts**: Packs belong inside `dialog_shop.xml` or their respective modular bundle layout (e.g. `shop_bundle_equipment.xml`, `shop_bundle_infrastructure.xml`). Do not invent ad-hoc layout files for single packs.
4. **Interactive Previews**: Every item icon and adventurer preview displayed in a pack **must** have an attached click listener to open its respective detail dialog.

---

## 2. Design Tokens & Visual Hierarchy

| Element | Resource / Value | Notes |
| :--- | :--- | :--- |
| **Card Outer Border** | `@drawable/object_border_brass` | Applied to the card `ConstraintLayout` |
| **Icon Frame** | `@drawable/object_border_dim_white` | Applied to item, pet, and upgrade icons |
| **Buy Button Border** | `@drawable/object_border_buy` | Applied to the buy button `LinearLayout` |
| **Active Category Chip** | `@drawable/object_border_buy` | Text color: `@color/brass_filler` |
| **Inactive Category Chip** | `@drawable/object_border_dim_white` | Text color: `@color/dim_white` |
| **Purchased Checkmark** | `@drawable/check_brass` | Centered exactly on top of the buy button |
| **Gem Icon** | `@drawable/gem` | `22.0dip` × `22.0dip`, `marginEnd="4.0dip"` |
| **Brass Text Color** | `@color/brass_filler` | Used for prices, balances, pet names, active chips |
| **Dim White Text Color** | `@color/dim_white` | Used for secondary labels, inactive chips, close button |
| **Card Padding** | `8.0dip` | Uniform padding on all 4 sides of the card |
| **Card Margin Top** | `4.0dip` | Distance between the title and the card |
| **Title Margin Top** | `8.0dip` | Distance between preceding card and the new pack title |
| **Buy Button Size** | Width: `140.0dip`, Height: `36.0dip` | **MANDATORY**: Never use 42dp or `wrap_content` |

---

## 3. Pack Card Structure (The Golden Rule)

Every pack card consists of **two separate sibling elements**:
1. A `TextView` for the **Pack Title** (placed **OUTSIDE** and above the card).
2. A `ConstraintLayout` for the **Pack Card** (containing the items, description, buy button, and checkmark).

```
[TextView: Pack Title] (OUTSIDE the card, marginTop="8.0dip", textSize="18.0sp", bold)
[ConstraintLayout: Pack Card] (marginTop="4.0dip", background="object_border_brass", padding="8.0dip")
    ├── [Content: Items / Adventurers / Upgrades / Description]
    ├── [LinearLayout: Buy Button] (140.0dip × 36.0dip, background="object_border_buy")
    └── [ImageView: Checkmark] (src="check_brass", visibility="gone", aligned to Buy Button)
```

> [!CAUTION]
> **NEVER** put the pack title inside the `ConstraintLayout` card border. In vanilla Idle Guild Master, the title sits outside and directly above the brass card.

---

## 4. Canonical Pack Archetypes

### Archetype 1: Single-Row Upgrade / Feature Pack
**Use Case**: Storage upgrades, workshop speed/slots, market speed/slots, single equipment pieces.  
**Vanilla Reference**: `constraint_minor_storage`, `constraint_apprentice_merchant`, `constraint_apprentice_workshop`.

In this archetype, the icon, description text, and buy button are all arranged in **one compact horizontal row**.

```xml
<!-- Pack Title: OUTSIDE the card -->
<TextView
    android:id="@+id/minor_storage_title"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_marginTop="8.0dip"
    android:text="@string/shop_title_minor_storage"
    android:textSize="18.0sp"
    android:textStyle="bold" />

<!-- Pack Card -->
<androidx.constraintlayout.widget.ConstraintLayout
    android:id="@+id/constraint_minor_storage"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_marginTop="4.0dip"
    android:background="@drawable/object_border_brass"
    android:padding="8.0dip">

    <!-- Left Icon: 44dp x 44dp, dim_white border, 4dp padding -->
    <ImageView
        android:id="@+id/storage_image_minor"
        android:layout_width="44.0dip"
        android:layout_height="44.0dip"
        android:background="@drawable/object_border_dim_white"
        android:padding="4.0dip"
        android:src="@drawable/sign_storage"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <!-- Center Description: 0dp width, constrained between icon and buy button -->
    <TextView
        android:id="@+id/storage_text_minor"
        android:layout_width="0.0dip"
        android:layout_height="wrap_content"
        android:layout_marginStart="8.0dip"
        android:text="@string/shop_20_storage_spaces"
        android:textSize="14.0sp"
        android:textStyle="bold"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toStartOf="@id/minor_storage_buy"
        app:layout_constraintStart_toEndOf="@id/storage_image_minor"
        app:layout_constraintTop_toTopOf="parent" />

    <!-- Right Buy Button: 140dp x 36dp -->
    <LinearLayout
        android:id="@+id/minor_storage_buy"
        android:layout_width="140.0dip"
        android:layout_height="36.0dip"
        android:background="@drawable/object_border_buy"
        android:gravity="center"
        android:orientation="horizontal"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="parent">

        <ImageView
            android:layout_width="22.0dip"
            android:layout_height="22.0dip"
            android:layout_marginEnd="4.0dip"
            android:src="@drawable/gem" />

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="500"
            android:textColor="@color/brass_filler"
            android:textSize="15.0sp"
            android:textStyle="bold" />
    </LinearLayout>

    <!-- Purchased Checkmark: Overlaps Buy Button -->
    <ImageView
        android:id="@+id/check_minor_storage"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@drawable/check_brass"
        android:visibility="gone"
        app:layout_constraintBottom_toBottomOf="@id/minor_storage_buy"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="@id/minor_storage_buy" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

---

### Archetype 2: 2×2 Grid Multi-Feature Pack
**Use Case**: Packs with 3–4 features/items (e.g. Starter Pack, Explorer's Cache).  
**Vanilla Reference**: `constraint_starter_pack`, `constraint_adventurer_pack`.

Uses an **invisible center separator** (`View`) at 50% width to divide the card into two equal columns:

```xml
<TextView
    android:id="@+id/starter_pack_title"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_marginTop="8.0dip"
    android:text="@string/shop_title_guild_initiate"
    android:textSize="18.0sp"
    android:textStyle="bold" />

<androidx.constraintlayout.widget.ConstraintLayout
    android:id="@+id/constraint_starter_pack"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_marginTop="4.0dip"
    android:background="@drawable/object_border_brass"
    android:padding="8.0dip">

    <!-- Center Divider: Invisible guideline at 50% -->
    <View
        android:id="@+id/separator_starter_pack"
        android:layout_width="1.0dip"
        android:layout_height="1.0dip"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <!-- ROW 1 LEFT -->
    <ImageView
        android:id="@+id/quarters_image_starter_pack"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:background="@drawable/object_border_dim_white"
        android:padding="4.0dip"
        android:src="@drawable/shop_1"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/quarters_text_starter_pack"
        android:layout_width="0.0dip"
        android:layout_height="wrap_content"
        android:layout_marginStart="4.0dip"
        android:layout_marginEnd="4.0dip"
        android:text="@string/shop_quarters_space"
        android:textSize="13.0sp"
        android:textStyle="bold"
        app:layout_constraintBottom_toBottomOf="@id/quarters_image_starter_pack"
        app:layout_constraintEnd_toStartOf="@id/separator_starter_pack"
        app:layout_constraintStart_toEndOf="@id/quarters_image_starter_pack"
        app:layout_constraintTop_toTopOf="@id/quarters_image_starter_pack" />

    <!-- ROW 1 RIGHT -->
    <ImageView
        android:id="@+id/tavern_image_starter_pack"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="4.0dip"
        android:background="@drawable/object_border_dim_white"
        android:padding="4.0dip"
        android:src="@drawable/shop_1"
        app:layout_constraintStart_toEndOf="@id/separator_starter_pack"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/tavern_text_starter_pack"
        android:layout_width="0.0dip"
        android:layout_height="wrap_content"
        android:layout_marginStart="4.0dip"
        android:text="@string/shop_tavern_space"
        android:textSize="13.0sp"
        android:textStyle="bold"
        app:layout_constraintBottom_toBottomOf="@id/tavern_image_starter_pack"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toEndOf="@id/tavern_image_starter_pack"
        app:layout_constraintTop_toTopOf="@id/tavern_image_starter_pack" />

    <!-- ROW 2 LEFT -->
    <ImageView
        android:id="@+id/workshop_image_starter_pack"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="4.0dip"
        android:background="@drawable/object_border_dim_white"
        android:padding="4.0dip"
        android:src="@drawable/shop_1"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/quarters_image_starter_pack" />

    <TextView
        android:id="@+id/workshop_text_starter_pack"
        android:layout_width="0.0dip"
        android:layout_height="wrap_content"
        android:layout_marginStart="4.0dip"
        android:layout_marginEnd="4.0dip"
        android:text="@string/shop_workshop_space"
        android:textSize="13.0sp"
        android:textStyle="bold"
        app:layout_constraintBottom_toBottomOf="@id/workshop_image_starter_pack"
        app:layout_constraintEnd_toStartOf="@id/separator_starter_pack"
        app:layout_constraintStart_toEndOf="@id/workshop_image_starter_pack"
        app:layout_constraintTop_toTopOf="@id/workshop_image_starter_pack" />

    <!-- ROW 2 RIGHT -->
    <ImageView
        android:id="@+id/market_image_starter_pack"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="4.0dip"
        android:layout_marginTop="4.0dip"
        android:background="@drawable/object_border_dim_white"
        android:padding="4.0dip"
        android:src="@drawable/shop_1"
        app:layout_constraintStart_toEndOf="@id/separator_starter_pack"
        app:layout_constraintTop_toBottomOf="@id/tavern_image_starter_pack" />

    <TextView
        android:id="@+id/market_text_starter_pack"
        android:layout_width="0.0dip"
        android:layout_height="wrap_content"
        android:layout_marginStart="4.0dip"
        android:text="@string/shop_market_space"
        android:textSize="13.0sp"
        android:textStyle="bold"
        app:layout_constraintBottom_toBottomOf="@id/market_image_starter_pack"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toEndOf="@id/market_image_starter_pack"
        app:layout_constraintTop_toTopOf="@id/market_image_starter_pack" />

    <!-- Buy Button: Bottom Right, 140dp x 36dp -->
    <LinearLayout
        android:id="@+id/starter_pack_buy"
        android:layout_width="140.0dip"
        android:layout_height="36.0dip"
        android:layout_marginTop="8.0dip"
        android:background="@drawable/object_border_buy"
        android:gravity="center"
        android:orientation="horizontal"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toBottomOf="@id/market_image_starter_pack">

        <ImageView
            android:layout_width="22.0dip"
            android:layout_height="22.0dip"
            android:layout_marginEnd="4.0dip"
            android:src="@drawable/gem" />

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="500"
            android:textColor="@color/brass_filler"
            android:textSize="15.0sp"
            android:textStyle="bold" />
    </LinearLayout>

    <ImageView
        android:id="@+id/check_starter_pack"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@drawable/check_brass"
        android:visibility="gone"
        app:layout_constraintBottom_toBottomOf="@id/starter_pack_buy"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="@id/starter_pack_buy" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

---

### Archetype 3: Adventurer Roster Bundle
**Use Case**: Packs containing adventurers/heroes (e.g. Imperial Vanguard, Unholy Crusade, Primal Vanguard).  
**Vanilla Reference**: `constraint_imperial_vanguard`, `constraint_unholy_crusade`.

#### XML Rules:
1. Each adventurer is included via `<include layout="@layout/layout_adventurer" />`.
2. Each `<include>` has `android:layout_width="0.0dip"` spanning start to end of parent.
3. Subsequent adventurers have `android:layout_marginTop="4.0dip"`.
4. Below the adventurers, place any bonus items or Quarters space on the left, constrained to `app:layout_constraintEnd_toStartOf="@id/<pack>_buy"`.
5. The buy button is pinned to the bottom right.

```xml
<include
    android:id="@+id/imperial_vanguard_adventurer_1"
    layout="@layout/layout_adventurer"
    android:layout_width="0.0dip"
    android:layout_height="wrap_content"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toTopOf="parent" />

<include
    android:id="@+id/imperial_vanguard_adventurer_2"
    layout="@layout/layout_adventurer"
    android:layout_width="0.0dip"
    android:layout_height="wrap_content"
    android:layout_marginTop="4.0dip"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toBottomOf="@id/imperial_vanguard_adventurer_1" />
```

#### Kotlin Binding Rules (`populateAdventurer`):
When binding an adventurer inside a shop pack, you **MUST** hide all equipment slots, doctrine cards, and management buttons. Failing to hide these results in broken visual artifacts (such as empty gray gear boxes or delete icons):

```kotlin
private fun populateAdventurer(b: LayoutAdventurerBinding, adventurer: Adventurer) {
    val theme = context?.theme
    b.image.setImageDrawable(ResourcesCompat.getDrawable(resources, adventurer.imageId, theme))
    b.name.text = getString(adventurer.idName)
    b.traits.text = UIUtils.traitsToShortString(adventurer, resources)

    // MUST HIDE: All management and equipment views
    b.level.visibility = View.GONE
    b.cardView.visibility = View.GONE
    b.expendableDoctrinePoints.visibility = View.GONE
    b.weapon.visibility = View.GONE
    b.armor.visibility = View.GONE
    b.accessory.visibility = View.GONE
    b.arrowUp.visibility = View.GONE
    b.arrowDown.visibility = View.GONE
    b.delete.visibility = View.GONE

    // MUST ATTACH: Full adventurer detail modal on tap
    b.root.setOnClickListener {
        UIUtils.getAdventurerDetailDialog(parentFragmentManager, adventurer, false, false)
    }
}
```

---

### Archetype 4: Companion / Pet Bundle
**Use Case**: Pet packs with accompanying shelter space or consumables (e.g. Senko Pack).  
**Vanilla Reference**: `constraint_senko_pack`.

- **Pet Icon**: `48.0dip` × `48.0dip`, `background="@drawable/object_border_dim_white"`, `padding="4.0dip"`.
- **Pet Name**: `0.0dip` width, `marginStart="8.0dip"`, `textSize="15.0sp"`, bold, `textColor="@color/brass_filler"`.
- **Pet Description**: `0.0dip` width, `marginStart="8.0dip"`, `textSize="12.0sp"`, placed under the name.
- **Shelter Space / Bonus**: Placed under the pet icon, `marginTop="8.0dip"`.
- **Click Listener**: Tapping the pet icon opens `DialogPetDetail` with the preview pet instance.

---

### Archetype 5: Multi-Item / Reward Bundle
**Use Case**: Packs containing multiple items, potions, or materials (e.g. Converted Redeem Packs, Alchemist Bounty, Patrician Wardrobe).

> [!WARNING]
> **COMMON AI BUG**: Do NOT create a `wrap_content` horizontal `LinearLayout` where child `TextView`s have `android:layout_width="0.0dip"` without `android:layout_weight="1"`. This causes the text to collapse to 0 width on many Android devices!

#### Recommended XML Pattern (Vertical List of Items with Bottom-Right Buy Button):
```xml
<androidx.constraintlayout.widget.ConstraintLayout
    android:id="@+id/constraint_patrician_wardrobe"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_marginTop="4.0dip"
    android:background="@drawable/object_border_brass"
    android:padding="8.0dip">

    <!-- Column of Items: Spans from start to left of buy button -->
    <LinearLayout
        android:id="@+id/rows_patrician_wardrobe"
        android:layout_width="0.0dip"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toStartOf="@id/patrician_wardrobe_buy"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent">

        <!-- Item Row -->
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginBottom="6.0dip"
            android:gravity="center_vertical"
            android:orientation="horizontal">

            <ImageView
                android:id="@+id/patrician_wardrobe_r1_icon"
                android:layout_width="40.0dip"
                android:layout_height="40.0dip"
                android:background="@drawable/object_border_dim_white"
                android:padding="3.0dip"
                android:src="@drawable/patrician_armor" />

            <TextView
                android:id="@+id/patrician_wardrobe_r1_text"
                android:layout_width="0.0dip"
                android:layout_height="wrap_content"
                android:layout_marginStart="8.0dip"
                android:layout_weight="1"
                android:text="@string/armor_heavy_patrician_armor_name"
                android:textSize="12.0sp"
                android:textStyle="bold" />
        </LinearLayout>
        
        <!-- Additional item rows follow the same pattern -->
    </LinearLayout>

    <!-- Buy Button: Bottom Right, 140dp x 36dp -->
    <LinearLayout
        android:id="@+id/patrician_wardrobe_buy"
        android:layout_width="140.0dip"
        android:layout_height="36.0dip"
        android:background="@drawable/object_border_buy"
        android:gravity="center"
        android:orientation="horizontal"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent">

        <ImageView
            android:layout_width="22.0dip"
            android:layout_height="22.0dip"
            android:layout_marginEnd="4.0dip"
            android:src="@drawable/gem" />

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="300"
            android:textColor="@color/brass_filler"
            android:textSize="15.0sp"
            android:textStyle="bold" />
    </LinearLayout>

    <ImageView
        android:id="@+id/check_patrician_wardrobe"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@drawable/check_brass"
        android:visibility="gone"
        app:layout_constraintBottom_toBottomOf="@id/patrician_wardrobe_buy"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="@id/patrician_wardrobe_buy" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

---

## 5. Interaction & Detail Modals

Every visual element in a pack **must be interactive** so players know what they are purchasing:

1. **Items and Equipment**:
   ```kotlin
   b.myPackItemIcon.setOnClickListener {
       UIUtils.openItemDetail(Item.getInstance("ItemClassName"))
   }
   ```
2. **Adventurers**:
   ```kotlin
   adventurerBinding.root.setOnClickListener {
       UIUtils.getAdventurerDetailDialog(parentFragmentManager, adventurerInstance, false, false)
   }
   ```
3. **Pets**:
   ```kotlin
   b.myPackPetIcon.setOnClickListener {
       if (MainActivity.shownDialogPetDetail == null) {
           val dialog = DialogPetDetail()
           MainActivity.shownDialogPetDetail = dialog
           dialog.pet = petPreviewInstance
           dialog.show(parentFragmentManager, "pet_detail")
       }
   }
   ```

---

## 6. Kotlin Lifecycle in `DialogShop.kt`

When adding a new pack, update `DialogShop.kt` in exactly three places:

### Step 1: `initialize(arguments: Bundle?)`
Set preview hero/pet graphics, populate hero cards, and set formatted item count texts:
```kotlin
// Example: Adventurer preview
populateAdventurer(b.myPackAdventurer, myAdventurerPreview)

// Example: Formatted string text
b.myPackItemText.text = String.format(getString(R.string.shop_item_fourfold), getString(R.string.accessory_dreamcatcher_name))
```

### Step 2: `attachListeners()`
Hook up detail dialogs on icons and the purchase flow on the buy button:
```kotlin
// Detail click
b.myPackItemIcon.setOnClickListener { UIUtils.openItemDetail(Item.getInstance("MyItem")) }

// Purchase click
b.myPackBuy.setOnClickListener {
    confirmAndPurchase(getString(R.string.shop_title_my_pack), 500, MainActivity.data.isMyPackPurchased) {
        MainActivity.data.isMyPackPurchased = true
        Utils.collectItem(Item.getInstance("MyItem", 1), MainActivity.data.items)
        MainActivity.data.amountOfPurchases += 1
    }
}
```

### Step 3: `refresh()`
Add the pack to the `setPurchasedState` calls:
```kotlin
setPurchasedState(b.myPackBuy, b.checkMyPack, MainActivity.data.isMyPackPurchased)
```

---

## 7. DOs and DON'Ts Checklist

| Do | Don't |
| :--- | :--- |
| **DO** place the pack title `TextView` above and outside the card `ConstraintLayout`. | **DON'T** put the title inside the card border. |
| **DO** use `140.0dip` width and `36.0dip` height for the buy button. | **DON'T** use 42dp, wrap_content, or random heights for buy buttons. |
| **DO** use `@drawable/object_border_brass` for the card background. | **DON'T** use plain colors or `object_border_buy` for the card outline. |
| **DO** set `layout_weight="1"` when using `layout_width="0.0dip"` inside a `LinearLayout`. | **DON'T** use `0.0dip` without weight in `wrap_content` containers (text collapses). |
| **DO** hide all 9 equipment/doctrine views when reusing `layout_adventurer`. | **DON'T** leave empty equipment slots or delete buttons visible on shop heroes. |
| **DO** center the purchased checkmark exactly over the buy button (`check_brass`). | **DON'T** leave purchased packs without a checkmark or let the buy button stay active. |
| **DO** hook `UIUtils.openItemDetail(...)` on every item icon. | **DON'T** display unclickable item icons with no tooltips. |
| **DO** use `@color/brass_filler` for prices and active chip text. | **DON'T** use hardcoded yellow, orange, or white for currency text. |
