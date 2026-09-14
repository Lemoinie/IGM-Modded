package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class GourmetIcecream : Food() {
    override fun configureProperties() {
        idName = R.string.food_gourmet_icecream_name
        idDescription = R.string.food_gourmet_icecream_description
        idImage = R.drawable.gourmet_icecream
        price = 100L
        feedPower = 1350
    }
}
