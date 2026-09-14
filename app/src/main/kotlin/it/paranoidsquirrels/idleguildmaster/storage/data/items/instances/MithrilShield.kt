package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class MithrilShield : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_mithril_shield_name
        idDescription = R.string.accessory_mithril_shield_description
        idImage = R.drawable.mithril_shield
        price = 810L
        constitution = 33
    }
}
