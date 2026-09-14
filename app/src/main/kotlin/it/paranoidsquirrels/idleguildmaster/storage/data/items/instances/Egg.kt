package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class Egg : Food() {
    override fun configureProperties() {
        idName = R.string.food_egg_name
        idDescription = R.string.food_egg_description
        idImage = R.drawable.egg
        source.add(R.string.dungeon_name_the_desert)
        source.add(R.string.dungeon_name_the_southern_grove)
        price = 2L
        feedPower = 10
    }
}
