package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class DreamwroughtLarva : Item() {
    override fun configureProperties() {
        idName = R.string.item_dreamwrought_larva_name
        idDescription = R.string.item_dreamwrought_larva_description
        idImage = R.drawable.dreamwrought_larva
        source.add(R.string.raid_name_sleeping_planet)
        price = 50L
    }
}
