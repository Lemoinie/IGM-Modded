package it.paranoidsquirrels.idleguildmaster

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.Data
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionsDrank
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.MythicEgg
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.PetAbility
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Mythic
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances.Kitsune
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances.Phoenix
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.EnchantedForest
import java.util.concurrent.CopyOnWriteArrayList
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class PhoenixAndKitsuneTest {

    @Before
    fun setUp() {
        MainActivity.data = Data()
    }

    private val MYTHIC_POOL = listOf(PetAbility.EXPERIENCE, PetAbility.DROPS, PetAbility.OPPORTUNIST, PetAbility.SAVAGE)

    @Test
    fun testMythicPetsInheritMythicType() {
        val phoenix = Pet.getInstance("Phoenix", 100)!!
        val kitsune = Pet.getInstance("Kitsune", 101)!!
        assertTrue("Phoenix must be a Mythic pet", phoenix is Mythic)
        assertTrue("Phoenix must be a Phoenix", phoenix is Phoenix)
        assertTrue("Kitsune must be a Mythic pet", kitsune is Mythic)
        assertTrue("Kitsune must be a Kitsune", kitsune is Kitsune)
        assertEquals("Phoenix display name id", R.string.pet_phoenix_name, phoenix.idName)
        assertEquals("Kitsune display name id", R.string.pet_kitsune_name, kitsune.idName)
        assertEquals(R.drawable.pet_phoenix, phoenix.idImage)
        assertEquals(R.drawable.pet_kitsune, kitsune.idImage)
    }

    @Test
    fun testLegacyNamesResolveToKitsune() {
        for (name in listOf("Semi", "Senko", "Kitsune")) {
            val pet = Pet.getInstance(name, 200)!!
            assertTrue("'$name' must resolve to a Kitsune", pet is Kitsune)
            assertEquals("trueClass must be Kitsune", "Kitsune", pet.trueClass)
            assertEquals("Display name must be Senko", R.string.pet_kitsune_name, pet.idName)
        }
    }

    @Test
    fun testMythicTraitPoolIsRestrictedWithoutRepeats() {
        for (i in 1..30) {
            val phoenix = Pet.getInstance("Phoenix", 300 + i)!!
            val abilities = listOf(phoenix.petAbility1, phoenix.petAbility2, phoenix.petAbility3, phoenix.petAbility4)
            for (a in abilities) {
                assertTrue("Mythic trait must come from the pool (was $a)", a in MYTHIC_POOL)
            }
            assertEquals("Mythic traits must not repeat", 4, abilities.distinct().size)
        }
    }

    @Test
    fun testSolarRebirthScalesWithLevel() {
        val lvl1 = Pet.getInstance("Phoenix", 400, 1, 0, PetAbility.EMPTY, PetAbility.EMPTY, PetAbility.EMPTY, PetAbility.EMPTY)!! as Phoenix
        val lvl50 = Pet.getInstance("Phoenix", 401, 50, 0, PetAbility.EMPTY, PetAbility.EMPTY, PetAbility.EMPTY, PetAbility.EMPTY)!! as Phoenix
        val lvl100 = Pet.getInstance("Phoenix", 402, 100, 0, PetAbility.EMPTY, PetAbility.EMPTY, PetAbility.EMPTY, PetAbility.EMPTY)!! as Phoenix
        val lvl150 = Pet.getInstance("Phoenix", 403, 150, 0, PetAbility.EMPTY, PetAbility.EMPTY, PetAbility.EMPTY, PetAbility.EMPTY)!! as Phoenix
        assertEquals("Lv1: 1 target", 1, lvl1.getSolarRebirthTargetCount())
        assertEquals("Lv50: 2 targets", 2, lvl50.getSolarRebirthTargetCount())
        assertEquals("Lv100: 3 targets", 3, lvl100.getSolarRebirthTargetCount())
        assertEquals("Lv150: 4 targets", 4, lvl150.getSolarRebirthTargetCount())
        assertEquals("0.15% per level at Lv100", 0.15, lvl100.getSolarRebirthChance(), 0.0001)
    }

    @Test
    fun testMythicEggHatchesFiftyFifty() {
        var phoenixes = 0
        var kitsunes = 0
        for (i in 1..1000) {
            val hatched = MythicEgg().hatch()!!
            if (hatched is Phoenix) phoenixes++ else if (hatched is Kitsune) kitsunes++
        }
        assertEquals(1000, phoenixes + kitsunes)
        assertTrue("Phoenix share ~50% (was $phoenixes)", phoenixes > 400 && phoenixes < 600)
        assertTrue("Kitsune share ~50% (was $kitsunes)", kitsunes > 400 && kitsunes < 600)
    }

    @Test
    fun testSolarRebirthInterceptsLethalDamage() {
        val forest = EnchantedForest()
        val phoenix = Pet.getInstance("Phoenix", 77)!!
        forest.petExploring = phoenix
        val hero = Adventurer.getInstance("Footman", 1, 20, 0, null, null, null, null, null, PotionsDrank(), null, false)!!
        val wolf = Enemy.getInstance("Wolf")!!
        wolf.currentHp = wolf.calculateTotalMaxHp()
        wolf.alwaysHits = true
        forest.enemies = CopyOnWriteArrayList(listOf(wolf))
        forest.acting = wolf
        forest.adventurersExploring = CopyOnWriteArrayList(listOf(hero))
        hero.currentHp = 1
        hero.positiveStatusEffects.add(StatusEffect(StatusEffectType.SOLAR_REBIRTH, null, 1, 1.0))
        forest.dealDamage(wolf, hero, null, null)
        assertEquals("Solar Rebirth must save the ally at 1 HP", 1, hero.currentHp)
        assertFalse("Solar Rebirth must be consumed", hero.positiveStatusEffects.any { it.type == StatusEffectType.SOLAR_REBIRTH })
    }
}