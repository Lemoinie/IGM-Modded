package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class IgnitionOrb : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_ignition_orb_name
        idDescription = R.string.accessory_ignition_orb_description
        idEffect = R.string.accessory_ignition_orb_effect
        idImage = R.drawable.ignition_orb
        price = 657L
        onFireBonusDamage = 2
        maxHp = 70
        intelligence = 8
    }
}
