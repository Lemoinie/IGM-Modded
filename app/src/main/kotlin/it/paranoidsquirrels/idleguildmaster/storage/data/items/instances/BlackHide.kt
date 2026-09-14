package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class BlackHide : Item() {
    override fun configureProperties() {
        idName = R.string.item_black_hide_name
        idDescription = R.string.item_black_hide_description
        idImage = R.drawable.black_hide
        source.add(R.string.raid_name_the_lost_expedition)
        price = 16L
    }
}
