package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class Glass : Item() {
    override fun configureProperties() {
        idName = R.string.item_glass_name
        idDescription = R.string.item_glass_description
        idImage = R.drawable.glass
        price = 8L
    }
}
