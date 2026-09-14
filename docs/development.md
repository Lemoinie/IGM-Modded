# Development Guide

This document explains how to work on the IGM Modded repository day to day. Read
[architecture.md](architecture.md) and [build-system.md](build-system.md) first; the
build and architecture details live there. Rules for organization (where files go,
script policy, repository hygiene) are enforced by `.agents/AGENTS.md` — every AI
agent and contributor must follow it.

## Prerequisites

- **JDK 21** (the Gradle/Java/Kotlin toolchain target).
- **Android SDK Platform 34** (compile/target SDK) — path configured in the
  machine-local `local.properties` (`sdk.dir=C:/Users/<you>/AppData/Local/Android/Sdk`).
- **Android Studio** (recommended, optional) or a terminal + `gradlew.bat`.
- **ADB** (`platform-tools`) only if deploying to a device/emulator.

Note: `local.properties` is gitignored and machine-specific. After cloning, create it
or open the project in Android Studio once so it generates one.

## Where Code Belongs

| Content                            | Location                                        |
| ---------------------------------- | ----------------------------------------------- |
| Game/data/model code               | `app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/` |
| Formulas, utilities, mod toggles   | `app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/` (`Formulas.kt`, `Utils.kt`, `UIUtils.kt`, `DebugToggles.kt`) |
| UI (fragments, dialogs, views)     | `app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/` |
| Layouts/drawables/strings          | `app/src/main/res/**`                            |
| JVM tests                          | `app/src/test/java/it/paranoidsquirrels/idleguildmaster/` |
| Dev scripts / tooling              | `scripts/` (see [scripts.md](scripts.md))        |
| Save editor (browser tool)         | `save_editor/`                                   |
| Documentation                      | `docs/`                                          |

## How to Add a New Feature

Follow the AGENTS.md "every new file needs a home" rule and reuse existing patterns.

### Example: a new dungeon

1. **Version bump** — raise `modVersion` in `app/build.gradle.kts`
   (e.g. `1.3.1.0`).
2. **Content class** — create `MyDungeon.kt` in
   `app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/dungeons/`
   extending `Area`, overriding the same hooks as an existing dungeon
   (`EnchantedForest.kt` is the best template): `getAreaType()`, `getName()`,
   `getSummaryDrawable()`, `getDetailDrawable()`, `getLayout()`, `rollEnemies()`,
   `performAction()`, `listAreasUnlocked()`, `listEnemies()`, and the merchant rolls.
3. **Persist it** — add to `Data.kt`:
   `@SerializedName("myDungeon") var myDungeon: MyDungeon? = MyDungeon()`.
4. **Register the UI list** — add the field to `Utils.compileDungeonList()` (or
   `compileRaidList()` for a raid).
5. **Layout + resources** — add a dungeon slot to `res/layout/layout_dungeon.xml`
   (or the area-holder layout used by the dungeons tab), a `summary_my_dungeon` /
   `area_my_dungeon` drawable, and string ids (`dungeon_name_my_dungeon`,
   `log_my_dungeon_*`, etc.) to `res/values/strings.xml` **plus every
   `values-<locale>/strings.xml` that contains related mod strings**.
6. **Test** — add a JUnit test to `app/src/test/.../FunctionalParityTest.java`
   (or a new test class) mirroring the existing 6 tests (e.g. assert the new area
   exists in `Data` and `listEnemies()` is non-empty).
## How to Modify Existing Behavior

1. **Find the authoritative class** — search `app/src/main/kotlin/` for the symbol
   (e.g. `getTavernCapacity` in `Formulas.kt`).
2. **Check vanilla parity first** — if the behavior is vanilla game logic, confirm
   you actually intend to change gameplay. For mods, prefer toggles in `DebugToggles`
   or intent-driven changes rather than silently altering vanilla formulas
   (see [vanilla-behavior.md](vanilla-behavior.md)).
3. **Edit the smallest surface** — patch the Kotlin class, add strings/drawables if
   needed, add/adjust a test, bump `modVersion`.
4. **Update docs** when the change affects architecture, save format, or known
   behavior.

## How to Investigate Vanilla Behavior

The Java baseline and reverse-engineering notes are the reference layer:

- `backup_java/` — the **decompiled/reconstructed Java baseline** (for parity
  questions, e.g. "did vanilla gating unlock at level 80?"). Read the Java there,
  port the exact logic if needed.
- `docs/reverse-engineering.md` — where the decompilation came from and its limits.
- `docs/vanilla-behavior.md` — verified quirks (loot caps, offline-idle cap, skill
  target modes, stat calculation hierarchy, ...).
- `docs/save-format.md` — on-disk JSON schema; `app/src/main/assets/manual_load.txt`
  is a real example save (used by `DebugToggles.LOAD_FROM_TEST_FILE`).
- The external read-only reference workspace `C:\Repositories\Idle Guild Master`
  (jadx output + pristine APK smali) is the ground truth for bytecode-level checks.

Never guess: if a value is uncertain, record it in `docs/known-uncertainties.md`
rather than inventing behavior.

## Tests

```powershell
# run JVM unit tests (~seconds, no device required)
.\gradlew.bat testDebugUnitTest

# view report
app\build\reports\tests\testDebugUnitTest\index.html
```

All tests are plain JUnit 4 in `app/src/test/java/...`. Add tests alongside every
feature; `FunctionalParityTest` covers the core headless loop.

## Builds & Deploy

```powershell
# debug APK
.\gradlew.bat assembleDebug

# full pipeline: test → build → install → launch on a connected device
.\scripts\build\build.ps1 -Test
# build only
.\scripts\build\build.ps1 -Test -NoDeploy
```

APK: `app/build/outputs/apk/debug/IdleGuildMaster_v2.148_mod_v1.3.0.0.apk`
(install directly with `adb install -r` if you prefer).

## Save-File Workflow (mod testing)

Saves are JSON. Pull a live save from a device, edit it locally, and push it back:

```powershell
.\scripts\save\save_manager.ps1 pull                 # device → save.json + backups/
.\scripts\save\save_manager.ps1 add-gems 50000       # edit + push
.\scripts\save\save_manager.ps1 push                 # push save.json → device
.\scripts\save\save_manager.ps1 unlock-all           # enable packs/capacity
```

- `save.json` at the repository root is the **local working save** (gitignored).
  Never share or commit it.
- `backups/` holds timestamped snapshots (gitignored).
- `scripts/save/update_save.py` adds pack characters/items to `save.json`
  (PowerShell `unlock-all` covers most of the same ground).
- `save_editor/index.html` is a self-contained browser editor for a save file
  (open the HTML file, drop a JSON save onto it, edit, export).

See [scripts.md](scripts.md) for full tool documentation.

## How to Update Documentation

- **Architecture changed** → update `docs/architecture.md`.
- **Build/flags/gradle changed** → update `docs/build-system.md`.
- **New discovery about the game** → `docs/vanilla-behavior.md`, `docs/reverse-engineering.md`, or `docs/known-uncertainties.md`.
- **Save keys/format changed** → `docs/save-format.md`.
- **New/removed asset or resource convention** → `docs/asset-mapping.md`.
- **New/removed script or tool** → `docs/scripts.md`.
- **General how-to** → this document.

Update the existing document rather than creating lookalike files.

## Definition of Done

- Code compiles (`assembleDebug`) and tests pass (`testDebugUnitTest`).
- New files are in the correct home (`.agents/AGENTS.md` decision table).
- No temporary/dump/generated files left in source dirs or the root.
- `modVersion` bumped for user-visible mod changes.
- Relevant docs updated; no duplicated documentation.
- `git status` shows only intentional changes.
7. **Build & verify** — `.\gradlew.bat testDebugUnitTest` then `assembleDebug`.

### Example: a mod cheat

1. Add a flag to `DebugToggles.kt`, e.g.
   `@JvmField val INSTANT_LEVEL_UP = true`.
2. Locate the behavior (e.g. the XP/level-up code) and branch on the flag.
3. Never ship debug-only behavior enabled by default unless intentionally so.

### Example: persisted setting

1. Add `@SerializedName("myFlag") var myFlag: Boolean = false` to `Data`.
2. If the field needs custom loading (legacy/migrated keys), touch
   `DataDeserializer.kt`; otherwise defaults + Gson serialization are enough.