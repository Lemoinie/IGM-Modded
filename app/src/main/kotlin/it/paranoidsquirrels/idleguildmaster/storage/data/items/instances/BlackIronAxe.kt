package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Axe

class BlackIronAxe : Axe() {
    override fun configureProperties() {
        idName = R.string.weapon_axe_black_iron_axe_name
        idDescription = R.string.weapon_axe_black_iron_axe_description
        idImage = R.drawable.black_iron_axe
        price = 380L
        constitution = 15
        intelligence = 6
    }
}