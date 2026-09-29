package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Axe

class IronAxe : Axe() {
    override fun configureProperties() {
        idName = R.string.weapon_axe_iron_axe_name
        idDescription = R.string.weapon_axe_iron_axe_description
        idImage = R.drawable.iron_axe
        price = 50L
        constitution = 4
        intelligence = 3
    }
}