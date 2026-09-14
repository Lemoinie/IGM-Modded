package it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Wild

class RedWolf : Wild() {
    override fun configureStatistics() {
        idImage = R.drawable.pet_red_wolf
        idName = R.string.pet_red_wolf_name
        idDescription = R.string.pet_red_wolf_description
        abilityNumber = 4
    }
}
