# Project Architecture

## Overview

This repository is a from-scratch, 100% Kotlin **reconstruction** of the Android game
*Idle Guild Master* (vanilla v2.148), rebuilt as a modern Android project and extended
with a mod layer. The production source is Kotlin under `app/src/main/kotlin/`; the
`app/src/main/java/` tree is empty (legacy directories retained only as scaffolding).

The project intentionally preserves *vanilla gameplay parity* — the reconstructed game
is meant to behave exactly like the original — while the *mod* adds branding, cheat
toggles, and save tooling on top.

## Repository Layout (high level)

```text
/
├── .agents/AGENTS.md       Rules for AI-assisted development (mandatory reading)
├── app/                    Single Android application module
│   ├── src/main/kotlin/    All application source (Kotlin)
│   ├── src/main/res/       Android resource tree (layouts, drawables, strings, assets)
│   ├── src/main/assets/    Non-Android assets (manual_load.txt test save, dexopt)
│   ├── src/test/java/      JVM unit/integration tests
│   └── build/              Gradle generated output (never edit)
├── docs/                   Project documentation
├── scripts/                Reusable development tooling (build, save, tools)
├── save_editor/            Standalone browser-based save-file editor
├── build.gradle.kts        Root Gradle (plugin versions)
├── settings.gradle.kts     Gradle multi-module setup
├── gradle.properties       Gradle/Android configuration
├── implementation_plan.md  Migration/feature plan
└── README.md
```

## Application Module Layout

Source root: `app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/`

```text
it.paranoidsquirrels.idleguildmaster/
├── MainActivity.kt          App entry point and global hub (see below)
├── Formulas.kt              Pure game-economy/formula object (@JvmStatic)
├── Utils.kt                 Large shared utility object (@JvmStatic)
├── UIUtils.kt               UI helper object (dialogs, palettes, click handling)
├── AchievementsUtils.kt     Achievement definitions and unlock logic
├── TrueTimeUtils.kt         NTP/TrueTime helpers for offline-idle timestamps
├── DebugToggles.kt          ★ MOD layer: compile-time cheat/feature flags
├── IAPWrapper.kt            In-app-purchase wrapper (stubbed, hidden from UI)
├── Faq.kt / KingMessage.kt  Resource-backed enums (title/body string ids)
│
├── game/
│   └── redeem/
│       └── RedeemCodes.kt   Native redeem-code console (items/heroes/pets, caps, toggles)
│
├── storage/
│   ├── FileManager.kt       Low-level save file I/O (data.txt / databackup.txt)
│   ├── SaveManager.kt       Periodic autosave singleton
│   └── data/
│       ├── Data.kt          ★ Single save-state class (one flat JSON document)
│       ├── DataDeserializer.kt  Gson type adapter: tolerant save loader
│       ├── SnapshotData.kt
│       ├── entities/
│       │   ├── Entity.kt    Base combat entity (HP, mana, stats, status effects)
│       │   ├── Skills.kt    Skill enum (100+ skills)
│       │   ├── StatusEffect( Type ).kt
│       │   ├── adventurers/ Adventurer.kt, Trait.kt, PotionsDrank.kt,
│       │   │                doctrines/ (base + instances/), units/ (per-class)
│       │   └── enemies/     Enemy.kt + units/ (per-enemy subclass)
│       ├── items/           Item.kt + abstractClasses/ + instances/ (per-item subclass)
│       ├── pets/            Pet.kt + abstractClasses/ + instances/
│       ├── places/
│       │   ├── Area.kt      ★ Abstract dungeon/raid base (combat loop, cast(), events)
│       │   ├── Action.kt / Event.kt / AdventureRecap.kt / Logger
│       │   ├── dungeons/    11 dungeon subclasses
│       │   └── raids/       12 raid subclasses
│       └── quests/          QuestsManager.kt + instances/
│
└── ui/                      View-layer (AndroidX DataBinding fragments/dialogs)
    ├── adventurers/  AdventurersFragment.kt (+ per-adventurer item layouts)
    ├── headquarters/ HeadquartersFragment.kt
    ├── dungeons/     DungeonsFragment.kt
    ├── raids/        RaidsFragment.kt
    ├── components/   Shared/custom views
    └── dialogs/      Dialog*.kt (~40 dialogs), plus DialogModAbout + ModChangelog
```

## Major Systems

### 1. MainActivity — global hub
`MainActivity` (singleton-style via a `companion object`) holds process-wide state:
`MainActivity.data` (the live `Data` instance), the four `*Fragment` instances, and
`shownDialog*` guards that prevent duplicate dialogs. Fragments are AndroidX
`Fragment`s inflated from layout XML via generated DataBinding classes.

### 2. Data / save system
`storage.data.Data` is a **single flat class** whose fields are the whole save game.
Every persisted field carries a `@SerializedName("...")` matching the on-disk key.
Serialization is Gson (`setPrettyPrinting`) with a custom `DataDeserializer` Gson
type adapter that tolerantly reads known keys (unknown/legacy keys are ignored and
missing keys take class defaults). `FileManager` alternates between `data.txt` and
`databackup.txt` on the device (in `<app-data>/files/`); `SaveManager` autosaves on
a timer. There is **no explicit `save_version` field** — compatibility is maintained
by the tolerant loader. See [save-format.md](save-format.md).

### 3. Areas: dungeons & raids
`places.Area` is the abstract base of all explorable content. Each dungeon/raid is a
concrete subclass overriding hooks:
`getAreaType()`, `getDarkness()`, `getName()`, `getSummaryDrawable()`,
`getDetailDrawable()`, `getLayout()` (generated layout binding), `rollEnemies()`,
`performAction(action, event)`, `listAreasUnlocked()`, `listEnemies()`,
`rollMerchantRegularOffers()`, `rollMerchantSpecialOffers()`.

`Area` also contains the reconstructed combat engine: `tick()`, `setupAdventurers()`,
`dealDamage()`, and the famous `cast(Entity)` skill dispatcher
(100 packed-switch cases mapping `Skills` ordinal → execution logic with a fluent
`Area.Skill` builder).

**Registration points** — new content must be added in two places:
- a field + getter in `Data` (persisted, e.g. `@SerializedName("myArea") var myArea: MyArea? = MyArea()`),
- an entry in `Utils.compileDungeonList()` (11 dungeons) or `Utils.compileRaidList()` (12 raids).

### 4. Combat entities
`entities.Entity` is the base for both `Adventurer` and `Enemy` (HP/mana/stats,
status-effect lists, `dealDamage()` integration). Like the vanilla game, every
concrete type is its own class: `units/Footman.kt`, `units/Paladin.kt`,
`enemies/units/Wolf.kt`, etc. — there are **no data-driven config tables**.
Instantiation is via `Adventurer.getInstance("ClassName", ...)` /
`Enemy.getInstance("ClassName")` static factories.

### 5. Economy / formulas
`Formulas` is a stateless Kotlin object with `@JvmStatic` helpers (quarters price,
tavern/storage/shelter capacity, level-up curves). `Utils` holds the remaining
globally shared helpers (dice rolls, dungeon/raid lists, tavern adventurer rolling,
item collection, etc.).

### 6. UI layer
The view layer is AndroidX Fragment/Activity + DataBinding:
- Layouts are XML in `app/src/main/res/layout*/`; the build generates
  `ActivityMainBinding`, `Fragment*Binding`, `Layout*Binding`, `Dialog*Binding`
  classes (do **not** edit generated classes — edit the XML).
- `R` (resource ids: `R.string.*`, `R.drawable.*`, `R.color.*`, `R.id.*`) is
  generated from the resource tree during the build.
- Fragments use `LayoutDungeonBinding` per area for the dungeon/raid tabs.

## Mod-Specific Code

Mod features are implemented as **native game code** in the source tree rather than
injected patches. The remaining "mod-specific" surface is thin and clearly located:

- **Redeem-code console** — `game/redeem/RedeemCodes.kt` services the in-game
  Redeem Code dialog (`ui/dialogs/DialogRedeemCode.kt`) with `GOLD`, `STORAGE`,
  `IDLETIME`, `LOOTCAP`, `SHOP`, `QUEST`, `KILLS`, `SETKILLS`, `ITEM`, `HERO`, and
  `PET` commands; each command mutates live `Data` and persists via
  `FileManager.saveNow(...)`.
- **Guild Activities** — Daily Request (`GuildRequestArea`) and Weekly Siege
  (`GuildSiegeArea`) are real raid areas under `storage/data/places/raids/`, driven
  by `game/activities/GuildActivitiesManager.kt` + `GuildActivitiesState.kt`
  (boundaries/status/rewards, hooked into `Utils.tick24Hours/tickWeek/refreshCooldowns`).
  Shadow's loot drops a Geode with a preset gem yield (10%/20%/70% → 100/50/20).
- **Progression overrides** — `Data` carries the mod's persisted tuning knobs
  (`imperialKills`, `idleTimeCapHours`, `lootCap`) which are consumed by normal game
  systems: `TheGoldenCity` (Imperial Captain spawn/kill counter), `MainActivity`
  (offline idle cap), and `Area.fullChest()` (dungeon loot cap).
- **DebugToggles.kt** — compile-time boolean flags (`ALWAYS_GRANT_MAX_IDLE_HOURS`,
  `MULTIPLY_ADVENTURERS_STATS_BY_50`, `INSTANT_LEVEL_UP`, `CLEAN_SAVE_ON_START`,
  `DISABLE_SHOP`, etc.). Game logic reads these flags where the toggled behavior lives.
- **Gameplay content mods** — extra adventurer classes/enemies/items (e.g.
  `Berserker`, `ImperialCaptain`, `CaptainsSword`, `CelestialBow`, `Evo22Vial`,
  `XPBook*`), bonus traits (`RUTHLESS_PLUS`), extra pets (`Senko`/`Semi`), and
  doctrine rebalances are implemented as normal Kotlin classes inside the vanilla
  trees and are protected by the `ModFeaturesTest` JVM tests (app/src/test/kotlin).
- **Changelog / info UI** — `ui/dialogs/ModChangelog.kt` (version entries) and
  `ui/dialogs/DialogModAbout.kt` (info + version detail dialogs, reachable from the
  nav drawer `R.id.mod_about`).
- **Branding** — `app/build.gradle.kts` (`modVersion`, `versionName = "$gameVersion-mod-$modVersion"`,
  custom APK name), `app/src/main/AndroidManifest.xml` (launcher icon =
  `@drawable/unit_balrog`), `app/src/main/res/values*/strings.xml` (`app_name` = "IGM Modded").
- **Ads/IAP stubs** — Google Play billing/Ads SDKs are wired so code compiles, but
  the UI hides them (see [known-uncertainties.md](known-uncertainties.md), item 2).
- **Save tooling** — `scripts/save/`, `save_editor/`, `scripts/build/` operate on
  save files outside the app (see [scripts.md](scripts.md)).

## Testing

JVM tests live in `app/src/test/java/it/paranoidsquirrels/idleguildmaster/`
(`FunctionalParityTest`, JUnit 4). They exercise the headless game loop (data init,
save round-trip, adventurer creation, formulas, skill casting, combat setup) in a few
seconds without an Android device. Run with
`.\gradlew.bat testDebugUnitTest` (see [build-system.md](build-system.md)).

## Architectural Boundaries

1. **Vanilla parity vs mod**: reconstructed game behavior must match vanilla
   (see [vanilla-behavior.md](vanilla-behavior.md)); mod behavior goes behind
   `DebugToggles` or explicit mod-branded UI/resources.
2. **Application code is Kotlin**: game functionality belongs in
   `app/src/main/kotlin/`. Python/scripts are tooling only, never application logic.
3. **One save class**: persist new state by adding `@SerializedName` fields to `Data`,
   and handle them in `DataDeserializer` only if custom loading is required.
4. **Generated output**: databinding classes, `R`, and everything under `app/build/`
   and `.gradle/` are generated — never edit, always regenerate.

## Where New Functionality Should Normally Be Implemented

| New ...                                      | Go to                                                        |
| -------------------------------------------- | ------------------------------------------------------------ |
| New dungeon/raid/enemy/item/pet/adventurer   | `storage/data/places/{dungeons,raids}/`, `entities/.../units/`, `items/instances/`, `pets/instances/` + `Data` field + `Utils.compile*List()` |
| New formula/balance number                    | `Formulas.kt` (or `Utils.kt`)                                 |
| New gameplay/mod toggle                       | Add flag to `DebugToggles.kt`; read it where the behavior lives |
| New persisted game state                      | `Data.kt` `@SerializedName` field (+ `DataDeserializer` only if custom parsing is needed) |
| New UI screen/dialog                          | New layout XML under `res/layout*/` + a fragment/dialog in `ui/`; add strings to `res/values/strings.xml` and translations |
| New dev tool, converter, analysis script     | `scripts/` (reuse existing first; see [scripts.md](scripts.md)) |
| New behavioral knowledge                      | Update `docs/` (reverse-engineering, save-format, vanilla-behavior, ...) |

## References

- Save format / device paths: [save-format.md](save-format.md)
- Build & tasks / generated output: [build-system.md](build-system.md)
- Day-to-day development guide: [development.md](development.md)
- Tooling inventory: [scripts.md](scripts.md)