package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Axe

class CopperAxe : Axe() {
    override fun configureProperties() {
        idName = R.string.weapon_axe_copper_axe_name
        idDescription = R.string.weapon_axe_copper_axe_description
        idImage = R.drawable.copper_axe
        price = 20L
        constitution = 2
        intelligence = 2
    }
}