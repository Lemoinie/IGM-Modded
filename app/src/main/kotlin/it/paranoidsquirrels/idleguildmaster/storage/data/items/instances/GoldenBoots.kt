package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class GoldenBoots : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_golden_boots_name
        idDescription = R.string.accessory_golden_boots_description
        idImage = R.drawable.golden_boots
        price = 312L
        dexterity = 12
    }
}
