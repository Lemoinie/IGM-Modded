package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class DeepSeaVelvet : Item() {
    override fun configureProperties() {
        idName = R.string.item_deep_sea_velvet_name
        idDescription = R.string.item_deep_sea_velvet_description
        idImage = R.drawable.deep_sea_velvet
        price = 1835L
    }
}
