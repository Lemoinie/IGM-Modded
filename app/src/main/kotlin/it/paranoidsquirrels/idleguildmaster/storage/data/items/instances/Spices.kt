package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class Spices : Food() {
    override fun configureProperties() {
        idName = R.string.food_spices_name
        idDescription = R.string.food_spices_description
        idImage = R.drawable.spices
        source.add(R.string.dungeon_name_enchanted_forest)
        price = 3L
        feedPower = 1
    }
}
