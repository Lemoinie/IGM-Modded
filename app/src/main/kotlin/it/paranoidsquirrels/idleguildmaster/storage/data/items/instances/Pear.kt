package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class Pear : Food() {
    override fun configureProperties() {
        idName = R.string.food_pear_name
        idDescription = R.string.food_pear_description
        idImage = R.drawable.pear
        price = 1L
        feedPower = 3
    }
}
