package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class WinterBoots : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_winter_boots_name
        idDescription = R.string.accessory_winter_boots_description
        idEffect = R.string.accessory_winter_boots_effect
        idImage = R.drawable.winter_boots
        price = 204L
        dexterity = 18
        regeneration = 4
    }
}
