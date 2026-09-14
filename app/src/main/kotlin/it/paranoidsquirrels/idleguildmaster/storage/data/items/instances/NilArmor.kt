package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor

class NilArmor : HeavyArmor() {
    override fun configureProperties() {
        idName = R.string.armor_heavy_nil_armor_name
        idDescription = R.string.armor_heavy_nil_armor_description
        idImage = R.drawable.nil_armor
        price = 57000L
        maxHp = 350
        defense = 15
        magicDefense = 15
    }
}
