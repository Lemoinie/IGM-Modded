package it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Reptile

class Crocodile : Reptile() {
    override fun configureStatistics() {
        idImage = R.drawable.pet_crocodile
        idName = R.string.pet_crocodile_name
        idDescription = R.string.pet_crocodile_description
        abilityNumber = 4
    }
}
