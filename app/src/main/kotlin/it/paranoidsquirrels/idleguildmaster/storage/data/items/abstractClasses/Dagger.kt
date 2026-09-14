package it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses

import it.paranoidsquirrels.idleguildmaster.R

abstract class Dagger : Weapon() {
    override fun damageDelta(): Double = 0.25
    override fun getDamageModifier(i: Int, i2: Int, i3: Int): Int = i + i3
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false
    override fun printType(): Int = R.string.type_dagger
    override fun damageDescription(): Int = R.string.help_attack_daggers
}
