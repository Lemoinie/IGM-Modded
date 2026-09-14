package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class MascarponeCheese : Food() {
    override fun configureProperties() {
        idName = R.string.food_mascarpone_cheese_name
        idDescription = R.string.food_mascarpone_cheese_description
        idImage = R.drawable.mascarpone_cheese
        price = 59L
        feedPower = 143
    }
}
