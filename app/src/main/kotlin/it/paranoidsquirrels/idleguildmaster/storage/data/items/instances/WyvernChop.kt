package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class WyvernChop : Food() {
    override fun configureProperties() {
        idName = R.string.food_wyvern_chop_name
        idDescription = R.string.food_wyvern_chop_description
        idImage = R.drawable.wyvern_chop
        source.add(R.string.dungeon_name_frostbite_peaks)
        price = 1L
        feedPower = 75
    }
}
