package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff

class BlackIronScepter : Staff() {
    override fun configureProperties() {
        idName = R.string.weapon_staff_black_iron_scepter_name
        idDescription = R.string.weapon_staff_black_iron_scepter_description
        idImage = R.drawable.black_iron_scepter
        price = 336L
        intelligence = 20
    }
}
