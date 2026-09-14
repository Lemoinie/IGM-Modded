package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class DreamwroughtMane : Item() {
    override fun configureProperties() {
        idName = R.string.item_dreamwrought_mane_name
        idDescription = R.string.item_dreamwrought_mane_description
        idImage = R.drawable.dreamwrought_mane
        source.add(R.string.raid_name_sleeping_planet)
        price = 5L
    }
}
