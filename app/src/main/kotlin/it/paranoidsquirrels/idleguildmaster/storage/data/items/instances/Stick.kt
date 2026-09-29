package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Axe

class Stick : Axe() {
    override fun configureProperties() {
        idName = R.string.weapon_axe_stick_name
        idDescription = R.string.weapon_axe_stick_description
        idImage = R.drawable.stick
        price = 0L
        constitution = 1
        intelligence = 1
    }
}