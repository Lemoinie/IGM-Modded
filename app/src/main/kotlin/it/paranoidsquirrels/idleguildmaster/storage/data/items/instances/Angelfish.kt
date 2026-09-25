package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class Angelfish : Food() {
    override fun configureProperties() {
        idName = R.string.food_angelfish_name
        idDescription = R.string.food_angelfish_description
        idImage = R.drawable.angelfish
        price = 50L
        feedPower = 25
    }
}