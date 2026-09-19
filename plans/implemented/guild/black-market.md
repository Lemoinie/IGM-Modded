# Implementation Plan: Night Market / Black Market System & Economy Expansion

## Goal Description
Introduce a comprehensive **Night Market / Black Market** system to *Idle Guild Master*, expand facility gem upgrade limits (allowing up to 300 storage, 40 adventurers, 15 tavern recruits, 20 pets, and Level 40 workshop/market speed with safety clamps), and implement a new high-denomination currency tier: **Diamond Coin** ($1\text{ Diamond} = 100\text{ Platinum}$).

---

## Confirmed Design Specifications

> [!NOTE]
> All design decisions confirmed:
> 1. **Daily Cadence & Bad Luck Protection**:
>    - **Base Daily Chance**: **10% chance** per day (evaluated at the 24-hour daily reset `tick24Hours`).
>    - **Bad Luck Protection**: **6 consecutive missed days $\rightarrow$ 7th day is 100% guaranteed**.
>    - **Duration**: Remains open for the entire 24-hour cycle until the next daily reset.
> 2. **Smuggled Legendaries (1 Dedicated Slot)**:
>    - Pool: `ScarletStrand` and `Aegis`.
>    - **90% chance** to sell for **Gems at -35% discount** (`ScarletStrand` = 420 Gems, `Aegis` = 650 Gems).
>    - **10% rare chance** to sell for **Gold** (`ScarletStrand` = 75,000 Gold, `Aegis` = 120,000 Gold).
> 3. **Guild Upgrades (3 Dedicated Slots)**:
>    - Offers **3 unmaxed guild upgrades** at a **-35% gem discount**.
>    - Expanded limits to achieve target end-game capacities:
>      - `UpgradeStorage`: Expanded to **185 purchases** (Base 35 + Gold 80 + Gem 185 = **300 total storage spaces**). Price: **52 Gems** (-35%).
>      - `UpgradeQuarters`: Expanded to **15 purchases** (Base 2 + Gold 23 + Gem 15 = **40 total adventurer capacity**). Price: **325 Gems** (-35%).
>      - `UpgradeTavernCapacity`: Expanded to **7 purchases** (Base 1 + Gold 7 + Gem 7 = **15 tavern capacity**). Price: **325 Gems** (-35%).
>      - `UpgradeShelter`: Expanded to **7 purchases** (Base 2 + Gold 11 + Gem 7 = **20 pet shelter capacity**). Price: **325 Gems** (-35%).
>      - `UpgradeWorkshopTime` & `UpgradeMarketTime`: Expanded to **15 purchases** (Gold 25 + Gem 15 = **Level 40 speed**). Price: **195 Gems** (-35%).
>      - Queue upgrades (`WorkshopQueue`, `MarketQueue`): Base 500g $\rightarrow$ **325 Gems** (-35%).
> 4. **Speed Safeguard (`.coerceAtLeast(1L)`)**:
>    - In [Item.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/Item.kt), `getSecondsToCraft()` and `getSecondsToSell()` are clamped to a minimum of `1L` (1 second). This prevents division by zero (`ArithmeticException: / by zero`) in `DialogWorkshop` and `DialogMarket` when craft times drop below 1 second at Level 40 speed.
> 5. **New Currency Tier: Diamond Coin**:
>    - Value: **1 Diamond Coin = 100 Platinum Coins** = 10,000 Gold Coins = 1,000,000 Silver Coins = 100,000,000 Copper units (`100_000_000L`).
>    - Asset: Existing drawable [`coin_diamond.png`](file:///c:/Repositories/IGM-Modded/app/src/main/res/drawable/coin_diamond.png).
>    - Integrated into `layout_money.xml` and `UIUtils.populateMoneyContainer()` across all headquarters and dialog interfaces.
> 6. **Forbidden Evolution Vials (1 Slot)**:
>    - Strictly `Evo22Vial` (1,000 Gems) and `Evo23Vial` (1,200 Gems). No pet eggs, no generic curios/rings.
> 7. **Smuggled Materials (4 Slots)**:
>    - Rolled from unlocked dungeons at **-50% Gold price** (`5x` multiplier instead of `10x`).
> 8. **Contraband Potions (2 Slots) & Shady Delicacies (1 Slot)**:
>    - Potions: **-40% discount** (42–60 Gems, with 25% chance of gold equivalent).
>    - Delicacies: **-40% discount** (30–900 Gems).

---

## Detailed System Mechanics & Technical Specifications

### 1. New Currency System: Diamond Coin
- **Denominations**:
  - $1\text{ Copper} = 1\text{ unit}$
  - $1\text{ Silver} = 100\text{ Copper}$
  - $1\text{ Gold} = 100\text{ Silver} = 10,000\text{ Copper}$
  - $1\text{ Platinum} = 100\text{ Gold} = 1,000,000\text{ Copper}$
  - **$1\text{ Diamond} = 100\text{ Platinum} = 10,000\text{ Gold} = 100,000,000\text{ Copper}$**
- **Decomposition Formula in [UIUtils.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/UIUtils.kt)**:
  ```kotlin
  val copper = j % 100L
  val silver = ((j % 10000L) - copper) / 100L
  val gold = (((j % 1000000L) - (silver * 100L)) - copper) / 10000L
  val platinum = (((j % 100000000L) - (gold * 10000L) - (silver * 100L)) - copper) / 1000000L
  val diamond = j / 100000000L
  ```
- **Layout updates**: Add `image_diamond` and `amount_diamond` to `layout_money.xml` positioned to the left of `image_platinum`.

---

### 2. Speed Safeguard
- In [Item.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/Item.kt):
  ```kotlin
  open fun getSecondsToCraft(): Long {
      val discount = if (MainActivity.data.isMerchantPackPurchased) 0.6 else 1.0
      val timeMultiplier = Math.pow(0.9, (MainActivity.data.levelWorkshopTime + MainActivity.data.upgradeWorkshopTime - 1).toDouble())
      val calculated = (discount * timeMultiplier * Math.max(price - 1, 1L).toDouble() * 6.0 * stack.toDouble()).toLong()
      return calculated.coerceAtLeast(1L) // Safeguard against divide-by-zero crash
  }

  open fun getSecondsToSell(): Long {
      val discount = if (MainActivity.data.isMerchantPackPurchased) 0.6 else 1.0
      val timeMultiplier = Math.pow(0.9, (MainActivity.data.levelMarketTime + MainActivity.data.upgradeMarketTime - 1).toDouble())
      val calculated = (discount * timeMultiplier * price.toDouble() * 4.0 * stack.toDouble()).toLong()
      return calculated.coerceAtLeast(1L) // Safeguard against divide-by-zero crash
  }
  ```

---

### 3. Expanded Gem Upgrade Limits
In [Utils.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/Utils.kt):
```kotlin
fun rollUpgrades(): List<MerchantOffer> {
    val arrayList = ArrayList<Item>()
    if (MainActivity.data.upgradeStorage < 185) { // Allows reaching 300 total storage
        Item.getInstance("UpgradeStorage")?.let { arrayList.add(it) }
    }
    if (MainActivity.data.upgradeQuarters < 15) { // Allows reaching 40 total roster
        Item.getInstance("UpgradeQuarters")?.let { arrayList.add(it) }
    }
    if (MainActivity.data.upgradeTavernCapacity < 7) { // Allows reaching 15 tavern capacity
        Item.getInstance("UpgradeTavernCapacity")?.let { arrayList.add(it) }
    }
    if (MainActivity.data.upgradeShelter < 7) { // Allows reaching 20 shelter capacity
        Item.getInstance("UpgradeShelter")?.let { arrayList.add(it) }
    }
    if (MainActivity.data.upgradeWorkshopTime < 15) { // Allows reaching Level 40 speed
        Item.getInstance("UpgradeWorkshopTime")?.let { arrayList.add(it) }
    }
    if (MainActivity.data.upgradeMarketTime < 15) { // Allows reaching Level 40 speed
        Item.getInstance("UpgradeMarketTime")?.let { arrayList.add(it) }
    }
    if (MainActivity.data.upgradeTavernTime < 5) {
        Item.getInstance("UpgradeTavernTime")?.let { arrayList.add(it) }
    }
    if (MainActivity.data.upgradeWorkshopQueue < 1) {
        Item.getInstance("UpgradeWorkshopQueue")?.let { arrayList.add(it) }
    }
    if (MainActivity.data.upgradeMarketQueue < 1) {
        Item.getInstance("UpgradeMarketQueue")?.let { arrayList.add(it) }
    }
    // ...
}
```

---

### 4. 12-Slot Black Market Stall Configuration

| Stall Slot | Category | Selection & Pricing |
| :--- | :--- | :--- |
| **Slots 1–4** | **Smuggled Materials** | 4 random materials from unlocked dungeons at **$5\times$ sell price** (**-50% Gold**). |
| **Slot 5** | **Smuggled Legendary** | `ScarletStrand` or `Aegis`.<br>• **90%**: Gems (-35% $\rightarrow$ 420g / 650g)<br>• **10%**: Gold (250,000g / 500,000g) |
| **Slots 6–7** | **Contraband Potions** | 2 potions at **-40% Gems** (42–60g, 25% chance of Gold equivalent). |
| **Slot 8** | **Shady Delicacy** | 1 food (`GlazedDonut` to `CeremonialCake`) at **-40% Gems**. |
| **Slot 9** | **Evolution Vial** | `Evo22Vial` (1,000 Gems) or `Evo23Vial` (1,200 Gems). |
| **Slots 10–12** | **Guild Upgrades** | Up to **3 unmaxed upgrades** at **-35% Gems** (52g / 195g / 325g). |

---

## Proposed Changes

### 1. Currency & UI Layouts

#### [MODIFY] [layout_money.xml](file:///c:/Repositories/IGM-Modded/app/src/main/res/layout/layout_money.xml)
- Add `image_diamond` and `amount_diamond` constraints to the left of `image_platinum`.

#### [MODIFY] [UIUtils.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/UIUtils.kt)
- Update `populateMoneyContainer()` to handle Diamond coins ($10^8$ copper).
- Update `changeMoneyContainerColor()` to format `amount_diamond.setTextColor()`.

#### [MODIFY] [DialogMarket.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogMarket.kt)
- Update `itemBinding.price.amountDiamond.setTextColor(brassColor)`.

---

### 2. Core Game Speed & Capacity

#### [MODIFY] [Item.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/Item.kt)
- Add `.coerceAtLeast(1L)` to `getSecondsToCraft()` and `getSecondsToSell()`.

#### [MODIFY] [Utils.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/Utils.kt)
- Update `truncatePrice(j: Long)` for diamond coin scale.
- Update `rollUpgrades()` candidate bounds for `upgradeStorage`, `upgradeQuarters`, `upgradeTavernCapacity`, `upgradeShelter`, `upgradeWorkshopTime`, and `upgradeMarketTime`.
- Implement `checkBlackMarketDailyArrival()` (10% daily roll + 6-day miss protection).
- Implement `refreshBlackMarketStock()` for the 12-slot stall.

---

### 3. Black Market Data & Dialog

#### [MODIFY] [Data.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/Data.kt)
- Add fields: `isBlackMarketActive`, `isNewBlackMarketItems`, `blackMarketMissedDays`, `blackMarketStock`.

#### [MODIFY] [DataDeserializer.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/DataDeserializer.kt)
- Deserialize Black Market fields with backward compatibility.

#### [NEW] [DialogBlackMarket.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogBlackMarket.kt)
- Dark-themed 12-slot dialog with departure countdown timer and deal badges.

#### [NEW] [dialog_black_market.xml](file:///c:/Repositories/IGM-Modded/app/src/main/res/layout/dialog_black_market.xml)
- Layout for the nocturnal Black Market stall.

#### [MODIFY] [activity_main.xml](file:///c:/Repositories/IGM-Modded/app/src/main/res/layout/activity_main.xml)
- Add `@id/black_market` and `@id/new_black_market_items` to the top bar.

#### [MODIFY] [MainActivity.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/MainActivity.kt)
- Toggle icon visibility and handle dialog launch.

#### [MODIFY] [strings.xml](file:///c:/Repositories/IGM-Modded/app/src/main/res/values/strings.xml)
- Add localization strings.

---

## Verification Plan

### Automated Tests
- Unit test for currency decomposition:
  - Test 50 Copper $\rightarrow$ 50c
  - Test 1,500 Copper $\rightarrow$ 15s
  - Test 150,000 Copper $\rightarrow$ 15g
  - Test 15,000,000 Copper $\rightarrow$ 15p
  - Test 250,000,000 Copper $\rightarrow$ 2d 50p
- Unit test for speed clamp:
  - Assert `Item.getSecondsToCraft()` and `getSecondsToSell()` return $\ge 1$ at Level 40 speed.
- Unit test for expanded upgrade caps.
- Unit test for 10% Black Market roll and 6-day miss bad luck protection.

### Manual Verification
- Verify that having $>100$ platinum coins renders the diamond coin icon and count properly.
- Inspect `DialogWorkshop` with Level 40 speed: confirm craft bar animates smoothly without crashing.
- Open `DialogBlackMarket`: test purchasing items for Diamond/Platinum/Gold and Gems.
- Confirm that maxed upgrades disappear properly from the Black Market grid.
