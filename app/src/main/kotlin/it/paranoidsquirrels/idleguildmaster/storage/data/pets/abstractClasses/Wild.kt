package it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.PetAbility
import java.util.Arrays

abstract class Wild : Pet() {
    override fun guaranteedFirstAbility(): List<PetAbility> = Arrays.asList(PetAbility.LIFESTEAL, PetAbility.COUNTERATTACK)
    override fun printPetType(): Int = R.string.pet_type_wild
}
