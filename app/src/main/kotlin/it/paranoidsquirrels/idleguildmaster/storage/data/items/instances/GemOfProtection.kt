package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class GemOfProtection : Item() {
    override fun configureProperties() {
        idName = R.string.accessory_gem_of_protection_name
        idDescription = R.string.accessory_gem_of_protection_description
        idImage = R.drawable.gem_of_protection
        price = 60L
    }
}
