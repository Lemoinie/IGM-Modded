package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class SunfireEssence : Item() {
    override fun configureProperties() {
        idName = R.string.item_sunfire_essence_name
        idDescription = R.string.item_sunfire_essence_description
        idImage = R.drawable.sunfire_essence
        price = 950L
    }
}
