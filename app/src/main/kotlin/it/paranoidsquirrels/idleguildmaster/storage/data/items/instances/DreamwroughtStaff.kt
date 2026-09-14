package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff

class DreamwroughtStaff : Staff() {
    override fun configureProperties() {
        idName = R.string.weapon_staff_dreamwrought_staff_name
        idDescription = R.string.weapon_staff_dreamwrought_staff_description
        idImage = R.drawable.dreamwrought_staff
        price = 893L
        intelligence = 52
    }
}
