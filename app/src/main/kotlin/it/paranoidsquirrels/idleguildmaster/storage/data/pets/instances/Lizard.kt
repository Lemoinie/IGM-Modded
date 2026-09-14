package it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Reptile

class Lizard : Reptile() {
    override fun configureStatistics() {
        idImage = R.drawable.pet_lizard
        idName = R.string.pet_lizard_name
        idDescription = R.string.pet_lizard_description
        abilityNumber = 2
    }
}
