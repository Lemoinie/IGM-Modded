package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class GhostwoodBoard : Item() {
    override fun configureProperties() {
        idName = R.string.item_ghostwoood_board_name
        idDescription = R.string.item_ghostwoood_board_description
        idImage = R.drawable.ghostwood_board
        source.add(R.string.dungeon_name_blackwater_port)
        price = 9L
    }
}
