package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class WinterHelm : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_winter_helm_name
        idDescription = R.string.accessory_winter_helm_description
        idImage = R.drawable.winter_helm
        price = 378L
        maxHp = 120
    }
}
