package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff

class FocusedScepter : Staff() {
    override fun configureProperties() {
        idName = R.string.weapon_staff_focused_scepter_name
        idDescription = R.string.weapon_staff_focused_scepter_description
        idEffect = R.string.weapon_staff_focused_scepter_effect
        idImage = R.drawable.focused_scepter
        price = 854L
        alwaysHits = true
        intelligence = 24
    }
}
