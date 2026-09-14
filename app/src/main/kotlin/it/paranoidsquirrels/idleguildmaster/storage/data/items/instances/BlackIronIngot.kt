package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class BlackIronIngot : Item() {
    override fun configureProperties() {
        idName = R.string.item_black_iron_ingot_name
        idDescription = R.string.item_black_iron_ingot_description
        idImage = R.drawable.black_iron_ingot
        price = 14L
    }
}
