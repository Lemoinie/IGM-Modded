package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class Wood : Item() {
    override fun configureProperties() {
        idName = R.string.item_wood_name
        idDescription = R.string.item_wood_description
        idImage = R.drawable.wood
        source.add(R.string.dungeon_name_enchanted_forest)
        price = 1L
    }
}
