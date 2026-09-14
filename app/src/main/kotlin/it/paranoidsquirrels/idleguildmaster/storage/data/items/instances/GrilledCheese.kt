package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class GrilledCheese : Food() {
    override fun configureProperties() {
        idName = R.string.food_grilled_cheese_name
        idDescription = R.string.food_grilled_cheese_description
        idImage = R.drawable.grilled_cheese
        price = 30L
        feedPower = 60
    }
}
