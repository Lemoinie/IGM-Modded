package it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Wild

class Rat : Wild() {
    override fun configureStatistics() {
        idImage = R.drawable.pet_rat
        idName = R.string.pet_rat_name
        idDescription = R.string.pet_rat_description
        abilityNumber = 2
    }
}
