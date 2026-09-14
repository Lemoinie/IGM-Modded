package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class WurmscalesGloves : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_wurmscales_gloves_name
        idDescription = R.string.accessory_wurmscales_gloves_description
        idImage = R.drawable.wurmscales_gloves
        price = 36L
        constitution = 4
        dexterity = 4
    }
}
