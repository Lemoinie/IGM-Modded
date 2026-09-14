package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor

class PatricianArmor : HeavyArmor() {
    override fun configureProperties() {
        idName = R.string.armor_heavy_patrician_armor_name
        idDescription = R.string.armor_heavy_patrician_armor_description
        idEffect = R.string.armor_heavy_patrician_armor_effect
        idImage = R.drawable.patrician_armor
        price = 645L
        maxHp = 120
        constitution = 4
        bonusExperience = 35
    }
}
