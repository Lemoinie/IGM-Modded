package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class FleetfootGloves : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_fleetfoot_gloves_name
        idDescription = R.string.accessory_fleetfoot_gloves_description
        idEffect = R.string.accessory_fleetfoot_gloves_effect
        idImage = R.drawable.fleetfoot_gloves
        price = 1031L
        flatDodgeChance = 0.16
        constitution = 10
        dexterity = 12
    }
}
