package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class BlackIronHelm : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_black_iron_helm_name
        idDescription = R.string.accessory_black_iron_helm_description
        idImage = R.drawable.black_iron_helm
        price = 279L
        maxHp = 100
    }
}
