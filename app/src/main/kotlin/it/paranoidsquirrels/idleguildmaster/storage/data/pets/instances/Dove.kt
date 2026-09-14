package it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Avian

class Dove : Avian() {
    override fun configureStatistics() {
        idImage = R.drawable.pet_dove
        idName = R.string.pet_dove_name
        idDescription = R.string.pet_dove_description
        abilityNumber = 2
    }
}
