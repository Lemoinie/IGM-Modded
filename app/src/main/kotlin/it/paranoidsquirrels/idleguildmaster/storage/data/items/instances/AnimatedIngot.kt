package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class AnimatedIngot : Item() {
    override fun configureProperties() {
        idName = R.string.item_animated_ingot_name
        idDescription = R.string.item_animated_ingot_description
        idImage = R.drawable.animated_ingot
        price = 9L
    }
}
