package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class CorsairLeather : Item() {
    override fun configureProperties() {
        idName = R.string.item_corsair_leather_name
        idDescription = R.string.item_corsair_leather_description
        idImage = R.drawable.corsair_leather
        price = 9L
    }
}
