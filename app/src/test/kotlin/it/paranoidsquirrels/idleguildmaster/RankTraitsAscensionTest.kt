package it.paranoidsquirrels.idleguildmaster

import it.paranoidsquirrels.idleguildmaster.storage.data.Data
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Trait
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class RankTraitsAscensionTest {

    @Before
    fun setUp() {
        MainActivity.data = Data()
    }

    @Test
    fun testDragonBloodUnascendedAndAscended() {
        // Tier 1 Footman (maxLevel = 5)
        val t1 = Adventurer.getInstance("Footman", 0, 1, 0, null, null, null, null, Trait.DRAGON_BLOOD, null, null, false)!!
        assertEquals(5, t1.maxLevel)
        // Raw 1000 physical damage with 100% armor penetration (d2 = 1.0) to isolate Dragon Blood:
        // Footman base CON = 8 -> flat DR = 8 / 8 = 1.
        // Unascended T1: 1% reduction -> 1000 * 0.99 - 1 = 989 damage taken
        val t1Dmg = t1.applyDamage(1000.0, false, 0, 1.0)
        assertEquals(989, t1Dmg)

        // Ascended T1: base CON * 1.5 = 12 -> flat DR = 12 / 8 = 1.
        // +9% base + 1% = 10% reduction -> 1000 * 0.90 - 1 = 899 damage taken
        t1.setAscended(true)
        t1.currentHp = t1.calculateTotalMaxHp()
        val t1AscDmg = t1.applyDamage(1000.0, false, 0, 1.0)
        assertEquals(899, t1AscDmg)

        // Tier 9 Wyrm Rider (maxLevel = 45, base CON = 12 -> flat DR = 12 / 8 = 1)
        val t9 = Adventurer.getInstance("WyrmRider", 1, 1, 0, null, null, null, null, Trait.DRAGON_BLOOD, null, null, false)!!
        assertEquals(45, t9.maxLevel)
        // Unascended T9: 9% reduction -> 1000 * 0.91 - 1 = 909 damage taken
        val t9Dmg = t9.applyDamage(1000.0, false, 0, 1.0)
        assertEquals(909, t9Dmg)

        // Ascended T9: base CON * 1.5 = 18 -> flat DR = 18 / 8 = 2.
        // +9% base + 9% = 18% reduction -> 1000 * 0.82 - 2 = 818 damage taken
        t9.setAscended(true)
        t9.currentHp = t9.calculateTotalMaxHp()
        val t9AscDmg = t9.applyDamage(1000.0, false, 0, 1.0)
        assertEquals(818, t9AscDmg)

        // Ascended T1 (899 dmg) takes LESS damage than unascended T9 (909 dmg)
        assertEquals(true, t1AscDmg < t9Dmg)
    }

    @Test
    fun testTrollBloodUnascendedAndAscended() {
        // Tier 1 Footman (maxLevel = 5)
        val t1 = Adventurer.getInstance("Footman", 0, 1, 0, null, null, null, null, Trait.TROLL_BLOOD, null, null, false)!!
        val maxHpT1Unasc = t1.calculateTotalMaxHp()
        // Unascended T1: rank = 1 -> bonus = (maxHp * 1 + 100) / 200 (~0.5% maxHp)
        val expectedT1Unasc = (maxHpT1Unasc * 1 + 100) / 200
        assertEquals(expectedT1Unasc, t1.calculateTotalRegeneration())

        // Ascended T1: rank = 1 + 9 = 10 -> bonus = (maxHp * 10 + 100) / 200 (~5.0% maxHp)
        // Note: Ascending also scales baseMaxHp by 1.5x, so recalculate maxHp
        t1.setAscended(true)
        val maxHpT1Asc = t1.calculateTotalMaxHp()
        val expectedT1Asc = (maxHpT1Asc * 10 + 100) / 200
        assertEquals(expectedT1Asc, t1.calculateTotalRegeneration())

        // Tier 9 Wyrm Rider (maxLevel = 45)
        val t9 = Adventurer.getInstance("WyrmRider", 1, 1, 0, null, null, null, null, Trait.TROLL_BLOOD, null, null, false)!!
        val maxHpT9Unasc = t9.calculateTotalMaxHp()
        // Unascended T9: rank = 9 -> bonus = (maxHp * 9 + 100) / 200 (~4.5% maxHp)
        val expectedT9Unasc = (maxHpT9Unasc * 9 + 100) / 200
        assertEquals(expectedT9Unasc, t9.calculateTotalRegeneration())

        // Ascended T9: rank = 9 + 9 = 18 -> bonus = (maxHp * 18 + 100) / 200 (~9.0% maxHp)
        t9.setAscended(true)
        val maxHpT9Asc = t9.calculateTotalMaxHp()
        val expectedT9Asc = (maxHpT9Asc * 18 + 100) / 200
        assertEquals(expectedT9Asc, t9.calculateTotalRegeneration())
    }
}
