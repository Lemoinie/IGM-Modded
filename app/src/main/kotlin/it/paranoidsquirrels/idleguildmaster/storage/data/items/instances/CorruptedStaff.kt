package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff

class CorruptedStaff : Staff() {
    override fun configureProperties() {
        idName = R.string.weapon_staff_corrupted_staff_name
        idDescription = R.string.weapon_staff_corrupted_staff_description
        idImage = R.drawable.corrupted_staff
        source.add(R.string.dungeon_name_the_golden_city)
        source.add(R.string.raid_name_imperial_rescue)
        price = 1L
        intelligence = 1
    }
}
