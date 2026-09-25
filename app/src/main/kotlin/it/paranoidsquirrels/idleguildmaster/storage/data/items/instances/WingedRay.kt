package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class WingedRay : Food() {
    override fun configureProperties() {
        idName = R.string.food_winged_ray_name
        idDescription = R.string.food_winged_ray_description
        idImage = R.drawable.winged_ray
        price = 70L
        feedPower = 35
    }
}