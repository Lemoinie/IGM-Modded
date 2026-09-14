package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class EldritchTendril : Item() {
    override fun configureProperties() {
        idName = R.string.item_eldritch_tendril_name
        idDescription = R.string.item_eldritch_tendril_description
        idImage = R.drawable.eldritch_tendril
        source.add(R.string.dungeon_name_obsidian_mines)
        price = 8L
    }
}
