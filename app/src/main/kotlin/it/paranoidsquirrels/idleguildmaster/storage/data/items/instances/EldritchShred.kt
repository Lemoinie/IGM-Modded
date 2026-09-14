package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class EldritchShred : Item() {
    override fun configureProperties() {
        idName = R.string.item_eldritch_shred_name
        idDescription = R.string.item_eldritch_shred_description
        idImage = R.drawable.eldritch_shred
        source.add(R.string.raid_name_the_lost_expedition)
        price = 85L
    }
}
