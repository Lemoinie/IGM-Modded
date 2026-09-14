package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class Strawberry : Food() {
    override fun configureProperties() {
        idName = R.string.food_strawberry_name
        idDescription = R.string.food_strawberry_description
        idImage = R.drawable.strawberry
        source.add(R.string.dungeon_name_the_southern_grove)
        price = 1L
        feedPower = 3
    }
}
