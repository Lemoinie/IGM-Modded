package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor

class SpiderRobe : LightArmor() {
    override fun configureProperties() {
        idName = R.string.armor_light_spider_robe_name
        idDescription = R.string.armor_light_spider_robe_description
        idImage = R.drawable.spider_robe
        price = 540L
        maxHp = 70
        intelligence = 21
    }
}
