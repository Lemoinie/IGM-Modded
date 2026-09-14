package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class ExoticBoots : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_exotic_boots_name
        idDescription = R.string.accessory_exotic_boots_description
        idImage = R.drawable.exotic_boots
        price = 396L
        dexterity = 15
    }
}
