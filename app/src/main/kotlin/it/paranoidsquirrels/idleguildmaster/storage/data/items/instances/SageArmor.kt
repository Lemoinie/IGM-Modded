package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor

class SageArmor : HeavyArmor() {
    override fun configureProperties() {
        idName = R.string.armor_heavy_sage_armor_name
        idDescription = R.string.armor_heavy_sage_armor_description
        idEffect = R.string.armor_heavy_sage_armor_effect
        idImage = R.drawable.sage_armor
        price = 3915L
        maxHp = 210
        constitution = 7
        bonusExperience = 60
    }
}
