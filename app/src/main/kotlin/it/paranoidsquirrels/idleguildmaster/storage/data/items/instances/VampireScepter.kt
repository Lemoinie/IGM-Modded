package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff

class VampireScepter : Staff() {
    override fun configureProperties() {
        idName = R.string.weapon_staff_vampire_scepter_name
        idDescription = R.string.weapon_staff_vampire_scepter_description
        idEffect = R.string.weapon_staff_vampire_scepter_effect
        idImage = R.drawable.vampire_scepter
        price = 1026L
        intelligence = 28
        lifesteal = 20
    }
}
