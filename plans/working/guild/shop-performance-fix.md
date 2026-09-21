# Shop Performance Fix: Async Inflation

## Goal

DialogShop currently inflates all pack cards synchronously on the main thread
every time the dialog opens (~600+ views across 5 sub-bundle XMLs). This causes
a visible freeze/stutter on open.

**Constraint**: The existing XML layouts, visual design, and all click interactions
must remain 100% pixel-identical. No layout files are to be modified. No UI
redesign. No RecyclerView migration. The shop must look and behave exactly as it
does today — just open without lag.

---

## Root Cause

DialogShop.kt calls LayoutInflater.inflate(...) for all 5 sub-bundle XMLs
synchronously inside onCreateView / onViewCreated, blocking the main thread
until every view in every card is measured and attached. With 600+ views this
takes tens of milliseconds and causes a visible stutter.

---

## Proposed Fix: AsyncLayoutInflater

Use Android's built-in AsyncLayoutInflater to inflate the 5 sub-bundle XMLs
**on a background thread**, then attach each one to the scroll container on the
main thread as they complete — one at a time, in order.

This is a surgical, low-risk change:
- Zero XML layout changes
- Zero visual changes
- Zero purchase logic changes
- Minimal change surface in DialogShop.kt

### How it works

`kotlin
// In DialogShop.kt onViewCreated (or equivalent setup point)
val asyncInflater = AsyncLayoutInflater(requireContext())

// Inflate each bundle asynchronously; attach in order as they complete
asyncInflater.inflate(R.layout.shop_bundle_utility, shopContainer) { view, _, parent ->
    parent?.addView(view)
    bindUtilityBundle(view)   // same binding logic, just moved here
}
asyncInflater.inflate(R.layout.shop_bundle_equipment, shopContainer) { view, _, parent ->
    parent?.addView(view)
    bindEquipmentBundle(view)
}
// ... repeat for all 5 bundles
`

The dialog opens immediately with the header and scroll container visible.
Bundles appear in the scroll view as each finishes inflating (typically within
1–2 frames each). The user sees the shop open instantly.

### Binding functions

Each indXxxBundle(view: View) function is extracted from the existing inline
setup code in DialogShop.kt. It contains exactly the same logic — button
listeners, purchased state checks, click handlers — just moved into a named
function that receives the already-inflated view root.

No logic changes. No behavioural changes. Pure refactor of *when* inflation
happens, not *what* is inflated.

---

## Proposed Changes

### [MODIFY] DialogShop.kt

1. Replace synchronous inflate(...) calls with AsyncLayoutInflater calls
   inside onViewCreated.
2. Extract existing inline binding code into named indXxxBundle(view) private
   functions (one per sub-bundle) — same code, just in a named function.
3. Show a brief loading indicator (optional: existing spinner or simply nothing
   visible) while bundles are inflating. Since inflation is fast (~1–2 frames
   per bundle), this is usually imperceptible.

**Files changed**: DialogShop.kt only.  
**XML layouts changed**: none.  
**Data / logic changed**: none.

---

## What Is NOT Changing

- shop_bundle_utility.xml, shop_bundle_equipment.xml,
  shop_bundle_infrastructure.xml, shop_bundle_storage.xml,
  shop_bundle_converted.xml — untouched.
- dialog_shop.xml — untouched.
- All purchase logic, gem deduction, confirmation dialogs — untouched.
- All click handlers (item detail, adventurer detail, pet detail) — untouched.
- Data.kt, save format, DataDeserializer.kt — untouched.

---

## Verification Plan

### Build check
`
./gradlew assembleDebug
`

### Manual verification
1. Open Shop dialog → opens instantly, no stutter.
2. Scroll through all cards → identical to current layout.
3. Tap every buy button → confirmation dialog appears as before.
4. Tap an adventurer portrait → DialogEntityDetail opens.
5. Tap an item icon → DialogItemDetail opens.
6. Tap a pet portrait → DialogPetDetail opens.
7. Purchase a pack → checkmark appears, gem balance deducted, inventory updated.
8. Close and reopen → purchased states persist correctly.
