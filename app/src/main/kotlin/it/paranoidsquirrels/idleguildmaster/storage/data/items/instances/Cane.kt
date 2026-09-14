package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff

class Cane : Staff() {
    override fun configureProperties() {
        idName = R.string.weapon_staff_cane_name
        idDescription = R.string.weapon_staff_cane_description
        idImage = R.drawable.cane
        price = 0L
        intelligence = 1
    }
}
