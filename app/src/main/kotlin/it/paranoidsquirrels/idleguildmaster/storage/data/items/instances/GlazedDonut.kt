package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class GlazedDonut : Food() {
    override fun configureProperties() {
        idName = R.string.food_glazed_donut_name
        idDescription = R.string.food_glazed_donut_description
        idImage = R.drawable.glazed_donut
        price = 45L
        feedPower = 600
    }
}
