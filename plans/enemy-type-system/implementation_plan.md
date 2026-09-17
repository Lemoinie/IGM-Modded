# Implementation Plan: Enemy Type System

This plan introduces a formal **Enemy Type System** into the *Idle Guild Master* engine, categorizing every enemy into one of 10 thematic RPG categories, exposing the type through `Enemy.getEnemyType()`, and surfacing it in the UI within `DialogEntityDetail` so players can inspect and understand enemy classifications during dungeon runs and in the bestiary.

---

## User Review Required

> [!IMPORTANT]
> **Proposed Enemy Categories (10 Types)**:
> 1. `UNDEAD`: Skeletons, ghosts, ghouls, liches, mummies, rotten entities.
> 2. `BEAST`: Animals, predators, vermin, insects, dinosaurs, swarms.
> 3. `HUMANOID`: Mortals, cultists, soldiers, pirates, mages, trolls.
> 4. `DEMON`: Fiends, imps, infernal entities.
> 5. `DRAGON`: Dragons, wyverns, drakes.
> 6. `SLIME`: Oozes, elemental slimes, King Slime.
> 7. `ELEMENTAL`: Nature spirits, djinn, phoenixes, wisps, pure elementals.
> 8. `PLANT`: Ents, treants, dryads, toxic fungi.
> 9. `CONSTRUCT`: Machines, automatons, animated armor, golems, mimics, iron doors.
> 10. `ABERRATION`: Eldritch horrors, cosmic titans, beholders, tentacled outer god entities.

> [!NOTE]
> All 124 base game enemies have been mapped 1-to-1 to these 10 categories in the full roster table below. If you prefer adjusting any individual enemy's category (e.g., classifying Trolls as a separate category or moving Dinosaurs between Beast and Dragon), let us know!

---

## Proposed Changes

### Core Entity Model

#### [NEW] [EnemyType.kt](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/enemies/EnemyType.kt)
Create the core enum defining the 10 enemy categories, their display string resources, descriptions, and icon/badge styles:
```kotlin
package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies

import androidx.annotation.StringRes
import it.paranoidsquirrels.idleguildmaster.R

enum class EnemyType(
    @JvmField @StringRes val nameRes: Int,
    @JvmField @StringRes val descriptionRes: Int
) {
    HUMANOID(R.string.enemy_type_humanoid, R.string.enemy_type_humanoid_desc),
    BEAST(R.string.enemy_type_beast, R.string.enemy_type_beast_desc),
    UNDEAD(R.string.enemy_type_undead, R.string.enemy_type_undead_desc),
    DEMON(R.string.enemy_type_demon, R.string.enemy_type_demon_desc),
    DRAGON(R.string.enemy_type_dragon, R.string.enemy_type_dragon_desc),
    SLIME(R.string.enemy_type_slime, R.string.enemy_type_slime_desc),
    ELEMENTAL(R.string.enemy_type_elemental, R.string.enemy_type_elemental_desc),
    PLANT(R.string.enemy_type_plant, R.string.enemy_type_plant_desc),
    CONSTRUCT(R.string.enemy_type_construct, R.string.enemy_type_construct_desc),
    ABERRATION(R.string.enemy_type_aberration, R.string.enemy_type_aberration_desc)
}
```

#### [MODIFY] [Enemy.kt](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/enemies/Enemy.kt)
- Add `@JvmField @Transient var enemyType: EnemyType = EnemyType.HUMANOID` to `Enemy`.
- Add `open fun getEnemyType(): EnemyType = enemyType`.
- Default to `EnemyTypeRegistry.getTypeForClass(trueClass)` if not explicitly overridden.

#### [MODIFY] [EliteEnemy.kt](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/enemies/EliteEnemy.kt)
- Delegate `getEnemyType()` to `base.getEnemyType()`.

#### [NEW] [EnemyTypeRegistry.kt](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/enemies/EnemyTypeRegistry.kt)
A centralized lookup map from enemy unit class name to `EnemyType`. This ensures all 124 enemies receive their correct type automatically without needing to edit 124 separate source files:
```kotlin
object EnemyTypeRegistry {
    private val TYPE_MAP: Map<String, EnemyType> = mapOf(
        // Populated with all 124 unit classes
    )
    fun getTypeForClass(className: String): EnemyType = TYPE_MAP[className] ?: EnemyType.HUMANOID
}
```

---

### UI & Strings

#### [MODIFY] [strings.xml](file:///C:/Repositories/IGM-Modded/app/src/main/res/values/strings.xml)
Add localized strings for each enemy type name, description, and UI format label:
```xml
<!-- Enemy Types -->
<string name="enemy_type_label">Type: %s</string>
<string name="enemy_type_humanoid">Humanoid</string>
<string name="enemy_type_humanoid_desc">Mortals, soldiers, cultists, mages, and sentient folk.</string>
<string name="enemy_type_beast">Beast</string>
<string name="enemy_type_beast_desc">Wild beasts, predators, swarms, and primeval animals.</string>
<string name="enemy_type_undead">Undead</string>
<string name="enemy_type_undead_desc">Reanimated corpses, restless spirits, ghouls, and skeletal horrors.</string>
<string name="enemy_type_demon">Demon</string>
<string name="enemy_type_demon_desc">Malicious fiends and infernal entities from the abyss.</string>
<string name="enemy_type_dragon">Dragon</string>
<string name="enemy_type_dragon_desc">Ancient drakes, wyverns, and apex reptilian terrors.</string>
<string name="enemy_type_slime">Slime</string>
<string name="enemy_type_slime_desc">Gelatinous organisms of various elemental resonances.</string>
<string name="enemy_type_elemental">Elemental</string>
<string name="enemy_type_elemental_desc">Living manifestations of raw physical or magical elements.</string>
<string name="enemy_type_plant">Plant</string>
<string name="enemy_type_plant_desc">Sentient flora, deep forest treants, and parasitic fungi.</string>
<string name="enemy_type_construct">Construct</string>
<string name="enemy_type_construct_desc">Inanimate machines, animated armors, stone automatons, and wards.</string>
<string name="enemy_type_aberration">Aberration</string>
<string name="enemy_type_aberration_desc">Eldritch monstrosities, cosmic entities, and avatars of outer beings.</string>
```

#### [MODIFY] [DialogEntityDetail.kt](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogEntityDetail.kt)
1. **Title Display**:
   Update `getTitle()`:
   ```kotlin
   override fun getTitle(): String {
       val e = entity ?: return ""
       if (e is Enemy) {
           return getString(e.idName) + " • " + getString(e.getEnemyType().nameRes)
       }
       return getString(e.idName)
   }
   ```
2. **Detail Badge View**:
   In `initialize()` when `e is Enemy`:
   - Keep `b.detailTraits.visibility = View.VISIBLE` (instead of hiding it).
   - Set badge text: `b.detailTraits.text = String.format(getString(R.string.enemy_type_label), getString(e.getEnemyType().nameRes))`.
   - Set background styling to `R.drawable.object_border_dim_white`.
   - In `attachListeners()`:
     ```kotlin
     b.detailTraits.setOnClickListener {
         populateHelp(it, getString(e.getEnemyType().descriptionRes), false, null)
     }
     ```

---

## Full Roster: All 124 Enemies & Their Types

| # | Class Name | In-Game Display Name | Assigned Type | Thematic Notes |
| :-: | :--- | :--- | :--- | :--- |
| 1 | `Abomination` | Abomination | **ABERRATION** | Flesh amalgamation created by forbidden alchemy |
| 2 | `AmanitaObscura` | Amanita Obscura | **PLANT** | Giant poisonous fungal organism |
| 3 | `AncientEnt` | Ancient Ent | **PLANT** | Millennia-old awakened magical tree |
| 4 | `ArcaneAssassin` | Arcane Assassin | **HUMANOID** | Elite covert humanoid spellsword |
| 5 | `ArchmageOfLarox` | Archmage of Larox | **HUMANOID** | Master human sorcerer of Larox |
| 6 | `AvatarOfTheAncient` | Avatar of the Ancient | **ABERRATION** | Manifestation of an Outer God |
| 7 | `Banshee` | Banshee | **UNDEAD** | Armored wailing spectral horror |
| 8 | `Beholder` | Beholder | **ABERRATION** | Floating eye-stalk eldritch aberration |
| 9 | `Berserker` | Berserker | **HUMANOID** | Dual-axe wielding frenzy warrior |
| 10 | `BleakDeacon` | Bleak Deacon | **HUMANOID** | Corrupted humanoid bishop of eldritch faith |
| 11 | `BleakDisciple` | Bleak Disciple | **HUMANOID** | Warped humanoid cult fanatic |
| 12 | `Boar` | Boar | **BEAST** | Wild woodland beast |
| 13 | `CelestialDestroyer` | Celestial Destroyer | **ABERRATION** | Massive cosmic warmachine entity |
| 14 | `CelestialLancer` | Celestial Lancer | **ABERRATION** | Otherworldly celestial footman |
| 15 | `Centaur` | Centaur | **HUMANOID** | Half-man, half-horse warrior |
| 16 | `Cerebrum` | Cerebrum | **ABERRATION** | Disembodied sentient brain in glass |
| 17 | `ChiefScientistAva` | Chief Scientist Ava | **HUMANOID** | Nexus laboratory master researcher |
| 18 | `CityWarden` | City Warden | **HUMANOID** | Capital law enforcement officer |
| 19 | `Claris` | Claris | **HUMANOID** | Powerful cultist rebel mage |
| 20 | `Crusader` | Crusader | **HUMANOID** | Zealous eastern holy knight |
| 21 | `DeathHound` | Death Hound | **BEAST** | Savage corrupted predatory hound |
| 22 | `Deckhand` | Deckhand | **HUMANOID** | Pirate crew member |
| 23 | `Djinn` | Djinn | **ELEMENTAL** | Primordial magical wind/fire spirit |
| 24 | `DreamwroughtBeast` | Dreamwrought Beast | **BEAST** | Nightmare-infused quadruped hunter |
| 25 | `DreamwroughtDragon` | Dreamwrought Dragon | **DRAGON** | Slumbering cosmic drake entity |
| 26 | `DreamwroughtForge` | Dreamwrought Forge | **CONSTRUCT** | Animated magical dream forge |
| 27 | `DreamwroughtSwarm` | Dreamwrought Swarm | **BEAST** | Hive-mind swarm of dream insects |
| 28 | `Dryad` | Dryad | **PLANT** | Sentient guardian spirit of the groves |
| 29 | `EldritchHound` | Eldritch Hound | **BEAST** | Otherworldly horned hunting beast |
| 30 | `ElectricSlime` | Electric Slime | **SLIME** | Lightning-charged gelatinous ooze |
| 31 | `EmperorClovisXXVIII` | Emperor Clovis XXVIII | **DEMON** | Corrupted emperor transformed into abyssal fiend |
| 32 | `Enforcer` | Enforcer | **HUMANOID** | Heavy-armored capital mercenary |
| 33 | `Ent` | Ent | **PLANT** | Living humanoid tree guardian |
| 34 | `EtherealSoul` | Ethereal Soul | **UNDEAD** | Lost disembodied ghost |
| 35 | `FireSlime` | Fire Slime | **SLIME** | Flaming molten ooze |
| 36 | `FirstMinisterAtos` | First Minister Atos | **HUMANOID** | High chancellor of the Empire |
| 37 | `ForestSpirit` | Forest Spirit | **ELEMENTAL** | Natural woodland elemental essence |
| 38 | `FrozenSlime` | Frozen Slime | **SLIME** | Sub-zero cryo ooze |
| 39 | `Gcss` | G.C.S.S. | **CONSTRUCT** | Guild Clockwork Security System automaton |
| 40 | `Ghoul` | Ghoul | **UNDEAD** | Carrion-feeding reanimated corpse |
| 41 | `GiantMoth` | Giant Moth | **BEAST** | Massive cave-dwelling insect |
| 42 | `GiantSpider` | Giant Spider | **BEAST** | Web-spinning venomous arachnid |
| 43 | `GiantTortoise` | Giant Tortoise | **BEAST** | Armored primeval reptile |
| 44 | `GoldenRabbit` | Golden Rabbit | **BEAST** | Rare mystical woodland critter |
| 45 | `GreenSpitfang` | Green Spitfang | **BEAST** | Acid-spitting serpentine beast |
| 46 | `HeadlessKnight` | Headless Knight | **UNDEAD** | Cursed decapitated spectral rider |
| 47 | `HeraldKali` | Herald Kali | **HUMANOID** | Fanatical apostle herald |
| 48 | `HeraldMaya` | Herald Maya | **HUMANOID** | Fanatical apostle herald |
| 49 | `HeraldShoran` | Herald Shoran | **HUMANOID** | Fanatical apostle herald |
| 50 | `HeraldXavi` | Herald Xavi | **HUMANOID** | Fanatical apostle herald |
| 51 | `IceElemental` | Ice Elemental | **ELEMENTAL** | Manifestation of glacial magic |
| 52 | `Iconoclast` | Iconoclast | **ABERRATION** | Reality-defying profane cosmic entity |
| 53 | `Imp` | Imp | **DEMON** | Minor winged abyssal mischief-maker |
| 54 | `ImperialCaptain` | Imperial Captain | **HUMANOID** | High-ranking Empire military officer |
| 55 | `ImperialGuard` | Imperial Guard | **HUMANOID** | Palace shieldbearer |
| 56 | `ImperialMage` | Imperial Mage | **HUMANOID** | Court spellcaster |
| 57 | `InsaneCitizen` | Insane Citizen | **HUMANOID** | Corrupted capital resident |
| 58 | `InsaneMerchant` | Insane Merchant | **HUMANOID** | Deranged trader driven mad by the mist |
| 59 | `InsanePriest` | Insane Priest | **HUMANOID** | Twisted cleric of the fallen church |
| 60 | `KabarTheRotten` | Ka'Bar, the Rotten | **UNDEAD** | Putrefied skeleton lord of the tombs |
| 61 | `KasimirTheSeer` | Kasimir, the Seer | **HUMANOID** | Blind prophet of the dunes |
| 62 | `KingAino` | King Aino | **HUMANOID** | Monarch of the western provinces |
| 63 | `KnightSlime` | Knight Slime | **SLIME** | Ooze wearing armor and wielding a blade |
| 64 | `Lazarus` | Lazarus | **UNDEAD** | Resurrected fallen champion |
| 65 | `LegateHadrian` | Legate Hadrian | **HUMANOID** | Commander of the imperial legions |
| 66 | `LesserTitan` | Lesser Titan | **ABERRATION** | Colossal primordial divine fragment |
| 67 | `LostMiner` | Lost Miner | **UNDEAD** | Starved and reanimated cavern dweller |
| 68 | `MagicArmor` | Magic Armor | **CONSTRUCT** | Empty plate suit animated by runes |
| 69 | `Mimic` | Mimic | **CONSTRUCT** | Predatory artificial trunk trap |
| 70 | `MysteriousTentacle` | Mysterious Tentacle | **ABERRATION** | Limb of an unfathomable subterranean horror |
| 71 | `Necrobot` | Necrobot | **CONSTRUCT** | Clockwork mechanical frame fueled by death magic |
| 72 | `Necrolith` | Necrolith | **ABERRATION** | Floating eldritch obelisk channeling doom |
| 73 | `NexusResearcher` | Nexus Researcher | **HUMANOID** | Arcane scientist studying rifts |
| 74 | `ObsidianGolem` | Obsidian Golem | **CONSTRUCT** | Carved volcanic rock automaton |
| 75 | `Oculus` | Oculus | **ABERRATION** | Floating psionic eye abomination |
| 76 | `PaleHermit` | Pale Hermit | **HUMANOID** | Reclusive dark arts hermit |
| 77 | `Phantasm` | Phantasm | **UNDEAD** | Incorporeal terrifying specter |
| 78 | `Phoenix` | Phoenix | **ELEMENTAL** | Immortal avian avatar of sacred flame |
| 79 | `Pirate` | Pirate | **HUMANOID** | High seas raider |
| 80 | `PirateCaptain` | Pirate Captain | **HUMANOID** | Leader of the corsair fleet |
| 81 | `PirateLieutenant` | Pirate Lieutenant | **HUMANOID** | First mate corsair officer |
| 82 | `PrimevalWurm` | Primeval Wurm | **BEAST** | Giant burrowing prehistoric worm |
| 83 | `PrimordialTitan` | Primordial Titan | **ABERRATION** | Cosmic titan from the dawn of creation |
| 84 | `Pterodactyl` | Pterodactyl | **BEAST** | Flying primeval reptile |
| 85 | `ReinforcedDoor` | Reinforced Door | **CONSTRUCT** | Fortified iron blockade mechanism |
| 86 | `SandDemon` | Sand Demon | **DEMON** | Desert fiend born of cursed sands |
| 87 | `SandStatue` | Sand Statue | **CONSTRUCT** | Animated sandstone effigy |
| 88 | `SandVulture` | Sand Vulture | **BEAST** | Scavenging desert raptor |
| 89 | `ShaKireFirstSwordsman` | Sha'kire, First Swordsman | **HUMANOID** | Legendary master blade of the east |
| 90 | `ShaTheHiddenGod` | Sha, the Hidden God | **ABERRATION** | Eldritch deity lurking in shadows |
| 91 | `Shadow` | Shadow | **ABERRATION** | Living darkness manifestation |
| 92 | `ShahuriArcher` | Sha'huri Archer | **HUMANOID** | Nomadic desert marksman |
| 93 | `ShahuriMage` | Sha'huri Mage | **HUMANOID** | Desert sand sorcerer |
| 94 | `ShahuriWarrior` | Sha'huri Warrior | **HUMANOID** | Desert scimitar fighter |
| 95 | `Singularity` | Singularity | **ABERRATION** | Cosmic gravity well entity |
| 96 | `Slime` | Slime | **SLIME** | Common green forest ooze |
| 97 | `SlimeKing` | Slime King | **SLIME** | Sovereign crown-wearing giant slime |
| 98 | `SmolderingTitan` | Smoldering Titan | **ABERRATION** | Fiery primordial titan |
| 99 | `SnowWyvern` | Snow Wyvern | **DRAGON** | Glacial winged dragon-kin |
| 100 | `StoneShaman` | Stone Shaman | **HUMANOID** | Mountain earth caster |
| 101 | `TekeliLiFirstApostle` | Tekeli'li, First Apostle | **ABERRATION** | Shoggoth-like formless apostle horror |
| 102 | `Terrorsaurus` | Terrorsaurus | **BEAST** | Apex carnivorous primeval dinosaur |
| 103 | `TheAncient` | The Ancient | **ABERRATION** | Cosmic entity slumbering deep below |
| 104 | `TheExiled` | The Exiled | **HUMANOID** | Banished royal swordsman |
| 105 | `TheMachine` | The Machine | **CONSTRUCT** | Giant core supercomputer of the ruins |
| 106 | `Thorvus` | Thorvus | **HUMANOID** | Renegade warlord |
| 107 | `Treant` | Treant | **PLANT** | Ancient sentient tree protector |
| 108 | `Troll` | Troll | **HUMANOID** | Regenerating massive brute |
| 109 | `TrollShaman` | Troll Shaman | **HUMANOID** | Spellcasting troll elder |
| 110 | `TrollWarrior` | Troll Warrior | **HUMANOID** | Heavy-club frontline troll |
| 111 | `TrollWhelp` | Troll Whelp | **HUMANOID** | Young aggressive troll |
| 112 | `TutorialWolf` | Wolf | **BEAST** | Early forest wolf |
| 113 | `Ultraslime` | Ultraslime | **SLIME** | Massive iridescent slime cluster |
| 114 | `Undead` | Undead | **UNDEAD** | Risen skeletal soldier |
| 115 | `UndeadArcher` | Undead Archer | **UNDEAD** | Skeletal bowman |
| 116 | `UndeadGeneral` | Undead General | **UNDEAD** | Skeletal commander of the ancient army |
| 117 | `UndeadWarlord` | Undead Warlord | **UNDEAD** | Armored death knight leader |
| 118 | `VampireBat` | Vampire Bat | **BEAST** | Blood-drinking cave mammal |
| 119 | `VoidSlime` | Void Slime | **SLIME** | Pure dark-matter ooze |
| 120 | `WickedTribute` | Wicked Tribute | **ABERRATION** | Eldritch sacrifice incarnate |
| 121 | `WillOWisp` | Will o' Wisp | **ELEMENTAL** | Floating wandering spirit light |
| 122 | `WizardOfLarox` | Wizard of Larox | **HUMANOID** | Apprentice battlemage of Larox |
| 123 | `Wolf` | Wolf | **BEAST** | Pack-hunting forest canine |
| 124 | `Wurm` | Wurm | **BEAST** | Subterranean carnivorous worm |

---

## Category Distribution Summary

- **Humanoid**: 43 enemies (34.7%)
- **Aberration**: 19 enemies (15.3%)
- **Beast**: 18 enemies (14.5%)
- **Undead**: 12 enemies (9.7%)
- **Construct**: 9 enemies (7.3%)
- **Slime**: 8 enemies (6.5%)
- **Elemental**: 5 enemies (4.0%)
- **Plant**: 5 enemies (4.0%)
- **Demon**: 3 enemies (2.4%)
- **Dragon**: 2 enemies (1.6%)
- **Total**: **124 Enemies (100%)**

---

## Verification Plan

### Compilation & Static Analysis
- Run `build_mod.ps1` or `./gradlew assembleDebug` to ensure `EnemyType.kt`, `EnemyTypeRegistry.kt`, and `Enemy.kt` compile with zero errors and no DEX collision.

### Runtime Verification
- Launch game via ADB (`am start -n it.paranoidsquirrels.idleguildmastermod/...`).
- Enter **Bestiary** (`DialogBestiary`) and inspect enemy entries.
- Tap an enemy in dungeon preview / combat:
  - Verify dialog title displays: `<Enemy Name> • <Type>`
  - Verify badge row displays: `Type: <Type>`
  - Tap the type badge and confirm popup displays the type description.
