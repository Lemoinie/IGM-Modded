package it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses

import it.paranoidsquirrels.idleguildmaster.R

abstract class HeavyArmor : Armor() {
    override fun printType(): Int = R.string.type_armor_heavy
}
