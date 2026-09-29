package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable

class Evo24Vial : Consumable() {
    override fun configureProperties() {
        super.configureProperties()
        idName = R.string.consumable_evo24_vial_name
        idDescription = R.string.consumable_evo24_vial_description
        idImage = R.drawable.evo24_vial
        notSellable = true
        price = 10L
    }

    override fun printConsumeImage(): Int = R.drawable.consume_evo24_vial
}