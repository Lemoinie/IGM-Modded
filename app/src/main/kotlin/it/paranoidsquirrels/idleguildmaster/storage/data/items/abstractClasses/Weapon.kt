package it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses

abstract class Weapon : Equipment() {
    abstract fun damageDelta(): Double
    abstract fun damageDescription(): Int
    abstract fun getDamageModifier(i: Int, i2: Int, i3: Int): Int
    abstract fun isMagic(): Boolean
    abstract fun isRanged(): Boolean
}
