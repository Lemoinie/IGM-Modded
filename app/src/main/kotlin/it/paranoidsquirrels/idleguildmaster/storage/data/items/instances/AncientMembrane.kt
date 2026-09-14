package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class AncientMembrane : Item() {
    override fun configureProperties() {
        idName = R.string.item_ancient_membrane_name
        idDescription = R.string.item_ancient_membrane_description
        idImage = R.drawable.ancient_membrane
        source.add(R.string.dungeon_name_lost_lands)
        price = 2L
    }
}
