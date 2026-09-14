package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class Vinegar : Food() {
    override fun configureProperties() {
        idName = R.string.food_vinegar_name
        idDescription = R.string.food_vinegar_description
        idImage = R.drawable.vinegar
        source.add(R.string.dungeon_name_the_golden_city)
        source.add(R.string.raid_name_imperial_rescue)
        price = 7L
        feedPower = 1
    }
}
