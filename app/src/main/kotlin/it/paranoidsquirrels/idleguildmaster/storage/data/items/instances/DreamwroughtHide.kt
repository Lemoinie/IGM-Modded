package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class DreamwroughtHide : Item() {
    override fun configureProperties() {
        idName = R.string.item_dreamwrought_hide_name
        idDescription = R.string.item_dreamwrought_hide_description
        idImage = R.drawable.dreamwrought_hide
        source.add(R.string.raid_name_sleeping_planet)
        price = 25L
    }
}
