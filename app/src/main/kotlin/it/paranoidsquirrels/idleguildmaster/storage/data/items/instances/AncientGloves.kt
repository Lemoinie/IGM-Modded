package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class AncientGloves : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_ancient_gloves_name
        idDescription = R.string.accessory_ancient_gloves_description
        idImage = R.drawable.ancient_gloves
        price = 468L
        constitution = 27
        dexterity = 22
    }
}
