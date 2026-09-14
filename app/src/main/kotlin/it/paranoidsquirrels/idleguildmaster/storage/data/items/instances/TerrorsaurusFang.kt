package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class TerrorsaurusFang : Item() {
    override fun configureProperties() {
        idName = R.string.item_terrorsaurus_fang_name
        idDescription = R.string.item_terrorsaurus_fang_description
        idImage = R.drawable.terrorsaurus_fang
        source.add(R.string.dungeon_name_lost_lands)
        price = 42L
    }
}
