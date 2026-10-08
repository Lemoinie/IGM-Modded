package it.paranoidsquirrels.idleguildmaster

import it.paranoidsquirrels.idleguildmaster.storage.data.Data
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units.BlackIdol
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units.BoneAbomination
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units.BoneHydra
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.EnchantedForest
import java.util.LinkedHashMap
import java.util.concurrent.CopyOnWriteArrayList
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class BlackIdolRebalanceTest {

    @Before
    fun setUp() {
        MainActivity.data = Data()
    }

    private fun testEnemy(dmg: Int): Enemy {
        val enemy = object : Enemy() {
            override fun getMaxDamage(): Int = dmg
            override fun getMinDamage(): Int = dmg
            override fun isMagic(): Boolean = false
            override fun isRanged(): Boolean = false
            override fun configureStatistics() {}
            override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> = LinkedHashMap()
        }
        enemy.currentHp = 100000
        enemy.alwaysHits = true
        enemy.baseDexterity = 0
        enemy.baseDefense = 0
        enemy.baseMagicDefense = 0
        return enemy
    }

    @Test
    fun testTierConfigurations() {
        val necro = Adventurer.getInstance("Necromancer", 1, 1, 0, null, null, null, null, null, null, null, false)!!
        assertEquals(1, necro.maxMinions)
        assertEquals(0.20, necro.soulTetherPercent, 0.001)
        assertEquals("Zombie", necro.minionSummonClass)
        assertEquals(1, necro.getMaxSoulHarvestStacks())
        assertEquals(Skills.PASSIVE_WITHERING_TOUCH_II, necro.passiveSkill)

        val demi = Adventurer.getInstance("Demilich", 2, 1, 0, null, null, null, null, null, null, null, false)!!
        assertEquals(1, demi.maxMinions)
        assertEquals(0.25, demi.soulTetherPercent, 0.001)
        assertEquals("Skeleton", demi.minionSummonClass)
        assertEquals(2, demi.getMaxSoulHarvestStacks())
        assertEquals(Skills.PASSIVE_WITHERING_TOUCH_III, demi.passiveSkill)

        val lich = Adventurer.getInstance("Lich", 3, 1, 0, null, null, null, null, null, null, null, false)!!
        assertEquals(2, lich.maxMinions)
        assertEquals(0.30, lich.soulTetherPercent, 0.001)
        assertEquals("BoneHorror", lich.minionSummonClass)
        assertEquals(4, lich.getMaxSoulHarvestStacks())
        assertEquals(Skills.PASSIVE_WITHERING_LINK_I, lich.passiveSkill)

        val ancient = Adventurer.getInstance("AncientLich", 4, 1, 0, null, null, null, null, null, null, null, false)!!
        assertEquals(2, ancient.maxMinions)
        assertEquals(0.35, ancient.soulTetherPercent, 0.001)
        assertEquals("BoneNightmare", ancient.minionSummonClass)
        assertEquals(6, ancient.getMaxSoulHarvestStacks())
        assertEquals(Skills.PASSIVE_WITHERING_LINK_II, ancient.passiveSkill)

        val lord = Adventurer.getInstance("LorfOfDecay", 5, 1, 0, null, null, null, null, null, null, null, false)!!
        assertEquals(3, lord.maxMinions)
        assertEquals(0.40, lord.soulTetherPercent, 0.001)
        assertEquals("BoneAbomination", lord.minionSummonClass)
        assertEquals(8, lord.getMaxSoulHarvestStacks())
        assertEquals(Skills.PASSIVE_WITHERING_LINK_III, lord.passiveSkill)

        val blackIdol = Adventurer.getInstance("BlackIdol", 6, 1, 0, null, null, null, null, null, null, null, false)!!
        assertEquals(3, blackIdol.maxMinions)
        assertEquals(0.45, blackIdol.soulTetherPercent, 0.001)
        assertEquals("BoneHydra", blackIdol.minionSummonClass)
        assertEquals(10, blackIdol.getMaxSoulHarvestStacks())
        assertEquals(Skills.PASSIVE_WITHERING_LINK_IV, blackIdol.passiveSkill)

        // Verify BoneAbomination instance
        val abom = Adventurer.getInstance("BoneAbomination", -100, 1, 0, null, null, null, null, null, null, null, false)!!
        assertTrue("Must be BoneAbomination", abom is BoneAbomination)
        assertTrue("Must be summonedMinion", abom.isSummonedMinion())

        // Verify tier-scaled minion decay rates
        val zombie = Adventurer.getInstance("Zombie", -101, 1, 0, null, null, null, null, null, null, null, false)!!
        val skeleton = Adventurer.getInstance("Skeleton", -102, 1, 0, null, null, null, null, null, null, null, false)!!
        val horror = Adventurer.getInstance("BoneHorror", -103, 1, 0, null, null, null, null, null, null, null, false)!!
        val nightmare = Adventurer.getInstance("BoneNightmare", -104, 1, 0, null, null, null, null, null, null, null, false)!!
        val hydra = Adventurer.getInstance("BoneHydra", -105, 1, 0, null, null, null, null, null, null, null, false)!!
        val beast = Adventurer.getInstance("SummonWolf", -106, 1, 0, null, null, null, null, null, null, null, false)!!

        assertEquals(0.20, zombie.minionDecayRate, 0.001)
        assertEquals(0.18, skeleton.minionDecayRate, 0.001)
        assertEquals(0.16, horror.minionDecayRate, 0.001)
        assertEquals(0.14, nightmare.minionDecayRate, 0.001)
        assertEquals(0.12, abom.minionDecayRate, 0.001)
        assertEquals(0.10, hydra.minionDecayRate, 0.001)
        assertEquals(0.25, beast.minionDecayRate, 0.001) // Vanilla beast unchanged at 25%

        assertEquals((zombie.calculateTotalMaxHp() * 0.20).toInt(), zombie.decay())
        assertEquals((hydra.calculateTotalMaxHp() * 0.10).toInt(), hydra.decay())
    }

    @Test
    fun testMultiMinionSkillSummonAndHeal() {
        val area = EnchantedForest()
        val idol = Adventurer.getInstance("BlackIdol", 1, 1, 0, null, null, null, null, null, null, null, false)!!
        idol.baseLifesteal = 0 // Disable lifesteal so it doesn't add extra healing to minions during skill attack
        val enemy = Enemy.getInstance("Wolf")!!
        area.adventurersExploring = CopyOnWriteArrayList(listOf(idol))
        area.fightingGroup = CopyOnWriteArrayList(listOf(idol, enemy))
        area.enemies = CopyOnWriteArrayList(listOf(enemy))
        idol.currentHp = idol.calculateTotalMaxHp()
        enemy.currentHp = enemy.calculateTotalMaxHp()

        // 1st active skill cast -> spawns 1st minion (BoneHydra)
        area.cast(idol)
        assertEquals(1, idol.minionsBound.size)
        assertTrue(idol.minionsBound[0] is BoneHydra)

        // 2nd active skill cast -> spawns 2nd minion
        area.cast(idol)
        assertEquals(2, idol.minionsBound.size)

        // 3rd active skill cast -> spawns 3rd minion (at capacity: maxMinions = 3)
        area.cast(idol)
        assertEquals(3, idol.minionsBound.size)

        // Damage the minions to test mending heal
        val m1 = idol.minionsBound[0]
        val m2 = idol.minionsBound[1]
        val m3 = idol.minionsBound[2]
        m1.currentHp = 100
        m2.currentHp = 100
        m3.currentHp = 100

        val maxHp = m1.calculateTotalMaxHp()
        val expectedHeal = (maxHp * 0.35).toInt()

        // 4th active skill cast -> at max capacity, heals all 3 minions by 35% Max HP
        area.cast(idol)
        assertEquals("Should not spawn beyond maxMinions cap", 3, idol.minionsBound.size)
        assertEquals(Math.min(maxHp, 100 + expectedHeal), m1.currentHp)
        assertEquals(Math.min(maxHp, 100 + expectedHeal), m2.currentHp)
        assertEquals(Math.min(maxHp, 100 + expectedHeal), m3.currentHp)
    }

    @Test
    fun testSoulTetherDistributedRedirection() {
        val area = EnchantedForest()
        val idol = Adventurer.getInstance("BlackIdol", 1, 1, 0, null, null, null, null, null, null, null, false)!!
        idol.baseConstitution = 0 // Disable CON flat damage reduction so we test pure raw redirection
        idol.baseDefense = 0
        idol.baseMagicDefense = 0
        idol.currentHp = 1000

        val h1 = Adventurer.getInstance("BoneHydra", -101, 1, 0, null, null, null, null, null, null, null, false)!!
        val h2 = Adventurer.getInstance("BoneHydra", -102, 1, 0, null, null, null, null, null, null, null, false)!!
        val h3 = Adventurer.getInstance("BoneHydra", -103, 1, 0, null, null, null, null, null, null, null, false)!!

        for (h in listOf(h1, h2, h3)) {
            h.baseConstitution = 0
            h.baseDefense = 0
            h.baseMagicDefense = 0
            h.currentHp = 500
            idol.minionsBound.add(h)
        }
        idol.minionBound = h1

        area.adventurersExploring = CopyOnWriteArrayList(listOf(idol, h1, h2, h3))
        area.fightingGroup = CopyOnWriteArrayList(listOf(idol, h1, h2, h3))

        val enemy = testEnemy(120)
        area.enemies = CopyOnWriteArrayList(listOf(enemy))

        // Raw 120 damage to Black Idol (Black Idol has 45% Soul Tether):
        // 45% of 120 = 54 redirected total.
        // Distributed across 3 living minions: 54 / 3 = 18 each.
        // Black Idol takes remaining 120 - 54 = 66 damage.
        val idolHpBefore = idol.currentHp
        val h1HpBefore = h1.currentHp
        val h2HpBefore = h2.currentHp
        val h3HpBefore = h3.currentHp

        area.dealDamage(enemy, idol, null, null)

        val idolLost = idolHpBefore - idol.currentHp
        val h1Lost = h1HpBefore - h1.currentHp
        val h2Lost = h2HpBefore - h2.currentHp
        val h3Lost = h3HpBefore - h3.currentHp

        assertEquals("Black Idol takes 55% (66 damage)", 66, idolLost)
        assertEquals("Hydra 1 takes 18 damage", 18, h1Lost)
        assertEquals("Hydra 2 takes 18 damage", 18, h2Lost)
        assertEquals("Hydra 3 takes 18 damage", 18, h3Lost)
    }

    @Test
    fun testSoulHarvestStatsAndTierCaps() {
        val minion = Adventurer.getInstance("Zombie", -100, 1, 0, null, null, null, null, null, null, null, false)!!
        val baseMaxHp = minion.calculateTotalMaxHp()
        val baseDmgDealt = minion.calculateTotalDamageDealt()
        val baseDmgTaken = minion.calculateTotalDamageTaken()

        // Apply 1 stack of SOUL_HARVEST
        minion.addStatusEffect(StatusEffect(StatusEffectType.SOUL_HARVEST, null, 1, 1.0), 0.0)
        assertEquals(1, minion.getSoulHarvestStacks())
        assertEquals((baseMaxHp * 1.15).toInt(), minion.calculateTotalMaxHp())
        assertEquals(baseDmgDealt + 0.10, minion.calculateTotalDamageDealt(), 0.001)
        assertEquals(baseDmgTaken - 0.05, minion.calculateTotalDamageTaken(), 0.001)

        // Consolidate second stack
        minion.addStatusEffect(StatusEffect(StatusEffectType.SOUL_HARVEST, null, 1, 1.0), 0.0)
        assertEquals(2, minion.getSoulHarvestStacks())
        assertEquals((baseMaxHp * 1.30).toInt(), minion.calculateTotalMaxHp())
        assertEquals(baseDmgDealt + 0.20, minion.calculateTotalDamageDealt(), 0.001)
        assertEquals(baseDmgTaken - 0.10, minion.calculateTotalDamageTaken(), 0.001)

        // Single status effect instance in positiveStatusEffects
        val harvestEffects = minion.positiveStatusEffects.filter { it.type == StatusEffectType.SOUL_HARVEST }
        assertEquals(1, harvestEffects.size)
        assertEquals(2, harvestEffects[0].turnsLeft)
    }

    @Test
    fun testMinionLifelineOnLichDeath() {
        val area = EnchantedForest()
        val idol = Adventurer.getInstance("BlackIdol", 1, 1, 0, null, null, null, null, null, null, null, false)!!
        val h1 = Adventurer.getInstance("BoneHydra", -101, 1, 0, null, null, null, null, null, null, null, false)!!
        val h2 = Adventurer.getInstance("BoneHydra", -102, 1, 0, null, null, null, null, null, null, null, false)!!
        idol.minionsBound.add(h1)
        idol.minionsBound.add(h2)
        area.adventurersExploring = CopyOnWriteArrayList(listOf(idol, h1, h2))
        area.fightingGroup = CopyOnWriteArrayList(listOf(idol, h1, h2))

        // When Black Idol dies, all bound minions must immediately perish
        idol.currentHp = 0
        area.checkDeath(idol)

        assertEquals("Hydra 1 must die when Lich dies", 0, h1.currentHp)
        assertEquals("Hydra 2 must die when Lich dies", 0, h2.currentHp)
        assertTrue("Minions must be cleared from bound list", idol.minionsBound.isEmpty())
    }

    @Test
    fun testWitheringLinkHealsAllBoundMinions() {
        val area = EnchantedForest()
        val idol = Adventurer.getInstance("BlackIdol", 1, 1, 0, null, null, null, null, null, null, null, false)!!
        idol.alwaysHits = true
        idol.baseLifesteal = 100
        val h1 = Adventurer.getInstance("BoneHydra", -101, 1, 0, null, null, null, null, null, null, null, false)!!
        val h2 = Adventurer.getInstance("BoneHydra", -102, 1, 0, null, null, null, null, null, null, null, false)!!
        h1.currentHp = 50
        h2.currentHp = 50
        idol.minionsBound.add(h1)
        idol.minionsBound.add(h2)
        idol.currentHp = 100

        area.adventurersExploring = CopyOnWriteArrayList(listOf(idol, h1, h2))
        area.fightingGroup = CopyOnWriteArrayList(listOf(idol, h1, h2))

        val enemy = Enemy.getInstance("Wolf")!!
        enemy.currentHp = 1000
        enemy.baseDefense = 0
        enemy.baseMagicDefense = 0
        enemy.baseConstitution = 0
        area.enemies = CopyOnWriteArrayList(listOf(enemy))

        // Deal 40 flat damage from Idol to enemy with 100% lifesteal using RIDER_II
        area.dealDamage(idol, enemy, null, EndOfTurnAction.RIDER_II)

        // Both h1 and h2 should receive 40 HP healing from Withering Link
        assertEquals(90, h1.currentHp)
        assertEquals(90, h2.currentHp)
    }
}
