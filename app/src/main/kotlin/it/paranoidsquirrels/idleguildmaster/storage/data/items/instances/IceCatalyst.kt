package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class IceCatalyst : Item() {
    override fun configureProperties() {
        idName = R.string.item_ice_catalyst_name
        idDescription = R.string.item_ice_catalyst_description
        idImage = R.drawable.ice_catalyst
        price = 212L
    }
}
