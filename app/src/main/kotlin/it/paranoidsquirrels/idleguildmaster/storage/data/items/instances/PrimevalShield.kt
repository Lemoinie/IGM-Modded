package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class PrimevalShield : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_primeval_shield_name
        idDescription = R.string.accessory_primeval_shield_description
        idImage = R.drawable.primeval_shield
        price = 675L
        constitution = 27
        defense = 12
    }
}
