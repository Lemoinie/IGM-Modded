package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class FireproofOil : Item() {
    override fun configureProperties() {
        idName = R.string.item_fireproof_oil_name
        idDescription = R.string.item_fireproof_oil_description
        idImage = R.drawable.fireproof_oil
        source.add(R.string.raid_name_kaunis)
        price = 100L
    }
}
