package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff

class MoltenStaff : Staff() {
    override fun configureProperties() {
        idName = R.string.weapon_staff_molten_staff_name
        idDescription = R.string.weapon_staff_molten_staff_description
        idImage = R.drawable.molten_staff
        price = 285L
        intelligence = 14
    }
}
