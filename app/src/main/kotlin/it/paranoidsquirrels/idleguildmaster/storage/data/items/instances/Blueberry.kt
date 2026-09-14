package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class Blueberry : Food() {
    override fun configureProperties() {
        idName = R.string.food_blueberry_name
        idDescription = R.string.food_blueberry_description
        idImage = R.drawable.blueberry
        source.add(R.string.dungeon_name_frostbite_peaks)
        price = 1L
        feedPower = 8
    }
}
