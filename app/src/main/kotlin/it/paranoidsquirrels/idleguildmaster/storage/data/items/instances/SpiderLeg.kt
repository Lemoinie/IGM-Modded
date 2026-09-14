package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class SpiderLeg : Item() {
    override fun configureProperties() {
        idName = R.string.item_spider_leg_name
        idDescription = R.string.item_spider_leg_description
        idImage = R.drawable.spider_leg
        source.add(R.string.dungeon_name_obsidian_mines)
        price = 2L
    }
}
