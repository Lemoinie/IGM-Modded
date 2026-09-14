package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class BansheeScale : Item() {
    override fun configureProperties() {
        idName = R.string.item_banshee_scale_name
        idDescription = R.string.item_banshee_scale_description
        idImage = R.drawable.banshee_scale
        source.add(R.string.dungeon_name_barren_wastelands)
        price = 3L
    }
}
