package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class CleansingPotion : Item() {
    override fun configureProperties() {
        idName = R.string.item_cleansing_potion_name
        idDescription = R.string.item_cleansing_potion_description
        idImage = R.drawable.cleansing_potion
        price = 375L
    }
}
