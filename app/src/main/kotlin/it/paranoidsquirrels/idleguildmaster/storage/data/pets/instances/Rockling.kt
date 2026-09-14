package it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Construct

class Rockling : Construct() {
    override fun configureStatistics() {
        idImage = R.drawable.pet_rockling
        idName = R.string.pet_rockling_name
        idDescription = R.string.pet_rockling_description
        abilityNumber = 2
    }
}
