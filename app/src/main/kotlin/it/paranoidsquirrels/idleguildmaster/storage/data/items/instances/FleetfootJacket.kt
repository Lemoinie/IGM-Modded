package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor

class FleetfootJacket : MediumArmor() {
    override fun configureProperties() {
        idName = R.string.armor_medium_fleetfoot_jacket_name
        idDescription = R.string.armor_medium_fleetfoot_jacket_description
        idEffect = R.string.armor_medium_fleetfoot_jacket_effect
        idImage = R.drawable.fleetfoot_jacket
        price = 945L
        flatDodgeChance = 0.2
        maxHp = 160
        constitution = 4
        dexterity = 8
    }
}
