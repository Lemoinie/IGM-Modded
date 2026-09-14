package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class Starvation : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_starvation_name
        idDescription = R.string.accessory_starvation_description
        idEffect = R.string.accessory_starvation_effect
        idImage = R.drawable.starvation
        price = 31500L
        intelligence = 5
        lifesteal = 75
    }
}
