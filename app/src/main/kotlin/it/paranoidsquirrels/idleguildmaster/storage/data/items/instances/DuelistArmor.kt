package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor

class DuelistArmor : HeavyArmor() {
    override fun configureProperties() {
        idName = R.string.armor_heavy_duelist_armor_name
        idDescription = R.string.armor_heavy_duelist_armor_description
        idEffect = R.string.armor_heavy_duelist_armor_effect
        idImage = R.drawable.duelist_armor
        price = 3885L
        maxHp = 75
        constitution = 20
        counterattack = 0.25
    }
}
