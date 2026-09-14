package it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Esoteric

class ThingFromTheAbyss : Esoteric() {
    override fun configureStatistics() {
        idImage = R.drawable.pet_thing_from_the_abyss
        idName = R.string.pet_thing_from_the_abyss_name
        idDescription = R.string.pet_thing_from_the_abyss_description
        abilityNumber = 4
    }
}
