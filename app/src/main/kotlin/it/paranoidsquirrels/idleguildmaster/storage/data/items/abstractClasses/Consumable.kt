package it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

abstract class Consumable : Item() {
    abstract fun printConsumeImage(): Int

    override fun configureProperties() {
        this.consumable = true
    }

    override fun printType(): Int = R.string.type_consumable
}
