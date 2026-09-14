package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class Maxxiburger : Food() {
    override fun configureProperties() {
        idName = R.string.food_maxxiburger_name
        idDescription = R.string.food_maxxiburger_description
        idImage = R.drawable.maxxiburger
        price = 220L
        feedPower = 3000
    }
}
