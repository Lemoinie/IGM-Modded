# Implementation Plan - SemVer 3-Part Versioning Transition

Transition the mod's versioning scheme from 4-part (`1.3.7.1`) to industry-standard 3-part **Semantic Versioning (`Major.Minor.Patch` $\to$ `3.7.1`)**.

---

## Goal & Design Rationale

### 1. Eliminating the Redundant Leading `1.`
Across the entire lifespan of the project, the leading `1.` has never changed:
- `1.0.x.x`: Smali patching era
- `1.1.x.x`: Java bytecode injection era
- `1.3.x.x`: Native Kotlin reconstruction era

Dropping the leading `1.` promotes the **Architectural Era (`3`)** to the **Major Version**:

$$\mathbf{Major} \;.\; \mathbf{Minor} \;.\; \mathbf{Patch}$$

| Component | Meaning | Current Value | Next Milestone Example |
| :--- | :--- | :--- | :--- |
| **Major (`3`)** | **Engine / Architectural Era** (Era 3: Full Kotlin Reconstruction) | **`3`** | **`4`** (Endgame Expansion: Transcendence & Apotheosis) |
| **Minor (`7`)** | **Feature / System Release** | **`7`** | **`8`** (Black Market System) |
| **Patch (`1`)** | **Bug Fixes, Balance & UI Polish** | **`1`** | **`0`** (Reset on new minor) |

---

## User Review Required

> [!IMPORTANT]
> **Immediate Version Change**:
> - Current: **`1.3.7.1`**
> - New: **`3.7.1`**
> - Generated APK: `IdleGuildMaster_v2.148_mod_v3.7.1.apk`
> - In-Game `versionName`: `2.148-mod-3.7.1`

> [!NOTE]
> **Changelog History Preservation**:
> - Past entries in `ModChangelog.kt` (`1.0.0.0` through `1.3.7.0`) will remain untouched as authentic historical records.
> - The current `1.3.7.1` entry header will be updated to `3.7.1` with a note introducing SemVer.

---

## Proposed Changes

### Build Configuration

#### [MODIFY] [app/build.gradle.kts](file:///c:/Repositories/IGM-Modded/app/build.gradle.kts)
- Change line 8:
  ```kotlin
  val modVersion = "3.7.1"
  ```

---

### In-Game UI & Changelog

#### [MODIFY] [ModChangelog.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/ModChangelog.kt)
- Update the latest entry header:
  ```kotlin
  "3.7.1 (19/9/2026):\n" +
  "- Transitioned versioning scheme to 3-part SemVer (Major.Minor.Patch) starting at v3.7.1 (Era 3: Kotlin Reconstruction).\n" +
  "- The Shelter Effectiveness button no longer shows the purchase level...\n" +
  "- Fixed auto-feed long-press marking the wrong pet...\n"
  ```

---

### Documentation

#### [MODIFY] [docs/build-system.md](file:///c:/Repositories/IGM-Modded/docs/build-system.md)
- Update versioning section to document the `Major.Minor.Patch` SemVer scheme and the meaning of Era 3.

#### [MODIFY] [docs/development.md](file:///c:/Repositories/IGM-Modded/docs/development.md)
- Update version bump guidelines.

---

## Verification Plan

### Automated Tests
- Run Gradle unit tests to ensure zero regressions:
  ```powershell
  .\gradlew.bat testDebugUnitTest
  ```

### Build & Version Check
- Verify that Gradle evaluates `versionName` cleanly as `2.148-mod-3.7.1`:
  ```powershell
  .\gradlew.bat -q printVersion
  ```
- Inspect generated APK output filename.
