# Shop Expansion: New Bundles, Extended Caps & Infrastructure

## Goal Description
Expand the in-game Shop (`DialogShop`) with new progression tiers, long-term Gem sinks, converted vanilla redeem codes into reasonably priced starter packs, and two dedicated new categories: **INFRASTRUCTURE** and **EQUIPMENT**.

This expansion includes:
1. **Converted Redeem Codes in Starter Bundle**: Reasonably priced packs replacing vanilla redeem codes (`f1r29u15eq`, `rotdrv9deq`, `f3hqt045`, `g394te91`) with full backward compatibility for existing saves.
2. **New Category: `EQUIPMENT`**: Dedicated to legendary weapons and armor, featuring the one-time **Celestial Bow** pack (`1,000 Gems`).
3. **New Category: `INFRASTRUCTURE`**: Dedicated guild building expansions with conservative Quarters (+1 per tier), Grand Tavern upgrades (-20% arrival interval & +2 capacity), and Pet Shelter expansions.
4. **Progressive Idle Time (Option C)**: Extended offline idle time in progressive steps up to **168 hours (7 days / 1 week)** via tiered Vigil packs.
5. **Storage Expansions**: Higher-tier dedicated storage vaults (+100 and +150 spaces).
6. **Utility Supplies**: One-time **Evolutionary Synthesis Crate** for key ascension materials.
7. **Thematic Adventurer Bundles**: Built strictly from real in-game classes.

---

## User Review Required

> [!IMPORTANT]
> ### 1. Converted Redeem Codes in Starter Bundle (Reasonably Priced)
> *Converts legacy vanilla redeem codes into accessible, reasonably priced packs in the **Starter Bundle**. Imported saves that already redeemed these codes automatically show them as PURCHASED (full backward compatibility).*
> 
> | Pack Name | Gem Cost | Origin Code | Contents | Backward Compatibility Flag |
> | :--- | :---: | :---: | :--- | :--- |
> | **Divine Champion Pack** | `500` | `f1r29u15eq` (Part 1) | • 1× `DivineChampion` (Level 45 Tier 7 Hero, `BRUTE_PLUS`, `FOCUSED`)<br>• 1× `ChampionArmor`<br>• 1× `SpikedPrimevalShield`<br>• 1× `GhastlyScimitar` | `isRedeem_f1r39h15` $\rightarrow$ `isDivineChampionPackPurchased = true` |
> | **Eternal Reliquary** | `500` | `f1r29u15eq` (Part 2) | • 2× `EternalHunger`<br>• 1× `ScarletVeil`<br>• 1× `ReassemblingJacket`<br>• 1× `SeekingGlass` | `isRedeem_f1r39h15` $\rightarrow$ `isEternalReliquaryPurchased = true` |
> | **Alchemist's Bounty** | `100` | `rotdrv9deq` (Part 1) | • **100× of all 11 permanent stat potions** (1,100 potions total: Constitution, Dexterity, Intelligence, Health, Defense, Magic Defense, Precision, Viciousness, Darkness, Immunity, Agility) | `isRedeem_potionsRefund1` $\rightarrow$ `isAlchemistBountyPurchased = true` |
> | **Patrician's Wardrobe** | `300` | `rotdrv9deq` (Part 2) | • 2× `PatricianArmor`<br>• 19× `DiamondAmulet`<br>• 10× `CottontailJacket`<br>• 6× `GhostRabbitCloak` | `isRedeem_potionsRefund1` $\rightarrow$ `isPatricianWardrobePurchased = true` |
> | **Royal Treasury & Feast** | `500` | `rotdrv9deq` (Part 3) | • **10 Platinum Coins** (`10,000,000` copper / 100 Gold)<br>• 10× `CeremonialCake` (Pet Shelter Food) | `isRedeem_potionsRefund1` $\rightarrow$ `isRoyalTreasuryPurchased = true` |
> | **Shroud of the Ancients** | `500` | `f3hqt045` / `g394te91` | • 1× `ScarletShroud` (Legendary Medium Armor) | `isRedeemed_f8hf3045` or `isRedeemed_g294ps91` $\rightarrow$ `isScarletShroudPurchased = true` |

---

> [!IMPORTANT]
> ### 2. Category: EQUIPMENT [NEW CATEGORY]
> *Dedicated to unique and legendary equipment unlocks.*
> 
> | Pack Name | Gem Cost | Type | Perk / Unlocks | Technical Implementation |
> | :--- | :---: | :---: | :--- | :--- |
> | **Armory: Celestial Bow** | `1,000` | One-time | Grants `1× CelestialBow` (Dex +40, Int +15, Crit +10%, Crit Dmg +10%, Attack Thrice) | `data.isCelestialBowPurchased` $\rightarrow$ Added to inventory (`MainActivity.data.items`) on purchase; buy button becomes checkmark |

---

> [!IMPORTANT]
> ### 3. Category: INFRASTRUCTURE [NEW CATEGORY]
> *Dedicated to guild building expansions. Quarters are intentionally kept conservative (+1 per tier) to reflect their immense endgame value (where vanilla requires 10 Platinum coins per upgrade).*
> 
> | Pack Name | Gem Cost | Type | Perk / Unlocks | Technical Implementation |
> | :--- | :---: | :---: | :--- | :--- |
> | **Barracks Expansion I** | `1,000` | One-time | `+1 Quarters Space` (`shop_1`) | `data.isBarracks1Purchased` $\rightarrow$ `Formulas.getQuartersCapacity()` (+1) |
> | **Barracks Expansion II** | `2,000` | One-time | `+1 Quarters Space` (`shop_1`) | `data.isBarracks2Purchased` $\rightarrow$ `Formulas.getQuartersCapacity()` (+1) |
> | **Grand Tavern Expansion** | `1,250` | One-time | `+2 Tavern Visitor Capacity`, `-20% Visitor Arrival Interval` | `data.isGrandTavernPurchased` $\rightarrow$ `Formulas.getTavernVisitorInterval()` (`* 0.8`), `Formulas.getTavernCapacity()` (+2) |
> | **Sanctuary Grounds I** | `750` | One-time | `+2 Pet Shelter Capacity` | `data.isSanctuary1Purchased` $\rightarrow$ `Formulas.shelterCapacity()` (+2) |
> | **Sanctuary Grounds II** | `1,250` | One-time | `+2 Pet Shelter Capacity` | `data.isSanctuary2Purchased` $\rightarrow$ `Formulas.shelterCapacity()` (+2) |

---

> [!IMPORTANT]
> ### 4. Category: Utility Expansion (Progressive Idle Time up to 1 Week & Supplies)
> *Offline idle time is extended progressively in steps up to 168 hours (Option C).*
> 
> | Pack Name | Gem Cost | Type | Perk / Unlocks | Technical Impact |
> | :--- | :---: | :---: | :--- | :--- |
> | **Extended Vigil II (Chronos Ward)** | `1,000` | One-time | `+6 Max Idle Hours` (Total **24h / 1 Day** cap) | `data.isIdleHoursPack2Purchased` $\rightarrow$ `MainActivity.kt` (+6h) |
> | **Extended Vigil III (Aegis of Time)** | `1,500` | One-time | `+24 Max Idle Hours` (Total **48h / 2 Days** cap) | `data.isIdleHoursPack3Purchased` $\rightarrow$ `MainActivity.kt` (+24h) |
> | **Extended Vigil IV (Temporal Anchor)** | `2,000` | One-time | `+48 Max Idle Hours` (Total **96h / 4 Days** cap) | `data.isIdleHoursPack4Purchased` $\rightarrow$ `MainActivity.kt` (+48h) |
> | **Eternal Vigil (Timeless Continuum)** | `3,000` | One-time | `+72 Max Idle Hours` (Total **168h / 7 Days / 1 Week** cap) | `data.isEternalVigilPurchased` $\rightarrow$ `MainActivity.kt` (+72h) |
> | **Deep Pockets II (Bottomless Chest)** | `1,000` | One-time | `+1,000 Max Loot Capacity` (Raises dungeon loot cap to 4,000) | `data.isMaxLootPack2Purchased` $\rightarrow$ `Area.kt` `fullChest()` |
> | **Evolutionary Synthesis Crate** | `1,000` | **One-time** | Grants `1× Evo22Vial`, `1× Evo23Vial`, `2× Dreamcatcher` | Added to inventory on purchase; buy button becomes checkmark |

---

> [!IMPORTANT]
> ### 5. Category: Storage Expansion (Agreed)
> | Pack Name | Gem Cost | Type | Perk / Unlocks | Technical Impact |
> | :--- | :---: | :---: | :--- | :--- |
> | **Dimensional Vault** | `1,500` | One-time | `+100 Storage Spaces` | `data.isStoragePack100Purchased` $\rightarrow$ `Formulas.storageSpaces()` (+100) |
> | **Infinite Hoard** | `2,000` | One-time | `+150 Storage Spaces` | `data.isStoragePack150Purchased` $\rightarrow$ `Formulas.storageSpaces()` (+150) |

---

## Proposed Changes

### UI & Layout
#### [MODIFY] [dialog_shop.xml](file:///c:/Repositories/IGM-Modded/app/src/main/res/layout/dialog_shop.xml)
- Add `INFRASTRUCTURE` and `EQUIPMENT` category filter chips to the top horizontal scroll bar.
- Add card layouts for the 6 new converted Starter packs (Divine Champion Pack, Eternal Reliquary, Alchemist's Bounty, Patrician's Wardrobe, Royal Treasury, Shroud of the Ancients).
- Add card layouts for Celestial Bow, Barracks, Grand Tavern, Sanctuary Grounds, Storage 100/150, and Vigil II-IV / Eternal Vigil.

#### [MODIFY] [DialogShop.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogShop.kt)
- Add `Category.INFRASTRUCTURE` and `Category.EQUIPMENT` to `Category` enum.
- Add click handlers, gem deduction, confirmation dialogs, and owned-state checkmarks for all new packs.
- Filter new packs under their respective categories (`STARTER`, `EQUIPMENT`, `INFRASTRUCTURE`, `UTILITY`, `STORAGE`, `ADVENTURERS`, `COMPANIONS`).

---

### Data & Persistence
#### [MODIFY] [Data.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/Data.kt)
- Add serialized flags:
  - `isDivineChampionPackPurchased`, `isEternalReliquaryPurchased`
  - `isAlchemistBountyPurchased`, `isPatricianWardrobePurchased`, `isRoyalTreasuryPurchased`
  - `isScarletShroudPurchased`
  - `isCelestialBowPurchased`
  - `isBarracks1Purchased`, `isBarracks2Purchased`
  - `isGrandTavernPurchased`
  - `isSanctuary1Purchased`, `isSanctuary2Purchased`
  - `isIdleHoursPack2Purchased`, `isIdleHoursPack3Purchased`, `isIdleHoursPack4Purchased`, `isEternalVigilPurchased`
  - `isMaxLootPack2Purchased`
  - `isEvolutionSynthesisPurchased`
  - `isStoragePack100Purchased`, `isStoragePack150Purchased`

#### [MODIFY] [DataDeserializer.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/DataDeserializer.kt)
- Add auto-migration for legacy redeem codes:
  - If `isRedeem_f1r39h15` $\rightarrow$ sets `isDivineChampionPackPurchased = true`, `isEternalReliquaryPurchased = true`.
  - If `isRedeem_potionsRefund1` $\rightarrow$ sets `isAlchemistBountyPurchased = true`, `isPatricianWardrobePurchased = true`, `isRoyalTreasuryPurchased = true`.
  - If `isRedeemed_f8hf3045 || isRedeemed_g294ps91` $\rightarrow$ sets `isScarletShroudPurchased = true`.

---

### Game Logic & Formulas
#### [MODIFY] [MainActivity.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/MainActivity.kt)
- Update `initializeThreads()` idle time calculation to incorporate Vigil II (+6h), Vigil III (+24h), Vigil IV (+48h), and Eternal Vigil (+72h), reaching up to 168 hours.

#### [MODIFY] [Formulas.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/Formulas.kt)
- Update `getQuartersCapacity()`: add +1 for `isBarracks1Purchased`, +1 for `isBarracks2Purchased`.
- Update `getTavernVisitorInterval()`: apply `* 0.8` multiplier if `isGrandTavernPurchased`.
- Update `getTavernCapacity()`: add +2 for `isGrandTavernPurchased`.
- Update `shelterCapacity()`: add +2 for `isSanctuary1Purchased`, +2 for `isSanctuary2Purchased`.
- Update `storageSpaces()`: add +100 for `isStoragePack100Purchased`, +150 for `isStoragePack150Purchased`.

#### [MODIFY] [Area.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/Area.kt)
- Update `fullChest()`: add +1,000 if `isMaxLootPack2Purchased` is true.

---

### Strings & Resources
#### [MODIFY] [strings.xml](file:///c:/Repositories/IGM-Modded/app/src/main/res/values/strings.xml)
- Add localized strings for `EQUIPMENT` and `INFRASTRUCTURE` chips, the 6 converted Starter packs, Celestial Bow pack, and other new packs.

---

## Verification Plan

### Automated Tests
- In `ShopReworkTest.kt`, add:
  - `testRedeemCodeMigration()`: verify imported saves with `isRedeem_f1r39h15`, `isRedeem_potionsRefund1`, and `isRedeemed_f8hf3045` automatically gain the corresponding pack flags and show as purchased.
  - `testConvertedStarterPacksPurchase()`: verify purchasing each starter pack grants the correct items, hero, potions, and gold.
  - `testCelestialBowPackPurchase()`: verify 1x CelestialBow is added to inventory, gems deducted, flag saved, and one-time purchase enforced.
  - `testInfrastructureFormulas()`: verify Quarters (+1, +2), Tavern interval (-20%) & capacity (+2), and Shelter capacity (+2, +4).
  - `testExtendedIdleTimeTiers()`: verify progressive idle cap at 24h, 48h, 96h, and 168h.
  - `testHighTierStorageSpaces()`: verify storage formula with +100 and +150 packs.
  - `testMaxLootCapTier2()`: verify 4,000 loot cap.
  - `testOneTimeEvolutionCrate()`: verify items granted and one-time purchase enforcement.

### Manual Verification
- Launch debug build on emulator/device.
- Verify `EQUIPMENT` and `INFRASTRUCTURE` chips appear in Shop header.
- Verify Starter bundle displays the converted redeem packs with clear titles and cheap gem prices.
- Verify cards for already-redeemed codes show checkmarks immediately.
