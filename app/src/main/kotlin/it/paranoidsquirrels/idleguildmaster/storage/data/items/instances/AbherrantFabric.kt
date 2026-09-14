package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class AbherrantFabric : Item() {
    override fun configureProperties() {
        idName = R.string.item_aberrant_fabric_name
        idDescription = R.string.item_aberrant_fabric_description
        idImage = R.drawable.abherrant_fabric
        source.add(R.string.raid_name_the_lost_expedition)
        price = 20L
    }
}
