package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class MysteriousAppendage : Item() {
    override fun configureProperties() {
        idName = R.string.item_mysterious_appendage_name
        idDescription = R.string.item_mysterious_appendage_description
        idImage = R.drawable.mysterious_appendage
        source.add(R.string.dungeon_name_blackwater_port)
        price = 15L
    }
}
