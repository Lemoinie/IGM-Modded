package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class IronHelm : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_iron_helm_name
        idDescription = R.string.accessory_iron_helm_description
        idImage = R.drawable.iron_helm
        price = 39L
        maxHp = 40
    }
}
