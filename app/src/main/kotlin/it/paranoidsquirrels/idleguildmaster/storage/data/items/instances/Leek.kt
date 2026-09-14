package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class Leek : Food() {
    override fun configureProperties() {
        idName = R.string.food_leek_name
        idDescription = R.string.food_leek_description
        idImage = R.drawable.leek
        source.add(R.string.dungeon_name_enchanted_forest)
        price = 1L
        feedPower = 2
    }
}
