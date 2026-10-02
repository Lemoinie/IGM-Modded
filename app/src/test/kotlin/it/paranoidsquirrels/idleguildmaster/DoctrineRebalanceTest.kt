package it.paranoidsquirrels.idleguildmaster

import it.paranoidsquirrels.idleguildmaster.storage.data.Data
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.DoctrineAbilityType
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class DoctrineRebalanceTest {

    @Before
    fun setUp() {
        MainActivity.data = Data()
    }

    @Test
    fun testDoctrineAbilityTypeValues() {
        // Exalted stats
        assertEquals(50, DoctrineAbilityType.EXALTED_HEALTH.increasePerLevel)
        assertEquals(5, DoctrineAbilityType.EXALTED_HEALTH.maxLevel)

        assertEquals(5, DoctrineAbilityType.EXALTED_DEXTERITY.increasePerLevel)
        assertEquals(5, DoctrineAbilityType.EXALTED_DEXTERITY.maxLevel)

        assertEquals(5, DoctrineAbilityType.EXALTED_INTELLIGENCE.increasePerLevel)
        assertEquals(5, DoctrineAbilityType.EXALTED_INTELLIGENCE.maxLevel)

        assertEquals(5, DoctrineAbilityType.EXALTED_CONSTITUTION.increasePerLevel)
        assertEquals(5, DoctrineAbilityType.EXALTED_CONSTITUTION.maxLevel)

        // Conditioned Reflexes
        assertEquals(15, DoctrineAbilityType.CONDITIONED_REFLEXES.increasePerLevel)
        assertEquals(3, DoctrineAbilityType.CONDITIONED_REFLEXES.maxLevel)

        // Selfless Spirit
        assertEquals(10, DoctrineAbilityType.SELFLESS_SPIRIT.increasePerLevel)
        assertEquals(5, DoctrineAbilityType.SELFLESS_SPIRIT.maxLevel)

        // Divine Intervention
        assertEquals(1, DoctrineAbilityType.DIVINE_INTERVENTION.increasePerLevel)
        assertEquals(5, DoctrineAbilityType.DIVINE_INTERVENTION.maxLevel)

        // False Life
        assertEquals(4, DoctrineAbilityType.FALSE_LIFE.increasePerLevel)
        assertEquals(3, DoctrineAbilityType.FALSE_LIFE.maxLevel)
    }

    @Test
    fun testDoctrineOfKnowledgeStatContributions() {
        // DoctrineOfKnowledge abilities:
        // 0: EXALTED_CONSTITUTION
        // 1: EXALTED_DEXTERITY
        // 2: EXALTED_INTELLIGENCE
        // 3: EXALTED_HEALTH
        // 4: EXALTED_MANA
        // 5: LORE_MASTER
        val doc = Doctrine.getInstance("DoctrineOfKnowledge", 5, 5, 5, 5, 3, 1)
        assertNotNull(doc)
        assertEquals(25, doc!!.bonusConstitution()) // 5 * 5
        assertEquals(25, doc.bonusDexterity()) // 5 * 5
        assertEquals(25, doc.bonusIntelligence()) // 5 * 5
        assertEquals(250, doc.bonusHp()) // 5 * 50
    }

    @Test
    fun testDoctrineOfWarCounterattack() {
        // DoctrineOfWar abilities:
        // 0: IMPROVED_CONSTITUTION
        // 1: IMPROVED_DEXTERITY
        // 2: CONDITIONED_REFLEXES
        // 3: TACTICAL_KNOWLEDGE
        // 4: RELENTLESS_ASSAULT
        // 5: WEAPON_MASTER
        val doc = Doctrine.getInstance("DoctrineOfWar", 5, 5, 3, 2, 1, 1)
        assertNotNull(doc)
        assertEquals(45, doc!!.bonusCounterattack()) // 3 * 15%
    }

    @Test
    fun testDoctrineOfGraceMaxLevels() {
        // DoctrineOfGrace abilities:
        // 0: IMPROVED_HEALTH
        // 1: IMPROVED_INTELLIGENCE
        // 2: SELFLESS_SPIRIT (now max level 5)
        // 3: DIVINE_INTERVENTION (now max level 5)
        // 4: OVERHEAL
        // 5: HEALING_NOVA
        val doc = Doctrine.getInstance("DoctrineOfGrace", 5, 5, 5, 5, 2, 1)
        assertNotNull(doc)
        assertEquals(50, doc!!.bonusHealingModifier()) // 5 * 10%
        assertEquals(5, doc.bonusResurrectionChance()) // 5 * 1%
    }

    @Test
    fun testDoctrineOfIllusionFalseLifeMaxLevel() {
        // DoctrineOfIllusion abilities:
        // 0: IMPROVED_DEXTERITY
        // 1: IMPROVED_INTELLIGENCE
        // 2: EPHEMERAL_PRESENCE
        // 3: BEAT_THE_ODDS
        // 4: FALSE_LIFE (now max level 3)
        // 5: TRUE_AGONY
        val doc = Doctrine.getInstance("DoctrineOfIllusion", 5, 5, 3, 1, 3, 1)
        assertNotNull(doc)
        assertEquals(12, doc!!.falseLifeChance()) // 3 * 4%
    }
}
