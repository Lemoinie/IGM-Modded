package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class SpiderSilk : Item() {
    override fun configureProperties() {
        idName = R.string.item_spider_silk_name
        idDescription = R.string.item_spider_silk_description
        idImage = R.drawable.spider_silk
        price = 18L
    }
}
