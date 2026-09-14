package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor

class AncientArmor : HeavyArmor() {
    override fun configureProperties() {
        idName = R.string.armor_heavy_ancient_armor_name
        idDescription = R.string.armor_heavy_ancient_armor_description
        idImage = R.drawable.ancient_armor
        price = 1092L
        maxHp = 330
        constitution = 11
    }
}
