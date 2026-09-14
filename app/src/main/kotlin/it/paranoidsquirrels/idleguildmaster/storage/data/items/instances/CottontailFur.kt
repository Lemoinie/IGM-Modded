package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class CottontailFur : Item() {
    override fun configureProperties() {
        idName = R.string.item_cottontail_fur_name
        idDescription = R.string.item_cottontail_fur_description
        idImage = R.drawable.cottontail_fur
        source.add(R.string.dungeon_name_enchanted_forest)
        price = 50L
    }
}
