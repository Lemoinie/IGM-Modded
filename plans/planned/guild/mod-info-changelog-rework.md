# Implementation Plan: ModChangelog & ModInfo UI Rework

## Goal Description
Refactor and modernize the mod's information and changelog architecture:
1. **Split `ModChangelog` for Maintainability**:
   - Break down the monolithic, 500-line string concatenation in [ModChangelog.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/ModChangelog.kt) into modular, era-based files.
   - Prevent approaching the JVM 64 KB method bytecode limit (`Method code too large`).
   - Separate active patch notes (`v1.3.x`) from historical archives (`v1.0.x` - `v1.2.x`).
2. **Upgrade the ModInfo Dialog UI**:
   - Replace the rudimentary programmatic text block in [DialogModAbout.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogModAbout.kt) with a dedicated XML layout ([`dialog_mod_info.xml`](file:///c:/Repositories/IGM-Modded/app/src/main/res/layout/dialog_mod_info.xml)) styled in the game's dark fantasy aesthetic.
   - Support multiple **Contributors** with structured roles, contribution descriptions, and badges.
   - Add a **Latest Version Highlights** preview card directly on the Mod Info screen so players immediately see recent additions.
   - Provide clean action buttons for "Full Changelog", "Support / Community", and "Close".

---

## 1. Architectural Design & Specifications

### 1.1 Changelog Modularization Strategy
To keep loading times instant (0ms runtime overhead) while making patch notes easy to manage, changelogs are split into clean files under `it.paranoidsquirrels.idleguildmaster.ui.dialogs.changelog`:

```text
app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/
├── ModChangelog.kt               (Facade: public API, combines active + archives, lazy parsing)
└── changelog/
    ├── ModChangelogActive.kt     (Active Era: v1.3.x entries - frequently updated)
    └── ModChangelogArchive.kt    (Historical Era: v1.0.x - v1.2.x - static archive)
```

- **`ModChangelog.kt` (Facade)**:
  Exposes the existing public contract (`allEntries()`, `latestEntry()`, `MOD_ABOUT_TEXT`) so no existing callers break.
  ```kotlin
  val MOD_ABOUT_TEXT: String by lazy {
      ModChangelogActive.TEXT + "\n\n" + ModChangelogArchive.TEXT
  }
  ```
- **Benefits**:
  - Developers only touch `ModChangelogActive.kt` when releasing new mod updates.
  - Historical entries remain immutable in `ModChangelogArchive.kt`.
  - Zero JVM 64 KB bytecode risk.
  - Zero loading latency: parsed only when opening the dialog (`by lazy`).

---

### 1.2 Contributor Data Model & Registry
Create a dedicated `ModContributors` registry allowing easy addition of contributors, modders, translators, and testers:

```kotlin
data class ModContributor(
    val name: String,
    val role: ContributorRole,
    val description: String,
    val github: String? = null
)

enum class ContributorRole(val title: String, val badgeColor: Int) {
    LEAD_DEV("Lead Developer", 0xFFFFD700.toInt()),       // Gold
    CORE_DEV("Core Developer", 0xFF00BFFF.toInt()),       // Light Blue
    CONTRIBUTOR("Contributor", 0xFF66BB6A.toInt()),       // Green
    SPECIAL_THANKS("Special Thanks", 0xFFBA68C8.toInt())  // Purple
}
```

#### Initial Registry (`ModContributors.kt`):
```kotlin
object ModContributors {
    val ALL: List<ModContributor> = listOf(
        ModContributor(
            name = "Lemoinie",
            role = ContributorRole.LEAD_DEV,
            description = "Mod creator, Kotlin reconstruction, combat systems & Auto-Raid architecture.",
            github = "Lemoinie"
        )
        // New contributors can be added here cleanly as 1 line
    )
}
```

---

### 1.3 Upgraded ModInfo Dialog Layout (`dialog_mod_info.xml`)
The new layout adopts the game's native dark-stone theme (`@drawable/dialog_border`, `@drawable/object_border_dim_white_square_no_border`):

```text
+-------------------------------------------------------+
|  [LOGO / ICON]   IGM-Modded                           |
|  Version: v1.3.13.6 (Modded Edition)                  |
+-------------------------------------------------------+
|  LATEST HIGHLIGHTS (v1.3.13.6)                        |
|  * Auto-Raid Report overhaul                          |
|  * Archmagus Valthex Blood Convocation tuning         |
+-------------------------------------------------------+
|  CONTRIBUTORS & CREDITS                               |
|  +-------------------------------------------------+  |
|  | [LEAD DEV] Lemoinie                             |  |
|  | Mod creator, Kotlin reconstruction & combat     |  |
|  +-------------------------------------------------+  |
|  | [CONTRIBUTOR] Name                              |  |
|  | Feature / translation details                   |  |
|  +-------------------------------------------------+  |
+-------------------------------------------------------+
|  [ VIEW FULL CHANGELOG ]      [ SUPPORT / KO-FI ]     |
|                                                       |
|                       [ CLOSE ]                       |
+-------------------------------------------------------+
```

1. **Header Card**:
   - Styled mod logo/title with version badge (`BuildConfig.VERSION_NAME`).
2. **Latest Highlights Card**:
   - Pulls the topmost version entry from `ModChangelog.latestEntry()` and renders the first 3 bullet points, letting players immediately see what's new.
3. **Contributors List**:
   - Scrollable card container with structured rows (`item_mod_contributor.xml`).
   - Colored role badge (`LEAD DEVELOPER`, `CONTRIBUTOR`, `SPECIAL THANKS`).
   - Contributor name and description text.
4. **Action Bar**:
   - **View Full Changelog** button: Opens the detailed version list browser ([`DialogModAbout.showChangelog()`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogModAbout.kt#L172)).
   - **Close** button.

---

## 2. Technical Implementation Steps

### 2.1 Changelog Splitting
1. **Create `app/src/main/kotlin/.../ui/dialogs/changelog/`**:
   - **[`ModChangelogActive.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/changelog/ModChangelogActive.kt)**: Contains all `1.3.x` entries (`1.3.0.0` through current `1.3.13.6`).
   - **[`ModChangelogArchive.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/changelog/ModChangelogArchive.kt)**: Contains historical `1.0.x`, `1.1.x`, and `1.2.x` entries.
2. **Refactor [`ModChangelog.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/ModChangelog.kt)**:
   - Concatenate active and archive strings lazily:
     ```kotlin
     val MOD_ABOUT_TEXT: String by lazy {
         ModChangelogActive.TEXT + "\n\n" + ModChangelogArchive.TEXT
     }
     ```
   - Add helper:
     ```kotlin
     @JvmStatic
     fun latestEntry(): VersionEntry? = allEntries().firstOrNull()
     ```

### 2.2 Contributor Data Model
1. **Create [`ModContributors.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/ModContributors.kt)**:
   - Define `ModContributor` and `ContributorRole`.
   - List initial contributors starting with Lemoinie.

### 2.3 XML Layouts
1. **Create [`dialog_mod_info.xml`](file:///c:/Repositories/IGM-Modded/app/src/main/res/layout/dialog_mod_info.xml)**:
   - Uses `ConstraintLayout` or `LinearLayout` inside `NestedScrollView`.
   - Includes containers for Title/Version, Latest Highlights, Contributors list (`LinearLayout`), and buttons.
2. **Create [`item_mod_contributor.xml`](file:///c:/Repositories/IGM-Modded/app/src/main/res/layout/item_mod_contributor.xml)**:
   - Background: `@drawable/object_border_dim_white_square_no_border`.
   - Role badge TextView (colored background or styled text).
   - Contributor name TextView (bold, white).
   - Contributor description TextView (dim white / muted gray).

### 2.4 Update [`DialogModAbout.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogModAbout.kt)
1. Replace programmatic `show(activity)` view construction with inflating `dialog_mod_info.xml`.
2. Populate:
   - Version text from `BuildConfig.VERSION_NAME`.
   - Highlights card from `ModChangelog.latestEntry()`.
   - Contributor cards dynamically from `ModContributors.ALL`.
   - Hook "View Full Changelog" to existing `showChangelog(activity)`.

---

## 3. Backward Compatibility & Stability Guarantees

1. **Zero External Breakage**:
   - `DialogModAbout.show(activity)` and `DialogModAbout.showChangelog(activity)` retain identical signatures called by [MainActivity.kt:551-555](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/MainActivity.kt#L551-L555).
   - `ModChangelog.allEntries()` and `ModChangelog.VersionEntry` remain identical.
2. **Performance**:
   - Dialog inflation takes $< 5\text{ms}$ on Android.
   - Changelog parsing remains `by lazy`, only loading into memory when viewing changelogs.
3. **Adding Future Contributors**:
   - Adding a contributor requires adding exactly one entry into `ModContributors.ALL`. The UI dynamically measures, formats, and renders the badge and card.

---

## 4. Verification Checklist

- [ ] `./gradlew compileDebugKotlin` builds cleanly with 0 errors.
- [ ] Navigation drawer $\rightarrow$ **Mod info** opens the new `dialog_mod_info.xml` layout.
- [ ] Header correctly reflects the active app version (`v1.3.13.6`).
- [ ] Latest Highlights card accurately renders recent patch notes.
- [ ] Contributor cards render with appropriate role badges and descriptions.
- [ ] Tapping "View Full Changelog" opens the version history list.
- [ ] Tapping any version row in the changelog opens the detailed bullet points dialog.
- [ ] Adding a new version to `ModChangelogActive.kt` automatically updates the latest highlights and version counter.
