package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Axe

class UndeadAxe : Axe() {
    override fun configureProperties() {
        idName = R.string.weapon_axe_undead_axe_name
        idDescription = R.string.weapon_axe_undead_axe_description
        idImage = R.drawable.undead_axe
        price = 75L
        constitution = 8
        intelligence = 5
    }
}