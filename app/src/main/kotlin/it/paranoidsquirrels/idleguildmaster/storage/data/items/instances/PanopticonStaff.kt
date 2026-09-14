package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff

class PanopticonStaff : Staff() {
    override fun configureProperties() {
        idName = R.string.weapon_staff_panopticon_staff_name
        idDescription = R.string.weapon_staff_panopticon_staff_description
        idEffect = R.string.weapon_staff_panopticon_staff_effect
        idImage = R.drawable.panopticon_staff
        price = 642L
        intelligence = 32
        darknessReduction = 16
    }
}
