package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable

class Evo23Vial : Consumable() {
    override fun configureProperties() {
        idName = R.string.consumable_evo23_vial_name
        idDescription = R.string.consumable_evo23_vial_description
        idImage = R.drawable.evo23_vial
        notSellable = true
        source.add(R.string.raid_name_celestial_mothership)
        price = 10L
    }

    override fun printConsumeImage(): Int = R.drawable.consume_evo23_vial
}
