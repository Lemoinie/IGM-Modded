package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class AncientBoots : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_ancient_boots_name
        idDescription = R.string.accessory_ancient_boots_description
        idImage = R.drawable.ancient_boots
        price = 465L
        dexterity = 33
    }
}
