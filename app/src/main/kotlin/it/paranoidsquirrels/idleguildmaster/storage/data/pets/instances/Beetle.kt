package it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Insect

class Beetle : Insect() {
    override fun configureStatistics() {
        idImage = R.drawable.pet_beetle
        idName = R.string.pet_beetle_name
        idDescription = R.string.pet_beetle_description
        abilityNumber = 3
    }
}
