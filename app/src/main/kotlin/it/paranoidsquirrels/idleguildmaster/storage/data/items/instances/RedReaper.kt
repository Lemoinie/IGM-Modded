package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class RedReaper : Food() {
    override fun configureProperties() {
        idName = R.string.food_red_reaper_name
        idDescription = R.string.food_red_reaper_description
        idImage = R.drawable.red_reaper
        source.add(R.string.dungeon_name_the_golden_city)
        source.add(R.string.raid_name_imperial_rescue)
        price = 10L
        feedPower = 2
    }
}
