package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class WinterGloves : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_winter_gloves_name
        idDescription = R.string.accessory_winter_gloves_description
        idEffect = R.string.accessory_winter_gloves_effect
        idImage = R.drawable.winter_gloves
        price = 264L
        constitution = 16
        dexterity = 13
        regeneration = 4
    }
}
