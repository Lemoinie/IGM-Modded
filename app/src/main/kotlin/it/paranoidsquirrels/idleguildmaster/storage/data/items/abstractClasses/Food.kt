package it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses

import it.paranoidsquirrels.idleguildmaster.R

abstract class Food : Consumable() {
    @JvmField @Transient protected var feedPower: Int = 0

    override fun printType(): Int = R.string.type_food

    override fun printConsumeImage(): Int = R.drawable.consume_food

    open fun getFeedPower(): Int = feedPower
}
