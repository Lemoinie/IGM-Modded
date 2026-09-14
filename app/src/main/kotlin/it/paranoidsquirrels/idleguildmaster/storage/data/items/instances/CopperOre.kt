package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class CopperOre : Item() {
    override fun configureProperties() {
        idName = R.string.item_copper_ore_name
        idDescription = R.string.item_copper_ore_description
        idImage = R.drawable.copper_ore
        source.add(R.string.dungeon_name_enchanted_forest)
        price = 1L
    }
}
