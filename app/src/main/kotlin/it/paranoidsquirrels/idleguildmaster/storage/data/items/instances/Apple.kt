package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class Apple : Food() {
    override fun configureProperties() {
        idName = R.string.food_apple_name
        idDescription = R.string.food_apple_description
        idImage = R.drawable.apple
        source.add(R.string.dungeon_name_enchanted_forest)
        price = 1L
        feedPower = 4
    }
}
