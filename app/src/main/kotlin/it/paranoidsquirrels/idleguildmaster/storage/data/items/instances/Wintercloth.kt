package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class Wintercloth : Item() {
    override fun configureProperties() {
        idName = R.string.item_wintercloth_name
        idDescription = R.string.item_wintercloth_description
        idImage = R.drawable.wintercloth
        price = 18L
    }
}
