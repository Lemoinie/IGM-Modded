package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class Butter : Food() {
    override fun configureProperties() {
        idName = R.string.food_butter_name
        idDescription = R.string.food_butter_description
        idImage = R.drawable.butter
        price = 3L
        feedPower = 7
    }
}
