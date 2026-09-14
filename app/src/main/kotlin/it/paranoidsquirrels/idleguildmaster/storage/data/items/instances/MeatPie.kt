package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class MeatPie : Food() {
    override fun configureProperties() {
        idName = R.string.food_meat_pie_name
        idDescription = R.string.food_meat_pie_description
        idImage = R.drawable.meat_pie
        price = 35L
        feedPower = 115
    }
}
