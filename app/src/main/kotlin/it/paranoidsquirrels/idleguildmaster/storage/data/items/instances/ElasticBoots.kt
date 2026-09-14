package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class ElasticBoots : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_elastic_boots_name
        idDescription = R.string.accessory_elastic_boots_description
        idImage = R.drawable.elastic_boots
        price = 312L
        dexterity = 27
    }
}
