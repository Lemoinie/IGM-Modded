package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class SilverRing : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_silver_ring_name
        idDescription = R.string.accessory_silver_ring_description
        idEffect = R.string.accessory_silver_ring_effect
        idImage = R.drawable.silver_ring
        source.add(R.string.dungeon_name_the_golden_city)
        source.add(R.string.raid_name_imperial_rescue)
        price = 28L
        initiative = true
        defense = 1
    }
}
