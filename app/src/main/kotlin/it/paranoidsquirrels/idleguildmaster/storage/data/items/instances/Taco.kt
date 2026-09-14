package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class Taco : Food() {
    override fun configureProperties() {
        idName = R.string.food_taco_name
        idDescription = R.string.food_taco_description
        idImage = R.drawable.taco
        price = 78L
        feedPower = 184
    }
}
