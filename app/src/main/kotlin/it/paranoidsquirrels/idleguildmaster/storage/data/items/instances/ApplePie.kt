package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class ApplePie : Food() {
    override fun configureProperties() {
        idName = R.string.food_apple_pie_name
        idDescription = R.string.food_apple_pie_description
        idImage = R.drawable.apple_pie
        price = 51L
        feedPower = 122
    }
}
