package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class SpiderGloves : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_spider_gloves_name
        idDescription = R.string.accessory_spider_gloves_description
        idImage = R.drawable.spider_gloves
        price = 378L
        constitution = 17
        dexterity = 14
    }
}
