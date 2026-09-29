package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable

class XPBookC : Consumable() {
    override fun configureProperties() {
        super.configureProperties()
        idName = R.string.consumable_xp_book_c_name
        idDescription = R.string.consumable_xp_book_c_description
        idImage = R.drawable.xp_book_c
        notSellable = true
        price = 1000000L
    }

    override fun printConsumeImage(): Int = R.drawable.xp_book_c

    fun getXpToGive(): Int = 1000000
}
