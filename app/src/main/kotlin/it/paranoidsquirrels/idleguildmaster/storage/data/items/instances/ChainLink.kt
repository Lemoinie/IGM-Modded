package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class ChainLink : Item() {
    override fun configureProperties() {
        idName = R.string.item_chain_link_name
        idDescription = R.string.item_chain_link_description
        idImage = R.drawable.chain_link
        source.add(R.string.dungeon_name_barren_wastelands)
        price = 9L
    }
}
