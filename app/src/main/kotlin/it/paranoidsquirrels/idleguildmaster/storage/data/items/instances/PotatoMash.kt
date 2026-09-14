package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class PotatoMash : Food() {
    override fun configureProperties() {
        idName = R.string.food_potato_mash_name
        idDescription = R.string.food_potato_mash_description
        idImage = R.drawable.potato_mash
        price = 9L
        feedPower = 27
    }
}
