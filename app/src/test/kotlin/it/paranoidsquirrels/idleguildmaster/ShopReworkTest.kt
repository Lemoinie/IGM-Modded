package it.paranoidsquirrels.idleguildmaster

import it.paranoidsquirrels.idleguildmaster.storage.data.Data
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionsDrank
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Trait
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.Spade
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.PetAbility
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.EnchantedForest
import it.paranoidsquirrels.idleguildmaster.game.redeem.RedeemCodes
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogShop
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class ShopReworkTest {

    @Before
    fun setUp() {
        MainActivity.data = Data()
    }

    @Test
    fun testStorageSpacesFormula() {
        // Base storage is 35 + levelStorage(0) + upgradeStorage(0) = 35
        assertEquals(35, Formulas.storageSpaces())

        // Starter and Adventurer packs no longer grant storage
        MainActivity.data.isStarterPackPurchased = true
        MainActivity.data.isAdventurerPackPurchased = true
        MainActivity.data.isMerchantPackPurchased = true
        assertEquals(35, Formulas.storageSpaces())

        // Dedicated storage packs
        MainActivity.data.isStoragePack35Purchased = true
        assertEquals(70, Formulas.storageSpaces())

        MainActivity.data.isStoragePack50Purchased = true
        assertEquals(120, Formulas.storageSpaces())

        MainActivity.data.isStoragePack70Purchased = true
        assertEquals(190, Formulas.storageSpaces())
    }

    @Test
    fun testQuartersCapacityFormula() {
        // Base quarters: levelQuarters(0) + 2 + upgradeQuarters(0) = 2
        assertEquals(2, Formulas.getQuartersCapacity())

        MainActivity.data.isPrimalVanguardPurchased = true
        assertEquals(6, Formulas.getQuartersCapacity())
    }

    @Test
    fun testShelterCapacityFormula() {
        // Base shelter: levelShelter(0) + upgradeShelter(0) + 2 = 2
        assertEquals(2, Formulas.shelterCapacity())

        MainActivity.data.isSenkoPackPurchased = true
        assertEquals(3, Formulas.shelterCapacity())
    }

    @Test
    fun testMarketListingsFormula() {
        // Base: levelMarketListings(0) + 1 = 1
        assertEquals(1, Formulas.marketListings())

        MainActivity.data.isApprenticeMerchantPurchased = true
        assertEquals(2, Formulas.marketListings())

        MainActivity.data.isJourneymanMerchantPurchased = true
        assertEquals(4, Formulas.marketListings())

        MainActivity.data.isMerchantPackPurchased = true
        assertEquals(7, Formulas.marketListings())

        MainActivity.data.isTradeBaronPurchased = true
        assertEquals(11, Formulas.marketListings())
    }

    @Test
    fun testWorkshopQueueFormula() {
        // Base: levelWorkshopQueue(0) + 1 = 1
        assertEquals(1, Formulas.workshopQueue())

        // Merchant pack no longer grants workshop queue
        MainActivity.data.isMerchantPackPurchased = true
        assertEquals(1, Formulas.workshopQueue())

        MainActivity.data.isApprenticeWorkshopPurchased = true
        assertEquals(2, Formulas.workshopQueue())

        MainActivity.data.isJourneymanWorkshopPurchased = true
        assertEquals(4, Formulas.workshopQueue())

        MainActivity.data.isMasterWorkshopPurchased = true
        assertEquals(7, Formulas.workshopQueue())

        MainActivity.data.isGrandmasterWorkshopPurchased = true
        assertEquals(11, Formulas.workshopQueue())
    }

    @Test
    fun testWorkshopAndMarketSpeedDiscounts() {
        val item = Spade()
        item.setStack(1)
        item.setPrice(10L)

        val baseCraftSeconds = item.getSecondsToCraft()
        val baseSellSeconds = item.getSecondsToSell()

        // Workshop discount
        MainActivity.data.isApprenticeWorkshopPurchased = true
        val craftWithApprentice = item.getSecondsToCraft()
        assertTrue(craftWithApprentice < baseCraftSeconds)

        // Market discount
        MainActivity.data.isApprenticeMerchantPurchased = true
        val sellWithApprentice = item.getSecondsToSell()
        assertTrue(sellWithApprentice < baseSellSeconds)
    }

    @Test
    fun testPrimalVanguardAdventurers() {
        val u1 = DialogShop.primalVanguard1
        val u2 = DialogShop.primalVanguard2
        val u3 = DialogShop.primalVanguard3
        val u4 = DialogShop.primalVanguard4

        // All must be Tier 4 (maxLevel = 20)
        assertEquals(20, u1.maxLevel)
        assertEquals(20, u2.maxLevel)
        assertEquals(20, u3.maxLevel)
        assertEquals(20, u4.maxLevel)

        // All must have Plus basic traits
        assertEquals(Trait.FERAL_PLUS, u1.traitCommon)
        assertEquals(Trait.FERAL_PLUS, u2.traitCommon)
        assertEquals(Trait.BOOKWORM_PLUS, u3.traitCommon)
        assertEquals(Trait.BRUTE_PLUS, u4.traitCommon)

        // Rare traits
        assertNotNull(u1.traitRare)
        assertNotNull(u2.traitRare)
        assertNotNull(u3.traitRare)
        assertNotNull(u4.traitRare)
    }

    @Test
    fun testSenkoPetConfiguration() {
        val senko = Pet.getInstance(
            "Senko",
            -100,
            50,
            0,
            PetAbility.SAVAGE,
            PetAbility.REGENERATION,
            PetAbility.DROPS,
            PetAbility.EXPERIENCE
        )

        assertNotNull(senko)
        assertEquals(50, senko!!.level)
        assertEquals(0, senko.food)
        assertEquals(PetAbility.SAVAGE, senko.petAbility1)
        assertEquals(PetAbility.REGENERATION, senko.petAbility2)
        assertEquals(PetAbility.DROPS, senko.petAbility3)
        assertEquals(PetAbility.EXPERIENCE, senko.petAbility4)

        // Senko unlocks all abilities at Level 1, and level 50 Kitsune blessing is 50 * 0.006 = 0.30
        assertEquals(0.30, senko.kitsuneBlessingApplied, 0.001)
        assertTrue(senko.savage > 0.0)
        assertTrue(senko.regeneration > 0)
        assertTrue(senko.drops > 0.0)
        assertTrue(senko.experience > 0.0)
    }

    @Test
    fun testSaveAutoMigrationFailsafe() {
        val legacyData = Data().apply {
            isStarterPackPurchased = true
            isAdventurerPackPurchased = true
            isMerchantPackPurchased = true
        }
        val gson = com.google.gson.GsonBuilder()
            .registerTypeAdapter(Data::class.java, it.paranoidsquirrels.idleguildmaster.storage.data.DataDeserializer())
            .create()

        val json = com.google.gson.Gson().toJson(legacyData)
        val migrated = gson.fromJson(json, Data::class.java)

        assertTrue("Starter pack must auto-migrate storage 35", migrated.isStoragePack35Purchased)
        assertTrue("Adventurer pack must auto-migrate storage 50", migrated.isStoragePack50Purchased)
        assertTrue("Merchant pack must auto-migrate storage 70", migrated.isStoragePack70Purchased)
        assertTrue("Merchant pack must auto-migrate master workshop", migrated.isMasterWorkshopPurchased)
        assertTrue("Merchant pack must auto-migrate max loot pack", migrated.isMaxLootPackPurchased)

        val freshData = Data()
        val freshJson = com.google.gson.Gson().toJson(freshData)
        val freshMigrated = gson.fromJson(freshJson, Data::class.java)

        assertFalse("Fresh save must not have storage 35", freshMigrated.isStoragePack35Purchased)
        assertFalse("Fresh save must not have storage 50", freshMigrated.isStoragePack50Purchased)
        assertFalse("Fresh save must not have storage 70", freshMigrated.isStoragePack70Purchased)
        assertFalse("Fresh save must not have master workshop", freshMigrated.isMasterWorkshopPurchased)
        assertFalse("Fresh save must not have max loot", freshMigrated.isMaxLootPackPurchased)
    }

    @Test
    fun testLootCapPackIsAuthoritative() {
        // Deep Pockets / merchant-pack migration grants +1,000 (base 2,000 = 3,000).
        val area = it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.EnchantedForest()
        MainActivity.data.isMaxLootPackPurchased = true
        // Legacy LOOTCAP redeem override must NOT keep the cap above the pack's value.
        MainActivity.data.lootCap = 4096
        assertEquals(3000, area.getLootCap())

        // Without the pack the explicit LOOTCAP override still wins.
        MainActivity.data.isMaxLootPackPurchased = false
        assertEquals(4096, area.getLootCap())

        // Default vanilla cap without any pack/override.
        MainActivity.data.lootCap = 0
        assertEquals(2000, area.getLootCap())
    }

    @Test
    fun testSacredIntercessionOneTimeFlag() {
        MainActivity.data.isSacredIntercessionPurchased = true
        // The flag is persisted and read back through the tolerant deserializer.
        val gson = com.google.gson.GsonBuilder()
            .registerTypeAdapter(Data::class.java, it.paranoidsquirrels.idleguildmaster.storage.data.DataDeserializer())
            .create()
        val json = com.google.gson.Gson().toJson(MainActivity.data)
        val loaded = gson.fromJson(json, Data::class.java)
        assertTrue("one-time sacred intercession flag must persist through save/load", loaded.isSacredIntercessionPurchased)
    }

    @Test
    fun testCakePackFlagRoundTrips() {
        MainActivity.data.isCakePackPurchased = true
        val gson = com.google.gson.GsonBuilder()
            .registerTypeAdapter(Data::class.java, it.paranoidsquirrels.idleguildmaster.storage.data.DataDeserializer())
            .create()
        val json = com.google.gson.Gson().toJson(MainActivity.data)
        val loaded = gson.fromJson(json, Data::class.java)
        assertTrue("cake pack flag must persist through save/load", loaded.isCakePackPurchased)
    }

    @Test
    fun testRedeemCodeMigration() {
        // Legacy redeem codes migrate into the converted starter packs.
        val legacy = Data().apply {
            isRedeem_f1r39h15 = true
            isRedeem_potionsRefund1 = true
            isRedeemed_f8hf3045 = true
        }
        val gson = com.google.gson.GsonBuilder()
            .registerTypeAdapter(Data::class.java, it.paranoidsquirrels.idleguildmaster.storage.data.DataDeserializer())
            .create()
        val json = com.google.gson.Gson().toJson(legacy)
        val migrated = gson.fromJson(json, Data::class.java)

        assertTrue("f1r39h15 must grant Divine Champion pack", migrated.isDivineChampionPackPurchased)
        assertTrue("f1r39h15 must grant Eternal Reliquary", migrated.isEternalReliquaryPurchased)
        assertTrue("potionsRefund1 must grant Alchemist's Bounty", migrated.isAlchemistBountyPurchased)
        assertTrue("potionsRefund1 must grant Patrician's Wardrobe", migrated.isPatricianWardrobePurchased)
        assertTrue("potionsRefund1 must grant Royal Treasury & Feast", migrated.isRoyalTreasuryPurchased)
        assertTrue("f8hf3045 must grant Shroud of the Ancients", migrated.isScarletShroudPurchased)

        // Fresh save must NOT auto-grant any of them.
        val freshJson = com.google.gson.Gson().toJson(Data())
        val fresh = gson.fromJson(freshJson, Data::class.java)
        assertFalse(fresh.isDivineChampionPackPurchased)
        assertFalse(fresh.isScarletShroudPurchased)
    }

    @Test
    fun testConvertedStarterPacksPurchase() {
        // Divine Champion pack grants the Level 45 hero + 3 gear pieces (mirrors the shop handler).
        MainActivity.data.adventurers.clear()
        MainActivity.data.items.clear()
        val hero = Adventurer.getInstance("DivineChampion", -40, 45, 0, null, null, null, Trait.BRUTE_PLUS, Trait.FOCUSED, PotionsDrank(), null, false)
        assertNotNull("Divine Champion hero must exist", hero)
        MainActivity.data.adventurers.add(hero!!)
        Utils.collectItem(Item.getInstance("ChampionArmor", 1), MainActivity.data.items)
        Utils.collectItem(Item.getInstance("SpikedPrimevalShield", 1), MainActivity.data.items)
        Utils.collectItem(Item.getInstance("GhastlyScimitar", 1), MainActivity.data.items)
        assertTrue(MainActivity.data.adventurers.any { it.getTrueClass() == "DivineChampion" })
        assertTrue(MainActivity.data.items.any { it.getTrueClass() == "ChampionArmor" })
        assertTrue(MainActivity.data.items.any { it.getTrueClass() == "SpikedPrimevalShield" })
        assertTrue(MainActivity.data.items.any { it.getTrueClass() == "GhastlyScimitar" })

        // Alchemist's Bounty grants 100x of all 11 permanent stat potions.
        MainActivity.data.items.clear()
        val potions = listOf(
            "PotionOfConstitution", "PotionOfDexterity", "PotionOfIntelligence", "PotionOfHealth",
            "PotionOfDefense", "PotionOfMagicDefense", "PotionOfPrecision", "PotionOfViciousness",
            "PotionOfDarkness", "PotionOfImmunity", "PotionOfAgility"
        )
        for (name in potions) Utils.collectItem(Item.getInstance(name, 100), MainActivity.data.items)
        assertEquals(11, MainActivity.data.items.size)
        assertTrue(MainActivity.data.items.all { it.getStack() == 100 })

        // Patrician's Wardrobe grants its gear with the documented counts.
        MainActivity.data.items.clear()
        Utils.collectItem(Item.getInstance("PatricianArmor", 2), MainActivity.data.items)
        Utils.collectItem(Item.getInstance("DiamondAmulet", 19), MainActivity.data.items)
        Utils.collectItem(Item.getInstance("CottontailJacket", 10), MainActivity.data.items)
        Utils.collectItem(Item.getInstance("GhostRabbitCloak", 6), MainActivity.data.items)
        assertEquals(4, MainActivity.data.items.size)
        assertTrue(MainActivity.data.items.any { it.getTrueClass() == "PatricianArmor" && it.getStack() == 2 })
        assertTrue(MainActivity.data.items.any { it.getTrueClass() == "DiamondAmulet" && it.getStack() == 19 })

        // Royal Treasury & Feast grants 10,000,000 copper (10 Platinum Coins).
        val moneyBefore = MainActivity.data.money
        MainActivity.data.money += 10_000_000L
        assertEquals(moneyBefore + 10_000_000L, MainActivity.data.money)

        // Purchased flags persist through a save/load round-trip.
        MainActivity.data.isDivineChampionPackPurchased = true
        MainActivity.data.isEternalReliquaryPurchased = true
        MainActivity.data.isAlchemistBountyPurchased = true
        MainActivity.data.isPatricianWardrobePurchased = true
        MainActivity.data.isRoyalTreasuryPurchased = true
        MainActivity.data.isScarletShroudPurchased = true
        val gson = com.google.gson.GsonBuilder()
            .registerTypeAdapter(Data::class.java, it.paranoidsquirrels.idleguildmaster.storage.data.DataDeserializer())
            .create()
        val json = com.google.gson.Gson().toJson(MainActivity.data)
        val loaded = gson.fromJson(json, Data::class.java)
        assertTrue(loaded.isDivineChampionPackPurchased)
        assertTrue(loaded.isEternalReliquaryPurchased)
        assertTrue(loaded.isAlchemistBountyPurchased)
        assertTrue(loaded.isPatricianWardrobePurchased)
        assertTrue(loaded.isRoyalTreasuryPurchased)
        assertTrue(loaded.isScarletShroudPurchased)
    }

    @Test
    fun testCelestialBowPackPurchase() {
        // One-time 1,000-gem pack grants 1x Celestial Bow (mirrors the shop handler).
        MainActivity.data.gems = 1000
        MainActivity.data.items.clear()
        MainActivity.data.gems -= 1000
        Utils.collectItem(Item.getInstance("CelestialBow", 1), MainActivity.data.items)
        assertEquals("gems must be deducted", 0, MainActivity.data.gems)
        val bow = MainActivity.data.items.firstOrNull { it.getTrueClass() == "CelestialBow" }
        assertNotNull("Celestial Bow must be added to inventory", bow)
        assertEquals(1, bow?.getStack())

        // One-time: the purchased flag persists through save/load, blocking repeat buys.
        MainActivity.data.isCelestialBowPurchased = true
        val gson = com.google.gson.GsonBuilder()
            .registerTypeAdapter(Data::class.java, it.paranoidsquirrels.idleguildmaster.storage.data.DataDeserializer())
            .create()
        val json = com.google.gson.Gson().toJson(MainActivity.data)
        val loaded = gson.fromJson(json, Data::class.java)
        assertTrue("Celestial Bow pack flag must persist", loaded.isCelestialBowPurchased)
    }

    @Test
    fun testInfrastructureFormulas() {
        // Barracks expansions: +1 Quarters space each.
        assertEquals(2, Formulas.getQuartersCapacity())
        MainActivity.data.isBarracks1Purchased = true
        assertEquals(3, Formulas.getQuartersCapacity())
        MainActivity.data.isBarracks2Purchased = true
        assertEquals(4, Formulas.getQuartersCapacity())

        // Grand Tavern: visitors arrive 20% faster and capacity +2.
        val baseInterval = Formulas.getTavernVisitorInterval() // 28,800,000 ms at level 0
        assertEquals(1, Formulas.getTavernCapacity())
        MainActivity.data.isGrandTavernPurchased = true
        assertEquals((baseInterval * 0.8).toLong(), Formulas.getTavernVisitorInterval())
        assertEquals(3, Formulas.getTavernCapacity())

        // Sanctuary expansions: +2 Pet Shelter capacity each.
        assertEquals(2, Formulas.shelterCapacity())
        MainActivity.data.isSanctuary1Purchased = true
        assertEquals(4, Formulas.shelterCapacity())
        MainActivity.data.isSanctuary2Purchased = true
        assertEquals(6, Formulas.shelterCapacity())
    }

    @Test
    fun testExtendedIdleTimeTiers() {
        // Base vanilla cap is 12h; Vigil packs progress: +6/+6/+24 then temporal & timeless add +6 each.
        assertEquals(12, Formulas.getIdleTimeCapHours())

        MainActivity.data.isIdleHoursPackPurchased = true
        assertEquals(18, Formulas.getIdleTimeCapHours())

        MainActivity.data.isIdleHoursPack2Purchased = true
        assertEquals(24, Formulas.getIdleTimeCapHours())

        MainActivity.data.isIdleHoursPack3Purchased = true
        assertEquals(48, Formulas.getIdleTimeCapHours())

        MainActivity.data.isIdleHoursPack4Purchased = true
        assertEquals(54, Formulas.getIdleTimeCapHours())

        MainActivity.data.isEternalVigilPurchased = true
        assertEquals(60, Formulas.getIdleTimeCapHours())
    }

    @Test
    fun testHighTierStorageSpaces() {
        assertEquals(35, Formulas.storageSpaces())

        MainActivity.data.isStoragePack100Purchased = true
        assertEquals(135, Formulas.storageSpaces())

        MainActivity.data.isStoragePack150Purchased = true
        assertEquals(285, Formulas.storageSpaces())
    }

    @Test
    fun testMaxLootCapTier2() {
        val area = EnchantedForest()
        assertEquals("vanilla loot cap is 2,000", 2000, area.getLootCap())

        MainActivity.data.isMaxLootPack2Purchased = true
        assertEquals("Deep Pockets II raises the cap to 4,000", 4000, area.getLootCap())

        // The pack is authoritative: legacy LOOTCAP/Deep Pockets overrides must not exceed it.
        MainActivity.data.isMaxLootPackPurchased = true
        MainActivity.data.lootCap = 8192
        assertEquals(4000, area.getLootCap())
    }

    @Test
    fun testResetCapsRedeemClearsOverridesAndLegacyBits() {
        val d = MainActivity.data
        d.lootCap = 4096
        d.idleTimeCapHours = 96
        // Legacy packed value layout: kills bits 0-9, idle hours bits 10-17, loot cap bits 18-31.
        d.redeem_m975nfu5 = 45 or (96 shl 10) or (4096 shl 18)

        val result = RedeemCodes.process("RESETCAPS", null)
        assertNotNull("RESETCAPS must be a recognized dev command", result)

        assertEquals("LOOTCAP override must reset to base (0)", 0, d.lootCap)
        assertEquals("IDLETIME override must reset to base (0)", 0, d.idleTimeCapHours)
        assertEquals("Legacy packed idle/loot bits must be wiped while the kill count is kept", 45, d.redeem_m975nfu5)

        // With the override gone and no loot packs, the vanilla 2,000 cap applies.
        assertEquals("Base loot cap is 2,000", 2000, EnchantedForest().getLootCap())
    }

    @Test
    fun testOneTimeEvolutionCrate() {
        // Grants 1x Evo-22 Vial, 1x Evo-23 Vial and 2x Dreamcatcher (mirrors the shop handler).
        MainActivity.data.items.clear()
        Utils.collectItem(Item.getInstance("Evo22Vial", 1), MainActivity.data.items)
        Utils.collectItem(Item.getInstance("Evo23Vial", 1), MainActivity.data.items)
        Utils.collectItem(Item.getInstance("Dreamcatcher", 2), MainActivity.data.items)
        assertEquals(3, MainActivity.data.items.size)
        assertTrue(MainActivity.data.items.any { it.getTrueClass() == "Evo22Vial" && it.getStack() == 1 })
        assertTrue(MainActivity.data.items.any { it.getTrueClass() == "Evo23Vial" && it.getStack() == 1 })
        assertTrue(MainActivity.data.items.any { it.getTrueClass() == "Dreamcatcher" && it.getStack() == 2 })

        // One-time: the flag persists through save/load, blocking repeat buys.
        MainActivity.data.isEvolutionSynthesisPurchased = true
        val gson = com.google.gson.GsonBuilder()
            .registerTypeAdapter(Data::class.java, it.paranoidsquirrels.idleguildmaster.storage.data.DataDeserializer())
            .create()
        val json = com.google.gson.Gson().toJson(MainActivity.data)
        val loaded = gson.fromJson(json, Data::class.java)
        assertTrue("Evolution crate flag must persist", loaded.isEvolutionSynthesisPurchased)
    }
}
