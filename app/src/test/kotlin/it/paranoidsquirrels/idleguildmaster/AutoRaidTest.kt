package it.paranoidsquirrels.idleguildmaster

import it.paranoidsquirrels.idleguildmaster.storage.data.Data
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionsDrank
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Event
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.SanguineCrucible
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
    fun testRaidNeedsPaidTryDispatchWhenFreeTrySpent() {
        val tower = newTowerWithTeam()
        tower.triesAvailable = false
        assertTrue("A raid with no free try needs a paid try before dispatching", tower.needsPaidTryDispatch())

        tower.triesAvailable = true
        assertFalse("An available free try must not require a paid try", tower.needsPaidTryDispatch())
    }

    @Test
    fun testPaidTryDispatchNeverAppliesToFreeAreas() {
        val forest = it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.EnchantedForest()
        forest.triesAvailable = false
        assertFalse("Dungeons must always dispatch free", forest.needsPaidTryDispatch())

        val request = it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.GuildRequestArea()
        request.triesAvailable = false
        assertFalse("Guild activities must never ask for a paid try", request.needsPaidTryDispatch())
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
        assertEquals("Wipe stop reason must be recorded for the report",
            it.paranoidsquirrels.idleguildmaster.R.string.auto_raid_report_reason_wipe, tower.autoRaidStopReasonRes)
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
        assertEquals("No-gems stop reason must be recorded for the report",
            it.paranoidsquirrels.idleguildmaster.R.string.auto_raid_report_reason_no_gems, tower.autoRaidStopReasonRes)
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
        assertEquals("Completed stop reason must be recorded for the report",
            it.paranoidsquirrels.idleguildmaster.R.string.auto_raid_report_reason_completed, tower.autoRaidStopReasonRes)
    }

    @Test
    fun testAutoRaidStopsWhenAreaLootCapReached() {
        val tower = newTowerWithTeam()
        // Fill the raid's loot chest up to the area loot cap across the run's drops.
        tower.drops.add(Item.getInstance("GoldScraps", tower.getLootCap())!!)
        tower.isAutoRaidActive = true
        tower.autoRaidRunsRemaining = 3
        tower.autoRaidStopOnWipe = true
        tower.triesAvailable = false
        MainActivity.data.gems = 100L

        assertFalse("A full loot chest must halt the loop", tower.handleAutoRaidCycle())
        assertFalse(tower.isAutoRaidActive)
        assertEquals("Drops must be kept in the chest when the loop halts", 1, tower.drops.size)
        assertEquals("Gems must not be spent after a loot-cap stop", 100L, MainActivity.data.gems)
        assertEquals("Storage-full stop reason must be recorded for the report",
            it.paranoidsquirrels.idleguildmaster.R.string.auto_raid_report_reason_storage_full, tower.autoRaidStopReasonRes)
    }

    @Test
    fun testSanguineFreeTryNotRegrantedOnReload() {
        // A save that already consumed the daily free try (triesAvailable = false) must keep
        // it consumed after a reload — even though the Sanguine Crucible is unlocked for
        // saves owning a Scarlet Strand. Only the daily reset grants a new free try.
        val data = Data().apply {
            sanguineCrucible?.isUnlocked = true
            sanguineCrucible?.triesAvailable = false
            seenItems.add("ScarletStrand")
        }
        val gson = com.google.gson.GsonBuilder()
            .registerTypeAdapter(Data::class.java, it.paranoidsquirrels.idleguildmaster.storage.data.DataDeserializer())
            .create()
        val json = com.google.gson.Gson().toJson(data)
        val loaded = gson.fromJson(json, Data::class.java)
        assertTrue("The area must stay unlocked after reload", loaded.sanguineCrucible?.isUnlocked == true)
        assertFalse("The consumed free try must not be re-granted on reload", loaded.sanguineCrucible!!.triesAvailable)
    }

    @Test
    fun testBloodConvocationSummonChance() {
        assertEquals(
            "Blood Convocation must summon a Crimson Acolyte on 36% of hits",
            0.36,
            Area.BLOOD_CONVOCATION_SUMMON_CHANCE,
            0.0
        )
    }

    @Test
    fun testSanguineCrucibleBossKillDoesNotEndRunBeforeLoot() {
        // Sanctum state: the boss room has been reached.
        val crucible = SanguineCrucible()
        crucible.progress = 1
        crucible.event = Event(Event.HALLS_EXPLORATION)
        crucible.event?.progress = 1

        // The boss dies mid-fight: the run must NOT be terminated here, otherwise the
        // Victory -> Experience -> Loot actions never run (no drops, no XP).
        val boss = Enemy.getInstance("ArchmagusValthex")!!
        crucible.enemies.add(boss)
        boss.currentHp = 0
        crucible.checkDeath(boss)
        assertFalse("Boss death alone must not terminate the raid (it would void loot/XP)", crucible.terminationRequested)
        assertTrue("The boss must be stashed as a corpse for the loot action", crucible.corpses.contains(boss))
    }
}