package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class HeavenAndHell : Food() {
    override fun configureProperties() {
        idName = R.string.food_heaven_and_hell_name
        idDescription = R.string.food_heaven_and_hell_description
        idImage = R.drawable.heaven_and_hell
        price = 167L
        feedPower = 362
    }
}
