package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class ScrapMetal : Item() {
    override fun configureProperties() {
        idName = R.string.item_scrap_metal_name
        idDescription = R.string.item_scrap_metal_description
        idImage = R.drawable.scrap_metal
        source.add(R.string.dungeon_name_the_desert)
        source.add(R.string.raid_name_divine_archeology)
        price = 1L
    }
}
