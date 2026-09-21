# Implementation Plan: Legendary Scarlet Oni & Scarlet Sigil Armor

## Goal Description
Introduce two new endgame craftable legendary armors inspired by **Scarlet Veil**, completing a damage-focused Scarlet equipment trilogy across all three armor proficiencies:
- **Medium Armor**: [ScarletVeil](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/instances/ScarletVeil.kt) (270 HP, 30 CON, 24 DEX, 18% Crit Chance) $\rightarrow$ upgradable to [ScarletShroud](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/instances/ScarletShroud.kt).
- **Heavy Armor (New)**: `ScarletOni` (470 HP, 56 CON, 18% Crit Chance, 5% Crit Damage).
- **Light Armor (New)**: `ScarletSigil` (200 HP, 62 INT, 20% Crit Chance, +2 Mana Regen).

Both items trade traditional defensive values (0 Defense / 0 Magic Defense) for aggressive offensive multipliers, specialized stats, and high primary stat pools tailored for brute-force tank/warriors and arcane spellcasters.

---

## 1. Item Specifications & Formulas

### 1.1 Scarlet Oni (`ScarletOni`)
- **Category**: Heavy Armor ([HeavyArmor](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/abstractClasses/HeavyArmor.kt))
- **Eligible Classes**: Heavy armor users (Footman, Knight, Titan, Unchained, etc.)
- **Sprite**: `R.drawable.scarlet_oni` (already sized at 32×32 RGBA in [scarlet_oni.png](file:///C:/Repositories/IGM-Modded/app/src/main/res/drawable/scarlet_oni.png))
- **Base Stats**:
  - `maxHp`: `470`
  - `constitution`: `56`
  - `criticalChance`: `0.18` (+18%)
  - `criticalDamage`: `0.05` (+5%)
  - `defense`: `0`
  - `magicDefense`: `0`
- **Pricing**: `100000L` (5 × 20,000L [ScarletStrand](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/instances/ScarletStrand.kt) sell price, following the 1:1 ingredient valuation rule used by [ScarletVeil](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/instances/ScarletVeil.kt))
- **Recipe**:
  - 5× `ScarletStrand`
- **Flavor & Display Text**:
  - **Name**: `Scarlet Oni`
  - **Description**: *"A demonic visage forged from condensed Scarlet strands. Discarding conventional heavy plating, it surges with raw bloodlust that drives its wearer to strike down foes with brutal, crushing criticals."*
  - **Effect Text**: `+18% crit chance, +5% crit dmg`

### 1.2 Scarlet Sigil (`ScarletSigil`)
- **Category**: Light Armor ([LightArmor](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/abstractClasses/LightArmor.kt))
- **Eligible Classes**: Light armor users (Adept, Fire Mage, Ice Mage, Necromancer, Cleric, etc.)
- **Sprite**: `R.drawable.scarlet_sigil` (already sized at 32×32 RGBA in [scarlet_sigil.png](file:///C:/Repositories/IGM-Modded/app/src/main/res/drawable/scarlet_sigil.png))
- **Base Stats**:
  - `maxHp`: `200`
  - `intelligence`: `62`
  - `criticalChance`: `0.20` (+20%)
  - `criticalDamage`: `0.0` (None)
  - `manaRegen`: `2` (+2 Mana Regen per turn)
  - `defense`: `0`
  - `magicDefense`: `0`
- **Pricing**: `60893L` (3 × 20,000L `ScarletStrand` + 1 × 893L [EldritchSeal](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/instances/EldritchSeal.kt))
- **Recipe**:
  - 3× `ScarletStrand` + 1× `EldritchSeal`
- **Flavor & Display Text**:
  - **Name**: `Scarlet Sigil`
  - **Description**: *"An arcane focus intertwining otherworldly eldritch power with the lethal weave of the Scarlet strands. It channels intense occult resonance to fuel endless spellcasting and lethal critical surges."*
  - **Effect Text**: `+20% crit chance, +2 mana regen`

---

## 2. Technical Architecture & Integration Points

### 2.1 Equipment Engine: Mana Regeneration Support
In [Equipment.kt](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/abstractClasses/Equipment.kt):
- Add `@JvmField @Transient protected var manaRegen: Int = 0`.
- Add getters and setters:
  ```kotlin
  open fun getManaRegen(): Int = manaRegen
  open fun setManaRegen(i: Int) { manaRegen = i }
  ```

In [Adventurer.kt](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/adventurers/Adventurer.kt):
- Update `calculateManaRegen()` to include equipment bonuses:
  ```kotlin
  override fun calculateManaRegen(): Int {
      var mr = super.calculateManaRegen() + (doctrine?.bonusManaRegen() ?: 0)
      if (traitRare == Trait.GIFTED) mr += 2
      val w = weapon
      if (w != null) mr += w.getManaRegen()
      val a = armor
      if (a != null) mr += a.getManaRegen()
      val acc = accessory
      if (acc != null) mr += acc.getManaRegen()
      return mr
  }
  ```
- Automatically benefits combat turn ticks in [Area.kt](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/Area.kt#L1267) and UI display in [DialogEntityDetail.kt](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogEntityDetail.kt#L152).

### 2.2 Class Definitions
Create the two concrete item instance classes in `it.paranoidsquirrels.idleguildmaster.storage.data.items.instances`:
1. `ScarletOni.kt`: Extends `HeavyArmor()`, sets properties in `configureProperties()`.
   - `maxHp = 470`
   - `constitution = 56`
   - `criticalChance = 0.18`
   - `criticalDamage = 0.05`
2. `ScarletSigil.kt`: Extends `LightArmor()`, sets properties in `configureProperties()`.
   - `maxHp = 200`
   - `intelligence = 62`
   - `criticalChance = 0.20`
   - `manaRegen = 2`

Because item instantiation uses reflection via `Item.getInstance(name, stack)` in [Item.kt](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/Item.kt), defining the classes under this package immediately registers them with the engine.

### 2.3 Crafting Recipes ([Recipes.kt](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/Recipes.kt))
Add entries to the `Recipes` enum:
```kotlin
ScarletOni(Item.getInstance("ScarletStrand", 5)),
ScarletSigil(Item.getInstance("ScarletStrand", 3), Item.getInstance("EldritchSeal", 1)),
```

### 2.4 Retroactive Recipe Learning ([MainActivity.kt](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/MainActivity.kt))
In `retroactivelyAddKnownRecipes()`, include `Recipes.ScarletOni` and `Recipes.ScarletSigil` alongside `Recipes.VoltaicShock`:
```kotlin
private fun retroactivelyAddKnownRecipes() {
    for (recipes in listOf(Recipes.VoltaicShock, Recipes.ScarletOni, Recipes.ScarletSigil)) {
        for (ingredient in recipes.getIngredients()) {
            val tc = ingredient?.getTrueClass()
            if (tc != null && data.seenItems.contains(tc)) {
                data.knownRecipes.add(recipes)
                break
            }
        }
    }
}
```
*Benefit*: Any player who has previously encountered `ScarletStrand` or `EldritchSeal` will immediately have both recipes visible in their Workshop without needing to farm new drops.

### 2.5 Localization Strings ([strings.xml](file:///C:/Repositories/IGM-Modded/app/src/main/res/values/strings.xml))
Add string resources:
```xml
<!-- Scarlet Oni -->
<string name="armor_heavy_scarlet_oni_name">Scarlet Oni</string>
<string name="armor_heavy_scarlet_oni_description">A demonic visage forged from condensed Scarlet strands. Discarding conventional heavy plating, it surges with raw bloodlust that drives its wearer to strike down foes with brutal, crushing criticals.</string>
<string name="armor_heavy_scarlet_oni_effect">+18% crit chance, +5% crit dmg</string>

<!-- Scarlet Sigil -->
<string name="armor_light_scarlet_sigil_name">Scarlet Sigil</string>
<string name="armor_light_scarlet_sigil_description">An arcane focus intertwining otherworldly eldritch power with the lethal weave of the Scarlet strands. It channels intense occult resonance to fuel endless spellcasting and lethal critical surges.</string>
<string name="armor_light_scarlet_sigil_effect">+20% crit chance, +2 mana regen</string>
```

### 2.6 Save Editor Support ([save_editor/data.js](file:///C:/Repositories/IGM-Modded/save_editor/data.js))
1. Copy `scarlet_oni.png` and `scarlet_sigil.png` to [save_editor/images/](file:///C:/Repositories/IGM-Modded/save_editor/images/).
2. Add metadata entries to `save_editor/data.js` under their respective categories ("Heavy Armor" and "Light Armor") so the web save editor recognizes and renders them.

---

## 3. Verification Plan

### Automated Build & Unit Tests
Run `./gradlew testDebugUnitTest` to ensure compilation and existing suite integrity.

### Runtime Verification
1. Test recipe registration:
   - Check that `Recipes.into(Item.getInstance("ScarletOni"))` and `Recipes.into(Item.getInstance("ScarletSigil"))` return the corresponding recipes.
   - Verify ingredient checks and craftable amount calculations.
2. Test stats & combat evaluation:
   - Equip `ScarletOni` on a Heavy Armor adventurer $\rightarrow$ verify +470 HP, +56 CON, +18% crit chance, +5% crit damage.
   - Equip `ScarletSigil` on a Light Armor adventurer $\rightarrow$ verify +200 HP, +62 INT, +20% crit chance, +2 mana regen (shown in entity detail and verified during combat mana restoration).
3. Test UI rendering:
   - Inspect item details dialog, workshop craft dialog, and equipment selection dialog.
