# Shop Rework: Categorized Shop, New Bundles & Rebalanced Perks

## Goal Description
Rework the in-game Shop (`DialogShop`) from real-money in-app purchases (Google Play Billing / `IAPWrapper`) to in-game **Gem** unlocks with a **categorized navigation system**. 

The shop is organized into 7 distinct categories: **Starter Bundle**, **Adventurer Bundle**, **Companion Bundle**, **Merchant Bundle**, **Workshop Bundle**, **Storage Bundle**, and **Utility Bundle**. Storage spaces, workshop stats, and utility perks are cleanly separated into dedicated packs. Pack names are updated to avoid repetition, a Level 50 5-trait pet pack (**Senko**) is introduced at 2,500 Gems, all adventurer packs strictly feature **Tier 4** units, duplicate purchase protections are enforced, and top-tier packs utilize the new `shop_3.png` asset (+3 bonus).

---

## User Review Required

> [!IMPORTANT]
> ### 1. Complete Shop Categories & Pack Breakdown
> 
> #### 📦 Category 1: Starter Bundle
> *Renamed to prevent repetitive naming; storage, no-ads, and gem bonuses removed.*
> - **Guild Initiate Pack** (formerly *Starter Pack*): `500 Gems`
>   - *Unlocks*: Quarters +1 (`shop_1`), Tavern +1 (`shop_1`), Workshop +1 (`shop_1`), Market +1 (`shop_1`).
> - **Explorer's Supply Cache** (formerly *Adventurer Pack*): `1,000 Gems`
>   - *Unlocks*: Quarters +2 (`shop_2`), Tavern +2 (`shop_2`), 4× Dreamcatcher, 1× Vial of Subjugation (Evo23Vial2).
> 
> ---
> 
> #### ⚔️ Category 2: Adventurer Bundle (`5,000 Gems` each)
> *All adventurer packs strictly contain **Tier 4 (`maxLevel = 20`)** units with upgraded PLUS basic traits, rare traits, Quarters +4 (`shop_4`), and 1× Intercession.*
> 
> | Pack | Unit | ID | Class / Role | Tier | Basic Trait | Rare Trait | Starting Weapon |
> | :--- | :--- | :---: | :--- | :---: | :--- | :--- | :--- |
> | **Imperial Vanguard** | Holy Knight | `-10` | Tank / Holy DPS | **T4** | `BRUTE_PLUS` (+STR++) | `BLESSED` (+Holy synergy) | Spade (Sword) |
> | *(5,000 Gems)* | White Mage | `-11` | Main Healer | **T4** | `BOOKWORM_PLUS` (+INT++) | `EMPATHETIC` (+Healing power) | Cane (Staff) |
> | | Red Mage | `-12` | Fire DPS Caster | **T4** | `BOOKWORM_PLUS` (+INT++) | `GIFTED` (+Magic damage) | Cane (Staff) |
> | | Sureshot | `-13` | Single-target Ranged | **T4** | `FERAL_PLUS` (+DEX++) | `RUTHLESS` (+Crit damage) | TrainingBow (Bow) |
> | **Unholy Crusade** | Dark Knight | `-20` | Tank / Darkness DPS | **T4** | `BRUTE_PLUS` (+STR++) | `FOCUSED` (+Crit chance) | Spade (Sword) |
> | *(5,000 Gems)* | Necromancer | `-21` | Dark Summoner/DPS | **T4** | `BOOKWORM_PLUS` (+INT++) | `CURSED` (+Dark/Curse synergy) | Cane (Staff) |
> | | Assassin | `-22` | Burst Melee DPS | **T4** | `FERAL_PLUS` (+DEX++) | `RUTHLESS` (+Crit damage) | Sickle (Dagger) |
> | | Poison Bow | `-23` | Poison / AoE Ranged | **T4** | `FERAL_PLUS` (+DEX++) | `ALERT` (+Initiative/Speed) | TrainingBow (Bow) |
> | **[NEW] Primal Vanguard** | Wolf Rider | `-30` | Mobile Mounted DPS | **T4** | `FERAL_PLUS` (+DEX++) | `ALERT` (+Initiative/Speed) | TrainingBow (Bow) |
> | *(5,000 Gems)* | Shadow Dancer | `-31` | Evasion Melee DPS | **T4** | `FERAL_PLUS` (+DEX++) | `NIMBLE` (+Dodge/Evasion) | Sickle (Dagger) |
> | | Silver Tongue | `-32` | Buffer / Saboteur | **T4** | `BOOKWORM_PLUS` (+INT++) | `EMPATHETIC` (+Support synergy) | Sickle (Dagger) |
> | | Iron Warden | `-33` | Regeneration Bruiser | **T4** | `BRUTE_PLUS` (+STR++) | `TROLL_BLOOD` (+HP Regen) | Spade (Sword) |
> 
> ---
> 
> #### 🦊 Category 3: Companion Bundle
> - **[NEW] Senko's Celestial Bond**: `2,500 Gems`
>   - *Unlocks*: Unique 5-Trait Pet **Senko** instantiated directly at **Level 50**:
>     - Level: `50`
>     - Trait 1: `PetAbility.HEALER` (+Healing output)
>     - Trait 2: `PetAbility.REGENERATION` (+Health regen)
>     - Trait 3: `PetAbility.DROPS` (+Drop rate)
>     - Trait 4: `PetAbility.EXPERIENCE` (+Experience gain)
>     - Trait 5: *Kitsune Spirit Blessing* (Inherent Senko ability: at Level 50, grants a **+30% healing multiplier**)
>   - *Bonus*: Shelter Capacity +1 (ensures immediate room in the shelter).
> 
> ---
> 
> #### ⚖️ Category 4: Merchant Bundle (4 Progressive Tiers)
> *Workshop queue, workshop speed, storage, and max loot removed.*
> - **Apprentice Trader's Permit**: `500 Gems` $\rightarrow$ Market Listings +1 (`shop_1`), Market Speed +15%.
> - **Journeyman Merchant's Charter**: `750 Gems` $\rightarrow$ Market Listings +2 (`shop_2`), Market Speed +25%.
> - **Grand Merchant's License** (formerly *Merchant Pack*): `1,000 Gems` $\rightarrow$ Market Listings +2 (`shop_2`), Market Speed +35%.
> - **Trade Baron's Monopoly**: `1,500 Gems` $\rightarrow$ Market Listings +3 (`shop_3`), Market Speed +45%.
> *(Total stack if all 4 unlocked: Market Listings +8, Market Speed +120%).*
> 
> ---
> 
> #### 🔨 Category 5: Workshop Bundle (4 Progressive Tiers)
> - **Apprentice Craftsman's Kit**: `500 Gems` $\rightarrow$ Workshop Queue +1 (`shop_1`), Workshop Speed +15%.
> - **Journeyman Smith's Forge**: `750 Gems` $\rightarrow$ Workshop Queue +2 (`shop_2`), Workshop Speed +25%.
> - **Master Artificer's Workshop**: `1,000 Gems` $\rightarrow$ Workshop Queue +2 (`shop_2`), Workshop Speed +35%.
> - **Grandmaster's Legendary Anvil**: `1,500 Gems` $\rightarrow$ Workshop Queue +3 (`shop_3`), Workshop Speed +45%.
> *(Total stack if all 4 unlocked: Workshop Queue +8, Workshop Speed +120%).*
> 
> ---
> 
> #### 🎒 Category 6: Storage Bundle
> *All storage spaces removed from other packs and consolidated into dedicated storage upgrades.*
> - **Minor Storage Vault**: `500 Gems` $\rightarrow$ `+35 Storage Spaces`
> - **Expanded Storage Vault**: `750 Gems` $\rightarrow$ `+50 Storage Spaces`
> - **Grand Storage Vault**: `1,000 Gems` $\rightarrow$ `+70 Storage Spaces`
> 
> ---
> 
> #### 🛠️ Category 7: Utility Bundle
> - **Deep Pockets Haul**: `750 Gems`
>   - *Unlocks*: `+1,000 Max Loot Capacity` (increases area loot cap from 2,000 to 3,000).
> - **Extended Vigil (Chronos Hourglass)**: `750 Gems`
>   - *Unlocks*: `+6 Max Idle Hours` (increases idle offline progress cap from 12 hours to 18 hours).
> - **Sacred Intercession**: `500 Gems`
>   - *Unlocks*: Grants `1× Intercession` consumable (allows re-rolling/resetting adventurer traits).

> [!NOTE]
> **Category Navigation Design:**
> The Shop dialog header will feature a horizontal scrollable category bar:
> `[All] [Starter] [Adventurers] [Companions] [Merchant] [Workshop] [Storage] [Utility]`
> Selecting a category filters the displayed packs or smoothly scrolls to that category's section.

> [!NOTE]
> **Save Compatibility & "Already Bought" State:**
> - When importing a save from the base game or previous versions, all existing flags are preserved.
> - If a pack is owned, its button displays an unclickable **"PURCHASED"** state alongside the brass checkmark.
> - Click listeners are strictly guarded with `if (isPurchased) return` to prevent duplicate purchases or gem deductions.

---

## Proposed Changes

### Data & Save Layer

#### [MODIFY] [Data.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/Data.kt)
- Add serialization flags for all new packs:
  - `@SerializedName("primalVanguardPurchased") var isPrimalVanguardPurchased: Boolean = false`
  - `@SerializedName("senkoPackPurchased") var isSenkoPackPurchased: Boolean = false`
  - **Merchant Bundle**:
    - `@SerializedName("apprenticeMerchantPurchased") var isApprenticeMerchantPurchased: Boolean = false`
    - `@SerializedName("journeymanMerchantPurchased") var isJourneymanMerchantPurchased: Boolean = false`
    - `@SerializedName("tradeBaronPurchased") var isTradeBaronPurchased: Boolean = false`
  - **Workshop Bundle**:
    - `@SerializedName("apprenticeWorkshopPurchased") var isApprenticeWorkshopPurchased: Boolean = false`
    - `@SerializedName("journeymanWorkshopPurchased") var isJourneymanWorkshopPurchased: Boolean = false`
    - `@SerializedName("masterWorkshopPurchased") var isMasterWorkshopPurchased: Boolean = false`
    - `@SerializedName("grandmasterWorkshopPurchased") var isGrandmasterWorkshopPurchased: Boolean = false`
  - **Storage Bundle**:
    - `@SerializedName("storagePack35Purchased") var isStoragePack35Purchased: Boolean = false`
    - `@SerializedName("storagePack50Purchased") var isStoragePack50Purchased: Boolean = false`
    - `@SerializedName("storagePack70Purchased") var isStoragePack70Purchased: Boolean = false`
  - **Utility Bundle**:
    - `@SerializedName("maxLootPackPurchased") var isMaxLootPackPurchased: Boolean = false`
    - `@SerializedName("idleHoursPackPurchased") var isIdleHoursPackPurchased: Boolean = false`

#### [MODIFY] [DataDeserializer.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/DataDeserializer.kt)
- Deserialize each new pack flag from JSON:
  - `this.data.isPrimalVanguardPurchased = asJsonObject.has("primalVanguardPurchased") && asJsonObject.get("primalVanguardPurchased").asBoolean`
  - `this.data.isSenkoPackPurchased = asJsonObject.has("senkoPackPurchased") && asJsonObject.get("senkoPackPurchased").asBoolean`
  - `this.data.isApprenticeMerchantPurchased = asJsonObject.has("apprenticeMerchantPurchased") && asJsonObject.get("apprenticeMerchantPurchased").asBoolean`
  - `this.data.isJourneymanMerchantPurchased = asJsonObject.has("journeymanMerchantPurchased") && asJsonObject.get("journeymanMerchantPurchased").asBoolean`
  - `this.data.isTradeBaronPurchased = asJsonObject.has("tradeBaronPurchased") && asJsonObject.get("tradeBaronPurchased").asBoolean`
  - `this.data.isApprenticeWorkshopPurchased = asJsonObject.has("apprenticeWorkshopPurchased") && asJsonObject.get("apprenticeWorkshopPurchased").asBoolean`
  - `this.data.isJourneymanWorkshopPurchased = asJsonObject.has("journeymanWorkshopPurchased") && asJsonObject.get("journeymanWorkshopPurchased").asBoolean`
  - `this.data.isMasterWorkshopPurchased = asJsonObject.has("masterWorkshopPurchased") && asJsonObject.get("masterWorkshopPurchased").asBoolean`
  - `this.data.isGrandmasterWorkshopPurchased = asJsonObject.has("grandmasterWorkshopPurchased") && asJsonObject.get("grandmasterWorkshopPurchased").asBoolean`
  - `this.data.isStoragePack35Purchased = asJsonObject.has("storagePack35Purchased") && asJsonObject.get("storagePack35Purchased").asBoolean`
  - `this.data.isStoragePack50Purchased = asJsonObject.has("storagePack50Purchased") && asJsonObject.get("storagePack50Purchased").asBoolean`
  - `this.data.isStoragePack70Purchased = asJsonObject.has("storagePack70Purchased") && asJsonObject.get("storagePack70Purchased").asBoolean`
  - `this.data.isMaxLootPackPurchased = asJsonObject.has("maxLootPackPurchased") && asJsonObject.get("maxLootPackPurchased").asBoolean`
  - `this.data.isIdleHoursPackPurchased = asJsonObject.has("idleHoursPackPurchased") && asJsonObject.get("idleHoursPackPurchased").asBoolean`

#### [MODIFY] [Formulas.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/Formulas.kt)
- Update formula bonuses according to the new bundles:
  - **Quarters**:
    ```kotlin
    var packBonus = if (MainActivity.data.isStarterPackPurchased) 1 else 0
    if (MainActivity.data.isAdventurerPackPurchased) packBonus += 2
    if (MainActivity.data.isImperialVanguardPurchased) packBonus += 4
    if (MainActivity.data.isUnholyCrusadePurchased) packBonus += 4
    if (MainActivity.data.isPrimalVanguardPurchased) packBonus += 4
    ```
  - **Shelter**:
    ```kotlin
    var packBonus = if (MainActivity.data.isSenkoPackPurchased) 1 else 0
    return MainActivity.data.levelShelter + MainActivity.data.upgradeShelter + 2 + packBonus
    ```
  - **Workshop Queue**:
    ```kotlin
    var packBonus = if (MainActivity.data.isStarterPackPurchased) 1 else 0
    if (MainActivity.data.isApprenticeWorkshopPurchased) packBonus += 1
    if (MainActivity.data.isJourneymanWorkshopPurchased) packBonus += 2
    if (MainActivity.data.isMasterWorkshopPurchased) packBonus += 2
    if (MainActivity.data.isGrandmasterWorkshopPurchased) packBonus += 3
    ```
  - **Market Listings**:
    ```kotlin
    var packBonus = if (MainActivity.data.isStarterPackPurchased) 1 else 0
    if (MainActivity.data.isApprenticeMerchantPurchased) packBonus += 1
    if (MainActivity.data.isJourneymanMerchantPurchased) packBonus += 2
    if (MainActivity.data.isMerchantPackPurchased) packBonus += 2
    if (MainActivity.data.isTradeBaronPurchased) packBonus += 3
    ```
  - **Storage Spaces**:
    *(Removed from Starter, Adventurer, and Merchant packs)*
    ```kotlin
    var packBonus = 0
    if (MainActivity.data.isStoragePack35Purchased) packBonus += 35
    if (MainActivity.data.isStoragePack50Purchased) packBonus += 50
    if (MainActivity.data.isStoragePack70Purchased) packBonus += 70
    ```

#### [MODIFY] [Item.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/Item.kt) & [Area.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/Area.kt)
- Update merchant discount calculation in `Item.kt` (accumulate discount according to unlocked merchant tiers).
- Update max loot in `Area.kt`:
  ```kotlin
  val bonusLoot = if (MainActivity.data.isMaxLootPackPurchased) 1000 else 0
  val effectiveCap = if (lootCap > 0) lootCap else (2000 + bonusLoot)
  return stack >= effectiveCap
  ```

#### [MODIFY] [MainActivity.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/MainActivity.kt)
- Update idle progress cap in `initializeThreads()`:
  ```kotlin
  val bonusIdleHours = if (data.isIdleHoursPackPurchased) 6 else 0
  val vanillaCap = ((Math.min(4, 4) + 8) + bonusIdleHours) * Utils.ONE_HOUR_IN_SECONDS
  ```

---

### UI & Layout

#### [MODIFY] [dialog_shop.xml](file:///c:/Repositories/IGM-Modded/app/src/main/res/layout/dialog_shop.xml)
- **Category Navigation Header**:
  - Add a horizontal `HorizontalScrollView` containing category chips:
    `[All]` `[Starter]` `[Adventurers]` `[Companions]` `[Merchant]` `[Workshop]` `[Storage]` `[Utility]`.
- **Remove Real-Money Elements**:
  - Hide `constraint_gems_1` through `constraint_gems_4`.
- **Category Containers & shop_3 Integration**:
  - Group packs under 7 category container layouts / section headers:
    1. **Starter Category**:
       - `constraint_starter_pack` (Guild Initiate Pack): quarters +1 (`shop_1`), tavern +1 (`shop_1`), workshop +1 (`shop_1`), market +1 (`shop_1`).
       - `constraint_adventurer_pack` (Explorer's Supply Cache): quarters +2 (`shop_2`), tavern +2 (`shop_2`), dreamcatcher 4x, evo vial 1x.
    2. **Adventurer Category**:
       - Imperial Vanguard (Holy Knight, White Mage, Red Mage, Sureshot - all Tier 4)
       - Unholy Crusade (Dark Knight, Necromancer, Assassin, Poison Bow - all Tier 4)
       - Primal Vanguard (Wolf Rider, Shadow Dancer, Silver Tongue, Iron Warden - all Tier 4)
    3. **Companion Category**:
       - Senko's Celestial Bond (Level 50 Pet Senko with 5 traits preview + Shelter +1)
    4. **Merchant Category**:
       - Apprentice Trader's Permit (Market +1 via `shop_1`, Speed +15%)
       - Journeyman Merchant's Charter (Market +2 via `shop_2`, Speed +25%)
       - Grand Merchant's License (Market +2 via `shop_2`, Speed +35%)
       - Trade Baron's Monopoly (Market +3 via `shop_3`, Speed +45%)
    5. **Workshop Category**:
       - Apprentice Craftsman's Kit (Queue +1 via `shop_1`, Speed +15%)
       - Journeyman Smith's Forge (Queue +2 via `shop_2`, Speed +25%)
       - Master Artificer's Workshop (Queue +2 via `shop_2`, Speed +35%)
       - Grandmaster's Legendary Anvil (Queue +3 via `shop_3`, Speed +45%)
    6. **Storage Category**:
       - Minor Storage Vault (+35 Spaces)
       - Expanded Storage Vault (+50 Spaces)
       - Grand Storage Vault (+70 Spaces)
    7. **Utility Category**:
       - Deep Pockets Haul (+1,000 Max Loot)
       - Extended Vigil (+6 Max Idle Hours)
       - Sacred Intercession (1× Intercession consumable)

---

### Shop Logic

#### [MODIFY] [DialogShop.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogShop.kt)
- **Category Filtering**:
  - Implement click listeners on category chips to toggle visibility of corresponding category containers.
- **Adventurer Definitions**:
  - Imperial Vanguard: `-10` to `-13`
  - Unholy Crusade: `-20` to `-23`
  - Primal Vanguard: `-30` to `-33`
- **Senko Pet Reward Handling**:
  - When purchasing Senko's Celestial Bond:
    ```kotlin
    val senko = Pet.getInstance(
        "Senko",
        -100, // Negative ID for unique shop pet
        50,   // Level 50!
        0,    // Food 0
        PetAbility.HEALER,
        PetAbility.REGENERATION,
        PetAbility.DROPS,
        PetAbility.EXPERIENCE
    )
    MainActivity.data.pets.add(senko)
    ```
- **Utility Rewards Handling**:
  - Deep Pockets: `data.isMaxLootPackPurchased = true`
  - Extended Vigil: `data.isIdleHoursPackPurchased = true`
  - Sacred Intercession: `Utils.collectItem(Item.getInstance("Intercession", 1), MainActivity.data.items)`
- **Universal Purchase Flow**:
  - Check `MainActivity.data.gems >= cost`.
  - Confirmation dialog with pack title and cost.
  - On confirm:
    - Deduct gems.
    - Set purchase flag (or grant consumable).
    - Apply corresponding bonuses.
    - `amountOfPurchases += 1`.
    - Update UI and save immediately via `FileManager.saveNow(context)`.

---

## Verification Plan

### Automated Tests
- Build verification:
  ```powershell
  ./gradlew assembleDebug
  ```
- Unit tests:
  ```powershell
  ./gradlew testDebugUnitTest
  ```

### Manual Verification
1. **Category Navigation**:
   - Tap each category chip (`All`, `Starter`, `Adventurers`, `Companions`, `Merchant`, `Workshop`, `Storage`, `Utility`) and verify correct bundles are shown.
2. **Tier 4 Adventurers**:
   - Verify all units in Imperial Vanguard, Unholy Crusade, and Primal Vanguard are Tier 4 (`maxLevel = 20`) with correct PLUS and rare traits.
3. **Companion Pack (Senko)**:
   - Purchase Senko pack for `2,500 Gems` $\rightarrow$ verify Senko is added at **Level 50**, all 5 traits active (+30% Kitsune blessing multiplier), and Shelter capacity is increased by +1.
4. **Merchant & Workshop Progressions & shop_3**:
   - Verify all 4 tiers of Merchant packs grant correct listings (+1, +2, +2, +3) and display `shop_1`, `shop_2`, and `shop_3`.
   - Verify all 4 tiers of Workshop packs grant correct queue (+1, +2, +2, +3) and display `shop_1`, `shop_2`, and `shop_3`.
5. **Storage & Utility Packs**:
   - Verify storage vault packs increase capacity by +35, +50, +70.
   - Verify Deep Pockets increases loot cap to 3000.
   - Verify Extended Vigil increases idle cap by +6 hours (18 hours).
   - Verify Sacred Intercession grants 1× Intercession in inventory.
6. **Save Persistence**:
   - Restart app $\rightarrow$ verify all purchases remain unlocked.
