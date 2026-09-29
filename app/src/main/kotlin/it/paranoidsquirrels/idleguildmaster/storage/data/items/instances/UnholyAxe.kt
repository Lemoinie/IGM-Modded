package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Axe

class UnholyAxe : Axe() {
    override fun configureProperties() {
        idName = R.string.weapon_axe_unholy_axe_name
        idDescription = R.string.weapon_axe_unholy_axe_description
        idEffect = R.string.weapon_axe_unholy_axe_effect
        idImage = R.drawable.unholy_axe
        price = 1520L
        constitution = 24
        intelligence = 12
        counterattack = 0.25
    }
}