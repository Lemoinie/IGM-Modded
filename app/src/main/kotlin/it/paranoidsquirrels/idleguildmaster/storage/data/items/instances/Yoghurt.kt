package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class Yoghurt : Food() {
    override fun configureProperties() {
        idName = R.string.food_yoghurt_name
        idDescription = R.string.food_yoghurt_description
        idImage = R.drawable.yoghurt
        price = 5L
        feedPower = 10
    }
}
