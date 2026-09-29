package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable

class Evo21Vial : Consumable() {
    override fun configureProperties() {
        super.configureProperties()
        idName = R.string.consumable_evo21_vial_name
        idDescription = R.string.consumable_evo21_vial_description
        idImage = R.drawable.evo21_vial
        source.add(R.string.raid_name_celestial_mothership)
        notSellable = true
        price = 10L
    }

    override fun printConsumeImage(): Int = R.drawable.consume_evo21_vial
}