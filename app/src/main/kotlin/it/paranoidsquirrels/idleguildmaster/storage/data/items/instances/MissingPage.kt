package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class MissingPage : Item() {
    override fun configureProperties() {
        idName = R.string.item_missing_page_name
        idDescription = R.string.item_missing_page_description
        idImage = R.drawable.missing_page
        source.add(R.string.dungeon_name_blackwater_port)
        price = 5L
    }
}
