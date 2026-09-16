package it.paranoidsquirrels.idleguildmaster

import it.paranoidsquirrels.idleguildmaster.game.redeem.RedeemCodes
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
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.TheGoldenCity
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.ModChangelog
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
        val goldResult = RedeemCodes.process("GOLD 50000", null)
        assertNotNull(goldResult)
        assertEquals(51000L, MainActivity.data.money)

        MainActivity.data.upgradeStorage = 0
        val storageResult = RedeemCodes.process("STORAGE 20", null)
        assertNotNull(storageResult)
        assertEquals(20, MainActivity.data.upgradeStorage)

        val idleResult = RedeemCodes.process("IDLETIME 72", null)
        assertNotNull(idleResult)
        assertEquals(72, MainActivity.data.idleTimeCapHours)

        val lootResult = RedeemCodes.process("LOOTCAP 500", null)
        assertNotNull(lootResult)
        assertEquals(500, MainActivity.data.lootCap)

        val killsResult = RedeemCodes.process("SETKILLS 120", null)
        assertNotNull(killsResult)
        assertEquals(120, MainActivity.data.imperialKills)
        assertTrue(MainActivity.data.imperialKills >= TheGoldenCity.IMPERIAL_CAPTAIN_KILL_THRESHOLD)

        val itemResult = RedeemCodes.process("ITEM CaptainsSword 2", null)
        assertNotNull(itemResult)
        val collected = MainActivity.data.items.find { it.getTrueClass() == "CaptainsSword" }
        assertNotNull(collected)
        assertEquals(2, collected?.stack)

        val heroResult = RedeemCodes.process("HERO Berserker 10 BRUTE_PLUS RUTHLESS_PLUS", null)
        assertNotNull(heroResult)
        val hero = MainActivity.data.adventurers.find { it.trueClass == "Berserker" }
        assertNotNull(hero)
        assertEquals(10, hero?.level)
        assertEquals(Trait.BRUTE_PLUS, hero?.traitCommon)
        assertEquals(Trait.RUTHLESS_PLUS, hero?.traitRare)

        val petResult = RedeemCodes.process("PET Senko 5", null)
        assertNotNull(petResult)
        val pet = MainActivity.data.pets.find { it.trueClass == "Senko" }
        assertNotNull(pet)
        assertEquals(5, pet?.level)
    }
    @Test
    fun testModAboutChangelogEntries() {
        val entries = ModChangelog.parseVersionEntries()
        assertTrue(entries.isNotEmpty())
        assertTrue("Top entry must be 1.3.0.4", entries[0].title.startsWith("1.3.0.4"))
        assertTrue("Bottom entry must be 1.0.0.0", entries.last().title.startsWith("1.0.0.0"))
    }

    @Test
    fun testModChangelogNoHardWrappedLines() {
        // Every change must be one logical line: no line inside a body may start
        // with whitespace (a folded continuation). The UI renders one row per change.
        for (entry in ModChangelog.parseVersionEntries()) {
            val folded = entry.body.split('\n').any { it.startsWith(" ") }
            assertFalse("Version " + entry.title + " has hard-wrapped continuation lines", folded)
        }
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
        val city = TheGoldenCity()
        MainActivity.data.imperialKills = 100
        assertEquals(100, MainActivity.data.imperialKills)

        city.onImperialCaptainDefeated()
        assertEquals("Kill count must reset to 0 upon defeat", 0, MainActivity.data.imperialKills)

        MainActivity.data.imperialKills = 100
        assertEquals(100, MainActivity.data.imperialKills)

        city.onTeamWipe()
        assertEquals("Kill count must reset to 0 upon team wipe", 0, MainActivity.data.imperialKills)
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
    @Test
    fun testCelestialMothershipNormalRaidAndDrops() {
        val mothership = it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.CelestialMothership()
        assertEquals("Celestial Mothership must be TYPE_RAID (1)", 1, mothership.getAreaType())
        assertFalse("Celestial Mothership must never be marked completed", mothership.completed())

        // Room 17 spawns Legate Hadrian regardless of seenItems
        MainActivity.data.seenItems.add("Evo23Vial")
        mothership.progress = 17
        mothership.maxProgress = 17
        val enemies17 = mothership.rollEnemies()
        assertEquals(1, enemies17.size)
        assertEquals("LegateHadrian", enemies17[0].getTrueClass())

        // Room 19 resets maxProgress to 0 so the raid can be replayed
        mothership.progress = 19
        mothership.maxProgress = 19
        mothership.triggerEvent("enter_room")
        assertEquals("maxProgress must reset to 0 upon completion", 0, mothership.maxProgress)
        assertTrue("terminationRequested must be set", mothership.terminationRequested)

        // Legate Hadrian drops
        val legate = it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units.LegateHadrian()
        val drops = legate.listDrops(0)
        assertEquals(2, drops.size)
        val evo23Entry = drops.entries.find { it.key.item?.getTrueClass() == "Evo23Vial" }
        val evo22Entry = drops.entries.find { it.key.item?.getTrueClass() == "Evo22Vial" }
        assertNotNull("Evo23Vial must be in drop table", evo23Entry)
        assertNotNull("Evo22Vial must be in drop table", evo22Entry)
        assertEquals("Evo23Vial drop rate must be 10% (weight 100)", 100, evo23Entry?.value)
        assertEquals("Evo22Vial drop rate must be 10% (weight 100)", 100, evo22Entry?.value)
        assertTrue("Evo23 stack must be 1..3", (evo23Entry?.key?.item?.getStack() ?: 0) in 1..3)
        assertTrue("Evo22 stack must be 1..3", (evo22Entry?.key?.item?.getStack() ?: 0) in 1..3)
    }

    @Test
    fun testBarrageRetargetsLivingEnemiesWhenTargetDies() {
        val area = TheGoldenCity()
        val archer = Adventurer.getInstance("Archer", 10, 20, 0, null, null, null, Trait.FERAL, null, PotionsDrank(), null, false)!!
        archer.activeSkill = Skills.ACTIVE_BARRAGE_III // 4 arrows
        area.adventurersExploring.add(archer)

        val e1 = Enemy.getInstance("Slime")!!
        e1.currentHp = 1
        e1.baseDefense = 0
        e1.baseMagicDefense = 0
        val e2 = Enemy.getInstance("Slime")!!
        e2.currentHp = 5000
        e2.baseDefense = 0
        e2.baseMagicDefense = 0

        area.enemies.add(e1)
        area.enemies.add(e2)

        val initialHpE2 = e2.currentHp
        area.cast(archer)

        assertEquals("E1 must be dead after hit 1", 0, e1.currentHp)
        assertTrue("E2 must take damage from remaining arrows", e2.currentHp < initialHpE2)
    }
}
