package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class CheeseRisotto : Food() {
    override fun configureProperties() {
        idName = R.string.food_cheese_risotto_name
        idDescription = R.string.food_cheese_risotto_description
        idImage = R.drawable.cheese_risotto
        price = 44L
        feedPower = 130
    }
}
