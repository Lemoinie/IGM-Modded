package it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.PetAbility
import java.util.Arrays

/**
 * Mythic pets (Phoenix / Kitsune) draw their traits from a fixed 4-trait pool
 * (EXPERIENCE, DROPS, OPPORTUNIST, SAVAGE) that is rolled without repeats.
 */
abstract class Mythic : Pet() {
    override fun guaranteedFirstAbility(): List<PetAbility> =
        Arrays.asList(PetAbility.EXPERIENCE, PetAbility.DROPS, PetAbility.OPPORTUNIST, PetAbility.SAVAGE)

    override fun printPetType(): Int = R.string.pet_type_mythic

    /** Rolls the next trait from the Mythic pool, excluding traits already picked. */
    override fun rollAbility(exclude: List<PetAbility>): PetAbility {
        val pool = guaranteedFirstAbility().filter { it !in exclude }
        if (pool.isEmpty()) return PetAbility.EMPTY
        return pool[(Utils.random() * pool.size.toDouble()).toInt()]
    }
}