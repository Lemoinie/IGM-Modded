package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class HolyWater : Item() {
    override fun configureProperties() {
        idName = R.string.item_holy_water_name
        idDescription = R.string.item_holy_water_description
        idImage = R.drawable.holy_water
        source.add(R.string.dungeon_name_the_golden_city)
        price = 70L
    }
}
