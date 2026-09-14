package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor

class VoidArmor : HeavyArmor() {
    override fun configureProperties() {
        idName = R.string.armor_heavy_void_armor_name
        idDescription = R.string.armor_heavy_void_armor_description
        idImage = R.drawable.void_armor
        price = 31500L
        maxHp = 280
        defense = 15
        magicDefense = 15
    }
}
