package it.paranoidsquirrels.idleguildmaster

import it.paranoidsquirrels.idleguildmaster.storage.data.Data
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionsDrank
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.TheTower
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.util.concurrent.CopyOnWriteArrayList

class AutoRaidTest {

    private fun newTowerWithTeam(): TheTower {
        val tower = TheTower()
        val adv = Adventurer.getInstance("Footman", 1, 5, 0, null, null, null, null, null, PotionsDrank(), null, false)!!
        adv.currentHp = adv.calculateTotalMaxHp()
        MainActivity.data.adventurers.add(adv)
        tower.savedAdventurersIds = CopyOnWriteArrayList(listOf(1))
        tower.adventurersExploringIds = CopyOnWriteArrayList(listOf(1))
        tower.savedPetId = null
        tower.petExploringId = null
        tower.setupAdventurers(MainActivity.data.adventurers, MainActivity.data.pets)
        return tower
    }

    @Before
    fun setUp() {
        MainActivity.data = Data()
    }

    @Test
    fun testAutoRaidRunCounterDecrements() {
        val tower = newTowerWithTeam()
        tower.isAutoRaidActive = true
        tower.autoRaidRunsRemaining = 3
        tower.autoRaidStopOnWipe = true
        tower.triesAvailable = false
        MainActivity.data.gems = 100L

        assertTrue("Cycle must dispatch the next run", tower.handleAutoRaidCycle())
        assertEquals("Run counter must decrement 3 -> 2", 2, tower.autoRaidRunsRemaining)
        assertEquals("One run must be completed", 1, tower.autoRaidRunsCompleted)
        assertEquals("The saved team must be re-dispatched", 1, tower.adventurersExploringIds.size)
    }

    @Test
    fun testAutoRaidDeductsExactGemCostPerRun() {
        val tower = newTowerWithTeam()
        tower.isAutoRaidActive = true
        tower.autoRaidRunsRemaining = 5
        tower.autoRaidStopOnWipe = true
        tower.triesAvailable = false
        MainActivity.data.gems = 100L

        tower.handleAutoRaidCycle()
        assertEquals("TheTower costs 15 gems per run", 85L, MainActivity.data.gems)
        assertEquals(15, tower.autoRaidGemsSpent)
        tower.handleAutoRaidCycle()
        assertEquals("A second run deducts another 15 gems", 70L, MainActivity.data.gems)
        assertEquals(30, tower.autoRaidGemsSpent)
    }

    @Test
    fun testAutoRaidConsumesFreeTryBeforeGems() {
        val tower = newTowerWithTeam()
        tower.isAutoRaidActive = true
        tower.autoRaidRunsRemaining = -1
        tower.autoRaidStopOnWipe = true
        tower.triesAvailable = true
        MainActivity.data.gems = 100L

        assertTrue(tower.handleAutoRaidCycle())
        assertFalse("An available free try must be consumed first", tower.triesAvailable)
        assertEquals("No gems may be spent while a free try was available", 100L, MainActivity.data.gems)
        assertEquals(0, tower.autoRaidGemsSpent)
    }

    @Test
    fun testAutoRaidStopsOnWipeWithoutSpendingGems() {
        val tower = newTowerWithTeam()
        tower.adventurersExploring[0].currentHp = 0
        tower.isAutoRaidActive = true
        tower.autoRaidRunsRemaining = 3
        tower.autoRaidStopOnWipe = true
        tower.triesAvailable = false
        MainActivity.data.gems = 100L

        assertFalse("A wipe with stop-on-wipe enabled must halt the loop", tower.handleAutoRaidCycle())
        assertFalse("Auto-Raid must be deactivated", tower.isAutoRaidActive)
        assertEquals("No gems may be spent after a wipe stop", 100L, MainActivity.data.gems)
        assertEquals(0, tower.autoRaidRunsCompleted)
    }

    @Test
    fun testAutoRaidStopsOnInsufficientGems() {
        val tower = newTowerWithTeam()
        tower.isAutoRaidActive = true
        tower.autoRaidRunsRemaining = 3
        tower.autoRaidStopOnWipe = true
        tower.triesAvailable = false
        MainActivity.data.gems = 5L // TheTower costs 15/run

        assertFalse("Out-of-gems must halt the loop", tower.handleAutoRaidCycle())
        assertFalse(tower.isAutoRaidActive)
        assertEquals("Gems must not go negative", 5L, MainActivity.data.gems)
    }

    @Test
    fun testAutoRaidStopsWhenRunsCompletedWithoutSpendingGems() {
        val tower = newTowerWithTeam()
        tower.isAutoRaidActive = true
        tower.autoRaidRunsRemaining = 1
        tower.autoRaidStopOnWipe = true
        tower.triesAvailable = false
        MainActivity.data.gems = 100L

        assertFalse("Reaching the target run count must stop the loop", tower.handleAutoRaidCycle())
        assertFalse(tower.isAutoRaidActive)
        assertEquals("The final run's gem cost must not be paid", 100L, MainActivity.data.gems)
        assertEquals(0, tower.autoRaidRunsCompleted)
    }

    @Test
    fun testAutoRaidStopsOnFullStorageWithoutItemLoss() {
        val tower = newTowerWithTeam()
        val capacity = Formulas.storageSpaces()
        for (i in 0 until capacity) {
            MainActivity.data.items.add(Item.getInstance("CopperSword", 1)!!)
        }
        tower.drops.add(Item.getInstance("GoldScraps", 2)!!)
        tower.isAutoRaidActive = true
        tower.autoRaidRunsRemaining = 3
        tower.autoRaidStopOnWipe = true
        tower.triesAvailable = false
        MainActivity.data.gems = 100L

        assertFalse("Full storage must halt the loop", tower.handleAutoRaidCycle())
        assertFalse(tower.isAutoRaidActive)
        assertEquals("Drops must not be lost when storage is full", 1, tower.drops.size)
        assertEquals(100L, MainActivity.data.gems)
    }

    @Test
    fun testStashDropsDirectlyDepositsAndFeedsFavouritePets() {
        val tower = newTowerWithTeam()
        val pet = Pet.getInstance("Beetle", 1)!!
        pet.favourite = true
        MainActivity.data.pets.add(pet)

        tower.drops.add(Item.getInstance("GoldScraps", 1)!!)
        tower.drops.add(Item.getInstance("Apple", 2)!!)

        tower.stashDropsDirectly()

        assertEquals("Drops must be cleared after stashing", 0, tower.drops.size)
        assertTrue(
            "Non-food drops must be deposited into the guild inventory",
            MainActivity.data.items.any { it.getTrueClass() == "GoldScraps" }
        )
        assertTrue(
            "Food drops must be fed to favourite pets",
            pet.food > 0 || pet.level > 1
        )
    }
}