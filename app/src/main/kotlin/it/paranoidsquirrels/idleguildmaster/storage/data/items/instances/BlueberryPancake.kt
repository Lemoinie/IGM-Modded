package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class BlueberryPancake : Food() {
    override fun configureProperties() {
        idName = R.string.food_blueberry_pancake_name
        idDescription = R.string.food_blueberry_pancake_description
        idImage = R.drawable.blueberry_pancake
        price = 8L
        feedPower = 17
    }
}
