package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class MeatStew : Food() {
    override fun configureProperties() {
        idName = R.string.food_meat_stew_name
        idDescription = R.string.food_meat_stew_description
        idImage = R.drawable.meat_stew
        price = 42L
        feedPower = 168
    }
}
