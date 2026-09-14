package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class ExoticFruitSalad : Food() {
    override fun configureProperties() {
        idName = R.string.food_exotic_fruit_salad_name
        idDescription = R.string.food_exotic_fruit_salad_description
        idImage = R.drawable.exotic_fruit_salad
        price = 23L
        feedPower = 46
    }
}
