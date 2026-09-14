package it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet

abstract class Egg : Consumable() {
    abstract fun hatch(): Pet?

    override fun printType(): Int = R.string.type_egg

    override fun printConsumeImage(): Int = R.drawable.consume_egg
}
