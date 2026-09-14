package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class FruitSalad : Food() {
    override fun configureProperties() {
        idName = R.string.food_fruit_salad_name
        idDescription = R.string.food_fruit_salad_description
        idImage = R.drawable.fruit_salad
        price = 9L
        feedPower = 26
    }
}
