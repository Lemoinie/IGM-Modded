package it.paranoidsquirrels.idleguildmaster

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import it.paranoidsquirrels.idleguildmaster.storage.data.Data
import it.paranoidsquirrels.idleguildmaster.storage.data.DataDeserializer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionsDrank
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.DoctrineAbilityType
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

/**
 * Doctrine Expansion (v1.3.17.3): every Temple Doctrine gains a 7th ability node,
 * plus the new Entangle status. Getters, on-hit application, the anti-lifesteal
 * hook and the expanded save format (l7/l8) are covered here.
 */
class DoctrineExpansionTest {

    @Before
    fun setUp() {
        MainActivity.data = Data()
    }

    private fun doctrine(name: String, l7: Int = 0, l8: Int = 0): Doctrine? =
        Doctrine.getInstance(name, 0, 0, 0, 0, 0, 0, l7, l8)

    private fun newHero(): Adventurer {
        val hero = Adventurer.getInstance(
            "Footman", 1, 5, 0, null, null, null, null, null, PotionsDrank(), null, false
        )!!
        hero.currentHp = hero.calculateTotalMaxHp()
        return hero
    }

    @Test
    fun testEachDoctrineHasSevenAbilities() {
        val expected = mapOf(
            "DoctrineOfAffliction" to DoctrineAbilityType.BLOODLETTING,
            "DoctrineOfWar" to DoctrineAbilityType.TITANS_MIGHT,
            "DoctrineOfIllusion" to DoctrineAbilityType.EVASIVE_RIPOSTE,
            "DoctrineOfControl" to DoctrineAbilityType.VERDANT_BRIARS,
            "DoctrineOfGrace" to DoctrineAbilityType.SYMPATHETIC_WARD,
            "DoctrineOfKnowledge" to DoctrineAbilityType.ACCELERATED_MASTERY,
            "DoctrineOfRuin" to DoctrineAbilityType.ANNIHILATION,
            "DoctrineOfFortitude" to DoctrineAbilityType.ARMOR_MASTER
        )
        for ((className, newNode) in expected) {
            val doc = doctrine(className)
            assertNotNull("$className must instantiate", doc)
            assertEquals("$className must have 7 abilities", 7, doc!!.abilities.size)
            assertTrue("$className must contain the new node $newNode", doc.abilities.any { it.type == newNode })
        }
    }

    @Test
    fun testNoDoctrineRowExceedsFourCards() {
        // The doctrine dialog renders each ability row as a horizontal LinearLayout that
        // the plan's layout rules (section 3) cap at 4 cards per row. Regression: v1.3.17.3
        // initially placed Verdant Briars in Doctrine of Control's row 2, creating a 5-card
        // row (the root cause of the doctrine dialog failing to open; fixed in 1.3.17.4 by
        // moving Verdant Briars to row 3: Control is now rows 1/4/2).
        val names = listOf(
            "DoctrineOfAffliction", "DoctrineOfWar", "DoctrineOfIllusion",
            "DoctrineOfControl", "DoctrineOfGrace", "DoctrineOfKnowledge",
            "DoctrineOfRuin", "DoctrineOfFortitude"
        )
        val maxPerRow = 4
        for (name in names) {
            val doc = doctrine(name)!!
            val counts = doc.abilities.groupingBy { it.type?.row ?: 0 }.eachCount()
            for ((row, count) in counts) {
                assertTrue(
                    "$name row $row has $count abilities (max $maxPerRow)",
                    count <= maxPerRow
                )
            }
        }
    }

    @Test
    fun testBloodlettingScaling() {
        assertEquals(0, doctrine("DoctrineOfAffliction")!!.bloodlettingPercent())
        assertEquals(5, doctrine("DoctrineOfAffliction", 1)!!.bloodlettingPercent())
        assertEquals(10, doctrine("DoctrineOfAffliction", 2)!!.bloodlettingPercent())
        assertEquals(15, doctrine("DoctrineOfAffliction", 3)!!.bloodlettingPercent())
    }

    @Test
    fun testTitansMightScaling() {
        assertEquals(0, doctrine("DoctrineOfWar")!!.constitutionDamageConversion())
        assertEquals(50, doctrine("DoctrineOfWar", 1)!!.constitutionDamageConversion())
    }

    @Test
    fun testEvasiveRiposteScaling() {
        assertEquals(2, DoctrineAbilityType.EVASIVE_RIPOSTE.formatMode)
        assertEquals(50, DoctrineAbilityType.EVASIVE_RIPOSTE.increasePerLevel)
        assertEquals(0, doctrine("DoctrineOfIllusion")!!.evasiveRipostePercent())
        assertEquals(50, doctrine("DoctrineOfIllusion", 1)!!.evasiveRipostePercent())
        assertEquals(100, doctrine("DoctrineOfIllusion", 2)!!.evasiveRipostePercent())
        assertEquals(150, doctrine("DoctrineOfIllusion", 3)!!.evasiveRipostePercent())
    }

    @Test
    fun testVerdantBriarsScaling() {
        assertEquals(2, DoctrineAbilityType.VERDANT_BRIARS.formatMode)
        assertEquals(5, DoctrineAbilityType.VERDANT_BRIARS.increasePerLevel)
        assertEquals(0, doctrine("DoctrineOfControl")!!.verdantBriarsChance())
        assertEquals(5, doctrine("DoctrineOfControl", 1)!!.verdantBriarsChance())
        assertEquals(10, doctrine("DoctrineOfControl", 2)!!.verdantBriarsChance())
        assertEquals(15, doctrine("DoctrineOfControl", 3)!!.verdantBriarsChance())
    }

    @Test
    fun testSympatheticWardScaling() {
        assertEquals(2, DoctrineAbilityType.SYMPATHETIC_WARD.formatMode)
        assertEquals(10, DoctrineAbilityType.SYMPATHETIC_WARD.increasePerLevel)
        assertEquals(0, doctrine("DoctrineOfGrace")!!.sympatheticWardPercent())
        assertEquals(10, doctrine("DoctrineOfGrace", 1)!!.sympatheticWardPercent())
        assertEquals(20, doctrine("DoctrineOfGrace", 2)!!.sympatheticWardPercent())
        assertEquals(30, doctrine("DoctrineOfGrace", 3)!!.sympatheticWardPercent())
    }

    @Test
    fun testAcceleratedMasteryScaling() {
        assertEquals(0, doctrine("DoctrineOfKnowledge")!!.acceleratedMasteryPercent())
        assertEquals(10, doctrine("DoctrineOfKnowledge", 1)!!.acceleratedMasteryPercent())
        assertEquals(20, doctrine("DoctrineOfKnowledge", 2)!!.acceleratedMasteryPercent())
        assertEquals(30, doctrine("DoctrineOfKnowledge", 3)!!.acceleratedMasteryPercent())
    }

    @Test
    fun testAnnihilationScaling() {
        assertEquals(0, doctrine("DoctrineOfRuin")!!.annihilationCritDamageBonus())
        assertFalse(doctrine("DoctrineOfRuin")!!.hasAnnihilation())
        val doc = doctrine("DoctrineOfRuin", 2)!!
        assertEquals(60, doc.annihilationCritDamageBonus())
        assertTrue(doc.hasAnnihilation())
    }

    @Test
    fun testAnnihilationDisablesLifesteal() {
        val hero = newHero()
        hero.weapon = Item.getInstance("CrimsonLeech") as? Weapon
        assertNotNull("CrimsonLeech must exist and be equippable", hero.weapon)
        assertTrue("CrimsonLeech must grant lifesteal", hero.calculateTotalLifesteal() > 0)

        hero.doctrine = doctrine("DoctrineOfRuin", 1)
        assertEquals("Annihilation must remove all lifesteal", 0, hero.calculateTotalLifesteal())
    }

    @Test
    fun testArmorMasterScaling() {
        assertEquals(2, DoctrineAbilityType.ARMOR_MASTER.formatMode)
        assertEquals(20, DoctrineAbilityType.ARMOR_MASTER.increasePerLevel)
        assertEquals(0, doctrine("DoctrineOfFortitude")!!.armorMasterPercent())
        assertEquals(20, doctrine("DoctrineOfFortitude", 1)!!.armorMasterPercent())
        assertEquals(40, doctrine("DoctrineOfFortitude", 2)!!.armorMasterPercent())
        assertEquals(60, doctrine("DoctrineOfFortitude", 3)!!.armorMasterPercent())
    }

    @Test
    fun testVerdantBriarsAddsEntangleOnHit() {
        val hero = newHero()
        assertTrue(
            "No entangle without the node",
            hero.onTargetHitEffects().none { it.type == StatusEffectType.ENTANGLE }
        )

        hero.doctrine = doctrine("DoctrineOfControl", 3)
        val entangle = hero.onTargetHitEffects().find { it.type == StatusEffectType.ENTANGLE }
        assertNotNull("Verdant Briars must add an Entangle on-hit effect", entangle)
        assertEquals("Entangle must last 2 turns", 2, entangle!!.turnsLeft)
    }

    @Test
    fun testEntangleStatusIsNegativeAndSerialized() {
        assertTrue("Entangle must be a negative status", StatusEffectType.ENTANGLE.negative)
        assertTrue("Entangle must survive save/load", StatusEffectType.ENTANGLE.serialized)
    }

    @Test
    fun testDoctrineL7L8SaveRoundTrip() {
        val data = Data().apply {
            val hero = newHero()
            hero.doctrine = doctrine("DoctrineOfAffliction", 3, 0)
            adventurers.add(hero)
        }
        val gson = GsonBuilder()
            .registerTypeAdapter(Data::class.java, DataDeserializer())
            .create()
        val json = Gson().toJson(data)
        val loaded = gson.fromJson(json, Data::class.java)

        val doc = loaded.adventurers.firstOrNull()?.doctrine
        assertNotNull("Doctrine must survive the save round trip", doc)
        assertEquals("l7 must survive the save round trip", 3, doc!!.l7)
        assertEquals("l8 must default to 0 on legacy-style saves", 0, doc.l8)
        assertEquals("Bloodletting value must survive the save round trip", 15, doc.bloodlettingPercent())
    }
}