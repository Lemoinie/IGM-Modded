package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class MeatChop : Food() {
    override fun configureProperties() {
        idName = R.string.food_meat_chop_name
        idDescription = R.string.food_meat_chop_description
        idImage = R.drawable.meat_chop
        source.add(R.string.dungeon_name_enchanted_forest)
        price = 2L
        feedPower = 10
    }
}
