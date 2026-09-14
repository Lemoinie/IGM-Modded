package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class Cloth : Item() {
    override fun configureProperties() {
        idName = R.string.item_cloth_name
        idDescription = R.string.item_cloth_description
        idImage = R.drawable.cloth
        source.add(R.string.dungeon_name_enchanted_forest)
        price = 12L
    }
}
