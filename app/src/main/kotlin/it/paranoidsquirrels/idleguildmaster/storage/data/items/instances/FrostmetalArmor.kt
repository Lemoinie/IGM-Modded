package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor

class FrostmetalArmor : HeavyArmor() {
    override fun configureProperties() {
        idName = R.string.armor_heavy_frostmetal_armor_name
        idDescription = R.string.armor_heavy_frostmetal_armor_description
        idEffect = R.string.armor_heavy_frostmetal_armor_effect
        idImage = R.drawable.frostmetal_armor
        price = 504L
        maxHp = 180
        constitution = 5
        regeneration = 6
    }
}
