package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class WurmScale : Item() {
    override fun configureProperties() {
        idName = R.string.item_wurm_scale_name
        idDescription = R.string.item_wurm_scale_description
        idImage = R.drawable.wurm_scale
        source.add(R.string.dungeon_name_the_desert)
        price = 1L
    }
}
