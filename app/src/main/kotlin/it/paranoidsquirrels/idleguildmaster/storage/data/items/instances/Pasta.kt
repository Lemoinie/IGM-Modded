package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class Pasta : Food() {
    override fun configureProperties() {
        idName = R.string.food_pasta_name
        idDescription = R.string.food_pasta_description
        idImage = R.drawable.pasta
        price = 24L
        feedPower = 59
    }
}
