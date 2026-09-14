package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class NightwingLeather : Item() {
    override fun configureProperties() {
        idName = R.string.item_nightwing_leather_name
        idDescription = R.string.item_nightwing_leather_description
        idImage = R.drawable.nightwing_leather
        price = 9L
    }
}
