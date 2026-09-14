package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class VerdantBoots : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_verdant_boots_name
        idDescription = R.string.accessory_verdant_boots_description
        idImage = R.drawable.verdant_boots
        price = 477L
        dexterity = 24
    }
}
