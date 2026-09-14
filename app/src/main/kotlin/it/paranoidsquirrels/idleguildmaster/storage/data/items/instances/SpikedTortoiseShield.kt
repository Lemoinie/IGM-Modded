package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class SpikedTortoiseShield : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_spiked_tortoise_shield_name
        idDescription = R.string.accessory_spiked_tortoise_shield_description
        idEffect = R.string.accessory_spiked_tortoise_shield_effect
        idImage = R.drawable.spiked_tortoise_shield
        price = 846L
        retaliationPhysicalDamage = 25
        constitution = 24
    }
}
