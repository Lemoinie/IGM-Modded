package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor

class AnimatedCuirass : HeavyArmor() {
    override fun configureProperties() {
        idName = R.string.armor_heavy_animated_cuirass_name
        idDescription = R.string.armor_heavy_animated_cuirass_description
        idImage = R.drawable.animated_cuirass
        price = 756L
        maxHp = 300
        constitution = 10
    }
}
