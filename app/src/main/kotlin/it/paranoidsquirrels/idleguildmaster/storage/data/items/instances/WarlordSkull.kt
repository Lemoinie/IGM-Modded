package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class WarlordSkull : Item() {
    override fun configureProperties() {
        idName = R.string.item_warlord_skull_name
        idDescription = R.string.item_warlord_skull_description
        idImage = R.drawable.warlord_skull
        source.add(R.string.dungeon_name_eternal_battlefield)
        source.add(R.string.raid_name_ancient_grave_digging)
        price = 26L
    }
}
