package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class Milk : Food() {
    override fun configureProperties() {
        idName = R.string.food_milk_name
        idDescription = R.string.food_milk_description
        idImage = R.drawable.milk
        source.add(R.string.dungeon_name_the_desert)
        source.add(R.string.raid_name_divine_archeology)
        price = 1L
        feedPower = 2
    }
}
