package it.paranoidsquirrels.idleguildmaster

import it.paranoidsquirrels.idleguildmaster.storage.data.Data
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Trait
import it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.Spade
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.PetAbility
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
    fun testDevRedeemCodesIdentification() {
        val devCodes = listOf(
            "GOLD 100", "BLACK", "ITEM Spade", "HERO Paladin", "PET Semi",
            "REROLL", "SHOP", "QUEST", "STORAGE 10", "IDLETIME 24",
            "LOOTCAP 5000", "KILLS", "SETKILLS 50"
        )
        for (code in devCodes) {
            assertTrue("Code '$code' should be recognized as a dev code", it.paranoidsquirrels.idleguildmaster.game.redeem.RedeemCodes.isDevCode(code))
        }

        val nonDevCodes = listOf("Z3GAAZRT", "e44ttr7z", "rotdrv9deq", "f1r29u15eq", "f3hqt045", "UNKNOWN")
        for (code in nonDevCodes) {
            assertFalse("Code '$code' should not be recognized as a dev code", it.paranoidsquirrels.idleguildmaster.game.redeem.RedeemCodes.isDevCode(code))
        }
    }
}
