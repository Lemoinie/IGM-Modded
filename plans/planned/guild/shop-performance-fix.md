# Shop Performance Fix: RecyclerView Migration

## Goal Description

`DialogShop` currently inflates all pack cards simultaneously inside a `NestedScrollView`
(~246 views on open). Every field binding call, adventurer-preview draw, and text-set
runs synchronously on the main thread before the dialog becomes visible, causing a
noticeable stutter/delay on open.

The fix replaces the static `NestedScrollView` + flat XML card tree with a
`RecyclerView` + `ListAdapter`. Each pack becomes a lightweight `ShopItem` data class.
The `RecyclerView` inflates only the items visible on screen at open time (~5–8 cards
on a typical phone), deferring the rest until the user scrolls. Category filtering
(ALL / STARTER / ADVENTURERS / …) switches the submitted list, not the view hierarchy.

This is a **pure UI refactor** — zero changes to purchase logic, `Data.kt`, formulas,
or any other system.

---

## Open Questions

> [!IMPORTANT]
> **Adventurer preview cards** — the existing pack cards embed a full `LayoutAdventurerBinding`
> per adventurer (image, name, traits). The plan uses a dedicated `VIEW_TYPE_ADVENTURER_PACK`
> that inflates the same partial `layout_adventurer.xml` slots inside the card, bound
> lazily by the adapter. If you prefer to keep those three cards as fully static XML
> (not recycled), say so and they will use a separate fixed layout instead.

---

## Proposed Changes

### New Data Model

#### [NEW] `ShopItem.kt`
- Path: `app/src/main/kotlin/…/ui/dialogs/shop/ShopItem.kt`
- Sealed class:
  ```kotlin
  sealed class ShopItem {
      abstract val category: DialogShop.Category
      // Generic pack (title, description, price, buy/check, optional bonus item)
      data class Pack(...) : ShopItem()
      // Pack with embedded adventurer previews
      data class AdventurerPack(...) : ShopItem()
      // Pack with embedded pet preview
      data class CompanionPack(...) : ShopItem()
  }
  ```
- `isPurchased: () -> Boolean` and `onPurchase: () -> Unit` are lambdas that close
  over `MainActivity.data` — no logic moves out of `DialogShop`.

---

### Adapter

#### [NEW] `ShopAdapter.kt`
- Path: `app/src/main/kotlin/…/ui/dialogs/shop/ShopAdapter.kt`
- `ListAdapter<ShopItem, RecyclerView.ViewHolder>` with `DiffUtil.ItemCallback` keyed
  by `titleRes` (unique per pack).
- Three view types: `PACK`, `ADVENTURER_PACK`, `COMPANION_PACK`.
- `onBindViewHolder` sets title/body/price text, calls `setPurchasedState()`, wires
  the BUY button click → `onPurchaseClick(item)` callback from `DialogShop`.
- Adventurer slot binding reuses the same logic as the existing `populateAdventurer()`
  helper (extracted to a static utility or kept inline in the adapter).

---

### Layout

#### [DELETE] `dialog_shop.xml`
The current ~246-view flat layout is removed entirely.

#### [NEW] `dialog_shop.xml` (replacement — thin shell)
- `LinearLayout` root:
  - Title `TextView`
  - `HorizontalScrollView` containing the category chip row (same chip IDs/labels)
  - Gem balance row
  - `RecyclerView` (`id/shopRecyclerView`, `LinearLayoutManager`)
  - Close `Button`
- Total inflated views on open: ~15

#### [NEW] `layout_shop_item_pack.xml`
- Generic pack card: title, description body, gem-price badge, BUY button, ✓ checkmark,
  optional bonus-item `ImageView`.

#### [NEW] `layout_shop_item_adventurer_pack.xml`
- Extends the generic card with a horizontal strip of up to 4 adventurer slot includes
  (`layout_adventurer.xml` partials).

#### [NEW] `layout_shop_item_companion_pack.xml`
- Extends the generic card with a pet portrait `ImageView` and detail-click listener.

---

### Dialog Controller

#### [MODIFY] [DialogShop.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogShop.kt)
- Remove all `binding.xyzBuy.setOnClickListener` blocks (~20 listeners).
- Remove `populateAdventurer()` method (logic moves to `ShopAdapter`).
- `initialize()`:
  - Creates `ShopAdapter`, sets it on `binding.shopRecyclerView`.
  - Calls `buildShopItems()` → pure function returning `List<ShopItem>` for all packs.
  - Calls `filterAndSubmit(Category.ALL)`.
- `selectCategory(category)`:
  - Filters the cached master list.
  - Calls `adapter.submitList(filtered)` — DiffUtil diffs, no view creation.
- `refresh()`:
  - Re-submits filtered list to adapter (DiffUtil handles minimal redraws).
- `confirmAndPurchase()` — **unchanged**, stays as a private function; called via
  lambda stored in each `ShopItem`.
- `companion object` adventurer instances — **unchanged** (pre-built once at class
  load time, no regression).
- `Category` enum — **unchanged**.

---

### Package Structure

```
ui/dialogs/
├── shop/
│   ├── ShopItem.kt      ← new
│   └── ShopAdapter.kt   ← new
└── DialogShop.kt        ← modified
```

The `shop/` sub-package is justified: two new cohesive files scoped exclusively to
this dialog refactor; keeps `ui/dialogs/` from accumulating adapter classes.

---

### No Changes Required

| Component | Reason |
|-----------|--------|
| `Data.kt` | Pure UI refactor — no new fields |
| `Formulas.kt` | No formula changes |
| `strings.xml` | Existing string IDs reused as `titleRes`/`bodyRes` in `ShopItem` |
| `build.gradle.kts` | `RecyclerView` already on classpath via `androidx.recyclerview` |
| All purchase logic | Unchanged; moved into lambdas in `buildShopItems()` |

---

## Verification Plan

### Automated Tests
- `ShopReworkTest.kt` — add `testShopItemListCompleteness()`:
  - Instantiate `Data`, call `buildShopItems()`, assert every existing purchase
    flag has a corresponding `ShopItem` entry.
  - Ensures future pack additions don't silently miss a list entry.

### Manual Verification
1. Open Shop — should open with no perceptible stutter.
2. Tap each category chip — correct cards appear; others are gone.
3. Purchase one pack — gem balance decreases, checkmark appears, save writes.
4. Tap an adventurer preview card — `DialogEntityDetail` opens correctly.
5. Rotate device / re-open dialog — purchased packs still show checkmarks.

### Build Check
```powershell
.\gradlew.bat testDebugUnitTest
.\gradlew.bat assembleDebug
```
