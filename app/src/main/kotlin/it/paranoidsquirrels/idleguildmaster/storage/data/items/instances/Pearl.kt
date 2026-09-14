package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class Pearl : Item() {
    override fun configureProperties() {
        idName = R.string.item_pearl_name
        idDescription = R.string.item_pearl_description
        idImage = R.drawable.pearl
        source.add(R.string.dungeon_name_blackwater_port)
        price = 100L
    }
}
