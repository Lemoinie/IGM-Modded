package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class MithrilHelm : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_mithril_helm_name
        idDescription = R.string.accessory_mithril_helm_description
        idImage = R.drawable.mithril_helm
        price = 750L
        maxHp = 220
    }
}
