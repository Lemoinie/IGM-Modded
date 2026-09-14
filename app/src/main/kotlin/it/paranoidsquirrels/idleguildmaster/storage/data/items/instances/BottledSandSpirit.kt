package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class BottledSandSpirit : Item() {
    override fun configureProperties() {
        idName = R.string.item_bottled_sand_spirit_name
        idDescription = R.string.item_bottled_sand_spirit_description
        idImage = R.drawable.bottled_sand_spirit
        source.add(R.string.dungeon_name_the_desert)
        price = 110L
    }
}
