package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff

class StellarStaff : Staff() {
    override fun configureProperties() {
        idName = R.string.weapon_staff_stellar_staff_name
        idDescription = R.string.weapon_staff_stellar_staff_description
        idEffect = R.string.weapon_staff_stellar_staff_effect
        idImage = R.drawable.stellar_staff
        price = 6090L
        onFireBonusDamage = 3
        intelligence = 25
        constitution = 10
        dexterity = 10
    }
}
