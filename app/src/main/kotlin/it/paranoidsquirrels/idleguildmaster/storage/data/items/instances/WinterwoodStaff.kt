package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff

class WinterwoodStaff : Staff() {
    override fun configureProperties() {
        idName = R.string.weapon_staff_winterwood_staff_name
        idDescription = R.string.weapon_staff_winterwood_staff_description
        idImage = R.drawable.winterwood_staff
        price = 249L
        intelligence = 24
    }
}
