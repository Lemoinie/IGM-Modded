package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Axe

class GoldenAxe : Axe() {
    override fun configureProperties() {
        idName = R.string.weapon_axe_golden_axe_name
        idDescription = R.string.weapon_axe_golden_axe_description
        idImage = R.drawable.gold_axe
        price = 485L
        constitution = 12
        intelligence = 6
    }
}