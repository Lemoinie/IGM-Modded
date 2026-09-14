package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class MushroomRisotto : Food() {
    override fun configureProperties() {
        idName = R.string.food_mushroom_risotto_name
        idDescription = R.string.food_mushroom_risotto_description
        idImage = R.drawable.mushroom_risotto
        price = 65L
        feedPower = 227
    }
}
