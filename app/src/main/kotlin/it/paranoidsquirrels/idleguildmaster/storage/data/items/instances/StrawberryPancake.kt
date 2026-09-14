package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class StrawberryPancake : Food() {
    override fun configureProperties() {
        idName = R.string.food_strawberry_pancake_name
        idDescription = R.string.food_strawberry_pancake_description
        idImage = R.drawable.strawberry_pancake
        price = 8L
        feedPower = 22
    }
}
