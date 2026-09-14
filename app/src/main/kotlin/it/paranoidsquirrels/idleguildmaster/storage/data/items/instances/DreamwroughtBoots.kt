package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class DreamwroughtBoots : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_dreamwrought_boots_name
        idDescription = R.string.accessory_dreamwrought_boots_description
        idImage = R.drawable.dreamwrought_boots
        price = 789L
        dexterity = 42
    }
}
