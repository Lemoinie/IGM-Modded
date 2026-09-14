package it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Avian

class Eagle : Avian() {
    override fun configureStatistics() {
        idImage = R.drawable.pet_eagle
        idName = R.string.pet_eagle_name
        idDescription = R.string.pet_eagle_description
        abilityNumber = 4
    }
}
