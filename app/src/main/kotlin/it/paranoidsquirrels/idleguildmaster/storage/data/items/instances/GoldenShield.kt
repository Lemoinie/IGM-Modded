package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class GoldenShield : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_golden_shield_name
        idDescription = R.string.accessory_golden_shield_description
        idImage = R.drawable.golden_shield
        price = 414L
        constitution = 12
    }
}
