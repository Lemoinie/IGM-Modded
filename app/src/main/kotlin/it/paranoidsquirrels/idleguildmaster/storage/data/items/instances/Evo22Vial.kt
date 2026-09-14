package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable

class Evo22Vial : Consumable() {
    override fun configureProperties() {
        super.configureProperties()
        idName = R.string.consumable_evo22_vial_name
        idDescription = R.string.consumable_evo22_vial_description
        idImage = R.drawable.evo22_vial
        notSellable = true
        price = 10L
    }

    override fun printConsumeImage(): Int = R.drawable.consume_evo22_vial
}
