package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class Perch : Food() {
    override fun configureProperties() {
        idName = R.string.food_perch_name
        idDescription = R.string.food_perch_description
        idImage = R.drawable.perch
        price = 20L
        feedPower = 10
    }
}