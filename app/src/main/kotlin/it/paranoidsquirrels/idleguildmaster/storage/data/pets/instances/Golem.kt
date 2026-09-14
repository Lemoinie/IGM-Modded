package it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Construct

class Golem : Construct() {
    override fun configureStatistics() {
        idImage = R.drawable.pet_golem
        idName = R.string.pet_golem_name
        idDescription = R.string.pet_golem_description
        abilityNumber = 3
    }
}
