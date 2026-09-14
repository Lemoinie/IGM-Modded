package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class WurmscalesBoots : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_wurmscales_boots_name
        idDescription = R.string.accessory_wurmscales_boots_description
        idImage = R.drawable.wurmscales_boots
        price = 30L
        dexterity = 6
    }
}
