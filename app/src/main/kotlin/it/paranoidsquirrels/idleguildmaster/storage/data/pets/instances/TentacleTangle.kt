package it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Esoteric

class TentacleTangle : Esoteric() {
    override fun configureStatistics() {
        idImage = R.drawable.pet_tentacle_tangle
        idName = R.string.pet_tentacle_tangle_name
        idDescription = R.string.pet_tentacle_tangle_description
        abilityNumber = 3
    }
}
