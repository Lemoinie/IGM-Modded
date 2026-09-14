package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class KaunianFabric : Item() {
    override fun configureProperties() {
        idName = R.string.item_kaunian_fabric_name
        idDescription = R.string.item_kaunian_fabric_description
        idImage = R.drawable.kaunian_fabric
        source.add(R.string.raid_name_kaunis)
        price = 25L
    }
}
