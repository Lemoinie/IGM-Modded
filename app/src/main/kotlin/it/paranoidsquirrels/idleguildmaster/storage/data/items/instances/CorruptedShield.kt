package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class CorruptedShield : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_corrupted_shield_name
        idDescription = R.string.accessory_corrupted_shield_description
        idImage = R.drawable.corrupted_shield
        source.add(R.string.dungeon_name_the_golden_city)
        source.add(R.string.raid_name_imperial_rescue)
        price = 1L
        constitution = 1
    }
}
