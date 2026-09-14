package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class SinisterStabilizer : Item() {
    override fun configureProperties() {
        idName = R.string.item_sinister_stabilizer_name
        idDescription = R.string.item_sinister_stabilizer_description
        idImage = R.drawable.sinister_stabilizer
        price = 885L
    }
}
