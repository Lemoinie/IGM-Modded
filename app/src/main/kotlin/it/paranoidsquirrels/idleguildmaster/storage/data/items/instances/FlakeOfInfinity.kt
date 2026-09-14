package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class FlakeOfInfinity : Item() {
    override fun configureProperties() {
        idName = R.string.item_flake_of_infinity_name
        idDescription = R.string.item_flake_of_infinity_description
        idImage = R.drawable.flake_of_infinity
        source.add(R.string.raid_name_sleeping_planet)
        price = 250L
    }
}
