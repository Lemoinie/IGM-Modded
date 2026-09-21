# Ko-fi Donate Button (Nav Drawer)

Add a "Support / Ko-fi" entry to the navigation drawer that opens the project's
Ko-fi page in the device browser. Follows the exact same pattern as the existing
Reddit and Cafe Naver drawer items.

---

## Scope

| File | Change |
|------|--------|
| pp/src/main/res/menu/drawer_nav_menu.xml | Add new group + menu item |
| pp/src/main/res/values/strings.xml | Add title string |
| pp/src/main/res/drawable/drawer_icon_donate.xml / .png | Add icon |
| pp/src/main/res/values/ids.xml (or generated) | Add @+id/donate |
| pp/src/main/kotlin/.../MainActivity.kt | Add click handler |

Zero logic changes. Zero data changes. Zero new classes.

---

## Proposed Changes

### [MODIFY] drawer_nav_menu.xml

Add a new group after group12 (Changelog), before the closing </menu> tag:

`xml
<group android:id="@+id/group13" android:checkableBehavior="none">
    <item
        android:icon="@drawable/drawer_icon_donate"
        android:id="@+id/donate"
        android:title="@string/drawer_donate_title" />
</group>
`

Placement: at the bottom of the drawer, below Changelog.

---

### [MODIFY] strings.xml

Add one string near the other drawer title strings:

`xml
<string name="drawer_donate_title">Support on Ko-fi</string>
`

---

### [NEW] Donate icon drawable

Two options — choose one:

**Option A (vector, recommended):** Create
pp/src/main/res/drawable/drawer_icon_donate.xml using a simple heart or
coffee-cup vector path matching the style of other drawer icons (white, ~24dp).

**Option B (PNG):** Use a 24dp white Ko-fi logo exported at mdpi/hdpi/xhdpi/xxhdpi.

Either option: icon must match the existing drawer icon style (white, ~24×24dp).

---

### [MODIFY] MainActivity.kt

Add the click handler alongside the reddit / cafe_naver handlers (around line 558):

`kotlin
binding.navViewDrawer.menu.findItem(R.id.donate)?.setOnMenuItemClickListener {
    try {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://ko-fi.com/YOURNAME")))
    } catch (_: ActivityNotFoundException) {
        Toast.makeText(this, R.string.drawer_toast_no_browser, Toast.LENGTH_LONG).show()
    }
    true
}
`

Replace YOURNAME with your actual Ko-fi username before implementing.

---

## Open Questions

- **Ko-fi username**: What is (or will be) your Ko-fi profile URL?
  Provide it before implementation so the URL is correct from the start.
- **Icon style**: Vector heart/coffee icon, or the official Ko-fi logo PNG?

---

## Verification Plan

`
./gradlew assembleDebug
`

Manual checks:
1. Open nav drawer → "Support on Ko-fi" appears at the bottom.
2. Tap it → Ko-fi page opens in browser.
3. No browser installed → Toast "No browser found" appears (reuses existing string).
4. All other drawer items still work normally.
