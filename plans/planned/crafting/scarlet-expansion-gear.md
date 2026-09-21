# Implementation Plan: Scarlet Expansion Gear (Oni Juggernaut & Cape Upgrades)

## Goal Description
Expand the endgame Scarlet equipment line with 4 new high-tier items:
1. **Scarlet Oni Juggernaut**: Apex Heavy Armor upgrade for [ScarletOni](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/instances/ScarletOni.kt).
2. **Scarlet Cape**: Universal tri-stat accessory crafted from 10× [ScarletStrand](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/instances/ScarletStrand.kt).
3. **Eldritch Scarlet Cape**: First accessory upgrade using 5× [EldritchSeal](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/instances/EldritchSeal.kt).
4. **Abyssal Scarlet Mantle**: Pinnacle accessory upgrade using 10× [AncestralBlood](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/instances/AncestralBlood.kt).

---

## 1. Item Specifications

### 1.1 Scarlet Oni Juggernaut (`ScarletOniJuggernaut`)
- **Type**: Heavy Armor ([HeavyArmor](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/abstractClasses/HeavyArmor.kt))
- **Slot**: Armor (Heavy armor classes: Fighter, Knight, Crusader, etc.)
- **Sprite**: `R.drawable.scarlet_oni_juggernaut` (32×32 RGBA in [scarlet_oni_juggernaut.png](file:///C:/Repositories/IGM-Modded/app/src/main/res/drawable/scarlet_oni_juggernaut.png))
- **Base Stats**:
  - `maxHp`: `720`
  - `constitution`: `126`
  - `criticalChance`: `0.30` (+30%)
  - `criticalDamage`: `0.35` (+35%)
  - `defense`: `0`
  - `magicDefense`: `0`
- **Recipe Ingredients**:
  - `1× ScarletOni` + `5× MysteriousCog` + `10× HeartOfDarkness` + `1× EldritchSeal`
  - *Engine Extension*: Requires adding 4th ingredient slot support to crafting layouts (`layout_craft.xml`, `layout_craft_big.xml`, `layout_craft_named.xml`) and dialog viewholders (`DialogCraft.kt`, `DialogItemDetail.kt`, `UIUtils.kt`). When recipe has $\le 3$ ingredients, slot 4 stays `GONE` preserving 100% backwards compatibility with vanilla recipes.
- **Price**: 100,000L + (5 × 2,000L) + (10 × 1,500L) + (1 × 893L) = `125893L`
- **Strings**:
  - **Name**: `Scarlet Oni Juggernaut`
  - **Description**: *"The apex manifestation of demonic Scarlet armor. Imbued with titanic resilience and boundless fury, it pulverizes enemy lines with devastating critical brutality."*
  - **Effect Text**: `+30% crit chance, +35% crit dmg`

---

### 1.2 Scarlet Cape (`ScarletCape`)
- **Type**: Accessory ([Accessory](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/abstractClasses/Accessory.kt))
- **Slot**: Accessory (Equippable by all adventurer classes)
- **Sprite**: `R.drawable.scarlet_cape` (32×32 RGBA in [scarlet_cape.png](file:///C:/Repositories/IGM-Modded/app/src/main/res/drawable/scarlet_cape.png))
- **Base Stats**:
  - `constitution`: `30`
  - `dexterity`: `30`
  - `intelligence`: `30`
  - `criticalChance`: `0.15` (+15%)
- **Recipe**:
  - 10× `ScarletStrand`
- **Price**: 10 × 20,000L = `200000L`
- **Strings**:
  - **Name**: `Scarlet Cape`
  - **Description**: *"A regal cape woven from tenfold Scarlet strands. Flowing with occult grace, it bolsters the wearer's physical and arcane agility while sharpening lethal precision."*
  - **Effect Text**: `+15% crit chance`

---

### 1.3 Eldritch Scarlet Cape (`EldritchScarletCape`)
- **Type**: Accessory ([Accessory](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/abstractClasses/Accessory.kt))
- **Slot**: Accessory (Equippable by all adventurer classes)
- **Sprite**: `R.drawable.eldritch_scarlet_cape` (32×32 RGBA in [eldritch_scarlet_cape.png](file:///C:/Repositories/IGM-Modded/app/src/main/res/drawable/eldritch_scarlet_cape.png))
- **Base Stats**:
  - `constitution`: `40`
  - `dexterity`: `40`
  - `intelligence`: `40`
  - `criticalChance`: `0.21` (+21%)
  - `criticalDamage`: `0.21` (+21%)
- **Recipe**:
  - 1× `ScarletCape` + 5× `EldritchSeal`
- **Price**: 200,000L + (5 × 893L) = `204465L`
- **Strings**:
  - **Name**: `Eldritch Scarlet Cape`
  - **Description**: *"The Scarlet Cape steeped in esoteric rites and sealed by outer horrors. Deep crimson threads twist with cosmic energy, multiplying critical destruction."*
  - **Effect Text**: `+21% crit chance and dmg`

---

### 1.4 Abyssal Scarlet Mantle (`AbyssalScarletMantle`)
- **Type**: Accessory ([Accessory](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/abstractClasses/Accessory.kt))
- **Slot**: Accessory (Equippable by all adventurer classes)
- **Sprite**: `R.drawable.abyssal_scarlet_mantle` (32×32 RGBA in [abyssal_scarlet_mantle.png](file:///C:/Repositories/IGM-Modded/app/src/main/res/drawable/abyssal_scarlet_mantle.png))
- **Base Stats**:
  - `constitution`: `50`
  - `dexterity`: `50`
  - `intelligence`: `50`
  - `criticalChance`: `0.35` (+35%)
  - `criticalDamage`: `0.40` (+40%)
- **Recipe**:
  - 1× `EldritchScarletCape` + 10× `AncestralBlood`
- **Price**: 204,465L + (10 × 1,000L) = `214465L`
- **Strings**:
  - **Name**: `Abyssal Scarlet Mantle`
  - **Description**: *"An awe-inspiring mantle saturated with Ancestral Blood from the deepest abyss. Its suffocating crimson aura elevates all mortal faculties to mythical heights, delivering cataclysmic critical strikes."*
  - **Effect Text**: `+35% crit chance, +40% crit dmg`

---

## 2. Technical Architecture & Integration Points

### 2.1 Crafting Engine 4-Slot Extension
To support `ScarletOniJuggernaut`'s 4-ingredient recipe while preserving layout symmetry and vanilla compatibility:
1. **Layout XMLs**:
   - `layout_craft.xml`: Add `plus_sign_3` and `ingredient_4` (layout="@layout/layout_item"). Anchor `ingredient_4` to `ingredient_3`, and re-anchor `arrow` and `result` to `ingredient_4`.
   - `layout_craft_big.xml`: Add `plus_sign_3` and `ingredient_4` (layout="@layout/layout_item_big"). Adjust horizontal spacing/margins (10dp) so 4 ingredients fit comfortably within dialog boundaries.
   - `layout_craft_named.xml`: Add `plus_sign_3` and `ingredient_4` (layout="@layout/layout_item").
2. **Dialog & Adapter Code**:
   - [DialogCraft.kt](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogCraft.kt): In `populateCraftLayout()` and `changeAmount()`, add binding for `recipes.getIngredients().getOrNull(3)`.
   - [DialogItemDetail.kt](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogItemDetail.kt): In `populateCraftLayout()`, add binding for `ingredients.getOrNull(3)`.
   - [UIUtils.kt](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/UIUtils.kt): In `craftRecipe()`, bind `ingredient4` and `plusSign3` when present.

### 2.2 Concrete Item Classes
Under `it.paranoidsquirrels.idleguildmaster.storage.data.items.instances`:
1. `ScarletOniJuggernaut.kt`: Extends `HeavyArmor()`.
2. `ScarletCape.kt`: Extends `Accessory()`.
3. `EldritchScarletCape.kt`: Extends `Accessory()`.
4. `AbyssalScarletMantle.kt`: Extends `Accessory()`.

### 2.3 Crafting Recipes ([Recipes.kt](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/Recipes.kt))
Add to `Recipes` enum:
```kotlin
ScarletOniJuggernaut(Item.getInstance("ScarletOni", 1), Item.getInstance("MysteriousCog", 5), Item.getInstance("HeartOfDarkness", 10), Item.getInstance("EldritchSeal", 1)),
ScarletCape(Item.getInstance("ScarletStrand", 10)),
EldritchScarletCape(Item.getInstance("ScarletCape", 1), Item.getInstance("EldritchSeal", 5)),
AbyssalScarletMantle(Item.getInstance("EldritchScarletCape", 1), Item.getInstance("AncestralBlood", 10)),
```

### 2.4 Retroactive Recipe Discovery ([MainActivity.kt](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/MainActivity.kt))
Include all 4 new recipes in `retroactivelyAddKnownRecipes()`:
```kotlin
for (recipes in listOf(
    Recipes.VoltaicShock,
    Recipes.ScarletOni,
    Recipes.ScarletSigil,
    Recipes.ScarletOniJuggernaut,
    Recipes.ScarletCape,
    Recipes.EldritchScarletCape,
    Recipes.AbyssalScarletMantle
)) { ... }
```

### 2.5 Localization Strings ([strings.xml](file:///C:/Repositories/IGM-Modded/app/src/main/res/values/strings.xml))
Register name, description, and effect strings for each of the 4 items.

### 2.6 Save Editor Support ([save_editor/data.js](file:///C:/Repositories/IGM-Modded/save_editor/data.js))
1. Copy all 4 images (`scarlet_oni_juggernaut.png`, `scarlet_cape.png`, `eldritch_scarlet_cape.png`, `abyssal_scarlet_mantle.png`) to `save_editor/images/`.
2. Register item entries in `data.js`.

---

## 3. Verification Plan

### Automated Tests
- Run `./gradlew testDebugUnitTest` to ensure all unit tests pass, item instantiate properly, and `checkPrices()` / recipe validation passes.

### Manual Verification
- In Workshop, verify the 4 new recipes appear with accurate ingredient icons, quantities, and result previews.
- Verify 4-ingredient craft dialog for `ScarletOniJuggernaut`:
  - Displays all 4 ingredients: `ScarletOni` + `MysteriousCog` (5) + `HeartOfDarkness` (10) + `EldritchSeal` (1).
  - Quantity slider scales ingredient counts correctly.
  - Crafting deducts all 4 items from inventory and places `ScarletOniJuggernaut` in the workshop queue.
- Verify Cape accessory progression:
  - `ScarletCape` can be equipped into any adventurer's accessory slot, applying +30 CON/DEX/INT and +15% crit chance.
  - Upgrading to `EldritchScarletCape` applies +40 CON/DEX/INT and +21% crit chance/dmg.
  - Upgrading to `AbyssalScarletMantle` applies +50 CON/DEX/INT and +35% crit chance / +40% crit dmg.
- Verify Save Editor loads and edits the 4 new items seamlessly.
