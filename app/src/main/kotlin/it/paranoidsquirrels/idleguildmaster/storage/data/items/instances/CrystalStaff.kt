package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff

class CrystalStaff : Staff() {
    override fun configureProperties() {
        idName = R.string.weapon_staff_crystal_staff_name
        idDescription = R.string.weapon_staff_crystal_staff_description
        idEffect = R.string.weapon_staff_crystal_staff_effect
        idImage = R.drawable.crystal_staff
        price = 360L
        intelligence = 26
        immunityToStatus = 0.25
    }
}
