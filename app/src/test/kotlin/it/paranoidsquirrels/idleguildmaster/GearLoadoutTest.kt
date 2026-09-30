package it.paranoidsquirrels.idleguildmaster

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import it.paranoidsquirrels.idleguildmaster.storage.data.Data
import it.paranoidsquirrels.idleguildmaster.storage.data.DataDeserializer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionsDrank
import it.paranoidsquirrels.idleguildmaster.storage.data.items.EquipmentLoadoutHelper
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Armor
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon
import it.paranoidsquirrels.idleguildmaster.storage.data.places.SavedEquipment
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.TheTower
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.util.concurrent.CopyOnWriteArrayList

/** Tests for the Dungeon & Raid Team Gear Loadouts feature. */
class GearLoadoutTest {

    @Before
    fun setUp() {
        MainActivity.data = Data()
        // compileDungeonRaidList() is a static cache over MainActivity.data; rebuild it so
        // the active-explorer checks see this test's fresh Data instance.
        Utils.invalidateAreaCaches()
    }

    private fun newHero(id: Int): Adventurer {
        return Adventurer.getInstance("Footman", id, 5, 0, null, null, null, null, null, PotionsDrank(), null, false)!!
    }

    private fun copperSword(): Weapon? = Item.getInstance("CopperSword", 1) as? Weapon

    private fun abyssalCutlass(): Weapon? = Item.getInstance("AbyssalCutlass", 1) as? Weapon

    @Test
    fun testSnapshotCapturesEquippedGear() {
        val hero = Adventurer.getInstance("Footman", 1, 5, 0, copperSword(), Item.getInstance("CopperArmor", 1) as? Armor, Item.getInstance("TuskNecklace", 1) as? Accessory, null, null, PotionsDrank(), null, false)!!
        val snapshot = EquipmentLoadoutHelper.snapshotHeroGear(hero)
        assertEquals("CopperSword", snapshot.weapon)
        assertEquals("CopperArmor", snapshot.armor)
        assertEquals("TuskNecklace", snapshot.accessory)
    }

    @Test
    fun testApplyTakesGearFromWarehouseStorage() {
        val hero = newHero(1)
        MainActivity.data.items.add(Item.getInstance("CopperSword", 1)!!)
        val warnings = ArrayList<String>()
        EquipmentLoadoutHelper.applyHeroGear(hero, SavedEquipment("CopperSword", null, null), warnings)
        assertEquals("CopperSword", hero.weapon?.getTrueClass())
        assertTrue("No warning expected for a clean storage swap", warnings.isEmpty())
        assertFalse("The sword must leave storage", MainActivity.data.items.any { it.getTrueClass() == "CopperSword" })
    }

    @Test
    fun testApplyKeepsAlreadyEquippedGear() {
        val hero = Adventurer.getInstance("Footman", 1, 5, 0, copperSword(), null, null, null, null, PotionsDrank(), null, false)!!
        val warnings = ArrayList<String>()
        EquipmentLoadoutHelper.applyHeroGear(hero, SavedEquipment("CopperSword", null, null), warnings)
        assertEquals("CopperSword", hero.weapon?.getTrueClass())
        assertTrue("Already equipped must be a no-op", warnings.isEmpty())
    }

    @Test
    fun testApplySwapsEquippedGearWithStorage() {
        val hero = Adventurer.getInstance("Footman", 1, 5, 0, copperSword(), null, null, null, null, PotionsDrank(), null, false)!!
        MainActivity.data.adventurers.add(hero)
        MainActivity.data.items.add(Item.getInstance("AbyssalCutlass", 1)!!)
        val warnings = ArrayList<String>()
        EquipmentLoadoutHelper.applyHeroGear(hero, SavedEquipment("AbyssalCutlass", null, null), warnings)
        assertEquals("AbyssalCutlass", hero.weapon?.getTrueClass())
        assertTrue("Old weapon must go back to storage", MainActivity.data.items.any { it.getTrueClass() == "CopperSword" })
        assertFalse("New weapon must leave storage", MainActivity.data.items.any { it.getTrueClass() == "AbyssalCutlass" })
        assertTrue(warnings.isEmpty())
    }

    @Test
    fun testApplyStealsGearFromIdleHero() {
        val heroA = newHero(1)
        val heroB = newHero(2)
        heroB.weapon = copperSword()
        MainActivity.data.adventurers.add(heroA)
        MainActivity.data.adventurers.add(heroB)
        val warnings = ArrayList<String>()
        EquipmentLoadoutHelper.applyHeroGear(heroA, SavedEquipment("CopperSword", null, null), warnings)
        assertEquals("CopperSword", heroA.weapon?.getTrueClass())
        assertEquals("Idle hero must fall back to the default weapon", "Spade", heroB.weapon?.getTrueClass())
        assertTrue("A clean idle swap must not warn", warnings.isEmpty())
    }

    @Test
    fun testApplyProtectsGearOnActiveExplorer() {
        val heroA = newHero(1)
        val heroB = newHero(2)
        heroB.weapon = copperSword()
        MainActivity.data.adventurers.add(heroA)
        MainActivity.data.adventurers.add(heroB)
        MainActivity.data.enchantedForest!!.adventurersExploringIds.add(2)
        val warnings = ArrayList<String>()
        EquipmentLoadoutHelper.applyHeroGear(heroA, SavedEquipment("CopperSword", null, null), warnings)
        assertNull("Active explorer's gear must not be stolen", heroA.weapon)
        assertEquals("CopperSword", heroB.weapon?.getTrueClass())
        assertEquals(1, warnings.size)
    }

    @Test
    fun testApplyWarnsWhenItemMissing() {
        val hero = newHero(1)
        MainActivity.data.adventurers.add(hero)
        val warnings = ArrayList<String>()
        EquipmentLoadoutHelper.applyHeroGear(hero, SavedEquipment("AbyssalCutlass", null, null), warnings)
        assertNull(hero.weapon)
        assertEquals(1, warnings.size)
    }

    @Test
    fun testApplyWarnsWhenStorageFullForIdleSwap() {
        val heroA = Adventurer.getInstance("Footman", 1, 5, 0, copperSword(), null, null, null, null, PotionsDrank(), null, false)!!
        val heroB = newHero(2)
        heroB.weapon = abyssalCutlass()
        MainActivity.data.adventurers.add(heroA)
        MainActivity.data.adventurers.add(heroB)
        repeat(40) {
            MainActivity.data.items.add(Item.getInstance("Wood", 1)!!)
        }
        val warnings = ArrayList<String>()
        EquipmentLoadoutHelper.applyHeroGear(heroA, SavedEquipment("AbyssalCutlass", null, null), warnings)
        assertEquals("Storage cap prevents the idle-swap", "CopperSword", heroA.weapon?.getTrueClass())
        assertEquals(1, warnings.size)
    }

    @Test
    fun testAreaSavedGearSerializationRoundTrip() {
        val forest = MainActivity.data.enchantedForest!!
        forest.savedAdventurersGear["7"] = SavedEquipment("CopperSword", "CopperArmor", "TuskNecklace")
        val gson = GsonBuilder().setPrettyPrinting().registerTypeAdapter(Data::class.java, DataDeserializer()).create()
        val json = gson.toJson(MainActivity.data)
        val loaded = gson.fromJson(json, Data::class.java)!!
        val restored = loaded.enchantedForest!!.savedAdventurersGear["7"]
        assertNotNull(restored)
        assertEquals("CopperSword", restored?.weapon)
        assertEquals("CopperArmor", restored?.armor)
        assertEquals("TuskNecklace", restored?.accessory)
        // Older saves without the key default to an empty map (backwards compatible).
        assertTrue(loaded.theDesert!!.savedAdventurersGear.isEmpty())
    }

    @Test
    fun testAutoRaidRedispatchAppliesSavedGear() {
        val tower = TheTower()
        val hero = Adventurer.getInstance("Footman", 1, 5, 0, null, null, null, null, null, PotionsDrank(), null, false)!!
        hero.currentHp = hero.calculateTotalMaxHp()
        MainActivity.data.adventurers.add(hero)
        tower.savedAdventurersIds = CopyOnWriteArrayList(listOf(1))
        tower.adventurersExploringIds = CopyOnWriteArrayList(listOf(1))
        tower.savedPetId = null
        tower.petExploringId = null
        tower.setupAdventurers(MainActivity.data.adventurers, MainActivity.data.pets)
        MainActivity.data.items.add(Item.getInstance("CopperSword", 1)!!)
        tower.savedAdventurersGear["1"] = SavedEquipment("CopperSword", null, null)
        tower.isAutoRaidActive = true
        tower.autoRaidRunsRemaining = 3
        tower.autoRaidStopOnWipe = true
        tower.triesAvailable = false
        MainActivity.data.gems = 100L

        assertTrue("Cycle must dispatch the next run", tower.handleAutoRaidCycle())
        assertEquals("Auto-Raid must re-equip the saved loadout", "CopperSword", hero.weapon?.getTrueClass())
        assertEquals(1, tower.autoRaidRunsCompleted)
    }
}