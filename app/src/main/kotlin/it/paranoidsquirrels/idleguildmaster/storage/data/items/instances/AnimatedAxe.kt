package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Axe

class AnimatedAxe : Axe() {
    override fun configureProperties() {
        idName = R.string.weapon_axe_animated_axe_name
        idDescription = R.string.weapon_axe_animated_axe_description
        idImage = R.drawable.animated_axe
        price = 670L
        constitution = 28
        intelligence = 16
    }
}