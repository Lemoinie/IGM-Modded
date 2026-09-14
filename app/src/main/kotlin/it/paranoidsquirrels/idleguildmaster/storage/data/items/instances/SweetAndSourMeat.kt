package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class SweetAndSourMeat : Food() {
    override fun configureProperties() {
        idName = R.string.food_sweet_and_sour_meat_name
        idDescription = R.string.food_sweet_and_sour_meat_description
        idImage = R.drawable.sweet_and_sour_meat
        price = 21L
        feedPower = 38
    }
}
