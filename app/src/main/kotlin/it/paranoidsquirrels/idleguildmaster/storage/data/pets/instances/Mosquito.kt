package it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Insect

class Mosquito : Insect() {
    override fun configureStatistics() {
        idImage = R.drawable.pet_mosquito
        idName = R.string.pet_mosquito_name
        idDescription = R.string.pet_mosquito_description
        abilityNumber = 2
    }
}
