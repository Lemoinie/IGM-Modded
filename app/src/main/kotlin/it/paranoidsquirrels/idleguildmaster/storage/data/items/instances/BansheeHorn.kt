package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class BansheeHorn : Item() {
    override fun configureProperties() {
        idName = R.string.item_banshee_horn_name
        idDescription = R.string.item_banshee_horn_description
        idImage = R.drawable.banshee_horn
        source.add(R.string.dungeon_name_barren_wastelands)
        price = 95L
    }
}
