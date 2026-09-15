package it.paranoidsquirrels.idleguildmaster

import it.paranoidsquirrels.idleguildmaster.mod.ModManager
import it.paranoidsquirrels.idleguildmaster.storage.data.Data
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionsDrank
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Trait
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.DoctrineAbilityType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.EliteEnemy
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.*
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class ModFeaturesTest {

    @Before
    fun setUp() {
        MainActivity.data = Data()
    }

    @Test
    fun testDoctrineRebalances() {
        assertEquals(25, DoctrineAbilityType.IMPROVED_HEALTH.increasePerLevel)
        assertEquals(1, DoctrineAbilityType.TROLL_RESISTANCE.cost)
        assertEquals(2, DoctrineAbilityType.TROLL_RESISTANCE.increasePerLevel)
        assertEquals(5, DoctrineAbilityType.TROLL_RESISTANCE.maxLevel)
        assertEquals(20, DoctrineAbilityType.LIGHTNING_SPEED.increasePerLevel)
    }

    @Test
    fun testRuthlessPlusTrait() {
        val trait = Trait.valueOf("RUTHLESS_PLUS")
        assertNotNull(trait)
        assertEquals("RUTHLESS_PLUS", trait.name)
    }

    @Test
    fun testCustomItemsInstantiation() {
        val sword = Item.getInstance("CaptainsSword", 1)
        assertNotNull(sword)
        assertTrue(sword is CaptainsSword)

        val bow = Item.getInstance("CelestialBow", 1)
        assertNotNull(bow)
        assertTrue(bow is CelestialBow)

        val evo22 = Item.getInstance("Evo22Vial", 1)
        assertNotNull(evo22)
        assertTrue(evo22 is Evo22Vial)

        val xp1 = Item.getInstance("XPBook1", 5) as? XPBook1
        assertNotNull(xp1)
        assertEquals(10, xp1?.getXpToGive())
        assertEquals(5, xp1?.stack)

        val xp10 = Item.getInstance("XPBook10", 1) as? XPBook10
        assertNotNull(xp10)
        assertEquals(100000, xp10?.getXpToGive())
    }

    @Test
    fun testCelestialBowAttackThrice() {
        val bow = Item.getInstance("CelestialBow", 1) as? CelestialBow
        assertNotNull(bow)
        val hero = Adventurer.getInstance("Footman", 1, 1, 0, bow, null, null, null, null, PotionsDrank(), null, false)
        assertNotNull(hero)
        val actions = hero?.endOfTurnActions() ?: emptyList()
        val extraAttacks = actions.count { it == EndOfTurnAction.EXTRA_ATTACK }
        assertEquals(
            "Celestial Bow must grant 2 extra attacks (base + 2 = attack thrice)",
            2,
            extraAttacks
        )
    }

    @Test
    fun testCustomEntitiesInstantiation() {
        val berserker = Adventurer.getInstance("Berserker", 1, 45, 0, null, null, null, null, null, PotionsDrank(), null, false)
        assertNotNull(berserker)
        assertEquals("Berserker", berserker?.trueClass)

        val captain = Enemy.getInstance("ImperialCaptain")
        assertNotNull(captain)
        assertEquals("ImperialCaptain", captain?.trueClass)
        assertEquals(Skills.ACTIVE_EXECUTION_ORDER, captain?.activeSkill)

        val knightSlime = Enemy.getInstance("KnightSlime")
        assertNotNull(knightSlime)
        assertEquals("KnightSlime", knightSlime?.trueClass)

        val senko = Pet.getInstance("Senko", 1)
        assertNotNull(senko)
        assertEquals("Senko", senko?.trueClass)

        val eliteSlime = Enemy.getInstance("Elite_Slime")
        assertNotNull(eliteSlime)
        assertTrue(eliteSlime is EliteEnemy)
        assertEquals("Elite_Slime", eliteSlime?.trueClass)
    }

    @Test
    fun testModRedeemCodes() {
        MainActivity.data.money = 1000L
        val goldResult = ModManager.processRedeemCode("GOLD 50000", null)
        assertNotNull(goldResult)
        assertEquals(51000L, MainActivity.data.money)

        MainActivity.data.upgradeStorage = 0
        val storageResult = ModManager.processRedeemCode("STORAGE 20", null)
        assertNotNull(storageResult)
        assertEquals(20, MainActivity.data.upgradeStorage)

        val idleResult = ModManager.processRedeemCode("IDLETIME 72", null)
        assertNotNull(idleResult)
        assertEquals(72 * 3600, ModManager.getIdleTimeCap(12 * 3600))

        val lootResult = ModManager.processRedeemCode("LOOTCAP 500", null)
        assertNotNull(lootResult)
        assertEquals(500, ModManager.getLootCap())

        val killsResult = ModManager.processRedeemCode("SETKILLS 120", null)
        assertNotNull(killsResult)
        assertEquals(120, ModManager.getImperialKills())
        assertTrue(ModManager.getImperialKills() >= ModManager.IMPERIAL_CAPTAIN_THRESHOLD)

        val itemResult = ModManager.processRedeemCode("ITEM CaptainsSword 2", null)
        assertNotNull(itemResult)
        val collected = MainActivity.data.items.find { it.getTrueClass() == "CaptainsSword" }
        assertNotNull(collected)
        assertEquals(2, collected?.stack)

        val heroResult = ModManager.processRedeemCode("HERO Berserker 10 BRUTE_PLUS RUTHLESS_PLUS", null)
        assertNotNull(heroResult)
        val hero = MainActivity.data.adventurers.find { it.trueClass == "Berserker" }
        assertNotNull(hero)
        assertEquals(10, hero?.level)
        assertEquals(Trait.BRUTE_PLUS, hero?.traitCommon)
        assertEquals(Trait.RUTHLESS_PLUS, hero?.traitRare)

        val petResult = ModManager.processRedeemCode("PET Senko 5", null)
        assertNotNull(petResult)
        val pet = MainActivity.data.pets.find { it.trueClass == "Senko" }
        assertNotNull(pet)
        assertEquals(5, pet?.level)
    }
    @Test
    fun testModAboutChangelogEntries() {
        val entries = ModManager.parseVersionEntries()
        assertTrue(entries.isNotEmpty())
        assertTrue("Top entry must be 1.3.0.1", entries[0].title.startsWith("1.3.0.1"))
        assertTrue("Bottom entry must be 1.0.0.0", entries.last().title.startsWith("1.0.0.0"))
    }

    @Test
    fun testBestiaryEntriesContainCaptainAndKnightSlime() {
        val goldenCity = it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.TheGoldenCity()
        val gcEnemies = goldenCity.listEnemies()
        assertTrue("TheGoldenCity must include ImperialCaptain in Bestiary", gcEnemies.any { it.getTrueClass() == "ImperialCaptain" })

        val slimePond = it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.TheSlimePond()
        val spEnemies = slimePond.listEnemies()
        assertTrue("TheSlimePond must include KnightSlime in Bestiary", spEnemies.any { it.getTrueClass() == "KnightSlime" })
    }

    @Test
    fun testImperialCaptainKillReset() {
        ModManager.setImperialKills(100, null)
        assertEquals(100, ModManager.getImperialKills())

        ModManager.onImperialCaptainDefeated(null)
        assertEquals("Kill count must reset to 0 upon defeat", 0, ModManager.getImperialKills())

        ModManager.setImperialKills(100, null)
        assertEquals(100, ModManager.getImperialKills())

        ModManager.onTeamWipe(null)
        assertEquals("Kill count must reset to 0 upon team wipe", 0, ModManager.getImperialKills())
    }

    @Test
    fun testSenkoSemiPetFeatures() {
        val semi = Pet.getInstance("Semi", 1)
        assertNotNull(semi)
        assertEquals("Senko", semi?.getTrueClass())
        assertEquals(1, semi?.level)

        // At level 1, Senko's abilities are unlocked and configureAbilities applies them
        val senko = Pet.getInstance("Senko", 1)
        assertNotNull(senko)
        assertEquals(1, senko?.level)
    }
}
