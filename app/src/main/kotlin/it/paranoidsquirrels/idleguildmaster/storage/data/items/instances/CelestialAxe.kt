package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Axe

class CelestialAxe : Axe() {
    override fun configureProperties() {
        idName = R.string.weapon_axe_celestial_axe_name
        idDescription = R.string.weapon_axe_celestial_axe_description
        idImage = R.drawable.celestial_axe
        price = 610L
        constitution = 26
        intelligence = 14
    }
}