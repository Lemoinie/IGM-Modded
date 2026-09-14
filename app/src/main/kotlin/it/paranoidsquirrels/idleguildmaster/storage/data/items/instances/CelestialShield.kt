package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class CelestialShield : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_celestial_shield_name
        idDescription = R.string.accessory_celestial_shield_description
        idImage = R.drawable.celestial_shield
        price = 473L
        constitution = 27
    }
}
