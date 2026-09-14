package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class BurningEffigy : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_burning_effigy_name
        idDescription = R.string.accessory_burning_effigy_description
        idEffect = R.string.accessory_burning_effigy_effect
        idImage = R.drawable.burning_effigy
        price = 43598L
        constitution = 34
        defense = 9
        magicDefense = 9
        threat = 3
    }
}
