package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class CeremonialCake : Food() {
    override fun configureProperties() {
        idName = R.string.food_ceremonial_cake_name
        idDescription = R.string.food_ceremonial_cake_description
        idImage = R.drawable.ceremonial_cake
        price = 2200L
        feedPower = 30000
    }
}
