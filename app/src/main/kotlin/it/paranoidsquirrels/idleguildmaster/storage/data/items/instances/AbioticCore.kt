package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class AbioticCore : Item() {
    override fun configureProperties() {
        idName = R.string.item_abiotic_core_name
        idDescription = R.string.item_abiotic_core_description
        idImage = R.drawable.abiotic_core
        source.add(R.string.raid_name_kaunis)
        price = 2000L
    }
}
