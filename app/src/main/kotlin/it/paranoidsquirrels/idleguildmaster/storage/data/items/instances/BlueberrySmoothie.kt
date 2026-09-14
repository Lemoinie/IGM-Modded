package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class BlueberrySmoothie : Food() {
    override fun configureProperties() {
        idName = R.string.food_blueberry_smoothie_name
        idDescription = R.string.food_blueberry_smoothie_description
        idImage = R.drawable.blueberry_smoothie
        price = 38L
        feedPower = 85
    }
}
