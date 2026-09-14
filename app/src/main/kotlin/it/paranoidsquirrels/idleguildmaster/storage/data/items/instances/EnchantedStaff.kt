package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff

class EnchantedStaff : Staff() {
    override fun configureProperties() {
        idName = R.string.weapon_staff_enchanted_staff_name
        idDescription = R.string.weapon_staff_enchanted_staff_description
        idImage = R.drawable.enchanted_staff
        price = 45L
        intelligence = 4
    }
}
