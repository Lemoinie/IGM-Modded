package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class SpikedPrimevalShield : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_spiked_primeval_shield_name
        idDescription = R.string.accessory_spiked_primeval_shield_description
        idEffect = R.string.accessory_spiked_primeval_shield_effect
        idImage = R.drawable.spiked_primeval_shield
        price = 1499L
        retaliationPhysicalDamage = 25
        constitution = 27
        defense = 12
    }
}
