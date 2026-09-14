package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class ElysianWood : Item() {
    override fun configureProperties() {
        idName = R.string.item_elysian_wood_name
        idDescription = R.string.item_elysian_wood_description
        idImage = R.drawable.elysian_wood
        source.add(R.string.dungeon_name_the_southern_grove)
        price = 2L
    }
}
