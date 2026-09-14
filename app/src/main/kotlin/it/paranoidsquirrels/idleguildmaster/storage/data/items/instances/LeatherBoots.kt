package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class LeatherBoots : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_leather_boots_name
        idDescription = R.string.accessory_leather_boots_description
        idImage = R.drawable.leather_boots
        price = 27L
        dexterity = 3
    }
}
