package it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses

import it.paranoidsquirrels.idleguildmaster.R

abstract class Axe : Weapon() {
    override fun damageDelta(): Double = 0.20
    override fun getDamageModifier(i: Int, i2: Int, i3: Int): Int = i + i2 // 100% Constitution + 100% Intelligence scaling
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false
    override fun printType(): Int = R.string.type_axe
    override fun damageDescription(): Int = R.string.help_attack_axes
}