package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class CelestialHelmet : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_celestial_helmet_name
        idDescription = R.string.accessory_celestial_helmet_description
        idImage = R.drawable.celestial_helmet
        price = 438L
        maxHp = 180
    }
}
