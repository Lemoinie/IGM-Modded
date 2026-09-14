package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class Cheese : Food() {
    override fun configureProperties() {
        idName = R.string.food_cheese_name
        idDescription = R.string.food_cheese_description
        idImage = R.drawable.cheese
        source.add(R.string.dungeon_name_enchanted_forest)
        price = 8L
        feedPower = 9
    }
}
