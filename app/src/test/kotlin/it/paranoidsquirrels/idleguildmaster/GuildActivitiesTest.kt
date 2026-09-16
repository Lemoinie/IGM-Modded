package it.paranoidsquirrels.idleguildmaster

import it.paranoidsquirrels.idleguildmaster.game.activities.GuildActivitiesManager
import it.paranoidsquirrels.idleguildmaster.game.activities.GuildActivitiesState
import it.paranoidsquirrels.idleguildmaster.storage.data.Data
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units.Shadow
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units.VoidSlime
import it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.Geode
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.GuildRequestArea
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.GuildSiegeArea
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class GuildActivitiesTest {

    @Before
    fun setUp() {
        MainActivity.data = Data()
        MainActivity.data.guildRequest = GuildRequestArea()
        MainActivity.data.guildSiege = GuildSiegeArea()
        MainActivity.data.guildActivitiesState = GuildActivitiesState()
    }

    @Test
    fun testShadowStatsAndInstantiation() {
        val enemy = Enemy.getInstance("Shadow")
        assertNotNull("Shadow should be instantiable via Enemy.getInstance", enemy)
        assertTrue("enemy should be an instance of Shadow", enemy is Shadow)
        val shadow = enemy as Shadow

        // Verify stats requested by user:
        // 100 con, 100 dex, 100 int, 100 min dmg, 1000 max dmg,
        // crit chance 50%, crit damage 200%, 50 def, 50 mdef,
        // status immunity 100%, 1000hp, no skills, melee and magic type, bonus dodge 20%
        assertEquals(100, shadow.calculateTotalConstitution())
        assertEquals(100, shadow.calculateTotalDexterity())
        assertEquals(100, shadow.calculateTotalIntelligence())
        assertEquals(100, shadow.calculateMinAttackDamage())
        assertEquals(1000, shadow.calculateMaxAttackDamage())
        assertEquals(0.50, shadow.calculateCriticalChance(), 0.001)
        assertEquals(2.0, shadow.calculateCriticalDamage(), 0.001)
        assertEquals(50, shadow.calculateTotalDefense())
        assertEquals(50, shadow.calculateTotalMagicDefense())
        assertEquals(1.0, shadow.calculateImmunityToStatus(), 0.001)
        assertEquals(1000, shadow.calculateTotalMaxHp())
        assertFalse("Shadow should be melee (not ranged)", shadow.isRanged())
        assertTrue("Shadow should be magic type", shadow.isMagic())
        assertEquals(0.20, shadow.calculateTotalFlatDodgeChance(), 0.001)
        assertEquals(R.drawable.shadow, shadow.imageId)
    }

    @Test
    fun testGuildRequestAreaEncounter() {
        val req = MainActivity.data.guildRequest!!
        assertEquals(12, req.adventurersNumber())
        assertEquals(R.drawable.area_request, req.getDetailDrawable())
        assertEquals(R.drawable.test_area_image_summary_forest, req.getSummaryDrawable())

        val enemies = req.listEnemies()
        assertTrue("listEnemies must contain Shadow", enemies.any { it is Shadow })
        assertTrue("listEnemies must contain VoidSlime", enemies.any { it is VoidSlime })

        req.progress = 1
        val wave = req.rollEnemies()
        assertEquals("Request wave must contain 3 enemies (2 Void Slimes, 1 Shadow)", 3, wave.size)
        val shadows = wave.count { it is Shadow }
        val voidSlimes = wave.count { it is VoidSlime }
        assertEquals(1, shadows)
        assertEquals(2, voidSlimes)
        // Order must be [VoidSlime, Shadow, VoidSlime]
        assertTrue("First enemy must be VoidSlime", wave[0] is VoidSlime)
        assertTrue("Second enemy must be Shadow", wave[1] is Shadow)
        assertTrue("Third enemy must be VoidSlime", wave[2] is VoidSlime)
    }

    @Test
    fun testGuildSiegeAreaConfiguration() {
        val siege = MainActivity.data.guildSiege!!
        assertEquals(12, siege.adventurersNumber())
        assertEquals(R.drawable.area_the_siege, siege.getDetailDrawable())
        assertEquals(R.drawable.test_area_image_summary_forest, siege.getSummaryDrawable())

        val wave1 = GuildActivitiesManager.rollSiegeWaveEnemies(1)
        assertTrue("Wave 1 should have 5..10 enemies", wave1.size in 5..10)
        // Verify no bosses in wave
        for (e in wave1) {
            assertTrue("No boss rarity in wave: ${e.getTrueClass()}", e.getRarity() < 2)
            assertNotEquals("SlimeKing", e.getTrueClass())
            assertNotEquals("Shadow", e.getTrueClass())
        }
    }

    @Test
    fun testRequestGemReward() {
        val state = MainActivity.data.guildActivitiesState
        MainActivity.data.gems = 100L

        GuildActivitiesManager.onRequestVictory(MainActivity.data.guildRequest!!)

        // Request pays a flat gem reward (replaces the removed reputation system).
        assertEquals(100L + GuildActivitiesManager.REQUEST_GEM_REWARD, MainActivity.data.gems)
        assertEquals(GuildActivitiesState.STATUS_COMPLETED, state.requestStatus)
        assertTrue(state.requestRewardClaimed)

        // Subsequent victory should not re-award gems
        GuildActivitiesManager.onRequestVictory(MainActivity.data.guildRequest!!)
        assertEquals(100L + GuildActivitiesManager.REQUEST_GEM_REWARD, MainActivity.data.gems)
    }

    @Test
    fun testSiegeDefeatMarksFailed() {
        val state = MainActivity.data.guildActivitiesState

        GuildActivitiesManager.onSiegeDefeat(MainActivity.data.guildSiege!!)
        assertEquals("Defeat should mark the siege as failed", GuildActivitiesState.STATUS_FAILED, state.siegeStatus)
    }

    @Test
    fun testSiegeRolloverResetsForNewWeek() {
        val state = MainActivity.data.guildActivitiesState
        state.siegeWeekBoundary = 1000L
        state.siegeStatus = GuildActivitiesState.STATUS_COMPLETED

        // Advance to next week boundary
        val nextWeek = 1000L + 7 * 24 * 60 * 60 * 1000L
        GuildActivitiesManager.ensureSiege(nextWeek)

        assertEquals("New week siege should be active", GuildActivitiesState.STATUS_ACTIVE, state.siegeStatus)
        assertEquals("Waves should reset", 0, state.siegeWavesCleared)
    }

    @Test
    fun testShadowLootPoolGeode() {
        val shadow = Enemy.getInstance("Shadow") as? Shadow
        assertNotNull(shadow)
        val drops = shadow?.listDrops(0)
        assertNotNull(drops)
        assertEquals("Shadow must drop exactly one Geode", 1, drops?.size)
        val wrapper = drops?.keys?.first()
        assertNotNull("Shadow should have a Geode drop", wrapper)
        assertTrue(wrapper!!.item is Geode)
        val gemValue = (wrapper!!.item as? Geode)?.getGemValue()
        assertNotNull("Geode from Shadow must carry a preset gem value", gemValue)
        assertTrue("Geode value must be one of 100/50/20", gemValue in setOf(100, 50, 20))
    }

    @Test
    fun testEligibleSiegeEnemiesDoNotRecurse() {
        // Regression: GuildSiegeArea.listEnemies() delegates to getEligibleSiegeEnemies(),
        // which must not iterate the siege itself (previously caused a stack overflow).
        val eligible = GuildActivitiesManager.getEligibleSiegeEnemies()
        assertTrue("Eligible pool should be non-empty", eligible.isNotEmpty())
        val siegeList = MainActivity.data.guildSiege!!.listEnemies()
        assertTrue("Siege listEnemies must terminate and be finite", siegeList.size > 0)
    }

    @Test
    fun testUtilsCompileRaidListIncludesGuildActivities() {
        val raids = Utils.compileRaidList()
        assertTrue("Raid list must include GuildRequest", raids.any { it is GuildRequestArea })
        assertTrue("Raid list must include GuildSiege", raids.any { it is GuildSiegeArea })
    }
}
