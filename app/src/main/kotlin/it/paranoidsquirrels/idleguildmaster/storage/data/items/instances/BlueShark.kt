package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class BlueShark : Food() {
    override fun configureProperties() {
        idName = R.string.food_blue_shark_name
        idDescription = R.string.food_blue_shark_description
        idImage = R.drawable.blue_shark
        price = 120L
        feedPower = 60
    }
}