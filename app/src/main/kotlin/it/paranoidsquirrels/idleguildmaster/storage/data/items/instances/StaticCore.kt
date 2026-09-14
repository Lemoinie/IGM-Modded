package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class StaticCore : Item() {
    override fun configureProperties() {
        idName = R.string.item_static_core_name
        idDescription = R.string.item_static_core_description
        idImage = R.drawable.static_core
        source.add(R.string.raid_name_the_slime_pond)
        price = 50L
    }
}
