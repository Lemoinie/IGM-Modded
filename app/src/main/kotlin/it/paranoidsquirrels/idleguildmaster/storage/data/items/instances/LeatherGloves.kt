package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class LeatherGloves : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_leather_gloves_name
        idDescription = R.string.accessory_leather_gloves_description
        idImage = R.drawable.leather_gloves
        price = 41L
        dexterity = 2
        constitution = 2
    }
}
