package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable

class XPBook1 : Consumable() {
    override fun configureProperties() {
        super.configureProperties()
        idName = R.string.consumable_xp_book_1_name
        idDescription = R.string.consumable_xp_book_1_description
        idImage = R.drawable.xp_book_1
        notSellable = false
        price = 100L
    }

    override fun printConsumeImage(): Int = R.drawable.xp_book_1

    fun getXpToGive(): Int = 10
}
