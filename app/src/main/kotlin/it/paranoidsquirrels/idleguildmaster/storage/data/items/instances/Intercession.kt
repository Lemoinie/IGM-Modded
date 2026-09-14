package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable

class Intercession : Consumable() {
    override fun configureProperties() {
        idName = R.string.consumable_intercession_name
        idDescription = R.string.consumable_intercession_description
        idImage = R.drawable.intercession
        notSellable = true
        price = 10L
    }

    override fun printConsumeImage(): Int = R.drawable.consume_intercession
}
