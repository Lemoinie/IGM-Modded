package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor

class GoldenArmor : HeavyArmor() {
    override fun configureProperties() {
        idName = R.string.armor_heavy_golden_armor_name
        idDescription = R.string.armor_heavy_golden_armor_description
        idImage = R.drawable.golden_armor
        price = 552L
        maxHp = 120
        constitution = 4
    }
}
