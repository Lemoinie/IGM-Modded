package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class BlueTrout : Food() {
    override fun configureProperties() {
        idName = R.string.food_blue_trout_name
        idDescription = R.string.food_blue_trout_description
        idImage = R.drawable.blue_trout
        price = 36L
        feedPower = 18
    }
}