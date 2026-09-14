package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class MushroomStew : Food() {
    override fun configureProperties() {
        idName = R.string.food_mushroom_stew_name
        idDescription = R.string.food_mushroom_stew_description
        idImage = R.drawable.mushroom_stew
        price = 54L
        feedPower = 217
    }
}
