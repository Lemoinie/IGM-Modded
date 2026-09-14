package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class ScarletStrand : Item() {
    override fun configureProperties() {
        idName = R.string.item_scarlet_strand_name
        idDescription = R.string.item_scarlet_strand_description
        idImage = R.drawable.scarlet_strand
        price = 20000L
    }
}
