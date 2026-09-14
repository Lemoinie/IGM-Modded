package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class MushroomOmelette : Food() {
    override fun configureProperties() {
        idName = R.string.food_mushroom_omelette_name
        idDescription = R.string.food_mushroom_omelette_description
        idImage = R.drawable.mushroom_omelette
        price = 17L
        feedPower = 41
    }
}
