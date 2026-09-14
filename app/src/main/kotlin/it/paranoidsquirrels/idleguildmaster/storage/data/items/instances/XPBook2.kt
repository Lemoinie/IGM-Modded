package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable

class XPBook2 : Consumable() {
    override fun configureProperties() {
        super.configureProperties()
        idName = R.string.consumable_xp_book_2_name
        idDescription = R.string.consumable_xp_book_2_description
        idImage = R.drawable.xp_book_2
        notSellable = false
        price = 1000L
    }

    override fun printConsumeImage(): Int = R.drawable.xp_book_2

    fun getXpToGive(): Int = 100
}
