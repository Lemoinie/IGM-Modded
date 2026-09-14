package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class Sandstone : Item() {
    override fun configureProperties() {
        idName = R.string.item_sandstone_name
        idDescription = R.string.item_sandstone_description
        idImage = R.drawable.sandstone
        source.add(R.string.dungeon_name_the_desert)
        price = 1L
    }
}
