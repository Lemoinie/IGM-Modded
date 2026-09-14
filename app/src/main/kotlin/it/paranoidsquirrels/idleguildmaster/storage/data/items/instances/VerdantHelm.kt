package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class VerdantHelm : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_verdant_helm_name
        idDescription = R.string.accessory_verdant_helm_description
        idImage = R.drawable.verdant_helm
        price = 372L
        maxHp = 160
    }
}
