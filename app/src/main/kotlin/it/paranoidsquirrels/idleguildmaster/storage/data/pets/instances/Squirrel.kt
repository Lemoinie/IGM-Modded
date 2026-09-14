package it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Wild

class Squirrel : Wild() {
    override fun configureStatistics() {
        idImage = R.drawable.pet_squirrel
        idName = R.string.pet_squirrel_name
        idDescription = R.string.pet_squirrel_description
        abilityNumber = 3
    }
}
