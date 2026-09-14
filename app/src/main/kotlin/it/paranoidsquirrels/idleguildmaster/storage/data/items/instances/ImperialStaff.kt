package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff

class ImperialStaff : Staff() {
    override fun configureProperties() {
        idName = R.string.weapon_staff_imperial_staff_name
        idDescription = R.string.weapon_staff_imperial_staff_description
        idImage = R.drawable.imperial_staff
        price = 564L
        intelligence = 26
        constitution = 8
        dexterity = 8
    }
}
