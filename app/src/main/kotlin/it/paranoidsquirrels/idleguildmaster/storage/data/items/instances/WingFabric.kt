package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class WingFabric : Item() {
    override fun configureProperties() {
        idName = R.string.item_wing_fabric_name
        idDescription = R.string.item_wing_fabric_description
        idImage = R.drawable.wing_fabric
        price = 18L
    }
}
