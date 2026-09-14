package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class SalmonRoll : Food() {
    override fun configureProperties() {
        idName = R.string.food_salmon_roll_name
        idDescription = R.string.food_salmon_roll_description
        idImage = R.drawable.salmon_roll
        price = 47L
        feedPower = 65
    }
}
