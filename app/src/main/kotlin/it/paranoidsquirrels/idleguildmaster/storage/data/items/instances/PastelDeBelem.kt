package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class PastelDeBelem : Food() {
    override fun configureProperties() {
        idName = R.string.food_pastel_de_belem_name
        idDescription = R.string.food_pastel_de_belem_description
        idImage = R.drawable.pastel_de_belem
        price = 300L
        feedPower = 1000
    }
}
