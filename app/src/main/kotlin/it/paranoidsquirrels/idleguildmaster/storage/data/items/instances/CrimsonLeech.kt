package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff

class CrimsonLeech : Staff() {
    override fun configureProperties() {
        idName = R.string.weapon_staff_crimson_leech_name
        idDescription = R.string.weapon_staff_crimson_leech_description
        idEffect = R.string.weapon_staff_crimson_leech_effect
        idImage = R.drawable.crimson_leech
        price = 834L
        intelligence = 16
        constitution = 4
        lifesteal = 20
    }
}
