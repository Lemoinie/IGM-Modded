package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff

class CursedScepter : Staff() {
    override fun configureProperties() {
        idName = R.string.weapon_staff_cursed_scepter_name
        idDescription = R.string.weapon_staff_cursed_scepter_description
        idEffect = R.string.weapon_staff_cursed_scepter_effect
        idImage = R.drawable.cursed_scepter
        price = 8468L
        intelligence = 55
    }
}
