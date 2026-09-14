package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class SentientSlab : Item() {
    override fun configureProperties() {
        idName = R.string.item_sentient_slab_name
        idDescription = R.string.item_sentient_slab_description
        idImage = R.drawable.sentient_slab
        source.add(R.string.raid_name_the_cultist_rebels)
        price = 150L
    }
}
