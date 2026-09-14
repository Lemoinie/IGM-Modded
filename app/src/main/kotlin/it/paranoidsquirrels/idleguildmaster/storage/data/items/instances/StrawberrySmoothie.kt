package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class StrawberrySmoothie : Food() {
    override fun configureProperties() {
        idName = R.string.food_strawberry_smoothie_name
        idDescription = R.string.food_strawberry_smoothie_description
        idImage = R.drawable.strawberry_smoothie
        price = 38L
        feedPower = 102
    }
}
