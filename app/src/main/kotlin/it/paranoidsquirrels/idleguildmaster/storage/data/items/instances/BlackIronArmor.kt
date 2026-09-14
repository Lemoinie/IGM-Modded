package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor

class BlackIronArmor : HeavyArmor() {
    override fun configureProperties() {
        idName = R.string.armor_heavy_black_iron_armor_name
        idDescription = R.string.armor_heavy_black_iron_armor_description
        idImage = R.drawable.black_iron_armor
        price = 419L
        maxHp = 150
        constitution = 5
    }
}
