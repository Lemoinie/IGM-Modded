package it.paranoidsquirrels.idleguildmaster

import it.paranoidsquirrels.idleguildmaster.storage.data.Data
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.items.LootRarityHelper
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import java.util.ArrayList

class LootRarityTest {

    @Before
    fun setUp() {
        MainActivity.data = Data()
    }

    @Test
    fun testItemsWithRareDropFlag() {
        // Items configured with isRareDrop = true must be detected as ultra-rare drops
        assertTrue(LootRarityHelper.isUltraRareDrop(Item.getInstance("CorruptedAxe")))
        assertTrue(LootRarityHelper.isUltraRareDrop(Item.getInstance("AvianEgg")))
        assertTrue(LootRarityHelper.isUltraRareDrop(Item.getInstance("InsectEgg")))
    }

    @Test
    fun testCommonDropsAreNotRareByDefault() {
        // Standard items and materials have isRareDrop = false by default
        assertFalse(LootRarityHelper.isUltraRareDrop(Item.getInstance("CopperOre")))
        assertFalse(LootRarityHelper.isUltraRareDrop(Item.getInstance("BeastPelt")))
        assertFalse(LootRarityHelper.isUltraRareDrop(Item.getInstance("BoneFragment")))
        assertFalse(LootRarityHelper.isUltraRareDrop(Item.getInstance("Egg"))) // cooking egg
    }

    @Test
    fun testDynamicIsRareDropFlag() {
        val ore = Item.getInstance("CopperOre")!!
        assertFalse(LootRarityHelper.isUltraRareDrop(ore))

        // When dynamically flagged
        ore.isRareDrop = true
        assertTrue(LootRarityHelper.isUltraRareDrop(ore))
    }

    @Test
    fun testCollectItemPreservesRareFlag() {
        val list = ArrayList<Item>()
        val geode = Item.getInstance("Geode", 1)!!
        geode.isRareDrop = true

        Utils.collectItem(geode, list)
        assertEquals(1, list.size)
        assertTrue(list[0].isRareDrop)

        // Adding another instance preserves the rare drop flag
        val secondGeode = Item.getInstance("Geode", 2)!!
        Utils.collectItem(secondGeode, list)
        assertEquals(1, list.size)
        assertEquals(3, list[0].stack)
        assertTrue(list[0].isRareDrop)
    }

    private fun assertEquals(expected: Any?, actual: Any?) {
        org.junit.Assert.assertEquals(expected, actual)
    }
}
