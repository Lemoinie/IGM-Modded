package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class Cookie : Food() {
    override fun configureProperties() {
        idName = R.string.food_cookie_name
        idDescription = R.string.food_cookie_description
        idImage = R.drawable.cookie
        price = 21L
        feedPower = 29
    }
}
