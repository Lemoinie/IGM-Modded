package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor

class SwarmkeeperArmor : HeavyArmor() {
    override fun configureProperties() {
        idName = R.string.armor_heavy_swarmkeeper_armor_name
        idDescription = R.string.armor_heavy_swarmkeeper_armor_description
        idEffect = R.string.armor_heavy_swarmkeeper_armor_effect
        idImage = R.drawable.swarmkeeper_armor
        price = 3368L
        retaliationMagicalDamage = 100
        maxHp = 390
        constitution = 13
    }
}
