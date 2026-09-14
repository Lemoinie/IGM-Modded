package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class PearPie : Food() {
    override fun configureProperties() {
        idName = R.string.food_pear_pie_name
        idDescription = R.string.food_pear_pie_description
        idImage = R.drawable.pear_pie
        price = 51L
        feedPower = 139
    }
}
