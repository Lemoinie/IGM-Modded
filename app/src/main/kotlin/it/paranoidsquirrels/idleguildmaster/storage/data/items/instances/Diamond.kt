package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class Diamond : Item() {
    override fun configureProperties() {
        idName = R.string.item_diamond_name
        idDescription = R.string.item_diamond_description
        idImage = R.drawable.diamond
        source.add(R.string.dungeon_name_lost_lands)
        price = 5000L
    }
}
