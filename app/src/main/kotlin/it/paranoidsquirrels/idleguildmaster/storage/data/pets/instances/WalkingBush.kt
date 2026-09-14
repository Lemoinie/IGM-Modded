package it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Wooden

class WalkingBush : Wooden() {
    override fun configureStatistics() {
        idImage = R.drawable.pet_walking_bush
        idName = R.string.pet_walking_bush_name
        idDescription = R.string.pet_walking_bush_description
        abilityNumber = 3
    }
}
