package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class Pumpkin : Food() {
    override fun configureProperties() {
        idName = R.string.food_pumpkin_name
        idDescription = R.string.food_pumpkin_description
        idImage = R.drawable.pumpkin
        source.add(R.string.dungeon_name_hidden_city_of_larox)
        price = 15L
        feedPower = 24
    }
}
