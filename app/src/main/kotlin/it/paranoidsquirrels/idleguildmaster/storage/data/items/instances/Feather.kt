package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class Feather : Item() {
    override fun configureProperties() {
        idName = R.string.item_feather_name
        idDescription = R.string.item_feather_description
        idImage = R.drawable.feather
        source.add(R.string.dungeon_name_the_desert)
        price = 2L
    }
}
