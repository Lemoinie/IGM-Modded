package it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses

import it.paranoidsquirrels.idleguildmaster.R

abstract class Staff : Weapon() {
    override fun damageDelta(): Double = 0.05
    override fun getDamageModifier(i: Int, i2: Int, i3: Int): Int = i2
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = true
    override fun printType(): Int = R.string.type_staff
    override fun damageDescription(): Int = R.string.help_attack_staffs
}
