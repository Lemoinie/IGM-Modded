package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class SunfireCore : Item() {
    override fun configureProperties() {
        idName = R.string.item_sunfire_core_name
        idDescription = R.string.item_sunfire_core_description
        idImage = R.drawable.sunfire_core
        source.add(R.string.raid_name_the_slime_pond)
        price = 50L
    }
}
