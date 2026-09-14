package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class DreamwroughtGloves : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_dreamwrought_gloves_name
        idDescription = R.string.accessory_dreamwrought_gloves_description
        idImage = R.drawable.dreamwrought_gloves
        price = 884L
        constitution = 34
        dexterity = 28
    }
}
