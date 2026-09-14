package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class Banana : Food() {
    override fun configureProperties() {
        idName = R.string.food_banana_name
        idDescription = R.string.food_banana_description
        idImage = R.drawable.banana
        source.add(R.string.dungeon_name_blackwater_port)
        price = 2L
        feedPower = 8
    }
}
