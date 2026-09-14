package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor

class ElasticRobe : LightArmor() {
    override fun configureProperties() {
        idName = R.string.armor_light_elastic_robe_name
        idDescription = R.string.armor_light_elastic_robe_description
        idImage = R.drawable.elastic_robe
        price = 444L
        maxHp = 90
        intelligence = 27
    }
}
