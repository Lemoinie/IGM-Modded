package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class WurmscalesShield : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_wurmscales_shield_name
        idDescription = R.string.accessory_wurmscales_shield_description
        idImage = R.drawable.wurmscales_shield
        price = 35L
        constitution = 6
    }
}
