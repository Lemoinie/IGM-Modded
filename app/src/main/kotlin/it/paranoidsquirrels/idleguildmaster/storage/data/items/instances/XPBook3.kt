package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable

class XPBook3 : Consumable() {
    override fun configureProperties() {
        super.configureProperties()
        idName = R.string.consumable_xp_book_3_name
        idDescription = R.string.consumable_xp_book_3_description
        idImage = R.drawable.xp_book_3
        notSellable = false
        price = 10000L
    }

    override fun printConsumeImage(): Int = R.drawable.xp_book_3

    fun getXpToGive(): Int = 1000
}
