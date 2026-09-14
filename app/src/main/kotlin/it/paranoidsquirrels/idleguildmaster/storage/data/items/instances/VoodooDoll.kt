package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class VoodooDoll : Item() {
    override fun configureProperties() {
        idName = R.string.item_voodoo_doll_name
        idDescription = R.string.item_voodoo_doll_description
        idImage = R.drawable.voodoo_doll
        source.add(R.string.dungeon_name_obsidian_mines)
        price = 84L
    }
}
