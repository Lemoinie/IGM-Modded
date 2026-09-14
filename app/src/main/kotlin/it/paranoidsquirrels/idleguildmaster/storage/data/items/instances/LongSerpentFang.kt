package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class LongSerpentFang : Item() {
    override fun configureProperties() {
        idName = R.string.item_long_serpent_fang_name
        idDescription = R.string.item_long_serpent_fang_description
        idImage = R.drawable.long_serpent_fang
        source.add(R.string.dungeon_name_the_southern_grove)
        price = 36L
    }
}
