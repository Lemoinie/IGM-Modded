package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class BatTooth : Item() {
    override fun configureProperties() {
        idName = R.string.item_bat_tooth_name
        idDescription = R.string.item_bat_tooth_description
        idImage = R.drawable.bat_tooth
        source.add(R.string.dungeon_name_obsidian_mines)
        price = 2L
    }
}
