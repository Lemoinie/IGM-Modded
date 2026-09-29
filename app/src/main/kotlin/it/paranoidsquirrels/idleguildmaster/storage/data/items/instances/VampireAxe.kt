package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Axe

class VampireAxe : Axe() {
    override fun configureProperties() {
        idName = R.string.weapon_axe_vampire_axe_name
        idDescription = R.string.weapon_axe_vampire_axe_description
        idEffect = R.string.weapon_axe_vampire_axe_effect
        idImage = R.drawable.vampire_axe
        price = 1050L
        constitution = 20
        intelligence = 10
        lifesteal = 20
    }
}