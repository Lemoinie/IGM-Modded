package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class CopperIngot : Item() {
    override fun configureProperties() {
        idName = R.string.item_copper_ingot_name
        idDescription = R.string.item_copper_ingot_description
        idImage = R.drawable.copper_ingot
        price = 5L
    }
}
