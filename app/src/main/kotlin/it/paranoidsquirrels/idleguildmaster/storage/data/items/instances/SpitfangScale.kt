package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class SpitfangScale : Item() {
    override fun configureProperties() {
        idName = R.string.item_spitfang_scale_name
        idDescription = R.string.item_spitfang_scale_description
        idImage = R.drawable.spitfang_scale
        source.add(R.string.dungeon_name_the_southern_grove)
        price = 1L
    }
}
