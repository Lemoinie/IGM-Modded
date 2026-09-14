package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class Cheesecake : Food() {
    override fun configureProperties() {
        idName = R.string.food_cheesecake_name
        idDescription = R.string.food_cheesecake_description
        idImage = R.drawable.cheesecake
        price = 450L
        feedPower = 6375
    }
}
