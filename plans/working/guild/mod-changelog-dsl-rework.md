# Implementation Plan: Mod Changelog DSL Rework

## 1. Goal Description
Eliminate the tedious and error-prone string concatenation (`\n` and `+`) in mod changelogs.
Replace the raw string concatenation with a clean, expressive Kotlin DSL/list of `VersionEntry` items.

### Key Objectives:
1. **Developer Experience**:
   Adding a new changelog entry manually becomes as simple as writing:
   ```kotlin
   version("1.3.14.1", "26/9/2026",
       "First change description.",
       "Second change description."
   )
   ```
   No `\n`, no `+`, no escaping quotes for line endings, and no manual whitespace continuation headaches.
2. **Newest-First Ordering**:
   The active changelog file ([`ModChangelogActive.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/changelog/ModChangelogActive.kt)) lists entries **newest first** at the top. When releasing a new version, developers simply add their new entry at the top of the list.
3. **Zero Breakage & 100% Backward Compatibility**:
   - `ModChangelog.allEntries()` returns `List<VersionEntry>` with identical `entry.title` and `entry.body` properties.
   - `ModChangelog.latestEntry()` and `ModChangelog.parseVersionEntries()` remain functional.
   - `ModChangelog.MOD_ABOUT_TEXT` remains available.
   - [DialogModAbout.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogModAbout.kt) and [ModFeaturesTest.kt](file:///c:/Repositories/IGM-Modded/app/src/test/kotlin/it/paranoidsquirrels/idleguildmaster/ModFeaturesTest.kt) pass completely without changes or regressions.

---

## 2. Proposed Architecture & Design

### 2.1 `ModChangelog.VersionEntry`
Enhance `VersionEntry` to store structured fields while maintaining legacy getters:
```kotlin
class VersionEntry(
    val version: String,
    val date: String = "",
    val changes: List<String> = emptyList()
) {
    /** Compatibility constructor for legacy code/tests taking (title, body) */
    constructor(title: String, body: String) : this(
        version = if (title.contains(" ")) title.substringBefore(" ") else title,
        date = if (title.contains("(") && title.contains(")")) title.substringAfter("(").substringBefore(")") else "",
        changes = body.split("\n").map { it.trim().removePrefix("-").trim() }.filter { it.isNotEmpty() }
    )

    /** Backward-compatible title: "1.3.14.0 (25/9/2026)" or "1.3.14.0" */
    val title: String
        get() = if (date.isNotBlank()) "$version ($date)" else version

    /** Backward-compatible body: lines starting with "- " */
    val body: String
        get() = changes.joinToString("\n") { "- $it" }
}
```

### 2.2 Helper Function `version(...)`
Provide a clean builder function:
```kotlin
fun version(version: String, date: String = "", vararg changes: String): VersionEntry =
    VersionEntry(version, date, changes.map { it.trim().removePrefix("-").trim() }.filter { it.isNotEmpty() })
```

### 2.3 `ModChangelogActive.kt` & `ModChangelogArchive.kt`
Both files define `val ENTRIES: List<VersionEntry>` ordered newest-to-oldest.
- `ModChangelogActive.ENTRIES`: contains `1.3.14.0` down to `1.3.0.0`.
- `ModChangelogArchive.ENTRIES`: contains `1.2.0.0` down to `1.0.0.0`.
- `ModChangelog.allEntries()`: concatenates `ModChangelogActive.ENTRIES + ModChangelogArchive.ENTRIES`.

---

## 3. Verification Checklist

- [x] `ModChangelogActive.kt` converted to `val ENTRIES: List<VersionEntry>`.
- [x] `ModChangelogArchive.kt` converted to `val ENTRIES: List<VersionEntry>`.
- [x] `ModChangelog.kt` facade updated with `version(...)` helper and backward-compatible properties.
- [x] Gradle build succeeds (`./gradlew compileDebugKotlin`).
- [x] All unit tests pass (`./gradlew testDebugUnitTest`).
