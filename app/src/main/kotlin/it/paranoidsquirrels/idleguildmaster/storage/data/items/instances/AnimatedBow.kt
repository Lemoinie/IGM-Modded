package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow

class AnimatedBow : Bow() {
    override fun configureProperties() {
        idName = R.string.weapon_bow_animated_bow_name
        idDescription = R.string.weapon_bow_animated_bow_description
        idImage = R.drawable.animated_bow
        price = 638L
        dexterity = 30
        intelligence = 10
    }
}
