# Save Format Specification

## What "the save" actually is

The application persists its entire game state as a **single JSON document**
produced by Gson from the `storage.data.Data` class.

- **On-device location** (internal storage): `files/data.txt`
  (`/data/data/it.paranoidsquirrels.idleguildmaster.rebuilt/files/data.txt`).
- `FileManager` rotates between `data.txt` and `databackup.txt` on every save so a
  crash never destroys the last good save; `FileManager.load()` picks the newer of
  the two.
- Serialization: `GsonBuilder().setPrettyPrinting().registerTypeAdapter(Data.class,
  DataDeserializer())` — see `storage/FileManager.kt`.
- Deserialization: `DataDeserializer` (`JsonDeserializer<Data>`) reads **known keys
  only**, ignoring unknown/legacy keys; missing keys fall back to `Data` field
  defaults. This tolerance is what keeps old saves loadable.
- **There is no `save_version` field** in the on-disk JSON despite earlier notes.
  Forward/backward compatibility is achieved purely by the tolerant loader.
- **File encoding**: the canonical encoding is **UTF-8 without a BOM** (that is what
  `FileManager.overwriteFile` writes and what the app expects). For robustness with
  external tools, `FileManager.loadFile` also accepts UTF-8 with a BOM and UTF-16
  LE/BE with a BOM (auto-detected, stripped on read).

> The name "save.json" in this repository is a **local working copy** used by the
> dev workflow (`scripts/save/save_manager.ps1`, `save_editor/`), not the file the
> app reads. The app reads/writes `data.txt` / `databackup.txt`.

## Top-Level Schema

The JSON root is a flat object with ~100 keys. Categories (representative keys):

| Category            | Keys                                                            |
| ------------------- | --------------------------------------------------------------- |
| Resources           | `money`, `gems`, `totalGemsPurchased`, `maxWealth`, `adsWatched`, `itemsCrafted`, `itemsSold`, `amountOfPurchases` |
| Purchased packs     | `starterPackPurchased`, `adventurerPackPurchased`, `merchantPackPurchased`, `imperialVanguardPurchased`, `unholyCrusadePurchased`, `doctrineMaxed`, `everAscended`, `potsMaxed`, `vial2RetGrant`, `intercessionsRetroactivelyGranted`, `reviewShown`, `reviewTrigger` |
| Guild buildings     | `levelQuarters`, `levelStorage`, `levelTavernCapacity`, `levelTavernTime`, `levelMarketListings`, `levelMarketTime`, `levelShelter`, `levelShelterAutofeed`, `levelWorkshopQueue`, `levelWorkshopTime` + matching `upgrade*` keys |
| Adventurers         | `adventurers[]`, `dismissedAdventurers[]`, `tavernGuests[]`, `maxAdventurersOwned`, `maxAdventurerTier` |
| Areas (11 dungeons) | `enchantedForest`, `theDesert`, `eternalBattlefield`, `theGoldenCity`, `blackwaterPort`, `frostbitePeaks`, `obsidianMines`, `theSouthernGrove`, `barrenWastelands`, `hiddenCityOfLarox`, `lostLands` |
| Areas (12 raids)    | `theSlimePond`, `divineArcheology`, `ancientGraveDigging`, `imperialRescue`, `theCultistRebels`, `theDreadfulAscent`, `theLostExpedition`, `celestialMothership`, `theDireDescent`, `sleepingPlanet`, `kaunis`, `theTower` |
| Items / market      | `items[]`, `knownRecipes`, `marketListings[]`, `soldMarketItems[]`, `merchantRegularStockItems[]`, `merchantSpecialReserve`, `newMerchantRegularItems`, `newMerchantSpecialItems`, `completedWorkshopItems[]`, `workshopQueue[]` |
| Pets                | `pets[]`, `t4Pet`                                                   |
| Quests              | `kingsQuests`, `afflictionQuests`, `controlQuests`, `fortitudeQuests`, `graceQuests`, `illusionQuests`, `knowledgeQuests`, `ruinQuests`, `warQuests`, `questsCompleted`, `questsRefreshed`, `questsSeen` |
| Doctrine levels     | `afflictionLevel/Progress`, `controlLevel/Progress`, `fortitudeLevel/Progress`, `graceLevel/Progress`, `illusionLevel/Progress`, `knowledgeLevel/Progress`, `ruinLevel/Progress`, `warLevel/Progress` |
| Messages            | `messagesGotten[]`, `messagesToShow[]` (KingMessage identifiers)     |
| Collection          | `seenEnemies[]`, `seenItems[]`, `uniqueItemsLost[]`                  |
| Timers              | `lastAccess`, `last24Triggered`, `lastHourTriggered`, `lastWeekTriggered`, `nextTavernVisit` |
| Settings            | `settingsLanguage`, `settingConfirmRetreat`, `settingConfirmSwap`, `settingConfirmUpgrade`, `settingCraftMaxAmount`, `settingSellMaxAmount`, `settingVerboseLogs`, `settingAutoOpenDungeonDetail`, `settingColorblindMode`, `shownDialogRaid`, `shownDialogEpicRaid` |
| Mod progression     | `imperialKills`, `idleTimeCapHours`, `lootCap` (0 = unset). Legacy saves are migrated by unpacking the old packed `redeem_m975nfu5` int (bits 0-9 kills / 10-17 idle hours / 18-31 loot cap) |
| Legacy/redeem keys  | `redeem_f1r39h15`, `redeem_g73mfkf4`, `redeem_potionsRefund1`, `redeemed_*` (incl. the one-time `redeemed_z3gaazrt`), `redeem_m975nfu5` (kept for save compatibility) |

## Nested Structures

**Item** (storage item, equipment slot value):

```json
{ "stack": 1, "trueClass": "CopperSword" }
```

**Adventurer** (from `app/src/main/assets/manual_load.txt`, an example save):

```json
{
  "id": 0,
  "trueClass": "RoyalGuard",
  "level": 17,
  "experience": 9768,
  "ascended": false,
  "seen": false,
  "timeWhenDismissed": 0,
  "traitCommon": "BOOKWORM",
  "traitRare": null,
  "weapon": { "stack": 1, "trueClass": "Scimitar" },
  "armor": { "stack": 1, "trueClass": "UndeadCuirass" },
  "accessory": { "stack": 1, "trueClass": "MetamorphicShield" },
  "potionsDrank": {
    "potionOfAgilityDrank": 0, "potionOfConstitutionDrank": 1,
    "potionOfDarknessDrank": 0, "potionOfDefenseDrank": 0,
    "potionOfDexterityDrank": 0, "potionOfHealthDrank": 0,
    "potionOfImmunityDrank": 1, "potionOfIntelligenceDrank": 0,
    "potionOfMagicDefenseDrank": 0, "potionOfPrecisionDrank": 0,
    "potionOfViciousnessDrank": 0
  },
  "doctrine": { "l1": 0, "l2": 0, "l3": 0, "l4": 0, "l5": 0, "l6": 0, "trueClass": "EmptyDoctrine" },
  "currentHp": 233,
  "currentMana": 30,
  "currentShield": 0,
  "negativeStatusEffects": [],
  "positiveStatusEffects": []
}
```

**Area** (each dungeon/raid):

```json
{
  "adventureRecap": {
    "areasCleared": 0, "enemiesKilled": [],
    "expEarned": 0, "expLost": 0, "secondsPassed": 0, "wiped": 0
  },
  "adventurersExploringIds": [],
  "locked": true,
  "progress": 0
}
```

## Entity Naming Convention

Every `trueClass` string (`"Wolf"`, `"IronSword"`, `"Footman"`, ...) maps to a
concrete Kotlin subclass via the static `getInstance("ClassName")` factories. There
is no data table — a save with an unknown `trueClass` may fail to instantiate that
object, depending on the loader path.

## Local Development Workflow

The save tools revolve around a gitignored `save.json` at the repository root:

```text
save.json          Working copy (gitignored)
save.json.tmp      Staging file during pull (gitignored)
backups/           Timestamped snapshots of save.json (gitignored)
```

- `save_manager.ps1 pull`  — copies device `files/data.txt` → `save.json` and backs up
- `save_manager.ps1 push`  — writes `save.json` back to device `data.txt` + `databackup.txt` and restarts the app
- `save_manager.ps1 backup/restore` — snapshot management
- `scripts/save/update_save.py` — injects pack heroes/items into `save.json`
- `save_editor/index.html` — browser editor for arbitrary save JSON

See [scripts.md](scripts.md) for details.

## Reference Implementation

- App code: `storage/FileManager.kt`, `storage/SaveManager.kt`,
  `storage/data/Data.kt` (fields + `@SerializedName`), `storage/data/DataDeserializer.kt`
  (tolerant loader).
- Real example save: `app/src/main/assets/manual_load.txt` (used by
  `DebugToggles.LOAD_FROM_TEST_FILE`).
- Local live save: `save.json` (current working copy).