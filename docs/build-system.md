# Build System

## Overview

The project is a standard **Android Gradle** setup using the **Kotlin DSL**
(`build.gradle.kts`). Gradle **8.9** (wrapper in `gradle/wrapper/`), Android Gradle
Plugin **8.5.2**, Kotlin **1.9.24**, JDK **21** toolchain. Windows is the primary
environment (`gradlew.bat`).

## Project Structure

```text
build.gradle.kts        Root: declares plugin versions only (apply false)
settings.gradle.kts     Repositories + module list (include(":app"))
gradle.properties       Global Gradle/Android flags (see below)
local.properties        Machine-local SDK path (gitignored; not committed)
gradlew / gradlew.bat   Wrapper launchers
app/
├── build.gradle.kts    Module build script (real build logic)
├── proguard-rules.pro  Release shrinking rules (unused: minify disabled)
└── build/              Generated output (gitignored)
```

## Key Configuration (app/build.gradle.kts)

| Setting            | Value                                              |
| ------------------ | -------------------------------------------------- |
| namespace          | `it.paranoidsquirrels.idleguildmaster`             |
| applicationId      | `it.paranoidsquirrels.idleguildmaster.rebuilt`     |
| compileSdk         | `34`                                               |
| minSdk             | `26`                                               |
| targetSdk          | `34`                                               |
| versionCode        | `162`                                              |
| versionName        | `2.148-mod-1.3.13.10` (gameVersion-mod-modVersion) |
| Java/Kotlin target | `21` (jvmTarget = 21)                              |
| build features     | `dataBinding`, `viewBinding`, `buildConfig`        |
| minify             | disabled (debug & release)                          |
| source sets        | `src/main/java` + `src/main/kotlin` (java tree unused) |
| APK names          | `${gameName}_v${gameVersion}_mod_v${modVersion}-dev.apk`<br>`${gameName}_v${gameVersion}_mod_v${modVersion}-release.apk` |

Version branding is driven by three values at the top of `app/build.gradle.kts`:

```kotlin
val gameName = "IdleGuildMaster"   // base game name
val gameVersion = "2.148"          // vanilla version the reconstruction targets
val modVersion = "1.3.13.10"       // mod version — bump for every mod release
```

## Root Configuration

- `build.gradle.kts` — only plugin declarations (`com.android.application` and
  `org.jetbrains.kotlin.android`) with `apply false`. Do not add project logic here.
- `settings.gradle.kts` — repositories: `google()`, `mavenCentral()`,
  `gradlePluginPortal()`, plus `jitpack.io` (TrueTime dependency). Module list:
  `include(":app")`.
- `gradle.properties`
  - `org.gradle.jvmargs=-Xmx4g -Dfile.encoding=UTF-8`
  - `android.useAndroidX=true`
  - `android.enableJetifier=false`
  - `android.nonTransitiveRClass=false` (generates a merged `R` class)
  - `android.suppressUnsupportedCompileSdk=35` (SDK 35 may be installed locally;
    the build currently compiles against 34)
- `local.properties` — holds `sdk.dir` locally. **Never commit.** It is already
  gitignored. Each developer needs their own SDK path here.
## Important Gradle Tasks

Run from the repository root:

```powershell
.\gradlew.bat -p c:\Repositories\IGM-Modded <task>
```

| Task                     | Purpose                                                        |
| ------------------------ | ------------------------------------------------------------- |
| `assembleDebug`          | Build the **Dev APK** (`-dev.apk`, `BuildConfig.DEBUG = true`) |
| `assembleRelease`        | Build the **Release APK** (`-release.apk`, `BuildConfig.DEBUG = false`) |
| `testDebugUnitTest`      | Run the JVM unit test suite (`FunctionalParityTest`)           |
| `clean`                  | Delete `app/build/` generated output                          |
| `build`                  | Assemble + run checks/tests (everything)                       |
| `installDebug`           | Build and install Dev APK to a connected device                |
| `compileDebugKotlin`     | Fast Kotlin-only compile check                                 |

### Dev vs Release Builds

1. **Dev Build (`debug`)**:
   - APK output: `app/build/outputs/apk/debug/IdleGuildMaster_v2.148_mod_v1.3.8.3-dev.apk`
   - `BuildConfig.DEBUG == true`
   - Developer cheat redeem codes (`GOLD`, `BLACK`, `ITEM`, `HERO`, `PET`, `REROLL`, `SHOP`, `QUEST`, `STORAGE`, `IDLETIME`, `LOOTCAP`, `KILLS`, `SETKILLS`) are **enabled**.
   - Deployed automatically by `scripts/build/build.ps1`.
2. **Release Build (`release`)**:
   - APK output: `app/build/outputs/apk/release/IdleGuildMaster_v2.148_mod_v1.3.8.3-release.apk`
   - `BuildConfig.DEBUG == false`
   - Developer cheat redeem codes are **blocked** (`"Dev commands are only available in Dev builds."`).
   - Signed with debug keystore (`signingConfig = signingConfigs.getByName("debug")`) for instant, error-free local installation.
   - Legitimate player reward codes (e.g. `Z3GAAZRT`) and vanilla codes remain functional.

## APK Location

After running `.\scripts\build\build.ps1` (or `gradlew assembleDebug assembleRelease`):

```text
app/build/outputs/apk/debug/IdleGuildMaster_v2.148_mod_v1.3.8.3-dev.apk
app/build/outputs/apk/release/IdleGuildMaster_v2.148_mod_v1.3.8.3-release.apk
```

The filenames are produced by the `applicationVariants.all` rename block in
`app/build.gradle.kts`. **Do not** git-commit APKs (`*.apk` is gitignored).

## Test Commands

```powershell
# whole suite
.\gradlew.bat testDebugUnitTest

# with an attached device: full build → install → launch (wrapper script)
.\scripts\build\build.ps1 -Test -NoDeploy        # build + test only
.\scripts\build\build.ps1 -Test                  # build + test + deploy
```

Unit test report: `app/build/reports/tests/testDebugUnitTest/index.html`

## SOURCE vs GENERATED OUTPUT

| Path                        | Kind      | Description                                                     |
| --------------------------- | --------- | --------------------------------------------------------------- |
| `app/src/main/kotlin/`      | SOURCE    | All application code (edit this)                                |
| `app/src/main/res/`, `assets/`, `AndroidManifest.xml` | SOURCE | Resources & manifest (edit these)                  |
| `app/src/test/`             | SOURCE    | Unit tests (edit these)                                         |
| `app/build/`                | GENERATED | DataBinding classes, `R`, compiled classes, intermediates, reports, APKs — delete/recreate freely, never edit |
| `.gradle/`                  | GENERATED | Gradle caches (wrapper, file hashes). Should not be committed   |
| `app/src/main/java/`        | LEGACY    | Empty directories retained from the Java baseline; not build input content |

> `R` and every `*Binding` class referenced from Kotlin are **generated** by the build
> from `res/` XML. To change them, edit the XML resource/layout and rebuild — never
> edit the generated `.java`/`.class`.

## What To Edit / Not Edit

**Edit (source):** Kotlin under `app/src/main/kotlin/`, resources under
`app/src/main/res/`, manifest, tests, Gradle scripts when configuration truly changes.

**Do not edit:** anything under `app/build/` or `.gradle/`; generated DataBinding/`R`
sources; APK outputs. Regenerate instead.

## Gitignore Contracts

`.gitignore` already excludes the standard generated paths. Do **not** force-add
generated content:

```text
.gradle/
app/build/
/build
*.apk
*.aab
local.properties
save.json
save.json.tmp
backups/
```

`save.json`, `backups/`, and `save.json.tmp` are **local save-workflow artifacts**
(pulled from a device by `scripts/save/save_manager.ps1`); they must stay untracked.

## Common Pitfalls

- Running Gradle from a path other than the module root: always pass
  `-p <repo-root>` or run inside the repo root.
- Editing generated bindings in `app/build/**` — changes vanish on next build and
  are never committed.
- Adding a string only to `values/strings.xml` but not translated `values-*/`: AGP
  does not fail, but non-English devices may fall back unexpectedly. The repo mirrors
  ~130 locales, so add the key to every `values-*/strings.xml` that already defines
  `app_name`-style mod keys.
- Bumping `compileSdk`/`targetSdk` beyond what the dependencies support can break the
  build; when SDK 35 is enabled the `android.suppressUnsupportedCompileSdk=35` hint in
  `gradle.properties` is what currently allows builds with a newer local SDK.

## Dependencies (app/build.gradle.kts)

- **AndroidX / Material** — appcompat, core-ktx, constraintlayout, drawerlayout,
  recyclerview, cardview, viewpager2, navigation, room-runtime, work-runtime, lifecycle
- **JSON** — Gson 2.10.1 (primary save serialization), Jackson (databind/core)
- **Networking/utilities** — RxJava 3, TrueTime (NTP), Guava
- **Play services** — billing 7.1.1, play-services-ads, play-services-games-v2,
  in-app review
- **Testing** — JUnit 4 (`testImplementation`)

Do **not** add dependencies casually; the dependency list is intentionally locked to
reproduce the vanilla APK surface (plus the mod layer).