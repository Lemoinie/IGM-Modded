package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor

class PrismaticArmor : HeavyArmor() {
    override fun configureProperties() {
        idName = R.string.armor_heavy_prismatic_armor_name
        idDescription = R.string.armor_heavy_prismatic_armor_description
        idImage = R.drawable.prismatic_armor
        price = 20850L
        maxHp = 230
        defense = 15
        magicDefense = 15
    }
}
