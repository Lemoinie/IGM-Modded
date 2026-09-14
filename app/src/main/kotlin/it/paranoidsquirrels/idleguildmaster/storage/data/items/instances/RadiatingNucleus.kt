package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class RadiatingNucleus : Item() {
    override fun configureProperties() {
        idName = R.string.item_radiating_nucleus_name
        idDescription = R.string.item_radiating_nucleus_description
        idImage = R.drawable.radiating_nucleus
        source.add(R.string.dungeon_name_hidden_city_of_larox)
        price = 10L
    }
}
