package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class TatteredHide : Item() {
    override fun configureProperties() {
        idName = R.string.item_tattered_hide_name
        idDescription = R.string.item_tattered_hide_description
        idImage = R.drawable.tattered_hide
        source.add(R.string.dungeon_name_eternal_battlefield)
        source.add(R.string.raid_name_ancient_grave_digging)
        price = 2L
    }
}
