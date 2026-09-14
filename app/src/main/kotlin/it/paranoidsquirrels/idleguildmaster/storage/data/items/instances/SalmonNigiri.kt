package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class SalmonNigiri : Food() {
    override fun configureProperties() {
        idName = R.string.food_salmon_nigiri_name
        idDescription = R.string.food_salmon_nigiri_description
        idImage = R.drawable.salmon_nigiri
        price = 18L
        feedPower = 54
    }
}
