package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class RedReaperSauce : Food() {
    override fun configureProperties() {
        idName = R.string.food_red_reaper_sauce_name
        idDescription = R.string.food_red_reaper_sauce_description
        idImage = R.drawable.red_reaper_sauce
        price = 80L
        feedPower = 128
    }
}
