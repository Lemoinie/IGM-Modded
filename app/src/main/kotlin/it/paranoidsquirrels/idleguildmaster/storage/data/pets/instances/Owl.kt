package it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Avian

class Owl : Avian() {
    override fun configureStatistics() {
        idImage = R.drawable.pet_owl
        idName = R.string.pet_owl_name
        idDescription = R.string.pet_owl_description
        abilityNumber = 3
    }
}
