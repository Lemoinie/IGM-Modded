package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class FrostmetalOre : Item() {
    override fun configureProperties() {
        idName = R.string.item_frostmetal_ore_name
        idDescription = R.string.item_frostmetal_ore_description
        idImage = R.drawable.frostmetal_ore
        source.add(R.string.dungeon_name_frostbite_peaks)
        price = 4L
    }
}
