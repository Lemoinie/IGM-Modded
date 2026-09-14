package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class DreamwroughtSteel : Item() {
    override fun configureProperties() {
        idName = R.string.item_dreamwrought_steel_name
        idDescription = R.string.item_dreamwrought_steel_description
        idImage = R.drawable.dreamwrought_steel
        source.add(R.string.raid_name_sleeping_planet)
        price = 85L
    }
}
