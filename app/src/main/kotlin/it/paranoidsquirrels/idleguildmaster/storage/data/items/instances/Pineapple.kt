package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class Pineapple : Food() {
    override fun configureProperties() {
        idName = R.string.food_pineapple_name
        idDescription = R.string.food_pineapple_description
        idImage = R.drawable.pineapple
        source.add(R.string.dungeon_name_the_desert)
        source.add(R.string.raid_name_divine_archeology)
        price = 3L
        feedPower = 8
    }
}
