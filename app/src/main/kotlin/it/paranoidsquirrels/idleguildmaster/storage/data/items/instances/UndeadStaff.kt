package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff

class UndeadStaff : Staff() {
    override fun configureProperties() {
        idName = R.string.weapon_staff_undead_staff_name
        idDescription = R.string.weapon_staff_undead_staff_description
        idImage = R.drawable.undead_staff
        price = 93L
        intelligence = 12
    }
}
