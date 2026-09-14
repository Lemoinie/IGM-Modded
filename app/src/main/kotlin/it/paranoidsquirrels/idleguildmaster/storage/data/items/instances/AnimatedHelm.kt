package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class AnimatedHelm : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_animated_helm_name
        idDescription = R.string.accessory_animated_helm_description
        idImage = R.drawable.animated_helm
        price = 471L
        maxHp = 200
    }
}
