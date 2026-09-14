package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class VeilShatterer : Item() {
    override fun configureProperties() {
        idName = R.string.item_veil_shatterer_name
        idDescription = R.string.item_veil_shatterer_description
        idImage = R.drawable.veil_shatterer
        price = 90L
    }
}
