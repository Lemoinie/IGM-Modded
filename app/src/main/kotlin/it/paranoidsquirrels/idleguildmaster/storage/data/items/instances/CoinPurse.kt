package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class CoinPurse : Item() {
    override fun configureProperties() {
        idName = R.string.item_coin_purse_name
        idDescription = R.string.item_coin_purse_description
        idImage = R.drawable.coin_purse
        source.add(R.string.dungeon_name_blackwater_port)
        price = 2250L
    }
}
