package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class AncientHide : Item() {
    override fun configureProperties() {
        idName = R.string.item_ancient_hide_name
        idDescription = R.string.item_ancient_hide_description
        idImage = R.drawable.ancient_hide
        source.add(R.string.dungeon_name_lost_lands)
        price = 2L
    }
}
