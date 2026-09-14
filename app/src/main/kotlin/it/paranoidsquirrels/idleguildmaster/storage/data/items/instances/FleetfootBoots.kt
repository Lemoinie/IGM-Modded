package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class FleetfootBoots : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_fleetfoot_boots_name
        idDescription = R.string.accessory_fleetfoot_boots_description
        idEffect = R.string.accessory_fleetfoot_boots_effect
        idImage = R.drawable.fleetfoot_boots
        price = 999L
        flatDodgeChance = 0.16
        dexterity = 16
    }
}
