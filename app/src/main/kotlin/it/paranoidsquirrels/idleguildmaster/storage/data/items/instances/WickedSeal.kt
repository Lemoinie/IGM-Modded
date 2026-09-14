package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class WickedSeal : Item() {
    override fun configureProperties() {
        idName = R.string.item_wicked_seal_name
        idDescription = R.string.item_wicked_seal_description
        idImage = R.drawable.wicked_seal
        source.add(R.string.dungeon_name_hidden_city_of_larox)
        price = 250L
    }
}
