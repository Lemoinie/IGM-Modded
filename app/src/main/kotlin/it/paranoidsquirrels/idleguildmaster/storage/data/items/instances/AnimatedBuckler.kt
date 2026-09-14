package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class AnimatedBuckler : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_animated_bucker_name
        idDescription = R.string.accessory_animated_bucker_description
        idImage = R.drawable.animated_buckler
        price = 500L
        constitution = 30
    }
}
