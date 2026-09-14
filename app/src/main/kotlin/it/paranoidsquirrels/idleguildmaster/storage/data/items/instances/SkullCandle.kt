package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class SkullCandle : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_skull_candle_name
        idDescription = R.string.accessory_skull_candle_description
        idEffect = R.string.accessory_skull_candle_effect
        idImage = R.drawable.skull_candle
        price = 69L
        intelligence = 4
        darknessReduction = 10
    }
}
