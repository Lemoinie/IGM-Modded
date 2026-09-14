package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class Ambrosia : Food() {
    override fun configureProperties() {
        idName = R.string.food_ambrosia_name
        idDescription = R.string.food_ambrosia_description
        idImage = R.drawable.ambrosia
        price = 1000L
        feedPower = 13500
    }
}
