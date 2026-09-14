package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff

class SunStaff : Staff() {
    override fun configureProperties() {
        idName = R.string.weapon_staff_sun_staff_name
        idDescription = R.string.weapon_staff_sun_staff_description
        idEffect = R.string.weapon_staff_sun_staff_effect
        idImage = R.drawable.sun_staff
        price = 1560L
        onFireBonusDamage = 2
        intelligence = 13
        constitution = 2
        dexterity = 2
    }
}
