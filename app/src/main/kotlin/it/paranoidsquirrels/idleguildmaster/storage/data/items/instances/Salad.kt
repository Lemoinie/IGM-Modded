package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class Salad : Food() {
    override fun configureProperties() {
        idName = R.string.food_salad_name
        idDescription = R.string.food_salad_description
        idImage = R.drawable.salad
        price = 20L
        feedPower = 33
    }
}
