package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable

class XPBook10 : Consumable() {
    override fun configureProperties() {
        super.configureProperties()
        idName = R.string.consumable_xp_book_10_name
        idDescription = R.string.consumable_xp_book_10_description
        idImage = R.drawable.xp_book_10
        notSellable = false
        price = 1000000L
    }

    override fun printConsumeImage(): Int = R.drawable.xp_book_10

    fun getXpToGive(): Int = 100000
}
