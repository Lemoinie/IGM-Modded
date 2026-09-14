package it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses

import it.paranoidsquirrels.idleguildmaster.R

abstract class Potion : Consumable() {
    companion object {
        const val AGILITY: Int = 10
        const val CONSTITUTION: Int = 0
        const val DARKNESS: Int = 8
        const val DEFENSE: Int = 4
        const val DEXTERITY: Int = 1
        const val HEALTH: Int = 3
        const val IMMUNITY: Int = 9
        const val INTELLIGENCE: Int = 2
        const val MAGIC_DEFENSE: Int = 5
        const val PRECISION: Int = 6
        const val VICIOUSNESS: Int = 7
    }

    abstract fun getPotionType(): Int

    override fun printType(): Int = R.string.type_potion

    override fun printConsumeImage(): Int = R.drawable.consume_potion
}
