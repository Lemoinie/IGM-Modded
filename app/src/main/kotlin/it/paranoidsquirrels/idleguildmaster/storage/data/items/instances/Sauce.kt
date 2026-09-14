package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class Sauce : Food() {
    override fun configureProperties() {
        idName = R.string.food_sauce_name
        idDescription = R.string.food_sauce_description
        idImage = R.drawable.sauce
        price = 20L
        feedPower = 43
    }
}
