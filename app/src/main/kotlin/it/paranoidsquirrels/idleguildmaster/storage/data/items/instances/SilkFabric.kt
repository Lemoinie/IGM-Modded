package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class SilkFabric : Item() {
    override fun configureProperties() {
        idName = R.string.item_silk_fabric_name
        idDescription = R.string.item_silk_fabric_description
        idImage = R.drawable.silk_fabric
        price = 12L
    }
}
