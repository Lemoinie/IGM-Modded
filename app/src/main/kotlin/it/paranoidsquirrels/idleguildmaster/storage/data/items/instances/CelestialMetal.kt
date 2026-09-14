package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class CelestialMetal : Item() {
    override fun configureProperties() {
        idName = R.string.item_celestial_metal_name
        idDescription = R.string.item_celestial_metal_description
        idImage = R.drawable.celestial_metal
        price = 9L
    }
}
