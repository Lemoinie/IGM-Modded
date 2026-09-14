package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class BlackIronScraps : Item() {
    override fun configureProperties() {
        idName = R.string.item_black_iron_scraps_name
        idDescription = R.string.item_black_iron_scraps_description
        idImage = R.drawable.black_iron_scraps
        source.add(R.string.dungeon_name_blackwater_port)
        price = 3L
    }
}
