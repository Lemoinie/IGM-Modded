package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger

class AnimatedDagger : Dagger() {
    override fun configureProperties() {
        idName = R.string.weapon_dagger_animated_dagger_name
        idDescription = R.string.weapon_dagger_animated_dagger_description
        idImage = R.drawable.animated_dagger
        price = 608L
        constitution = 30
        dexterity = 30
    }
}
