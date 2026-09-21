# Shop Performance Fix: RecyclerView Migration

## Goal Description

`DialogShop` currently inflates all pack cards simultaneously across 5 modular sub-bundles (`shop_bundle_converted.xml`, `shop_bundle_equipment.xml`, `shop_bundle_infrastructure.xml`, `shop_bundle_storage.xml`, `shop_bundle_utility.xml`) inside a single `NestedScrollView`. 

With the recent shop expansions (40+ individual pack cards, 16 hero previews, 10 categories, dozens of potion/item rows), the shop layout now contains **over 600+ views** inflated and measured synchronously on the main thread every time the dialog opens. This causes an immediate, noticeable stutter/freeze upon opening the Shop.

The fix replaces the static `NestedScrollView` + flat XML card hierarchy with a high-performance **`RecyclerView`** using `ListAdapter` and `DiffUtil`.

### Core Benefits:
1. **Instant Dialog Open (Zero Lag)**: Only the ~4–6 cards visible on screen are inflated initially (~20 views vs 600+), eliminating open stutter.
2. **Smooth Category Filtering**: Tapping any of the 10 category chips filters the list in-memory via `DiffUtil` with buttery-smooth animations, without re-measuring 600+ views.
3. **100% Feature & Visual Parity**: Adheres strictly to [`docs/shop-ui-rules.md`](file:///C:/Repositories/IGM-Modded/docs/shop-ui-rules.md). All 120×32 buy buttons, brass borders, checkmarks, prices, and interactive detail popups remain identical.
4. **Preserved Click Interactions**: Every hero preview, item icon, and companion portrait remains fully clickable to open their detail dialogs.
5. **Pure UI Refactor**: Zero changes to purchase logic, `Data.kt`, formulas, or save formats.

---

## 1. Shop Item Data Model ([`ShopItem.kt`](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/shop/ShopItem.kt))

Create a sealed class hierarchy mapping to the 5 canonical pack archetypes defined in `docs/shop-ui-rules.md`:

```kotlin
package it.paranoidsquirrels.idleguildmaster.ui.dialogs.shop

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogShop

sealed class ShopItem {
    abstract val id: String
    abstract val titleRes: Int
    abstract val priceGems: Int
    abstract val category: DialogShop.Category
    abstract val isPurchased: () -> Boolean
    abstract val onPurchase: () -> Unit

    // Archetype 1: Single-Row Upgrade / Feature (Storage, Workshop, Merchant, Single Gear)
    data class SingleRow(
        override val id: String,
        @StringRes override val titleRes: Int,
        @StringRes val descriptionRes: Int,
        @DrawableRes val iconRes: Int,
        override val priceGems: Int,
        override val category: DialogShop.Category,
        val detailItem: Item? = null,
        override val isPurchased: () -> Boolean,
        override val onPurchase: () -> Unit
    ) : ShopItem()

    // Archetype 2: 2x2 Grid Multi-Feature Pack (Guild Initiate, Explorer's Cache)
    data class Grid(
        override val id: String,
        @StringRes override val titleRes: Int,
        val gridItems: List<GridEntry>,
        val bonusItem: Item? = null,
        @StringRes val bonusItemTextRes: Int? = null,
        override val priceGems: Int,
        override val category: DialogShop.Category,
        override val isPurchased: () -> Boolean,
        override val onPurchase: () -> Unit
    ) : ShopItem()

    // Archetype 3: Adventurer / Hero Pack (Imperial Vanguard, Unholy Crusade, Primal Vanguard, Divine Champion)
    data class AdventurerPack(
        override val id: String,
        @StringRes override val titleRes: Int,
        val adventurers: List<Adventurer>,
        val bonusItem: Item? = null,
        @StringRes val bonusItemTextRes: Int? = null,
        val extraItems: List<CountedItem> = emptyList(),
        override val priceGems: Int,
        override val category: DialogShop.Category,
        override val isPurchased: () -> Boolean,
        override val onPurchase: () -> Unit
    ) : ShopItem()

    // Archetype 4: Companion / Pet Pack (Senko Pet Pack)
    data class CompanionPack(
        override val id: String,
        @StringRes override val titleRes: Int,
        val pet: Pet,
        @StringRes val petDescriptionRes: Int,
        @StringRes val shelterTextRes: Int,
        override val priceGems: Int,
        override val category: DialogShop.Category,
        override val isPurchased: () -> Boolean,
        override val onPurchase: () -> Unit
    ) : ShopItem()

    // Archetype 5: Multi-Item / Reward Bundle (Patrician Wardrobe, Alchemist Bounty, Eternal Reliquary, Evolution Crate, etc.)
    data class RewardBundle(
        override val id: String,
        @StringRes override val titleRes: Int,
        val items: List<CountedItem>,
        override val priceGems: Int,
        override val category: DialogShop.Category,
        override val isPurchased: () -> Boolean,
        override val onPurchase: () -> Unit
    ) : ShopItem()

    data class GridEntry(
        @DrawableRes val iconRes: Int,
        @StringRes val textRes: Int
    )

    data class CountedItem(
        val item: Item,
        val count: Int,
        @StringRes val nameRes: Int
    )
}
```

---

## 2. Interactive Previews & Click Handlers

Every item, adventurer, and pet bound in the `RecyclerView` ViewHolders has its click listener wired immediately:

1. **Adventurers**:
   ```kotlin
   adventurerBinding.root.setOnClickListener {
       UIUtils.getAdventurerDetailDialog(parentFragmentManager, adventurer, false, false)
   }
   ```
2. **Items & Equipment**:
   ```kotlin
   itemView.setOnClickListener {
       UIUtils.openItemDetail(item)
   }
   ```
3. **Pets / Companions**:
   ```kotlin
   petImageView.setOnClickListener {
       if (MainActivity.shownDialogPetDetail == null) {
           val dialog = DialogPetDetail()
           MainActivity.shownDialogPetDetail = dialog
           dialog.pet = pet
           dialog.show(parentFragmentManager, "pet_detail")
       }
   }
   ```

---

## 3. UI Layout Architecture

### 3.1 Main Dialog ([`dialog_shop.xml`](file:///C:/Repositories/IGM-Modded/app/src/main/res/layout/dialog_shop.xml))
Replace the massive 600-view layout with a lightweight shell:
- Header: Title (`shop_title`), Close button, Gem balance container.
- Horizontal Category Chip ScrollView (10 chips):
  `ALL`, `STARTER`, `ADVENTURERS`, `COMPANIONS`, `MERCHANT`, `WORKSHOP`, `STORAGE`, `UTILITY`, `EQUIPMENT`, `INFRASTRUCTURE`.
- `RecyclerView` (`@+id/shop_recycler_view`):
  `layout_width="match_parent"`, `layout_height="0dp"`, `layout_weight="1"`.
  Configured with standard `LinearLayoutManager`.

### 3.2 Canonical Card Layouts
Create 5 reusable item layout templates matching [`docs/shop-ui-rules.md`](file:///C:/Repositories/IGM-Modded/docs/shop-ui-rules.md):
1. `layout_shop_item_single_row.xml`: Title TextView (outside) + Card ConstraintLayout (icon, title/description, 120×32 buy button, checkmark).
2. `layout_shop_item_grid.xml`: Title TextView (outside) + Card with 2×2 grid layout + optional bonus item + 120×32 buy button.
3. `layout_shop_item_adventurer.xml`: Title TextView (outside) + Card with up to 4 embedded `layout_adventurer` slots + optional bonus item + 120×32 buy button.
4. `layout_shop_item_companion.xml`: Title TextView (outside) + Card with pet portrait, pet name, traits/description, shelter text + 120×32 buy button.
5. `layout_shop_item_reward_bundle.xml`: Title TextView (outside) + Card with vertical LinearLayout of item rows + 120×32 buy button.

---

## 4. Adapter & Controller Implementation

### 4.1 `ShopAdapter.kt`
- Extends `ListAdapter<ShopItem, RecyclerView.ViewHolder>(ShopDiffCallback())`.
- `getItemViewType(position)`: Returns `VIEW_TYPE_SINGLE_ROW`, `VIEW_TYPE_GRID`, `VIEW_TYPE_ADVENTURER`, `VIEW_TYPE_COMPANION`, or `VIEW_TYPE_REWARD_BUNDLE`.
- `onCreateViewHolder()`: Inflates the corresponding card layout.
- `onBindViewHolder()`:
  - Sets pack title, icons, descriptions, and gem prices (`@color/brass_filler`).
  - Sets purchased state (disables button, shows `@drawable/check_brass` centered on button).
  - Wires detail clicks on icons/heroes.
  - Wires buy button click $\rightarrow$ triggers `confirmAndPurchase()` via lambda.

### 4.2 `DialogShop.kt` Refactor
- Remove the 20+ separate `xyzBuy.setOnClickListener` blocks.
- `initialize()`:
  - Setup `shopRecyclerView` with `ShopAdapter`.
  - `masterShopItems = buildShopItems()`: Instantiates the master list of `ShopItem`s once.
  - Setup category chip listeners.
  - Call `selectCategory(Category.ALL)`.
- `selectCategory(category)`:
  - Updates category chip drawables (active vs inactive token styles).
  - Filters `masterShopItems`:
    ```kotlin
    val filtered = if (category == Category.ALL) masterShopItems else masterShopItems.filter { it.category == category }
    shopAdapter.submitList(filtered)
    ```
- `refresh()`:
  - Re-checks purchased states and calls `shopAdapter.notifyDataSetChanged()` (or updates `ShopItem` states and re-submits).

---

## 5. Directory & Package Structure

```text
app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/
├── shop/
│   ├── ShopItem.kt           ← Sealed class data models & pack catalog
│   ├── ShopAdapter.kt        ← RecyclerView ListAdapter with 5 ViewHolder types
│   └── ShopDiffCallback.kt   ← DiffUtil item callback
└── DialogShop.kt             ← Lightweight dialog controller
```

---

## 6. Verification Plan

### Automated Tests
- Run `./gradlew testDebugUnitTest`.
- Update `ShopReworkTest.kt`:
  - Assert that `buildShopItems()` contains entries for every shop pack in `Data.kt`.
  - Assert category filtering returns the correct pack subsets.
  - Verify purchase flag checks match `Data` properties.

### Manual Verification
1. **Dialog Open Performance**:
   - Open Shop dialog $\rightarrow$ Verify it opens instantly without any stutter or frame drop.
2. **Category Navigation**:
   - Tap through all 10 chips (`ALL`, `STARTER`, `ADVENTURERS`, `COMPANIONS`, `MERCHANT`, `WORKSHOP`, `STORAGE`, `UTILITY`, `EQUIPMENT`, `INFRASTRUCTURE`).
   - Confirm appropriate cards display smoothly for each category.
3. **Click Interactions**:
   - Tap on an adventurer in an adventurer pack $\rightarrow$ Confirm `DialogEntityDetail` opens.
   - Tap on an item icon in a reward bundle / bonus item $\rightarrow$ Confirm `DialogItemDetail` opens.
   - Tap on Senko pet icon $\rightarrow$ Confirm `DialogPetDetail` opens.
4. **Purchase Flow & Persistence**:
   - Purchase an unbought pack $\rightarrow$ Confirm confirmation dialog, gem deduction, checkmark appearance, and inventory reward.
   - Close and re-open Shop $\rightarrow$ Confirm purchased state persists.
