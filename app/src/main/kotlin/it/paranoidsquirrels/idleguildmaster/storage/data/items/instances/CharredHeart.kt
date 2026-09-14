package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class CharredHeart : Item() {
    override fun configureProperties() {
        idName = R.string.item_charred_heart_name
        idDescription = R.string.item_charred_heart_description
        idImage = R.drawable.charred_heart
        source.add(R.string.dungeon_name_barren_wastelands)
        price = 95L
    }
}
