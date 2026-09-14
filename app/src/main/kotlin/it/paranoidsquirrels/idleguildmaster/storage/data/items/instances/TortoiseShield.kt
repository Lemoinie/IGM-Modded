package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class TortoiseShield : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_tortoise_shield_name
        idDescription = R.string.accessory_tortoise_shield_description
        idImage = R.drawable.tortoise_shield
        price = 240L
        constitution = 24
    }
}
