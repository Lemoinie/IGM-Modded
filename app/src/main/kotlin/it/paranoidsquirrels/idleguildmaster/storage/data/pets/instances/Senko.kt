package it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.PetAbility
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Wild

class Senko : Wild() {
    init {
        trueClass = "Senko"
    }
    override fun configureStatistics() {
        idImage = R.drawable.pet_senko
        idName = R.string.pet_senko_name
        idDescription = R.string.pet_senko_description
        abilityNumber = 5
    }

    override fun guaranteedFirstAbility(): List<PetAbility> {
        return listOf(PetAbility.SAVAGE, PetAbility.REGENERATION, PetAbility.DROPS, PetAbility.EXPERIENCE)
    }
}
