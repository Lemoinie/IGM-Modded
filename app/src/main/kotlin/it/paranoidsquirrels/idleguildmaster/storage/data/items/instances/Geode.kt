package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable

class Geode : Consumable() {
    override fun configureProperties() {
        idName = R.string.consumable_geode_name
        idDescription = R.string.consumable_geode_description
        idImage = R.drawable.geode
        source.add(R.string.item_found_everywhere)
        price = 10L
    }

    override fun printConsumeImage(): Int = R.drawable.consume_geode
}
