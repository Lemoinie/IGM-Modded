package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class Bread : Food() {
    override fun configureProperties() {
        idName = R.string.food_bread_name
        idDescription = R.string.food_bread_description
        idImage = R.drawable.bread
        price = 12L
        feedPower = 18
    }
}
