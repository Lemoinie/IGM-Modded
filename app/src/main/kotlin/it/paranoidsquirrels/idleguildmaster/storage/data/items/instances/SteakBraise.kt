package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class SteakBraise : Food() {
    override fun configureProperties() {
        idName = R.string.food_steak_braise_name
        idDescription = R.string.food_steak_braise_description
        idImage = R.drawable.steak_braise
        price = 24L
        feedPower = 65
    }
}
