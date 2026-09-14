package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class SpiderBoots : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_spider_boots_name
        idDescription = R.string.accessory_spider_boots_description
        idImage = R.drawable.spider_boots
        price = 378L
        dexterity = 21
    }
}
