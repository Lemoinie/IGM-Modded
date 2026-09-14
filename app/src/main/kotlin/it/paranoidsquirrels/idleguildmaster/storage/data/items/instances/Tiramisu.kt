package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class Tiramisu : Food() {
    override fun configureProperties() {
        idName = R.string.food_tiramisu_name
        idDescription = R.string.food_tiramisu_description
        idImage = R.drawable.tiramisu
        price = 426L
        feedPower = 1107
    }
}
