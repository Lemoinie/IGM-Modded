package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable

class Evo23Vial2 : Consumable() {
    override fun configureProperties() {
        idName = R.string.consumable_evo23_vial_name
        idDescription = R.string.consumable_evo23_vial_description_alternative
        idImage = R.drawable.evo23_vial
        notSellable = true
        price = 10L
    }

    override fun printConsumeImage(): Int = R.drawable.consume_evo23_vial
}
