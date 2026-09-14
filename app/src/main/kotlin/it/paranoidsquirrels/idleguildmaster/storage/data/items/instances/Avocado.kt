package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class Avocado : Food() {
    override fun configureProperties() {
        idName = R.string.food_avocado_name
        idDescription = R.string.food_avocado_description
        idImage = R.drawable.avocado
        source.add(R.string.dungeon_name_the_southern_grove)
        price = 20L
        feedPower = 36
    }
}
