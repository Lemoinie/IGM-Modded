package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor

class KabelianArmor : HeavyArmor() {
    override fun configureProperties() {
        idName = R.string.armor_heavy_kabelian_armor_name
        idDescription = R.string.armor_heavy_kabelian_armor_description
        idEffect = R.string.armor_heavy_kabelian_armor_effect
        idImage = R.drawable.kabelian_armor
        price = 3276L
        maxHp = 105
        constitution = 20
        darknessReduction = 20
    }
}
