package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class Mithril : Item() {
    override fun configureProperties() {
        idName = R.string.item_mithril_name
        idDescription = R.string.item_mithril_description
        idImage = R.drawable.mithril
        source.add(R.string.dungeon_name_lost_lands)
        price = 4L
    }
}
