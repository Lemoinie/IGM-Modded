package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class Chocolate : Food() {
    override fun configureProperties() {
        idName = R.string.food_chocolate_name
        idDescription = R.string.food_chocolate_description
        idImage = R.drawable.chocolate
        source.add(R.string.dungeon_name_the_golden_city)
        source.add(R.string.raid_name_imperial_rescue)
        price = 10L
        feedPower = 20
    }
}
