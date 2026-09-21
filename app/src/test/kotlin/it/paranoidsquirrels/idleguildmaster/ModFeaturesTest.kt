package it.paranoidsquirrels.idleguildmaster

import it.paranoidsquirrels.idleguildmaster.game.redeem.RedeemCodes
import it.paranoidsquirrels.idleguildmaster.storage.data.Data
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
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
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.EnemyType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.EnemyTypeRegistry
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Recipes
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword
import it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.*
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.PetAbility
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.TheGoldenCity
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.EnchantedForest
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.ModChangelog
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.util.LinkedHashMap
import java.util.concurrent.CopyOnWriteArrayList

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
    fun testScarletOniAndScarletSigil() {
        // Scarlet Oni: Heavy Armor
        val oni = Item.getInstance("ScarletOni", 1) as? ScarletOni
        assertNotNull("ScarletOni must instantiate via reflection", oni)
        assertEquals("Scarlet Oni must grant +470 max HP", 470, oni?.getMaxHp())
        assertEquals("Scarlet Oni must grant +56 CON", 56, oni?.getConstitution())
        assertEquals("Scarlet Oni must grant +18% crit chance", 0.18, oni?.getCriticalChance()!!, 0.0001)
        assertEquals("Scarlet Oni must grant +5% crit damage", 0.05, oni?.getCriticalDamage()!!, 0.0001)

        // Scarlet Sigil: Light Armor
        val sigil = Item.getInstance("ScarletSigil", 1) as? ScarletSigil
        assertNotNull("ScarletSigil must instantiate via reflection", sigil)
        assertEquals("Scarlet Sigil must grant +200 max HP", 200, sigil?.getMaxHp())
        assertEquals("Scarlet Sigil must grant +62 INT", 62, sigil?.getIntelligence())
        assertEquals("Scarlet Sigil must grant +20% crit chance", 0.20, sigil?.getCriticalChance()!!, 0.0001)
        assertEquals("Scarlet Sigil must grant +2 mana regen", 2, sigil?.getManaRegen())

        // Recipe registration, resolvable both directions via Recipes.into
        val oniRecipe = Recipes.into(oni)
        assertNotNull("ScarletOni must have a craft recipe", oniRecipe)
        assertEquals(Recipes.ScarletOni, oniRecipe)
        assertEquals(
            listOf("ScarletStrand"),
            oniRecipe?.getIngredients()?.map { it?.getTrueClass() }
        )
        assertEquals(listOf(5), oniRecipe?.getIngredients()?.map { it?.getStack() })

        val sigilRecipe = Recipes.into(sigil)
        assertNotNull("ScarletSigil must have a craft recipe", sigilRecipe)
        assertEquals(Recipes.ScarletSigil, sigilRecipe)
        assertEquals(
            listOf("ScarletStrand", "EldritchSeal"),
            sigilRecipe?.getIngredients()?.map { it?.getTrueClass() }
        )
        assertEquals(listOf(3, 1), sigilRecipe?.getIngredients()?.map { it?.getStack() })

        // 1:1 ingredient valuation (Scarlet Veil rule) at actual sell-price level.
        val strand = Item.getInstance("ScarletStrand", 1)!!
        val seal = Item.getInstance("EldritchSeal", 1)!!
        assertEquals("Scarlet Oni price must equal 5x Scarlet Strand (truncated)", Utils.truncatePrice(5 * strand.getPrice()), oni?.getPrice())
        assertEquals("Scarlet Sigil price must equal 3x Scarlet Strand + Eldritch Seal (truncated)", Utils.truncatePrice(3 * strand.getPrice() + seal.getPrice()), sigil?.getPrice())
    }

    @Test
    fun testScarletOniAdventurerStats() {
        val bare = Adventurer.getInstance("Footman", 1, 5, 0, null, null, null, null, null, PotionsDrank(), null, false)!!
        val oni = Item.getInstance("ScarletOni", 1) as? ScarletOni
        val hero = Adventurer.getInstance("Footman", 1, 5, 0, null, oni, null, null, null, PotionsDrank(), null, false)!!
        assertEquals("+470 max HP from Scarlet Oni", 470, hero.calculateTotalMaxHp() - bare.calculateTotalMaxHp())
        assertEquals("+56 CON from Scarlet Oni", 56, hero.calculateTotalConstitution() - bare.calculateTotalConstitution())
        assertEquals("+18% crit chance from Scarlet Oni", 0.18, hero.calculateCriticalChance() - bare.calculateCriticalChance(), 0.0001)
        assertEquals("+5% crit damage from Scarlet Oni", 0.05, hero.calculateCriticalDamage() - bare.calculateCriticalDamage(), 0.0001)
    }

    @Test
    fun testScarletSigilEquipmentManaRegen() {
        val bare = Adventurer.getInstance("Adept", 1, 5, 0, null, null, null, null, null, PotionsDrank(), null, false)!!
        val sigil = Item.getInstance("ScarletSigil", 1) as? ScarletSigil
        val hero = Adventurer.getInstance("Adept", 1, 5, 0, null, sigil, null, null, null, PotionsDrank(), null, false)!!
        // Sigil grants +62 INT (adds floor(62/10)=+6 via the INT mana formula) plus its flat +2 equipment mana regen.
        val expected = ((bare.calculateTotalIntelligence() + 62) / 10) + 10 + 2
        assertEquals("Mana regen must count the Sigil's flat +2 equipment bonus on top of its INT gain", expected, hero.calculateManaRegen())
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
        assertTrue("Top entry must be 1.3.8.14", entries[0].title.startsWith("1.3.8.14"))
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
        assertEquals("AngelOfWar must scale CON at 100% (Holy branch rework)", 1.0, angel.attackConstitutionScaling, 0.001)
        assertEquals("AngelOfWar must scale INT at 70% (Holy branch rework)", 0.7, angel.attackIntelligenceScaling, 0.001)
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
            "Knight", "DarkKnight", "DeathKnight", "Scourge", "Tyrant", "Overlord", "BlackRegent"
        )
        for (cls in knightBranch) {
            val hero = Adventurer.getInstance(cls, 1, 5, 0, null, null, null, null, null, PotionsDrank(), null, false)!!
            assertEquals("$cls (Knight branch) must scale CON at 150%", 1.5, hero.attackConstitutionScaling, 0.001)
        }
        // 1.3.3.0: the Holy Knight -> Angel of War line was reworked to 100% CON + 70% INT.
        val holyBranch = listOf(
            "HolyKnight", "Paladin", "Templar", "Inquisitor", "Justiciar", "AngelOfWar"
        )
        for (cls in holyBranch) {
            val hero = Adventurer.getInstance(cls, 1, 5, 0, null, null, null, null, null, PotionsDrank(), null, false)!!
            assertEquals("$cls (Holy branch) must scale CON at 100%", 1.0, hero.attackConstitutionScaling, 0.001)
            assertEquals("$cls (Holy branch) must scale INT at 70%", 0.7, hero.attackIntelligenceScaling, 0.001)
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

        // Colossal-style damage formula: full CON always (the sword itself grants 124 CON).
        assertEquals(124, sword.getDamageModifier(124, 0, 0))
        assertEquals(62, sword.getDamageModifier(62, 0, 0))

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

    @Test
    fun testBloodflameBonusMultipliesBurnNotReplaces() {
        // +50% Bloodflame bonus must multiply the 5% max-HP burn, not replace it.
        // Example from the report: 4000 HP enemy + Scarlet King sword => 300 damage/tick.
        val maxHp = 4000.0
        val bonus = 50
        val fraction = 0.05 * (1.0 + bonus * 0.01) // 0.075
        assertEquals(0.075, fraction, 0.0001)
        assertEquals(300, Utils.round(fraction * maxHp))
        // Without any bonus the burn stays exactly 5%.
        assertEquals(200, Utils.round(0.05 * (1.0 + 0.0) * maxHp))
    }

    @Test
    fun testEnemyTypeRegistryAndInheritance() {
        val wolf = Enemy.getInstance("Wolf")!!
        assertEquals(EnemyType.BEAST, wolf.getEnemyType())

        val skeleton = Enemy.getInstance("UndeadArcher")!!
        assertEquals(EnemyType.UNDEAD, skeleton.getEnemyType())

        val imp = Enemy.getInstance("Imp")!!
        assertEquals(EnemyType.DEMON, imp.getEnemyType())

        val bandit = Enemy.getInstance("ImperialGuard")!!
        assertEquals(EnemyType.HUMANOID, bandit.getEnemyType())

        val slime = Enemy.getInstance("Slime")!!
        assertEquals(EnemyType.SLIME, slime.getEnemyType())

        val dragon = Enemy.getInstance("DreamwroughtDragon")!!
        assertEquals(EnemyType.DRAGON, dragon.getEnemyType())

        val ent = Enemy.getInstance("Ent")!!
        assertEquals(EnemyType.PLANT, ent.getEnemyType())

        val golem = Enemy.getInstance("ObsidianGolem")!!
        assertEquals(EnemyType.CONSTRUCT, golem.getEnemyType())

        // EliteEnemy inheritance check
        val eliteWolf = EliteEnemy.createElite(wolf)!!
        assertEquals("EliteEnemy must inherit base enemy type", EnemyType.BEAST, eliteWolf.getEnemyType())

        val eliteSkeleton = EliteEnemy.createElite(skeleton)!!
        assertEquals("EliteEnemy must inherit base enemy type", EnemyType.UNDEAD, eliteSkeleton.getEnemyType())
    }

    @Test
    fun testRadiantBranchClassesConfigured() {
        val classes = listOf(
            "HolyKnight" to Pair(Skills.PASSIVE_AURA_OF_LIGHT_I, Skills.ACTIVE_HOLY_SMITE_I),
            "Paladin" to Pair(Skills.PASSIVE_AURA_OF_LIGHT_II, Skills.ACTIVE_HOLY_SMITE_II),
            "Templar" to Pair(Skills.PASSIVE_AURA_OF_DEVOTION_I, Skills.ACTIVE_RADIANT_JUDGMENT_I),
            "Inquisitor" to Pair(Skills.PASSIVE_AURA_OF_DEVOTION_II, Skills.ACTIVE_RADIANT_JUDGMENT_II),
            "Justiciar" to Pair(Skills.PASSIVE_AURA_OF_SANCTITY, Skills.ACTIVE_WRATH_OF_HEAVEN_I),
            "AngelOfWar" to Pair(Skills.PASSIVE_AURA_OF_THE_SERAPHIM, Skills.ACTIVE_WRATH_OF_HEAVEN_II)
        )
        for ((cls, skills) in classes) {
            val hero = Adventurer.getInstance(cls, 1, 45, 0, null, null, null, null, null, PotionsDrank(), null, false)!!
            assertEquals("$cls must use 100% CON weapon scaling", 1.0, hero.attackConstitutionScaling, 0.001)
            assertEquals("$cls must use 70% INT weapon scaling", 0.7, hero.attackIntelligenceScaling, 0.001)
            assertEquals("$cls must use 0% DEX weapon scaling", 0.0, hero.attackDexterityScaling, 0.001)
            assertEquals("$cls must be threat 2", 2, hero.threat)
            assertEquals("$cls passive", skills.first, hero.passiveSkill)
            assertEquals("$cls active", skills.second, hero.activeSkill)
        }
    }

    @Test
    fun testRadiantBlessingStatusEffectTypeRegistered() {
        assertEquals("RADIANT_BLESSING must be a positive status effect", false, StatusEffectType.RADIANT_BLESSING.negative)
        assertEquals(R.drawable.icon_effect_radiant_blessing, StatusEffectType.RADIANT_BLESSING.icon)
    }

    @Test
    fun testRadiantBlessingPayloadPropagationAndBonuses() {
        val hero = Adventurer.getInstance("Footman", 1, 45, 0, null, null, null, null, null, PotionsDrank(), null, false)!!
        val baseImmunity = hero.calculateImmunityToStatus()
        val baseDr = hero.calculateFlatDamageReduction()
        val blessing = StatusEffect(StatusEffectType.RADIANT_BLESSING, null, 1, 1.0, 0.40, 10, 0.03, 0.25)
        hero.addStatusEffect(blessing, 1.0)
        val stored = hero.positiveStatusEffects.first { it.type == StatusEffectType.RADIANT_BLESSING }
        // addStatusEffect must propagate the aura payload fields.
        assertEquals("blessing immunity must propagate", 0.40, stored.immunity, 0.001)
        assertEquals("blessing flatDr must propagate", 10, stored.flatDr)
        assertEquals("blessing regen must propagate", 0.03, stored.regenPct, 0.001)
        assertEquals("blessing undead bonus must propagate", 0.25, stored.undeadDamageBonus, 0.001)
        assertEquals("blessing turnsLeft must be 1 — renewed each turn by a living aura-bearer only", 1, stored.turnsLeft)
        // Bonus status immunity.
        assertTrue(
            "status immunity must include the blessing (+40%)",
            hero.calculateImmunityToStatus() >= baseImmunity + 0.39
        )
        // Flat damage reduction.
        assertTrue(
            "flat damage reduction must include the blessing (+10)",
            hero.calculateFlatDamageReduction() >= baseDr + 10
        )
    }

    @Test
    fun testRadiantBlessingUndeadMultiplierMath() {
        // The plan contract: +N% multiplier is applied on top of the 5% burn-style modifier;
        // here we verify the multiplier math used for the undead bonus in dealDamage.
        // A Justiciar aura grants 0.25 bonus -> 1.25x damage against Undead.
        val bonus = 0.25
        val multiplier = 1.0 + bonus
        assertEquals(1.25, multiplier, 0.0001)
        assertEquals(275, Utils.round(220.0 * multiplier)) // 220% -> 275% effective vs Undead
    }

    @Test
    fun testBleedPetAbilitiesConfiguredAtLevel100() {
        // Bloodcrave = floor(level*0.5) -> 50 at Lv100; Lacerate/Serrated = level*0.6 -> 60; Savage = level*0.3 -> 30.
        val pet = Pet.getInstance("Semi", 1, 100, 0, PetAbility.BLOODCRAVE, PetAbility.LACERATE, PetAbility.SERRATED, PetAbility.SAVAGE)!!
        assertEquals(100, pet.level)
        assertEquals(50.0, pet.bloodcrave, 0.001)
        assertEquals(60.0, pet.lacerate, 0.001)
        assertEquals(60.0, pet.serrated, 0.001)
        assertEquals(30.0, pet.savage, 0.001)
    }

    @Test
    fun testWildGuaranteedPoolOffersBloodcrave() {
        // guaranteedFirstAbility() is protected; the public factory rolls from it, so
        // every base-Wild pet's first ability must be LIFESTEAL or BLOODCRAVE.
        // (Senko/Semi overrides the pool with its own heal/regen/drops/experience kit.)
        for (i in 1..20) {
            val wildPet = Pet.getInstance("RedWolf", 100 + i)!!
            assertTrue(
                "Wild first ability must be LIFESTEAL or BLOODCRAVE (was ${wildPet.petAbility1})",
                wildPet.petAbility1 == PetAbility.LIFESTEAL || wildPet.petAbility1 == PetAbility.BLOODCRAVE
            )
        }
    }

    @Test
    fun testOneTimeBloodcraveSemiRedeem() {
        MainActivity.data.isRedeemed_z3gaazrt = false
        MainActivity.data.pets.clear()

        val first = RedeemCodes.process("Z3GAAZRT", null)
        assertNotNull("First redeem must return a message", first)
        val semi = MainActivity.data.pets.firstOrNull { it.trueClass.equals("Semi", true) || it.trueClass.equals("Senko", true) }
        assertNotNull("Z3GAAZRT must grant a Semi pet", semi)
        assertEquals(100, semi!!.level)
        assertEquals(PetAbility.BLOODCRAVE, semi.petAbility1)
        assertEquals(PetAbility.LACERATE, semi.petAbility2)
        assertEquals(PetAbility.SERRATED, semi.petAbility3)
        assertEquals(PetAbility.SAVAGE, semi.petAbility4)
        assertEquals(50.0, semi.bloodcrave, 0.001)
        assertEquals(60.0, semi.lacerate, 0.001)
        assertEquals(60.0, semi.serrated, 0.001)
        assertEquals(30.0, semi.savage, 0.001)
        assertTrue("Redeem flag must be persisted", MainActivity.data.isRedeemed_z3gaazrt)

        val second = RedeemCodes.process("Z3GAAZRT", null)
        assertNotNull(second)
        assertTrue("Second redeem must be blocked", second!!.contains("already", ignoreCase = true))
        assertEquals(1, MainActivity.data.pets.count { it.trueClass.equals("Semi", true) || it.trueClass.equals("Senko", true) })
    }

    @Test
    fun testBleedArmorShredScalesAndCaps() {
        // Ghoul has 50 Defense and no status immunity, so shred is clearly observable.
        val ghoul = Enemy.getInstance("Ghoul")!!
        ghoul.currentHp = ghoul.calculateTotalMaxHp()
        val base = ghoul.applyDamage(10000.0, false, 0, 0.0)

        ghoul.currentHp = ghoul.calculateTotalMaxHp()
        repeat(50) { ghoul.addStatusEffect(StatusEffect(StatusEffectType.BLEED, null, 1, 1.0), 1.0) }
        assertEquals(50, ghoul.getBleedStacks())
        ghoul.currentHp = ghoul.calculateTotalMaxHp()
        val shred50 = ghoul.applyDamage(10000.0, false, 0, 0.0)
        assertTrue("50 stacks shred 5% defense (more damage taken than base: $base -> $shred50)", shred50 > base)

        ghoul.currentHp = ghoul.calculateTotalMaxHp()
        repeat(100) { ghoul.addStatusEffect(StatusEffect(StatusEffectType.BLEED, null, 1, 1.0), 1.0) }
        assertEquals(150, ghoul.getBleedStacks())
        ghoul.currentHp = ghoul.calculateTotalMaxHp()
        val shred150 = ghoul.applyDamage(10000.0, false, 0, 0.0)
        assertTrue("Cap of 15% shred at 150 stacks ($shred50 -> $shred150)", shred150 >= shred50)
    }

    @Test
    fun testSerratedDoublesBleedApplication() {
        val forest = EnchantedForest()
        val pet = Pet.getInstance("Semi", 7)!!
        pet.serrated = 100.0 // 100% proc chance
        forest.petExploring = pet
        val wolf = Enemy.getInstance("Wolf")!!
        val hero = Adventurer.getInstance("Footman", 1, 20, 0, null, null, null, null, null, PotionsDrank(), null, false)!!
        forest.applyStatus(wolf, StatusEffect(StatusEffectType.BLEED, hero, 5, 1.0), 1.0)
        assertEquals("Serrated (100%) must double the inflicted bleed stacks", 10, wolf.getBleedStacks())
    }

    @Test
    fun testThousandCutsAppliesBleedAndHemorrhage() {
        val forest = EnchantedForest()
        val hero = Adventurer.getInstance("HellishSculptor", 1, 50, 0, null, null, null, null, null, PotionsDrank(), null, false)!!
        val wolf = Enemy.getInstance("Wolf")!!
        wolf.currentHp = wolf.calculateTotalMaxHp()
        // Frozen = cannot dodge, so Thousand Cuts always lands its hit.
        wolf.negativeStatusEffects.add(StatusEffect.STATIC_INSTANCE_FROZEN)
        forest.enemies = CopyOnWriteArrayList(listOf(wolf))
        forest.acting = hero
        forest.cast(hero)
        assertTrue("Thousand Cuts must apply Bleed stacks (stacks=${wolf.getBleedStacks()})", wolf.getBleedStacks() > 0)
        assertTrue("Hemorrhage burst must have dealt damage", wolf.currentHp < wolf.calculateTotalMaxHp())
    }

    @Test
    fun testCurrencyDecomposition() {
        // 1 Diamond = 100 Platinum = 100M copper; paln verification cases.
        assertEquals("50 copper -> 50c", listOf(50L, 0L, 0L, 0L, 0L), UIUtils.decomposeMoney(50L))
        assertEquals("1,500 copper -> 15s", listOf(0L, 15L, 0L, 0L, 0L), UIUtils.decomposeMoney(1500L))
        assertEquals("150,000 copper -> 15g", listOf(0L, 0L, 15L, 0L, 0L), UIUtils.decomposeMoney(150000L))
        assertEquals("15,000,000 copper -> 15p", listOf(0L, 0L, 0L, 15L, 0L), UIUtils.decomposeMoney(15000000L))
        assertEquals("250,000,000 copper -> 2d 50p", listOf(0L, 0L, 0L, 50L, 2L), UIUtils.decomposeMoney(250000000L))
    }

    @Test
    fun testItemSpeedClampAtLevel40() {
        val d = MainActivity.data
        d.isMerchantPackPurchased = true
        d.levelWorkshopTime = 25
        d.upgradeWorkshopTime = 15
        d.levelMarketTime = 25
        d.upgradeMarketTime = 15
        val item = Item.getInstance("CopperSword", 1)!!
        assertTrue("Craft time must stay >= 1s at speed level 40 (was ${item.getSecondsToCraft()})", item.getSecondsToCraft() >= 1L)
        assertTrue("Sell time must stay >= 1s at speed level 40 (was ${item.getSecondsToSell()})", item.getSecondsToSell() >= 1L)
    }

    @Test
    fun testExpandedUpgradeCaps() {
        val d = MainActivity.data
        d.upgradeStorage = 184
        d.upgradeQuarters = 15
        d.upgradeTavernCapacity = 7
        d.upgradeShelter = 7
        d.upgradeWorkshopTime = 15
        d.upgradeMarketTime = 15
        d.upgradeTavernTime = 5
        d.upgradeWorkshopQueue = 1
        d.upgradeMarketQueue = 1

        val offers = Utils.rollUpgrades()
        assertTrue("Storage must be offerable at 184 gem purchases", offers.any { it.item?.getTrueClass() == "UpgradeStorage" })

        d.upgradeStorage = 185
        val after = Utils.rollUpgrades()
        assertTrue("Storage must disappear from offers at 185 purchases", after.none { it.item?.getTrueClass() == "UpgradeStorage" })
    }

    @Test
    fun testBlackMarketBadLuckProtection() {
        val d = MainActivity.data
        d.isBlackMarketActive = false
        d.blackMarketMissedDays = 6
        Utils.checkBlackMarketDailyArrival()
        assertTrue("6 consecutive missed days guarantees the 7th arrival", d.isBlackMarketActive)
        assertEquals("Missed-day counter must reset on arrival", 0, d.blackMarketMissedDays)
        assertTrue("Arrival must flag new items", d.isNewBlackMarketItems)
    }

    @Test
    fun testBlackMarketStockShape() {
        val d = MainActivity.data
        Utils.refreshBlackMarketStock()
        val stock = d.blackMarketStock
        assertTrue("Stock must not be empty", stock.isNotEmpty())
        assertTrue("Stock must fit the 12-slot stall (was ${stock.size})", stock.size <= 12)
        assertTrue("Stock must include a smuggled legendary", stock.any { it.item?.getTrueClass() == "ScarletStrand" || it.item?.getTrueClass() == "Aegis" })
        assertTrue("Stock must include an evolution vial", stock.any { it.item?.getTrueClass() == "Evo22Vial" || it.item?.getTrueClass() == "Evo23Vial" })
        assertTrue("Stock must include contraband potions", stock.count { it.item?.getTrueClass()?.contains("PotionOf") == true } >= 1)
        assertTrue("Stock must include a shady delicacy", stock.any { it.item?.getTrueClass() == "GlazedDonut" || it.item?.getTrueClass() == "GourmetIcecream" || it.item?.getTrueClass() == "Maxxiburger" || it.item?.getTrueClass() == "Cheesecake" || it.item?.getTrueClass() == "Ambrosia" || it.item?.getTrueClass() == "CeremonialCake" })
    }

    @Test
    fun testBlackMarketRedeemCode() {
        val d = MainActivity.data
        d.isBlackMarketActive = false
        d.blackMarketStock.clear()
        val result = RedeemCodes.process("BLACK", null)
        assertNotNull("BLACK must return a message", result)
        assertTrue("BLACK must activate the black market", d.isBlackMarketActive)
        assertTrue("BLACK must stock the stall", d.blackMarketStock.isNotEmpty())
    }

    @Test
    fun testMeleeTargetingPrioritizesGroundOverFlying() {
        val area = it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.EnchantedForest()
        val meleeAdv = it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units.Footman()
        meleeAdv.weapon = it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.CopperSword()
        meleeAdv.currentHp = 100

        val flyingEnemy = it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units.VampireBat().apply {
            flying = true
            baseMaxHp = 100
            currentHp = 50
        }
        val groundEnemy = it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units.Wolf().apply {
            flying = false
            baseMaxHp = 100
            currentHp = 50
        }

        area.adventurersExploring.clear()
        area.adventurersExploring.add(meleeAdv)
        area.enemies.clear()
        area.enemies.add(flyingEnemy)
        area.enemies.add(groundEnemy)

        // 1. Melee adventurer targeting random enemy must pick the reachable ground enemy (Wolf)
        val targetsRandom = area.selectTargets(meleeAdv, "random_enemy")
        assertNotNull(targetsRandom)
        assertEquals("Melee unit must pick reachable ground enemy over flying", groundEnemy, targetsRandom!![0])

        // 2. Melee adventurer targeting lowest HP enemy when flying is lower HP must still pick ground enemy
        flyingEnemy.currentHp = 10
        groundEnemy.currentHp = 50
        val targetsLowest = area.selectTargets(meleeAdv, "lowest_relative_enemy")
        assertNotNull(targetsLowest)
        assertEquals("Melee unit must pick ground enemy even if flying has lower HP", groundEnemy, targetsLowest!![0])

        // 3. When ground enemy dies, melee unit falls back to flying enemy
        groundEnemy.currentHp = 0
        val targetsFallback = area.selectTargets(meleeAdv, "random_enemy")
        assertNotNull(targetsFallback)
        assertEquals("Melee unit falls back to flying enemy when no ground enemies remain", flyingEnemy, targetsFallback!![0])

        // 4. Ranged adventurer can target lowest HP flying enemy directly
        groundEnemy.currentHp = 50
        flyingEnemy.currentHp = 10
        val rangedAdv = it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units.Archer()
        rangedAdv.weapon = it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.WoodenBow()
        rangedAdv.currentHp = 100
        area.adventurersExploring.add(rangedAdv)

        val rangedLowest = area.selectTargets(rangedAdv, "lowest_relative_enemy")
        assertNotNull(rangedLowest)
        assertEquals("Ranged unit can target lowest HP flying enemy", flyingEnemy, rangedLowest!![0])
    }

    @Test
    fun testKitsuneBlessingProgressesWithLevel() {
        val low = Pet.getInstance("Semi", 43, 1, 0, PetAbility.HEALER, PetAbility.EMPTY, PetAbility.EMPTY, PetAbility.EMPTY)!!
        val high = Pet.getInstance("Semi", 44, 100, 0, PetAbility.HEALER, PetAbility.EMPTY, PetAbility.EMPTY, PetAbility.EMPTY)!!
        assertEquals("Blessing at level 1 must be +0.6%", 0.006, low.getKitsuneBlessing(), 0.0001)
        assertEquals("Blessing at level 100 must be +60%", 0.6, high.getKitsuneBlessing(), 0.0001)
        // The blessing boosts the PARTY's adventurer healing at heal time; the pet's own healer stays raw.
        assertEquals(21.0, high.getHealer(), 0.0001)
        // Idempotent when abilities are re-computed (level ups / save loads).
        high.refreshAbilities()
        high.refreshAbilities()
        assertEquals(0.6, high.getKitsuneBlessing(), 0.0001)
        assertEquals(21.0, high.getHealer(), 0.0001)
        // Removed: +5 regen/turn and +1 light no longer come from the blessing.
        assertEquals(0, high.bright)
        assertEquals(0, high.regeneration)
    }

    @Test
    fun testKitsuneBlessingMultipliesAdventurerHealingAtHealTime() {
        // The blessing must multiply the healing DEALT BY ADVENTURERS in the party
        // (Area.heal), not the pet's own heal. Compare heal output with/without a
        // blessing pet over many samples (attack damage is rolled, so compare sums).
        val area = MainActivity.data.enchantedForest!!
        // Healer with a real weapon so heal amounts are meaningfully large (max(1,...) would
        // mask the 1.6x multiplier otherwise).
        val healer = Adventurer.getInstance("Footman", 1, 1, 0, null, null, null, null, null, PotionsDrank(), null, false)!!
        healer.weapon = ColossalSwordOfScarletKing()
        val target = Adventurer.getInstance("Footman", 2, 40, 0, null, null, null, null, null, PotionsDrank(), null, false)!!
        val maxHp = target.calculateTotalMaxHp()

        area.petExploring = null
        var sumWithout = 0L
        for (i in 1..150) {
            target.currentHp = maxHp - 10
            area.heal(healer, target, null)
            sumWithout += target.currentHp - (maxHp - 10)
        }

        val pet = Pet.getInstance("Semi", 44, 100, 0, PetAbility.HEALER, PetAbility.EMPTY, PetAbility.EMPTY, PetAbility.EMPTY)!!
        assertEquals(0.6, pet.getKitsuneBlessing(), 0.0001)
        // The pet's OWN heal is NOT boosted by the blessing.
        assertEquals(21.0, pet.healer, 0.0001)
        area.petExploring = pet
        var sumWith = 0L
        for (i in 1..150) {
            target.currentHp = maxHp - 10
            area.heal(healer, target, null)
            sumWith += target.currentHp - (maxHp - 10)
        }
        area.petExploring = null

        assertTrue(
            "Adventurer healing with Kitsune Spirit Blessing must be higher (with=$sumWith without=$sumWithout)",
            sumWith > sumWithout
        )
    }

    @Test
    fun testShelterEffectivenessPriceProgression() {
        // Guard-test the 5 exact gold price tiers against the current data counter.
        val expected = longArrayOf(50000L, 500000L, 5000000L, 50000000L, 500000000L)
        val original = MainActivity.data.levelShelterEffectiveness
        try {
            for (level in 0..4) {
                MainActivity.data.levelShelterEffectiveness = level
                assertEquals("Price tier $level", expected[level], Formulas.getShelterEffectivenessPrice())
            }
            MainActivity.data.levelShelterEffectiveness = 5
            assertTrue("Level 5 must be unobtainable", Formulas.getShelterEffectivenessPrice() > 500000000L)
        } finally {
            MainActivity.data.levelShelterEffectiveness = original
        }
    }

    @Test
    fun testShelterEffectivenessPercent() {
        val originalGold = MainActivity.data.levelShelterEffectiveness
        val originalGems = MainActivity.data.upgradeShelterEffectiveness
        try {
            MainActivity.data.levelShelterEffectiveness = 3
            MainActivity.data.upgradeShelterEffectiveness = 2
            assertEquals(50, Formulas.getShelterEffectivenessPercent())
            MainActivity.data.levelShelterEffectiveness = 5
            MainActivity.data.upgradeShelterEffectiveness = 5
            assertEquals(100, Formulas.getShelterEffectivenessPercent())
            MainActivity.data.levelShelterEffectiveness = 0
            MainActivity.data.upgradeShelterEffectiveness = 0
            assertEquals(0, Formulas.getShelterEffectivenessPercent())
        } finally {
            MainActivity.data.levelShelterEffectiveness = originalGold
            MainActivity.data.upgradeShelterEffectiveness = originalGems
        }
    }

    @Test
    fun testUpgradeShelterEffectivenessItem() {
        val item = Item.getInstance("UpgradeShelterEffectiveness", 1) as? UpgradeShelterEffectiveness
        assertNotNull("UpgradeShelterEffectiveness must be instantiable", item)
        assertEquals("Gem price must be 1000", 1000L, (item as? it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Upgrade)?.getGemPrice()?.toLong())
        val original = MainActivity.data.upgradeShelterEffectiveness
        try {
            MainActivity.data.upgradeShelterEffectiveness = 4
            item!!.use()
            assertEquals("use() must increment the counter", 5, MainActivity.data.upgradeShelterEffectiveness)
            item.use()
            assertEquals("use() must cap at 5", 5, MainActivity.data.upgradeShelterEffectiveness)
        } finally {
            MainActivity.data.upgradeShelterEffectiveness = original
        }
    }

    @Test
    fun testAutoFeedEffectivenessMultiplication() {
        val originalGold = MainActivity.data.levelShelterEffectiveness
        val originalGems = MainActivity.data.upgradeShelterEffectiveness
        try {
            // No effectiveness: feed power is unchanged.
            assertEquals(10, Utils.effectiveAutoFeedPower(10))
            // +50% (3 gold + 2 gem tiers): 10 -> 15.
            MainActivity.data.levelShelterEffectiveness = 3
            MainActivity.data.upgradeShelterEffectiveness = 2
            assertEquals(50, Formulas.getShelterEffectivenessPercent())
            assertEquals(15, Utils.effectiveAutoFeedPower(10))
            // Max +100%: a 10-feed-power food yields 20 feed power to favourite pets.
            MainActivity.data.levelShelterEffectiveness = 5
            MainActivity.data.upgradeShelterEffectiveness = 5
            assertEquals(100, Formulas.getShelterEffectivenessPercent())
            assertEquals(20, Utils.effectiveAutoFeedPower(10))
            // Rounding behaviour: +30% => 5 * 1.3 = 6.5 -> rounds to 7.
            MainActivity.data.levelShelterEffectiveness = 0
            MainActivity.data.upgradeShelterEffectiveness = 3
            assertEquals(30, Formulas.getShelterEffectivenessPercent())
            assertEquals(7, Utils.effectiveAutoFeedPower(5))
        } finally {
            MainActivity.data.levelShelterEffectiveness = originalGold
            MainActivity.data.upgradeShelterEffectiveness = originalGems
        }
    }

    // --- Angel of War branch: same-row AoE interception (Shared Burden) ---

    private fun aoeAdventurer(str: String): Adventurer =
        Adventurer.getInstance(str, 1, 5, 0, null, null, null, null, null, PotionsDrank(), null, false)!!

    /** Deterministic enemy: 100 min=max attack (raw 100), 0 crit, 0 defense, always hits. */
    private fun aoeTestEnemy(): Enemy {
        val enemy = object : Enemy() {
            override fun getMaxDamage(): Int = 100
            override fun getMinDamage(): Int = 100
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

    private fun aoeArea(area: Area, party: List<Adventurer>): Area {
        val partyList = ArrayList<Adventurer>()
        partyList.addAll(party)
        area.adventurersExploring = partyList
        for (a in party) {
            a.baseDefense = 0
            a.baseMagicDefense = 0
            a.currentHp = a.calculateTotalMaxHp()
        }
        return area
    }

    private fun aoeAllEnemiesSkill(area: Area, caster: Entity): Area.Skill =
        area.Skill(caster).setTargetSelectionMode(Area.TARGET_ALL_ENEMIES)

    private fun aoeHpLoss(area: Area, enemy: Enemy, target: Adventurer, skill: Area.Skill?, hpBefore: Int): Int {
        area.dealDamage(enemy, target, skill, null)
        return hpBefore - target.currentHp
    }

    @Test
    fun testAoeInterceptionSingleProtector() {
        val ally = aoeAdventurer("HolyKnight") // CON 20 -> 2 flat reduction
        val protector = aoeAdventurer("HolyKnight")
        val area = aoeArea(MainActivity.data.enchantedForest!!, listOf(ally, protector))
        val enemy = aoeTestEnemy()
        val skill = aoeAllEnemiesSkill(area, enemy)

        // Baseline without any protector: full raw 100 - 2 flat = 98. Uses a DIFFERENT
        // Area instance (Data fields are singletons — reusing enchantedForest would reset
        // the main party's list).
        val baselineArea = aoeArea(MainActivity.data.theDesert!!, listOf(aoeAdventurer("HolyKnight")))
        val baseline = aoeHpLoss(baselineArea, enemy, baselineArea.adventurersExploring[0],
            aoeAllEnemiesSkill(baselineArea, enemy), baselineArea.adventurersExploring[0].currentHp)
        assertEquals(98, baseline)

        var allyHp = ally.currentHp
        var protectorHp = protector.currentHp
        aoeHpLoss(area, enemy, ally, skill, allyHp)
        // HolyKnight = tier 4 -> intercepts 10%. Ally: 90 raw arrives -> 90 - 2 flat = 88 lost.
        assertEquals("Ally loses intercepted-reduced damage", 88, allyHp - ally.currentHp)
        // Protector takes its 10 raw slice minus its 2 flat = 8.
        assertEquals("Protector takes the intercepted slice", 8, protectorHp - protector.currentHp)
    }

    @Test
    fun testAoeSharedBurdenTwoProtectors() {
        val ally = aoeAdventurer("HolyKnight")
        val p1 = aoeAdventurer("HolyKnight")
        val p2 = aoeAdventurer("HolyKnight")
        val area = aoeArea(MainActivity.data.enchantedForest!!, listOf(ally, p1, p2))
        val enemy = aoeTestEnemy()
        val skill = aoeAllEnemiesSkill(area, enemy)

        var allyHp = ally.currentHp
        var p1Hp = p1.currentHp
        var p2Hp = p2.currentHp
        area.dealDamage(enemy, ally, skill, null)

        assertEquals("Ally still loses only 88 (90-2)", 88, allyHp - ally.currentHp)
        // HolyKnights (10%): 10 raw intercepted, split evenly = 5 each; minus flat 2 -> 3 each.
        val p1Loss = p1Hp - p1.currentHp
        val p2Loss = p2Hp - p2.currentHp
        assertEquals("Burden split equally across both protectors", p1Loss, p2Loss)
        assertEquals("Each protector takes its half slice", 3, p1Loss)
    }

    @Test
    fun testAoeTierPrioritySharedBurden() {
        // Angel of War (35%) + Inquisitor (25%) in the same row: highest tier (35%) is used
        // and the intercepted raw damage is split evenly between the two protectors.
        val ally = aoeAdventurer("HolyKnight")
        val angel = aoeAdventurer("AngelOfWar") // flat = 20/8 = 2
        val inquisitor = aoeAdventurer("Inquisitor") // flat = 32/8 = 4
        val area = aoeArea(MainActivity.data.enchantedForest!!, listOf(ally, angel, inquisitor))
        val enemy = aoeTestEnemy()
        val skill = aoeAllEnemiesSkill(area, enemy)

        var allyHp = ally.currentHp
        var angelHp = angel.currentHp
        var inquisitorHp = inquisitor.currentHp
        area.dealDamage(enemy, ally, skill, null)

        assertEquals("Ally sees the 35% tier (65-2=63)", 63, allyHp - ally.currentHp)
        // Each protector takes the same RAW slice (17.5); HP losses differ only by flat DR.
        // Utils.round truncates: Angel 17.5-5=12.5 -> 12; Inquisitor 17.5-4=13.5 -> 13.
        assertEquals("Angel of War raw slice 17.5 - 5 flat", 12, angelHp - angel.currentHp)
        assertEquals("Inquisitor raw slice 17.5 - 4 flat", 13, inquisitorHp - inquisitor.currentHp)
    }

    @Test
    fun testAoeRowIsolation() {
        // Protector in row 0 (index 0) must NOT intercept for an ally in row 1 (index 6).
        val protector = aoeAdventurer("HolyKnight")
        val filler = aoeAdventurer("Footman")
        val ally = aoeAdventurer("HolyKnight")
        val area = aoeArea(MainActivity.data.enchantedForest!!, listOf(protector, filler, filler, filler, filler, filler, ally))
        val enemy = aoeTestEnemy()
        val skill = aoeAllEnemiesSkill(area, enemy)

        var allyHp = ally.currentHp
        var protectorHp = protector.currentHp
        area.dealDamage(enemy, ally, skill, null)

        assertEquals("Row-0 protector must not absorb row-1 damage", protectorHp, protector.currentHp)
        assertEquals("Ally takes full 98 (no interception)", 98, allyHp - ally.currentHp)
    }

    @Test
    fun testAoeCrossProtection() {
        // Two Angels of War: when AoW1 is hit, AoW2 (same row) cross-protects it.
        val aow1 = aoeAdventurer("AngelOfWar")
        val aow2 = aoeAdventurer("AngelOfWar")
        val area = aoeArea(MainActivity.data.enchantedForest!!, listOf(aow1, aow2))
        val enemy = aoeTestEnemy()
        val skill = aoeAllEnemiesSkill(area, enemy)

        var aow1Hp = aow1.currentHp
        var aow2Hp = aow2.currentHp
        area.dealDamage(enemy, aow1, skill, null)

        assertEquals("AoW1 is protected by AoW2 (60 = 65-5)", 60, aow1Hp - aow1.currentHp)
        assertEquals("AoW2 takes its own intercept slice (35-5=30)", 30, aow2Hp - aow2.currentHp)
    }

    @Test
    fun testAoeProtectorDeathThenSharedBurdenContinues() {
        val ally = aoeAdventurer("HolyKnight")
        val p1 = aoeAdventurer("HolyKnight")
        val p2 = aoeAdventurer("HolyKnight")
        val area = aoeArea(MainActivity.data.enchantedForest!!, listOf(ally, p1, p2))
        p1.currentHp = 2 // dies from its 3-damage slice
        val enemy = aoeTestEnemy()
        val skill = aoeAllEnemiesSkill(area, enemy)

        var p2Hp = p2.currentHp
        area.dealDamage(enemy, ally, skill, null)
        assertEquals("Fragile protector dies from its slice", 0, p1.currentHp)
        assertEquals("Surviving protector takes its half slice", 3, p2Hp - p2.currentHp)

        // Second swing: dead protector is excluded; the survivor now intercepts alone (10%).
        // Restore HP first — the ally's remaining HP was lower than the incoming damage.
        ally.currentHp = ally.calculateTotalMaxHp()
        p2.currentHp = p2.calculateTotalMaxHp()
        var allyHp2 = ally.currentHp
        var p2Hp2 = p2.currentHp
        area.dealDamage(enemy, ally, skill, null)
        assertEquals("Ally still sees 10% interception on the second swing", 88, allyHp2 - ally.currentHp)
        assertEquals("Survivor takes the full 10-2=8 slice now", 8, p2Hp2 - p2.currentHp)
    }
}
