package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff

class StaffOfTheArchmage : Staff() {
    override fun configureProperties() {
        idName = R.string.weapon_staff_staff_of_the_archmage_name
        idDescription = R.string.weapon_staff_staff_of_the_archmage_description
        idEffect = R.string.weapon_staff_staff_of_the_archmage_effect
        idImage = R.drawable.staff_of_the_archmage
        price = 1707L
        intelligence = 40
    }

    override fun damageDelta(): Double = 0.11935110081112399

    override fun getDamageModifier(i: Int, i2: Int, i3: Int): Int = (super.getDamageModifier(i, i2, i3).toDouble() * 1.07875).toInt()
}
