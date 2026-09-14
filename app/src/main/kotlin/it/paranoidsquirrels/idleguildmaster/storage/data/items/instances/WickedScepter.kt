package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff

class WickedScepter : Staff() {
    override fun configureProperties() {
        idName = R.string.weapon_staff_wicked_scepter_name
        idDescription = R.string.weapon_staff_wicked_scepter_description
        idEffect = R.string.weapon_staff_wicked_scepter_effect
        idImage = R.drawable.wicked_scepter
        price = 1145L
        intelligence = 45
    }
}
