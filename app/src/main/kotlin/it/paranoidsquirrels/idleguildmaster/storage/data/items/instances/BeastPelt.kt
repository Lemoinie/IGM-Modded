package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class BeastPelt : Item() {
    override fun configureProperties() {
        idName = R.string.item_beast_pelt_name
        idDescription = R.string.item_beast_pelt_description
        idImage = R.drawable.beast_pelt
        source.add(R.string.dungeon_name_enchanted_forest)
        price = 1L
    }
}
