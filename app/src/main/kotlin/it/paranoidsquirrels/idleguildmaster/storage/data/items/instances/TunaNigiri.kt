package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class TunaNigiri : Food() {
    override fun configureProperties() {
        idName = R.string.food_tuna_nigiri_name
        idDescription = R.string.food_tuna_nigiri_description
        idImage = R.drawable.tuna_nigiri
        price = 26L
        feedPower = 74
    }
}
