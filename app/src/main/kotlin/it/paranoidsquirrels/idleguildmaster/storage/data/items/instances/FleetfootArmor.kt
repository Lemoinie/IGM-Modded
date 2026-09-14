package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor

class FleetfootArmor : HeavyArmor() {
    override fun configureProperties() {
        idName = R.string.armor_heavy_fleetfoot_armor_name
        idDescription = R.string.armor_heavy_fleetfoot_armor_description
        idEffect = R.string.armor_heavy_fleetfoot_armor_effect
        idImage = R.drawable.fleetfoot_armor
        price = 1251L
        flatDodgeChance = 0.12
        maxHp = 240
        constitution = 5
        dexterity = 1
    }
}
