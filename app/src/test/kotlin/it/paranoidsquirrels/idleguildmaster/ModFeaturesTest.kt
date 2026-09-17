package it.paranoidsquirrels.idleguildmaster

import it.paranoidsquirrels.idleguildmaster.game.redeem.RedeemCodes
import it.paranoidsquirrels.idleguildmaster.storage.data.Data
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionsDrank
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Trait
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.DoctrineAbilityType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.EliteEnemy
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Recipes
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword
import it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.*
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.PetAbility
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

        val shopResult = RedeemCodes.process("SHOP", null)
        assertNotNull(shopResult)
        assertTrue("SHOP must flag new merchant items", MainActivity.data.isNewMerchantRegularItems)

        // data.adventurers is non-empty here (the HERO above created one), so the
        // vanilla quest extraction actually generates a fresh quest board.
        val questResult = RedeemCodes.process("QUEST", null)
        assertNotNull(questResult)
        assertTrue("QUEST must repopulate King's quests", MainActivity.data.kingsQuests.isNotEmpty())
    }
    @Test
    fun testModAboutChangelogEntries() {
        val entries = ModChangelog.parseVersionEntries()
        assertTrue(entries.isNotEmpty())
        assertTrue("Top entry must be 1.3.1.8", entries[0].title.startsWith("1.3.1.8"))
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
        archer.alwaysHits = true // deterministic: arrows never dodge
        area.adventurersExploring.add(archer)

        val e1 = Enemy.getInstance("Slime")!!
        e1.currentHp = 1
        e1.baseDefense = 0
        e1.baseMagicDefense = 0
        // Weight target selection toward E1 (weightedSelection scales by threat), so the first
        // arrow almost always kills E1 and the remaining arrows re-target the living E2.
        e1.threat = 1000000
        val e2 = Enemy.getInstance("Slime")!!
        e2.currentHp = 5000
        e2.baseDefense = 0
        e2.baseMagicDefense = 0
        e2.threat = 1

        area.enemies.add(e1)
        area.enemies.add(e2)

        val initialHpE2 = e2.currentHp
        area.cast(archer)

        assertEquals("E1 must be dead after the barrage", 0, e1.currentHp)
        assertTrue("E2 must take damage from remaining arrows (retargeting)", e2.currentHp < initialHpE2)
    }

    @Test
    fun testPetSavageActivatesAfterProgrammaticLevelChange() {
        // Mirrors the PET redeem path: the pet is created (abilities configured at the
        // factory's level 1), then its level is set afterwards WITHOUT reconfiguring.
        val pet = Pet.getInstance("Semi", 1)!!
        pet.petAbility4 = PetAbility.SAVAGE
        pet.level = 2000
        pet.refreshAbilities()
        assertEquals(
            "Savage must be recomputed from the new level (2000 * 0.3 = 600)",
            600.0,
            pet.getSavage(),
            0.001
        )
        assertTrue("Savage must be > 0 so the super-crit roll can fire", pet.getSavage() > 0.0)
    }

    @Test
    fun testDoctrineOfGraceOverhealAndHealingNovaFlowThroughGetters() {
        // Grace abilities: index 4 = OVERHEAL (max level 2, +5/level -> 10), index 5 = HEALING_NOVA (max level 1, +7/level -> 7)
        val grace = Doctrine.getInstance("DoctrineOfGrace", 0, 0, 0, 0, 2, 1)!!
        val hero = Adventurer.getInstance("Footman", 1, 45, 0, null, null, null, null, null, PotionsDrank(), grace, false)!!
        assertTrue("getMaxOverheal() must include the doctrine", hero.getMaxOverheal() > 0)
        assertEquals("raw maxOverheal field stays 0 — combat MUST read the getter", 0, hero.maxOverheal)
        assertTrue("getHealMissingHpOnEnemyDeath() must include the doctrine", hero.getHealMissingHpOnEnemyDeath() > 0)
        assertEquals("raw healMissingHpOnEnemyDeath field stays 0 — combat MUST read the getter", 0, hero.healMissingHpOnEnemyDeath)
    }

    @Test
    fun testDoctrineOfWarTacticalKnowledgeIgnoresArmor() {
        // War abilities: index 3 = TACTICAL_KNOWLEDGE (max level 2, +20/level -> 40 = the advertised 40% armor ignore), so it maps to l4
        val war = Doctrine.getInstance("DoctrineOfWar", 0, 0, 0, 2, 0, 0)!!
        val hero = Adventurer.getInstance("Footman", 1, 45, 0, null, null, null, null, null, PotionsDrank(), war, false)!!
        assertEquals("Tactical Knowledge must ignore 40% armor", 0.40, hero.getArmorIgnored(), 0.001)
        assertEquals("raw armorIgnored field stays 0 — combat MUST read the getter", 0.0, hero.armorIgnored, 0.0)

        // Behavioral check: a high-defense target takes noticeably more damage past 40% armor ignore.
        val enemy = Enemy.getInstance("Wolf")!!
        enemy.baseDefense = 100
        enemy.baseMagicDefense = 100
        enemy.currentHp = 100000
        val damageWithIgnore = enemy.applyDamage(1000.0, false, 0, hero.getArmorIgnored())
        enemy.currentHp = 100000
        val damageWithoutIgnore = enemy.applyDamage(1000.0, false, 0, 0.0)
        assertTrue(
            "40% armor ignore must yield more damage (got $damageWithIgnore vs $damageWithoutIgnore)",
            damageWithIgnore > damageWithoutIgnore
        )
    }

    @Test
    fun testOverhealFromDoctrineOfGraceGrantsShield() {
        val grace = Doctrine.getInstance("DoctrineOfGrace", 0, 0, 0, 0, 2, 1)!!
        val healer = Adventurer.getInstance("Paladin", 1, 45, 0, null, null, null, null, null, PotionsDrank(), grace, false)!!
        val target = Adventurer.getInstance("Footman", 2, 45, 0, null, null, null, null, null, PotionsDrank(), null, false)!!
        // Full HP: all healed amount overflows into the overheal shield.
        target.currentHp = target.calculateTotalMaxHp()
        target.currentShield = 0
        val area = MainActivity.data.enchantedForest!!
        area.heal(healer, target, null)
        assertTrue(
            "Overheal from Doctrine of Grace must grant a shield (got ${target.currentShield})",
            target.currentShield > 0
        )
    }

    @Test
    fun testAdventurerAttackStatScaling() {
        val sword = (Item.getInstance("CopperSword", 1) as? Sword)!!

        // Default scaling must be 1.0 so vanilla classes are unaffected.
        val footman = Adventurer.getInstance("Footman", 1, 5, 0, sword, null, null, null, null, PotionsDrank(), null, false)!!
        assertEquals("Default CON scaling must be 1.0", 1.0, footman.attackConstitutionScaling, 0.001)
        assertEquals("Default INT scaling must be 1.0", 1.0, footman.attackIntelligenceScaling, 0.001)
        assertEquals("Default DEX scaling must be 1.0", 1.0, footman.attackDexterityScaling, 0.001)

        // The CON-scaling classes must be configured at 150%.
        val regent = Adventurer.getInstance("BlackRegent", 1, 45, 0, sword, null, null, null, null, PotionsDrank(), null, false)!!
        assertEquals("BlackRegent must scale CON at 150%", 1.5, regent.attackConstitutionScaling, 0.001)
        val angel = Adventurer.getInstance("AngelOfWar", 1, 45, 0, sword, null, null, null, null, PotionsDrank(), null, false)!!
        assertEquals("AngelOfWar must scale CON at 150%", 1.5, angel.attackConstitutionScaling, 0.001)
        val champion = Adventurer.getInstance("DivineChampion", 1, 45, 0, sword, null, null, null, null, PotionsDrank(), null, false)!!
        assertEquals("DivineChampion must scale CON at 150%", 1.5, champion.attackConstitutionScaling, 0.001)

        // Behavioral check: raising the scaling on the same character must raise sword damage
        // (Swords scale damage off CON, so a 150% CON scaling must yield more damage).
        val baseline = footman.calculateMinAttackDamage()
        footman.attackConstitutionScaling = 1.5
        val boosted = footman.calculateMinAttackDamage()
        assertTrue(
            "150% CON scaling must increase sword damage ($baseline -> $boosted)",
            boosted > baseline
        )
    }

    @Test
    fun testBloodflameStatusEffectAndNoStacking() {
        val enemy = Enemy.getInstance("Wolf")!!
        enemy.addStatusEffect(StatusEffect(StatusEffectType.BLOODFLAME, enemy, 3, 1.0), 1.0)
        val bb = enemy.negativeStatusEffects.firstOrNull { it.type == StatusEffectType.BLOODFLAME }
        assertNotNull("Bloodflame must be applied", bb)
        assertEquals(3, bb?.turnsLeft)
        assertTrue("hasBloodflame() must report true", enemy.hasBloodflame())

        // Same as Ablaze: a shorter application must NOT stack / refresh.
        assertEquals(0, enemy.addStatusEffect(StatusEffect(StatusEffectType.BLOODFLAME, enemy, 1, 1.0), 1.0))
        assertEquals(3, enemy.negativeStatusEffects.first { it.type == StatusEffectType.BLOODFLAME }.turnsLeft)

        // A longer application replaces (refreshes upward).
        enemy.addStatusEffect(StatusEffect(StatusEffectType.BLOODFLAME, enemy, 5, 1.0), 1.0)
        assertEquals(5, enemy.negativeStatusEffects.first { it.type == StatusEffectType.BLOODFLAME }.turnsLeft)
        assertEquals(1, enemy.negativeStatusEffects.count { it.type == StatusEffectType.BLOODFLAME })
    }

    @Test
    fun testBloodflameBlocksHealing() {
        val area = MainActivity.data.enchantedForest!!
        val healer = Adventurer.getInstance("Paladin", 1, 45, 0, null, null, null, null, null, PotionsDrank(), null, false)!!
        val target = Adventurer.getInstance("Footman", 2, 5, 0, null, null, null, null, null, PotionsDrank(), null, false)!!
        val maxHp = target.calculateTotalMaxHp()
        target.currentHp = maxHp - 10

        // Without Bloodflame healing works.
        area.heal(healer, target, null)
        assertTrue("Normal heal must restore HP", target.currentHp > maxHp - 10)

        // With Bloodflame healing is fully blocked.
        target.currentHp = maxHp - 10
        target.addStatusEffect(StatusEffect(StatusEffectType.BLOODFLAME, healer, 5, 1.0), 1.0)
        assertTrue(target.hasBloodflame())
        val before = target.currentHp
        area.heal(healer, target, null)
        assertEquals("Bloodflame must block all healing", before, target.currentHp)
    }

    @Test
    fun testDecimateAppliesStunAndBloodflame() {
        val area = TheGoldenCity()
        val overlord = Adventurer.getInstance("Overlord", 1, 40, 0, null, null, null, null, null, PotionsDrank(), null, false)!!
        overlord.activeSkill = Skills.ACTIVE_DECIMATE_II
        overlord.alwaysHits = true
        area.adventurersExploring.add(overlord)
        val wolf = Enemy.getInstance("Wolf")!!
        wolf.baseDefense = 0
        wolf.baseMagicDefense = 0
        wolf.currentHp = 999999
        area.enemies.add(wolf)

        area.cast(overlord)

        val bf = wolf.negativeStatusEffects.firstOrNull { it.type == StatusEffectType.BLOODFLAME }
        assertNotNull("Decimate must afflict hit targets with Bloodflame", bf)
        assertEquals("Decimate must set Bloodflame for 1 turn", 1, bf?.turnsLeft)
        assertTrue(
            "Decimate must also STUN its targets (STUN + Bloodflame)",
            wolf.negativeStatusEffects.any { it.type == StatusEffectType.STUN }
        )
    }

    @Test
    fun testSubjugatePassivesApplyBloodflame() {
        val area = TheGoldenCity()

        // Subjugate I (Overlord): bloodflame for 1 turn on basic hits.
        val overlord = Adventurer.getInstance("Overlord", 1, 40, 0, null, null, null, null, null, PotionsDrank(), null, false)!!
        overlord.alwaysHits = true
        val wolf1 = Enemy.getInstance("Wolf")!!
        wolf1.baseDefense = 0
        wolf1.baseMagicDefense = 0
        wolf1.currentHp = 999999
        area.dealDamage(overlord, wolf1, null, null)
        val bb1 = wolf1.negativeStatusEffects.firstOrNull { it.type == StatusEffectType.BLOODFLAME }
        assertNotNull("Subjugate I must afflict Bloodflame on hit", bb1)
        assertEquals(1, bb1?.turnsLeft)

        // Subjugate II (BlackRegent): bloodflame for 2 turns on basic hits.
        val regent = Adventurer.getInstance("BlackRegent", 1, 45, 0, null, null, null, null, null, PotionsDrank(), null, false)!!
        regent.alwaysHits = true
        val wolf2 = Enemy.getInstance("Wolf")!!
        wolf2.baseDefense = 0
        wolf2.baseMagicDefense = 0
        wolf2.currentHp = 999999
        area.dealDamage(regent, wolf2, null, null)
        val bb2 = wolf2.negativeStatusEffects.firstOrNull { it.type == StatusEffectType.BLOODFLAME }
        assertNotNull("Subjugate II must afflict Bloodflame on hit", bb2)
        assertEquals(2, bb2?.turnsLeft)
    }

    @Test
    fun testKnightBranchConScaling() {
        val knightBranch = listOf(
            "Knight", "DarkKnight", "DeathKnight", "Scourge", "Tyrant", "Overlord",
            "BlackRegent", "HolyKnight", "Paladin", "Templar", "Inquisitor", "Justiciar", "AngelOfWar"
        )
        for (cls in knightBranch) {
            val hero = Adventurer.getInstance(cls, 1, 5, 0, null, null, null, null, null, PotionsDrank(), null, false)!!
            assertEquals("$cls (Knight branch) must scale CON at 150%", 1.5, hero.attackConstitutionScaling, 0.001)
        }
        val guardBranch = listOf(
            "Guard", "RoyalGuard", "RoyalSwordsman", "RoyalCaptain", "KingsHand",
            "DivineDuelist", "IronWarden", "IronDefender", "Juggernaut", "Titan",
            "UndyingBastion", "EternalFortress"
        )
        for (cls in guardBranch) {
            val hero = Adventurer.getInstance(cls, 1, 5, 0, null, null, null, null, null, PotionsDrank(), null, false)!!
            assertEquals("$cls (Guard branch) must keep default 100% CON scaling", 1.0, hero.attackConstitutionScaling, 0.001)
        }
    }

    @Test
    fun testColossalSwordOfScarletKing() {
        val sword = (Item.getInstance("ColossalSwordOfScarletKing", 1) as? ColossalSwordOfScarletKing)!!
        assertEquals("+124 Constitution from the sword", 124, sword.getConstitution())
        assertEquals("+7 Dexterity from the sword", 7, sword.getDexterity())
        assertEquals("Bloodflame damage must be +50%", 50, sword.getBloodflameDamageBonus())

        // Colossal-style damage formula: full CON when CON >= 120, otherwise half.
        assertEquals(124, sword.getDamageModifier(124, 0, 0))
        assertEquals(31, sword.getDamageModifier(62, 0, 0))

        // Craft recipe: Colossal Sword + 5 Heart of Darkness + 5 Ancestral Blood.
        val recipe = Recipes.into(sword)
        assertNotNull("A craft recipe must exist for the sword", recipe)
        val ingredients = recipe?.getIngredients() ?: emptyList()
        assertEquals(
            listOf("ColossalSword", "HeartOfDarkness", "AncestralBlood"),
            ingredients.map { it?.getTrueClass() }
        )
        assertEquals(listOf(1, 5, 5), ingredients.map { it?.getStack() })
    }
}
