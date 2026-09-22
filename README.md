# IGM-Modded (Idle Guild Master Modded)

[![Language](https://img.shields.io/badge/Language-Kotlin%20100%25-blue.svg)](https://kotlinlang.org/)
[![Build](https://img.shields.io/badge/Build-Gradle-green.svg)](https://gradle.org/)
[![Architecture](https://img.shields.io/badge/Architecture-Native%20Clean%20Code-orange.svg)]()
[![Platform](https://img.shields.io/badge/Platform-Android%208.0%2B%20%28API%2026%2B%29-brightgreen.svg)]()

Modded and reconstructed edition of the Android game **Idle Guild Master** (base v2.148).

Originally developed as bytecode and smali injections, this repository represents a complete, ground-up rebuild into **100% pure, native Kotlin**. All custom entities, mechanics, items, and UI dialogs compile directly through Gradle with full type-safety and automated test coverage.

---

## Table of Contents
- [What's Changed (New Mod Features)](#whats-changed-new-mod-features)
  - [Custom Adventurers & Units](#custom-adventurers--units)
  - [Custom Bosses & Encounters](#custom-bosses--encounters)
  - [Custom Equipment](#custom-equipment)
  - [Custom Consumables & Dialogs](#custom-consumables--dialogs)
  - [New Pets](#new-pets)
  - [Balance Reworks](#balance-reworks)
- [Redeem Code Engine](#redeem-code-engine)
- [UI & Quality of Life](#ui--quality-of-life)
- [System Bridges & Automation](#system-bridges--automation)
- [Build & Deployment](#build--deployment)
- [Project Architecture](#project-architecture)

---

## What's Changed (New Mod Features)

### Custom Adventurers & Units
* **Berserker (`storage.data.entities.adventurers.units.Berserker`)**:
  * Fierce front-line warrior class equipped with heavy armor and swords.
  * **Skills**: `PASSIVE_BERSERKER_RAGE` and `ACTIVE_TAUNT_IV`.
  * **Mechanics**: Innate extra attack at the end of every turn and base 20% lifesteal.

### Custom Bosses & Encounters
* **Imperial Captain (`storage.data.entities.enemies.units.ImperialCaptain`)**:
  * Appears as an elite boss encounter in **The Golden City** after 100 Imperial Guards are slain (50% room roll).
  * **Passive: Imperial Authority (`PASSIVE_IMPERIAL_AUTHORITY`)**: Gains +5% damage and +5 DEF / MDEF on each turn, stacking up to 5 times (total +25% DMG, +25 DEF/MDEF).
  * **Active: Execution Order (`ACTIVE_EXECUTION_ORDER`)**: Strikes the lowest-HP adventurer for standard attack damage; targets below 50% HP are executed outright.
  * **On-Hit**: 50% chance to Stun targets for 1 turn. Drops gold scraps, stat potions, and the rare *Captain's Sword*.
* **Knight Slime (`storage.data.entities.enemies.units.KnightSlime`)**:
  * Added as an armored boss in **The Slime Pond** raid.
  * **Passive: Armored (`PASSIVE_ARMORED`)**: 50% chance to reduce physical damage taken by 50%. Drops Green Slime and Iron Helms.
* **Elite Enemy System (`storage.data.entities.enemies.EliteEnemy`)**:
  * Dynamic scaling wrapper that doubles HP, stat pools, damage, and rewards for any base enemy. Seamlessly integrates with `Enemy.getInstance("Elite_<Base>")`.

### Custom Equipment
* **Captain's Sword (`CaptainsSword`)**:
  * Tier sword granting +25 Constitution, +8 Dexterity, and a 20% chance to Stun on hit.
* **Celestial Bow (`CelestialBow`)**:
  * Endgame bow granting +40 Dexterity, +15 Intelligence, +10% Critical Chance, +10% Critical Damage, and 2 extra attacks per turn (attacks 3 times per turn).

### Custom Consumables & Dialogs
* **Experience Tomes (`XPBook1`, `XPBook2`, `XPBook3`, `XPBook10`)**:
  * Instantly grant experience to any chosen adventurer via `DialogConsumeXPBook`:
    * **Tome I**: +10 XP
    * **Tome II**: +100 XP
    * **Tome III**: +1,000 XP
    * **Tome X**: +100,000 XP
* **Evo-22 Vial (`Evo22Vial`)**:
  * Opens `DialogConsumeEvo22` and `DialogChangeTraitCommon` to upgrade an adventurer's common traits (`Brute`, `Feral`, `Bookworm`) into their enhanced `PLUS` versions.

### New Pets
* **Senko (`storage.data.pets.instances.Senko`)**:
  * Divine kitsune spirit pet (Semi). Its 5th trait (Kitsune Spirit Blessing) grants progressive healing: +(level × 0.6)%.
  * Rolls all 4 ability slots from guaranteed abilities (`HEALER`, `REGENERATION`, `DROPS`, `EXPERIENCE`).

### Balance Reworks
| Component | Vanilla | Modded |
| :--- | :--- | :--- |
| **Doctrine: Improved Health** | +15 HP / level | **+25 HP / level** |
| **Doctrine: Troll Resistance** | Cost 3, +1 DEF, Max Lv 2 | **Cost 1, +2 DEF, Max Lv 5** |
| **Doctrine: Warlock Resilience**| Cost 3, +1 DEF, Max Lv 2 | **Cost 1, +2 DEF, Max Lv 5** |
| **Doctrine: Lightning Speed** | +15% initiative / level | **+20% initiative / level** |
| **Trait: Ruthless+** | *Non-existent* | **New Rare Trait: 1.3x Critical Damage** |
| **Trait: Troll Blood** | Flat regen | **(Tier / 2)% Max HP regen per turn** |
| **Trait: Dragon Blood** | Flat damage reduction | **1% damage reduction per tier** |
| **Trait: Blessed** | +8 darkness reduction | **+15 darkness reduction** |
| **Trait: Nimble** | +8% dodge chance | **+15% flat dodge chance** |
| **Trait: Cursed** | +15% lifesteal, 4% HP decay | **+20% lifesteal, 2% HP decay** |
| **Trait: Nocturnal** | +0.5% darkness amp / pt | **+1.0% darkness amp / pt** |
| **Traits: Brute+ / Feral+ / Bookworm+** | 1.10x primary stat | **1.20x primary stat** |
| **Trait: Focused** | +15% hit chance | **+25% hit chance** |

---

## Redeem Code Engine

The in-game Redeem Code dialog (`DialogRedeemCode`) includes a command dispatcher backed by the native `game.redeem.RedeemCodes` service:

| Code Syntax | Effect |
| :--- | :--- |
| `GOLD <amount>` | Adds `<amount>` gold directly to the guild vault. |
| `STORAGE <slots>` | Expands warehouse inventory by `<slots>` slots. |
| `IDLETIME <hours>` | Overrides the offline progression cap (12 to 168 hours / 1 week). |
| `LOOTCAP <cap>` | Sets maximum dungeon chest loot drop capacity (e.g. 500). |
| `RESETCAPS` | Resets the LOOTCAP and IDLETIME overrides to base (vanilla). |
| `SHOP` | Forces an immediate restock of regular and weekly merchant offers. |
| `REROLL` | Forces The Hunt and The Siege to reroll (refreshes both). |
| `BLACK` | Summons the Nightstall / Black Market and refreshes its stock. |
| `QUEST` | Refreshes and rerolls King's quests. |
| `KILLS` | Displays current Imperial Guard kills toward Imperial Captain spawn. |
| `SETKILLS <n>` | Manually sets the Imperial Guard kill counter (0 to 1023). |
| `ITEM <ItemName> [count]` | Spawns any item directly into storage (e.g. `ITEM CaptainsSword 1`). |
| `HERO <Class> [lvl] [trait1] [trait2]` | Spawns an adventurer (e.g. `HERO Berserker 10 BRUTE_PLUS RUTHLESS_PLUS`). |
| `PET <PetClass> [level]` | Spawns a pet directly into the shelter (e.g. `PET Senko 5`). |

---

## UI & Quality of Life

* **Mod Info / Changelog Dialog (`v1.3.0.3`)**: Restored the original two-dialog FAQ list and version detail dialog layout from `Idle Guild Master`. Features full changelogs from `1.0.0.0` through `1.3.0.3 (15/9/2026)`.
* **Bestiary Entries**: Added Imperial Captain to The Golden City and enforced `trueClass` tracking for Knight Slime and Imperial Captain in the Bestiary.
* **Pet Battle Log Interactions**: Tapping the pet avatar in Dungeon and Raid battle logs (`DialogDungeonDetail`) opens the pet's detail dialog.
* **Imperial Captain Kill Count Reset**: Killing the Imperial Captain or wiping against him resets the Imperial Guard kill counter cleanly to 0 upon round completion.
* **Pet Senko/Semi Kitsune Spirit Blessing**: Unlocked all 4 traits at Level 1 with no level requirements (normally unlocked at Lv 1, 21, 41, 61). The 5th trait (Kitsune Spirit Blessing) grants progressive healing (+level × 0.6%) instead of the old fixed +20% (its +5 HP regen/turn and +1 light were removed).
* **Start New Game Reset**: Added to the Settings dialog (`DialogSettings`). Safely resets all local save data and restarts the game fresh upon two-step confirmation.
* **Modern App Identity**: Renamed application to **IGM Modded** with Sha unit launcher icon and custom Berserker sprite art.
* **Nightstall / Black Market**: A 10%-per-day nocturnal stall (guaranteed after 6 consecutive missed days) with up to 12 discounted slots — smuggled materials (−50% gold), a smuggled legendary (ScarletStrand/Aegis: gems at −35% or rare gold), contraband potions, a shady delicacy, a Forbidden Evolution Vial and guild upgrades at −35% gems. Opens from a top-bar icon with a NEW badge; the `BLACK` code summons it.
* **Diamond Coin currency tier**: 1 Diamond = 100 Platinum = 100,000,000 copper. The money container shows the Diamond coin to the left of Platinum once you hold that much wealth.
* **Expanded gem upgrade caps & speed clamp**: storage → 185 purchases (300 total spaces), quarters → 15 (40 roster), tavern → 7 (15 guests), shelter → 7 (20 pets), workshop/market time → 15 (speed level 40); craft/sell times are clamped to a minimum of 1 second.

---

## System Bridges & Automation

* **Save Content Provider (`storage.SaveContentProvider`)**:
  * Exposed at authority `${applicationId}.saveprovider`.
  * Enables external backup tools and companion apps to securely perform `READ_SAVE` and `WRITE_SAVE`.
* **Save Importer (`storage.SaveImporter`)**:
  * Handles incoming `ACTION_VIEW` and `ACTION_SEND` intents for `.json` or `.txt` save files with instant hot-reloading.
* **Build & Deploy Script (`build.ps1`)**:
  * Automated PowerShell script: builds APK with Gradle, detects connected wireless/USB ADB devices, and deploys.
* **Save Manager Script (`save_manager.ps1`)**:
  * Full CLI for wireless save management (`pull`, `push`, `backup`, `restore`, `add-gold`, `add-gems`, `connect`).
* **Browser Save Editor (`save_editor/index.html`)**:
  * Offline browser utility for inspecting and tweaking player saves.

---

## Build & Deployment

### Requirements
* **JDK 17**
* **Android SDK Platform 35** (`platforms;android-35`, `build-tools;35.0.0`)
* **Gradle 8.9** (bundled with `gradlew.bat`)

### Commands

**Run Automated Unit Tests:**
```powershell
.\gradlew.bat testDebugUnitTest
```

**Build Modded APK:**
```powershell
.\gradlew.bat assembleDebug
```
*Output: `app/build/outputs/apk/debug/IdleGuildMaster_v2.148_mod_v1.3.0.0.apk`*

**Build, Sign & Auto-Deploy to Connected Device:**
```powershell
powershell -ExecutionPolicy Bypass -File .\build.ps1
```

**Save Management via ADB:**
```powershell
powershell -ExecutionPolicy Bypass -File .\save_manager.ps1 pull
powershell -ExecutionPolicy Bypass -File .\save_manager.ps1 add-gold 100000
powershell -ExecutionPolicy Bypass -File .\save_manager.ps1 push
```

---

## Project Architecture

```
📁 IGM-Modded/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── kotlin/.../idleguildmaster/
│   │   │   │   ├── game/redeem/              # RedeemCodes console (native service)
│   │   │   │   ├── storage/
│   │   │   │   │   ├── data/entities/        # Units, traits, skills, balance hooks
│   │   │   │   │   ├── data/items/           # Weapons, armor, custom consumables
│   │   │   │   │   ├── data/pets/            # Pets (including Senko)
│   │   │   │   │   ├── data/places/          # Dungeons, raids, boss encounter hooks
│   │   │   │   │   ├── SaveContentProvider   # Companion app bridge
│   │   │   │   │   └── SaveImporter          # Share-intent save import
│   │   │   │   └── ui/dialogs/               # Custom consumption & trait picker dialogs
│   │   │   └── res/                          # Mod drawables, layouts, and strings
│   │   └── test/                             # Automated JUnit parity & mod feature tests
├── save_editor/                              # Browser-based save editor
├── scripts/                                  # Tooling, build, and save management scripts
├── build.ps1                                 # One-step build & deploy pipeline
├── save_manager.ps1                          # Wireless ADB save manager CLI
└── README.md                                 # Documentation
```
