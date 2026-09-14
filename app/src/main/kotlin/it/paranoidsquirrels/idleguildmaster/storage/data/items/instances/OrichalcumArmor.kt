package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor

class OrichalcumArmor : HeavyArmor() {
    override fun configureProperties() {
        idName = R.string.armor_heavy_orichalcum_armor_name
        idDescription = R.string.armor_heavy_orichalcum_armor_description
        idImage = R.drawable.orichalcum_armor
        price = 2730L
        maxHp = 442
    }
}
