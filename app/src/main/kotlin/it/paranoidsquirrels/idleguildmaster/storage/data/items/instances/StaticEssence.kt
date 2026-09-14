package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class StaticEssence : Item() {
    override fun configureProperties() {
        idName = R.string.item_static_essence_name
        idDescription = R.string.item_static_essence_description
        idImage = R.drawable.static_essence
        price = 950L
    }
}
