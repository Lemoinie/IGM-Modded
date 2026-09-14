package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class WhiteHair : Item() {
    override fun configureProperties() {
        idName = R.string.item_white_hair_name
        idDescription = R.string.item_white_hair_description
        idImage = R.drawable.white_hair
        source.add(R.string.dungeon_name_the_southern_grove)
        price = 90L
    }
}
