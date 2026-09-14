package it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Wooden

class FloatingSeed : Wooden() {
    override fun configureStatistics() {
        idImage = R.drawable.pet_floating_seed
        idName = R.string.pet_floating_seed_name
        idDescription = R.string.pet_floating_seed_description
        abilityNumber = 2
    }
}
