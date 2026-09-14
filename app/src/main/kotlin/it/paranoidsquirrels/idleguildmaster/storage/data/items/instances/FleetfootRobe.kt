package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor

class FleetfootRobe : LightArmor() {
    override fun configureProperties() {
        idName = R.string.armor_light_fleetfoot_robe_name
        idDescription = R.string.armor_light_fleetfoot_robe_description
        idEffect = R.string.armor_light_fleetfoot_robe_effect
        idImage = R.drawable.fleetfoot_robe
        price = 1688L
        flatDodgeChance = 0.24
        maxHp = 80
        intelligence = 12
        dexterity = 4
    }
}
