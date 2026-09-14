package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class VerdantGloves : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_verdant_gloves_name
        idDescription = R.string.accessory_verdant_gloves_description
        idImage = R.drawable.verdant_gloves
        price = 498L
        constitution = 20
        dexterity = 16
    }
}
