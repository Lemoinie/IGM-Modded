package it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses

abstract class Weapon : Equipment() {
    abstract fun damageDelta(): Double
    abstract fun damageDescription(): Int
    open fun getDamageModifier(i: Int, i2: Int, i3: Int): Int = i + i2 + i3
    abstract fun isMagic(): Boolean
    abstract fun isRanged(): Boolean
}
