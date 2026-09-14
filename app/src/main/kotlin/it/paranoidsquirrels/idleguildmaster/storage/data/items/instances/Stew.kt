package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class Stew : Food() {
    override fun configureProperties() {
        idName = R.string.food_stew_name
        idDescription = R.string.food_stew_description
        idImage = R.drawable.stew
        price = 23L
        feedPower = 60
    }
}
