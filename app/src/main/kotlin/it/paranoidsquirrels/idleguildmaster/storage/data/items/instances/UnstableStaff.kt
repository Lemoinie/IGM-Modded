package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff

class UnstableStaff : Staff() {
    override fun configureProperties() {
        idName = R.string.weapon_staff_unstable_staff_name
        idDescription = R.string.weapon_staff_unstable_staff_description
        idEffect = R.string.weapon_staff_unstable_staff_effect
        idImage = R.drawable.unstable_staff
        price = 998L
        intelligence = 40
    }

    override fun damageDelta(): Double = 0.8
}
