package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class HellishRations : Food() {
    override fun configureProperties() {
        idName = R.string.food_hellish_rations_name
        idDescription = R.string.food_hellish_rations_description
        idImage = R.drawable.hellish_ration
        source.add(R.string.dungeon_name_hidden_city_of_larox)
        price = 50L
        feedPower = 106
    }
}
