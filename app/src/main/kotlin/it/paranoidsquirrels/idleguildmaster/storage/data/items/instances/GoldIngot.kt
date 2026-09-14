package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class GoldIngot : Item() {
    override fun configureProperties() {
        idName = R.string.item_gold_ingot_name
        idDescription = R.string.item_gold_ingot_description
        idImage = R.drawable.gold_ingot
        price = 23L
    }
}
