package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class BatWing : Item() {
    override fun configureProperties() {
        idName = R.string.item_bat_wing_name
        idDescription = R.string.item_bat_wing_description
        idImage = R.drawable.bat_wing
        source.add(R.string.dungeon_name_obsidian_mines)
        price = 3L
    }
}
