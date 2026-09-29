package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Axe

class FrostmetalAxe : Axe() {
    override fun configureProperties() {
        idName = R.string.weapon_axe_frostmetal_axe_name
        idDescription = R.string.weapon_axe_frostmetal_axe_description
        idImage = R.drawable.frostmetal_axe
        price = 520L
        constitution = 17
        intelligence = 8
    }
}