package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class TunaRoll : Food() {
    override fun configureProperties() {
        idName = R.string.food_tuna_roll_name
        idDescription = R.string.food_tuna_roll_description
        idImage = R.drawable.tuna_roll
        price = 54L
        feedPower = 78
    }
}
