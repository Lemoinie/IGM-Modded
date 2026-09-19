# Shelter Upgrade: Effectiveness Implementation Plan

## 1. Overview
Add a new two-stage upgrade for the Pet Shelter called **Effectiveness** that increases the feed power of food consumed via **Auto-Feed** by +10% per level, up to a maximum of **+100% (Level 10)**:
- **5 Gold Tiers** (purchased directly in the Shelter dialog after unlocking Auto-Feed):
  - Lv 1: 5 Gold (50,000 Copper) $\to$ +10%
  - Lv 2: 50 Gold (500,000 Copper) $\to$ +20%
  - Lv 3: 5 Platinum (5,000,000 Copper) $\to$ +30%
  - Lv 4: 50 Platinum (50,000,000 Copper) $\to$ +40%
  - Lv 5: 5 Diamond (500,000,000 Copper) $\to$ +50%
- **5 Gem Tiers** (purchased as `UpgradeShelterEffectiveness` items from Traveling Merchant / Black Market):
  - Cost: 1,000 gems each (up to 5 purchases) $\to$ +10% per purchase (up to +50% total from gems)
  - Uses icon `R.drawable.upgrade_shelter`
- **Total Bonus**: Up to **+100%** (10 levels $\times$ 10%). A food with 10 feed power yields 20 feed power when auto-fed at max level.
- **Scope Restriction**: Effectiveness **only** applies to food consumed via dungeon/raid Auto-Feed collection (`Utils.collectDrops`), never manual feeding from inventory.

---

## 2. Proposed Changes

### Data & Persistence Layer
#### [MODIFY] [Data.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/Data.kt)
- Add `@SerializedName("levelShelterEffectiveness") var levelShelterEffectiveness: Int = 0` (Gold tiers 0..5).
- Add `@SerializedName("upgradeShelterEffectiveness") var upgradeShelterEffectiveness: Int = 0` (Gem tiers 0..5).
- Register `"UpgradeShelterEffectiveness"` in `seenItems`.

#### [MODIFY] [DataDeserializer.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/DataDeserializer.kt)
- Deserialize `levelShelterEffectiveness` and `upgradeShelterEffectiveness` with fallback to `0`.

---

### Item & Formulas Layer
#### [NEW] [UpgradeShelterEffectiveness.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/instances/UpgradeShelterEffectiveness.kt)
- Subclass of `Upgrade`.
- Configured with:
  - `idName = R.string.upgrade_shelter_effectiveness_name`
  - `idDescription = R.string.upgrade_shelter_effectiveness_description`
  - `idImage = R.drawable.upgrade_shelter`
  - `gemPrice = 1000`
  - `price = 1L`
  - `notSellable = true`
- On `use()`: increments `MainActivity.data.upgradeShelterEffectiveness++`.

#### [MODIFY] [Formulas.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/Formulas.kt)
- `getShelterEffectivenessPrice(): Long`:
  - Lv 0 $\to$ 50,000L (5 Gold)
  - Lv 1 $\to$ 500,000L (50 Gold)
  - Lv 2 $\to$ 5,000,000L (5 Platinum)
  - Lv 3 $\to$ 50,000,000L (50 Platinum)
  - Lv 4 $\to$ 500,000,000L (5 Diamond)
  - Lv $\ge 5 \to$ `IMPOSSIBLY_HIGH_PRICE`
- `getShelterEffectivenessPercent(): Int`:
  - `(levelShelterEffectiveness + upgradeShelterEffectiveness) * 10`

---

### Logic & Drop Collection Layer
#### [MODIFY] [Utils.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/Utils.kt)
- In `collectDrops(fragment: Fragment, area: Area)`:
  - Calculate `effectiveFeedPower = Math.round(feedPower * (1.0 + Formulas.getShelterEffectivenessPercent() * 0.01)).toInt()`
  - Distribute `effectiveFeedPower / size` to favorite pets.
- In `rollUpgrades()`:
  - Offer `UpgradeShelterEffectiveness` when `levelShelterAutofeed >= 1 && upgradeShelterEffectiveness < 5`.

---

### UI Layer
#### [MODIFY] [DialogShelter.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogShelter.kt)
- When `levelShelterAutofeed == 0`:
  - Shows "Auto-feed" button as in vanilla.
- When `levelShelterAutofeed >= 1`:
  - The right-hand upgrade button seamlessly becomes "Effectiveness (Lv. X/5)" displaying `getShelterEffectivenessPrice()`.
  - Description shows:
    - `- Long press to mark a pet for auto feeding`
    - `- Auto-feed food value: +X%` (when total percentage > 0)
  - Once `levelShelterEffectiveness >= 5`, the button is hidden (`GONE`).
- Add confirmation dialog support and `upgradeShelterEffectiveness()` purchase method.

#### [MODIFY] [strings.xml](file:///c:/Repositories/IGM-Modded/app/src/main/res/values/strings.xml)
- Add:
  - `headquarters_shelter_upgrade_effectiveness`: `Effectiveness (%d/5)`
  - `headquarters_shelter_upgrade_effectiveness_confirm`: `Effectiveness`
  - `headquarters_shelter_description_effectiveness`: `- Auto-feed food value: +%d%%`
  - `upgrade_shelter_effectiveness_name`: `Upgrade: Effectiveness`
  - `upgrade_shelter_effectiveness_description`: `Permanently increases Shelter auto-feed effectiveness by 10%.`
- Add localized strings across supported language files.

---

## 3. Verification Plan
### Automated Tests
- In `ModFeaturesTest.kt`:
  - `testShelterEffectivenessPriceProgression`: Verify the 5 exact price tiers (50k, 500k, 5M, 50M, 500M copper).
  - `testShelterEffectivenessPercent`: Verify formula returns combined gold + gem percentage.
  - `testUpgradeShelterEffectivenessItem`: Verify item creation, gem price (1000), and `use()` incrementing counter up to 5.
  - `testAutoFeedEffectivenessMultiplication`: Verify `collectDrops` scales dropped food feed power by effectiveness percentage, while manual feed remains unamplified.
