# Vietnamese Language Support Implementation Plan

## 1. Overview
Add full support for the **Vietnamese** language (`vi`) to Idle Guild Master, covering both the vanilla game systems and all mod-added features. This plan establishes the locale wiring in the settings spinner, runtime configuration, and an incremental translation strategy that guarantees zero crashes while translating the game.

---

## 2. Background & Architecture

### Current Locale System
- **Language Selection**: Handled in [`DialogSettings.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogSettings.kt) via a spinner bound to `R.array.drawer_settings_languages` in [`arrays.xml`](file:///c:/Repositories/IGM-Modded/app/src/main/res/values/arrays.xml).
- **Mapping**: Indices 0–11 map to language codes (`en`, `zh`, `fr`, `de`, `it`, `ja`, `ko`, `pl`, `pt`, `ru`, `es`, `th`).
- **Persistence**: Saved to `MainActivity.data.settingsLanguage` in `save.json`.
- **Runtime Application**: [`MainActivity.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/MainActivity.kt#L314-L319) reads `settingsLanguage`, builds a `Locale(lang)`, and applies it to `resources.configuration`.
- **Fallback Mechanism**: `res/values/strings.xml` is the base English fallback. Any key missing in a locale-specific `values-<lang>/strings.xml` automatically resolves to English.

### Current State of Vietnamese
- `res/values-vi/strings.xml` currently exists but contains only 139 lines of Android library/Google Play boilerplate strings.
- `Tiếng Việt` is not registered in `arrays.xml` or `DialogSettings.kt`.
- `<string name="language_code">vi</string>` is not yet defined in `res/values-vi/strings.xml`.

---

## 3. Scope of Changes

| File | Change Type | Purpose |
| --- | --- | --- |
| [`app/src/main/res/values/arrays.xml`](file:///c:/Repositories/IGM-Modded/app/src/main/res/values/arrays.xml) | Modify | Add `<item>Tiếng Việt</item>` as index 12 in `drawer_settings_languages` |
| [`app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogSettings.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogSettings.kt) | Modify | Register `map[12] = "vi"` in `languageMap` |
| [`app/src/main/res/values-vi/strings.xml`](file:///c:/Repositories/IGM-Modded/app/src/main/res/values-vi/strings.xml) | Modify | Add `language_code` and translated game/mod strings |
| [`app/src/test/kotlin/it/paranoidsquirrels/idleguildmaster/ModFeaturesTest.kt`](file:///c:/Repositories/IGM-Modded/app/src/test/kotlin/it/paranoidsquirrels/idleguildmaster/ModFeaturesTest.kt) | Modify | Add unit tests verifying index 12 and `"vi"` language mapping |

---

## 4. Implementation Steps

### Phase 1: Core Plumbing & Wiring (Zero-Risk Infrastructure)
1. **Update `arrays.xml`**:
   Add `<item>Tiếng Việt</item>` at index 12 of `drawer_settings_languages`:
   ```xml
   <item>Tiếng Việt</item>
   ```
2. **Update `DialogSettings.kt`**:
   In `initialize()`:
   ```kotlin
   map[12] = "vi"
   ```
3. **Add `language_code` to `res/values-vi/strings.xml`**:
   ```xml
   <string name="language_code">vi</string>
   ```
4. **Add Unit Test in `ModFeaturesTest.kt`**:
   Assert that `drawer_settings_languages` contains 13 items and index 12 corresponds to `"vi"`.

---

### Phase 2: Mod Content Translations (High Priority)
Because the modding project has added new systems, these strings must be translated into Vietnamese first so mod features are fully localized:

1. **Auto-Raid System**:
   - `auto_raid_title` -> `TỰ ĐỘNG ĐI RAID`
   - `auto_raid_start` -> `BẮT ĐẦU TỰ ĐỘNG`
   - `auto_raid_stop` -> `DỪNG TỰ ĐỘNG`
   - `auto_raid_badge` -> `TỰ ĐỘNG`
   - `auto_raid_runs` -> `%d Lượt`
   - `auto_raid_unlimited` -> `Không giới hạn`
   - `auto_raid_current_gems` -> `Gems hiện có: %d`
   - `auto_raid_cost_per_run` -> `Phí mỗi lượt: %d gems`
   - `auto_raid_affordable_runs` -> `Tối đa có thể đi: %d lượt`
   - `auto_raid_stop_on_wipe` -> `Dừng khi toàn đội ngã xuống:`
   - Auto-Raid report and log strings (`auto_raid_report_*`, `log_auto_raid_dispatch`).

2. **Status Effects Inspection Sheet**:
   - `btn_status_effects` -> `HIỆU ỨNG`
   - `status_effects_title` -> `Hiệu Ứng Trạng Thái`
   - `status_allies` -> `Đồng Minh`
   - `status_enemies` -> `Kẻ Địch`
   - `status_permanent` -> `Vĩnh viễn`
   - `status_turn_left` / `status_turns_left` -> `Còn 1 lượt` / `Còn %d lượt`
   - `status_by_cause` -> `bởi %s`

3. **Enemy Type System**:
   - `enemy_type_label` -> `Hệ: %s`
   - `enemy_type_humanoid`, `enemy_type_beast`, `enemy_type_undead`, `enemy_type_demon`, `enemy_type_dragon`, `enemy_type_slime`, `enemy_type_elemental`, `enemy_type_plant`, `enemy_type_construct`, `enemy_type_aberration` and their descriptions.

4. **Slumbering Shallows & Fishing Activity**:
   - `guild_slumbering_shallows_name` -> `Vùng Nước Trũng Ngái Ngủ`
   - Fishing fish enemies (`enemy_perch_*`, `enemy_blue_trout_*`, `enemy_angelfish_*`, `enemy_winged_ray_*`, `enemy_blue_shark_*`, `enemy_magma_shark_*`, `enemy_chorus_the_drowned_*`).
   - Pet fish foods (`food_perch_*`, etc.).

5. **Mod Items, Consumables & Traits**:
   - `trait_ruthless_plus_name` -> `Tàn Bạo+`
   - `consumable_evo22_vial_name` / `_description` (Evo-22 Vial)
   - `consumable_xp_book_*` (XP Books Tier 1, 2, 3, 10)
   - `weapon_sword_captains_sword_*` (Captain\'s Sword)
   - `weapon_bow_celestial_bow_*` (Celestial Bow)
   - Pets: `pet_senko_*`, `pet_kitsune_*`, `pet_phoenix_*`.

6. **Mod Info & Navigation**:
   - `drawer_mod_info_title` -> `Thông Tin Mod`
   - `drawer_changelog_title` -> `Nhật Ký Cập Nhật`
   - `drawer_mod_about_title` -> `Thông Tin Mod / Cập Nhật`

---

### Phase 3: Core UI, Navigation & Dialogs
Translate the primary UI elements so the entire app structure is in Vietnamese:
- Navigation tabs: Guild, Adventurers, Dungeons, Raids, Guild Activities.
- Common actions: YES, NO, CONFIRM, CANCEL, RETREAT, UPGRADE, BUY, SELL, CRAFT, CLAIM.
- Settings dialog options: Max Sell Amount, Max Craft Amount, Confirm Upgrades, Confirm Retreat, Swap Equipment, Auto-Open Dungeon Detail, Verbose Logs, Colorblind Mode.
- Combat log indicators and battle status prompts.

---

### Phase 4: Full Game Content (Items, Units, Classes, Dungeons)
Translate remaining content in organized batches:
1. Adventurer classes and active/passive skills.
2. Materials, weapons, armors, accessories, and crafting recipes.
3. Dungeons, raids, enemy units, and dungeon encounter texts.

---

## 5. Handling Mod Content Across Old Localizations (`zh`, `ru`, `de`, `fr`, etc.)

To solve the issue where players in other languages see English mod strings:
1. **String Inventory**: Compile a single reference list of all ~150 mod-added string keys from lines 3880–4712 of [`res/values/strings.xml`](file:///c:/Repositories/IGM-Modded/app/src/main/res/values/strings.xml).
2. **Translation Injection**: For any target language (e.g. Chinese `values-zh/strings.xml`, Russian `values-ru/strings.xml`), append those ~150 translated keys.
3. **Hardcoded Code Strings**: For `ModChangelogActive.kt` and `ModContributors.kt`, evaluate whether to keep changelogs in English (industry norm for mods) or extract user-facing strings into resource strings if multi-language changelog support is desired.

---

## 6. Verification Plan

### Automated Tests
Run unit tests:
```powershell
./gradlew testDebugUnitTest
```
Assert that:
1. `drawer_settings_languages` has length 13 and index 12 is `"Tiếng Việt"`.
2. Language index 12 maps to `"vi"`.
3. `values-vi/strings.xml` contains valid XML and parses correctly.

### Build Verification
```powershell
./gradlew assembleDebug
```
Ensure resource compilation passes without duplicate keys or XML syntax errors.

### Manual Verification
1. Launch app on device / emulator.
2. Open Navigation Drawer -> Settings (`Cài đặt`).
3. Select `Tiếng Việt` from the language dropdown.
4. Tap confirm (`Xong` / `Lưu`).
5. Verify:
   - App restarts with Vietnamese locale active.
   - Re-opening Settings shows `Tiếng Việt` correctly selected.
   - Navigation tabs, Auto-Raid button, and status effects display translated text.
   - Any untranslated strings safely display English without missing text or crashes.
