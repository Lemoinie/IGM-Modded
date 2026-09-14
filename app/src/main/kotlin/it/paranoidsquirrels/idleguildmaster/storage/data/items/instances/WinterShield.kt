package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class WinterShield : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_winter_shield_name
        idDescription = R.string.accessory_winter_shield_description
        idImage = R.drawable.winter_shield
        price = 261L
        constitution = 18
    }
}
