package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class UnholyPotion : Item() {
    override fun configureProperties() {
        idName = R.string.item_unholy_potion_name
        idDescription = R.string.item_unholy_potion_description
        idImage = R.drawable.unholy_potion
        price = 666L
    }
}
