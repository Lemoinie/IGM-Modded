package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class MeatyMushroom : Food() {
    override fun configureProperties() {
        idName = R.string.food_meaty_mushroom_name
        idDescription = R.string.food_meaty_mushroom_description
        idImage = R.drawable.meaty_mushroom
        source.add(R.string.dungeon_name_the_southern_grove)
        price = 5L
        feedPower = 22
    }
}
