package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class TrollHide : Item() {
    override fun configureProperties() {
        idName = R.string.item_troll_hide_name
        idDescription = R.string.item_troll_hide_description
        idImage = R.drawable.troll_hide
        source.add(R.string.dungeon_name_frostbite_peaks)
        price = 2L
    }
}
