package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class GhostwoodStump : Item() {
    override fun configureProperties() {
        idName = R.string.item_ghostwood_stump_name
        idDescription = R.string.item_ghostwood_stump_description
        idImage = R.drawable.ghostwood_stump
        source.add(R.string.dungeon_name_blackwater_port)
        price = 2L
    }
}
