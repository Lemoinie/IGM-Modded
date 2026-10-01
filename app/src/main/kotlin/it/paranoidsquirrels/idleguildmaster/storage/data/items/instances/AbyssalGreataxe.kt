package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Axe

class AbyssalGreataxe : Axe() {
    override fun configureProperties() {
        idName = R.string.weapon_axe_abyssal_great_axe_name
        idDescription = R.string.weapon_axe_abyssal_great_axe_description
        idImage = R.drawable.abyssal_great_axe
        price = 1250L
        constitution = 15
        intelligence = 20
    }
}