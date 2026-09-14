package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class DeviledEggs : Food() {
    override fun configureProperties() {
        idName = R.string.food_deviled_eggs_name
        idDescription = R.string.food_deviled_eggs_description
        idImage = R.drawable.deviled_eggs
        price = 129L
        feedPower = 238
    }
}
