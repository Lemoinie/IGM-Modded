package it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Insect

class Tarantula : Insect() {
    override fun configureStatistics() {
        idImage = R.drawable.pet_tarantula
        idName = R.string.pet_tarantula_name
        idDescription = R.string.pet_tarantula_description
        abilityNumber = 4
    }
}
