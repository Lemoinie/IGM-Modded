package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class SpiritCandle : Item() {
    override fun configureProperties() {
        idName = R.string.item_spirit_candle_name
        idDescription = R.string.item_spirit_candle_description
        idImage = R.drawable.spirit_candle
        source.add(R.string.dungeon_name_eternal_battlefield)
        price = 20L
    }
}
