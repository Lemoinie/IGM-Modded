package it.paranoidsquirrels.idleguildmaster

import it.paranoidsquirrels.idleguildmaster.game.activities.GuildActivitiesManager
import it.paranoidsquirrels.idleguildmaster.game.activities.GuildActivitiesState
import it.paranoidsquirrels.idleguildmaster.game.redeem.RedeemCodes
import it.paranoidsquirrels.idleguildmaster.storage.data.Data
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionsDrank
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units.Shadow
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units.VoidSlime
import it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.Geode
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Action
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
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
        assertEquals(5, req.adventurersNumber())
        assertEquals(R.drawable.area_request, req.getDetailDrawable())
        assertEquals(R.drawable.test_area_image_summary_forest, req.getSummaryDrawable())

        // Bestiary "Other" lists only new monsters (not Void Slime, which is in TheSlimePond).
        val bestiary = req.listEnemies()
        assertEquals("Bestiary Other should list only Shadow", 1, bestiary.size)
        assertTrue("Bestiary Other monster must be Shadow", bestiary[0] is Shadow)

        // Wave formation: 1 Shadow always in the middle, 1/2/4 Void Slimes.
        req.progress = 1
        repeat(40) {
            val wave = req.rollEnemies()
            val slimes = wave.count { it is VoidSlime }
            val shadows = wave.count { it is Shadow }
            assertEquals("Exactly one Shadow per wave", 1, shadows)
            assertTrue("Slime count must be 1/2/4, got $slimes (size ${wave.size})", slimes in setOf(1, 2, 4))
            assertEquals(slimes + 1, wave.size)
            assertTrue("Shadow must sit in the middle", wave[wave.size / 2] is Shadow)
        }
    }

    @Test
    fun testGuildSiegeAreaConfiguration() {
        val siege = MainActivity.data.guildSiege!!
        assertEquals(10, siege.adventurersNumber())
        assertEquals(R.drawable.area_the_siege, siege.getDetailDrawable())
        assertEquals(R.drawable.test_area_image_summary_forest, siege.getSummaryDrawable())

        // Unlock every area so the wave planner sees its full pool.
        val req = MainActivity.data.guildRequest!!
        for (area in Utils.compileDungeonRaidList()) {
            area.isUnlocked = true
        }

        val wave1 = GuildActivitiesManager.rollSiegeWaveEnemies(1)
        assertTrue("Wave 1 should have 5..10 enemies, got ${wave1.size}", wave1.size in 5..10)
        // Verify no bosses in wave
        for (e in wave1) {
            assertNotEquals("SlimeKing", e.getTrueClass())
            assertNotEquals("Shadow", e.getTrueClass())
        }
    }

    @Test
    fun testRequestVictoryHasNoGemReward() {
        val state = MainActivity.data.guildActivitiesState
        MainActivity.data.gems = 100L

        GuildActivitiesManager.onRequestVictory(MainActivity.data.guildRequest!!)

        // The Hunt no longer awards gems on completion.
        assertEquals("Victory must not add gems", 100L, MainActivity.data.gems)
        assertEquals(GuildActivitiesState.STATUS_COMPLETED, state.requestStatus)
        assertTrue(state.requestRewardClaimed)

        // Subsequent victory should not change anything further
        GuildActivitiesManager.onRequestVictory(MainActivity.data.guildRequest!!)
        assertEquals("Victory must not add gems", 100L, MainActivity.data.gems)
    }

    @Test
    fun testHuntVictoryProducesShadowGeodeDrop() {
        val req = MainActivity.data.guildRequest!!
        val hero = Adventurer.getInstance("Footman", 1, 50, 0, null, null, null, null, null, PotionsDrank(), null, false)!!
        hero.currentHp = hero.calculateTotalMaxHp()
        MainActivity.data.adventurers.add(hero)

        val pet = Pet.getInstance("Semi", 1)!!
        pet.level = 2000
        pet.opportunist = 100.0 // executes any alive enemy
        MainActivity.data.pets.add(pet)

        req.adventurersExploringIds.add(hero.id)
        req.petExploringId = pet.id
        req.setupAdventurers(MainActivity.data.adventurers, MainActivity.data.pets)

        // Prepare a finished fight: enemies already dead, bodies in corpses.
        val wave = listOfNotNull(
            Enemy.getInstance("VoidSlime"),
            Enemy.getInstance("Shadow"),
            Enemy.getInstance("VoidSlime")
        )
        for (e in wave) e.currentHp = 0
        req.corpses = java.util.concurrent.CopyOnWriteArrayList(wave)
        req.enemies = java.util.concurrent.CopyOnWriteArrayList()
        req.action = Action(Action.FIGHT)

        var guard = 0
        while (guard < 60 && req.adventurersExploringIds.isNotEmpty()) {
            req.tick()
            guard++
        }

        val shadowDropped = req.drops.any { it.getTrueClass() == "Geode" }
        assertTrue("Shadow must drop its Geode in The Hunt; drops=${req.drops.joinToString { it.getTrueClass() ?: "?" }}", shadowDropped)
    }

    @Test
    fun testHuntAndSiegeCannotRefillWithGems() {
        // No gem purchases for extra tries on guild activities — 1 try per reroll.
        assertFalse("The Hunt must not allow gem refills", MainActivity.data.guildRequest!!.canRefillWithGems())
        assertFalse("The Siege must not allow gem refills", MainActivity.data.guildSiege!!.canRefillWithGems())
    }

    @Test
    fun testForceRerollHuntAndSiege() {
        val state = MainActivity.data.guildActivitiesState
        state.requestStatus = GuildActivitiesState.STATUS_COMPLETED
        state.requestRewardClaimed = true
        state.siegeStatus = GuildActivitiesState.STATUS_FAILED
        state.siegeWavesCleared = 7

        val ok = GuildActivitiesManager.forceRerollHuntAndSiege()
        assertTrue("Reroll should succeed when nothing is exploring", ok)
        assertEquals(GuildActivitiesState.STATUS_ACTIVE, state.requestStatus)
        assertFalse(state.requestRewardClaimed)
        assertEquals(GuildActivitiesState.STATUS_ACTIVE, state.siegeStatus)
        assertEquals(0, state.siegeWavesCleared)
        assertEquals(0, MainActivity.data.guildRequest?.progress)
        assertEquals(0, MainActivity.data.guildSiege?.progress)
        assertTrue("Reroll must stamp a fresh day boundary", state.requestDayBoundary != 0L)
        assertTrue("Reroll must stamp a fresh week boundary", state.siegeWeekBoundary != 0L)
    }

    @Test
    fun testRerollRedeemCode() {
        val state = MainActivity.data.guildActivitiesState
        state.requestStatus = GuildActivitiesState.STATUS_COMPLETED
        state.requestRewardClaimed = true
        state.siegeStatus = GuildActivitiesState.STATUS_COMPLETED

        val result = RedeemCodes.process("REROLL", null)
        assertNotNull("REROLL must return a message", result)
        assertEquals(GuildActivitiesState.STATUS_ACTIVE, state.requestStatus)
        assertFalse(state.requestRewardClaimed)
        assertEquals(GuildActivitiesState.STATUS_ACTIVE, state.siegeStatus)
    }

    @Test
    fun testSiegeWaveUsesSingleAreaWithRules() {
        // Unlock every area on the CURRENT Data instance so the wave planner sees it.
        val allAreas = ArrayList<Area>()
        for (field in Data::class.java.declaredFields) {
            if (Area::class.java.isAssignableFrom(field.type)) {
                field.isAccessible = true
                (field.get(MainActivity.data) as? Area)?.let { allAreas.add(it) }
            }
        }
        for (a in allAreas) a.isUnlocked = true

        val forest = MainActivity.data.enchantedForest!!
        val forestAllowed = GuildActivitiesManager.siegeAllowedMonsters(forest)
        assertTrue("Enchanted Forest should have spawnable monsters", forestAllowed.isNotEmpty())
        assertFalse("Enchanted Forest must exclude GoldenRabbit", forestAllowed.contains("GoldenRabbit"))

        val divine = MainActivity.data.divineArcheology!!
        assertEquals("Divine Archeology must only spawn Sand Demon", listOf("SandDemon"), GuildActivitiesManager.siegeAllowedMonsters(divine))

        val grave = MainActivity.data.ancientGraveDigging!!
        val graveAllowed = GuildActivitiesManager.siegeAllowedMonsters(grave)
        assertFalse("Ancient Grave Digging must exclude KabarTheRotten", graveAllowed.contains("KabarTheRotten"))
        assertFalse("Ancient Grave Digging must exclude Necrolith", graveAllowed.contains("Necrolith"))

        val city = MainActivity.data.theGoldenCity!!
        assertFalse("The Golden City must exclude Imperial Captain", GuildActivitiesManager.siegeAllowedMonsters(city).contains("ImperialCaptain"))

        val dire = MainActivity.data.theDireDescent!!
        assertTrue("Dire Descent must never spawn monsters", GuildActivitiesManager.siegeAllowedMonsters(dire).isEmpty())

        val tower = MainActivity.data.theTower!!
        val towerAllowed = GuildActivitiesManager.siegeAllowedMonsters(tower)
        assertTrue("The Tower must include Lazarus/Phoenix/HeadlessKnight", towerAllowed.containsAll(listOf("Lazarus", "Phoenix", "HeadlessKnight")))

        for (w in listOf(1, 5, 10)) {
            val wave = GuildActivitiesManager.rollSiegeWaveEnemies(w)
            assertTrue("Wave $w should have 5..10 enemies, got ${wave.size}", wave.size in 5..10)
        }
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
        assertEquals("Shadow must drop a stack of 3 Geodes", 3, (wrapper.item as? Geode)?.stack)
        val gemValue = (wrapper!!.item as? Geode)?.getGemValue()
        assertNotNull("Geode from Shadow must carry a preset gem value", gemValue)
        assertTrue("Geode value must be one of 100/50/20", gemValue in setOf(100, 50, 20))
        // The drop itself must be guaranteed (weight is per-1000).
        val rolled = Utils.rollFromWeightedMap(shadow?.listDrops(0))
        assertNotNull("Shadow's Geode must always roll", rolled)
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
    fun testGuildActivitiesLiveInTheirOwnListNotRaids() {
        val raids = Utils.compileRaidList()
        assertFalse("Raids tab must NOT include The Hunt", raids.any { it is GuildRequestArea })
        assertFalse("Raids tab must NOT include The Siege", raids.any { it is GuildSiegeArea })

        val guild = Utils.compileGuildActivitiesList()
        assertTrue("Guild Activities list must include The Hunt", guild.any { it is GuildRequestArea })
        assertTrue("Guild Activities list must include The Siege", guild.any { it is GuildSiegeArea })

        val all = Utils.compileDungeonRaidList()
        assertTrue("Aggregate list must include The Hunt", all.any { it is GuildRequestArea })
        assertTrue("Aggregate list must include The Siege", all.any { it is GuildSiegeArea })
    }
}
