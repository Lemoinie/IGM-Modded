package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Axe

class EnforcersAxe : Axe() {
    override fun configureProperties() {
        idName = R.string.weapon_axe_enforcers_axe_name
        idDescription = R.string.weapon_axe_enforcers_axe_description
        idImage = R.drawable.enforcers_axe
        price = 950L
        constitution = 18
        dexterity = 10
        intelligence = 18
    }
}