package it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses

import it.paranoidsquirrels.idleguildmaster.R

abstract class Bow : Weapon() {
    override fun damageDelta(): Double = 0.1
    override fun getDamageModifier(i: Int, i2: Int, i3: Int): Int = i3
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = true
    override fun printType(): Int = R.string.type_bow
    override fun damageDescription(): Int = R.string.help_attack_bows
}
