package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class EldritchSeal : Item() {
    override fun configureProperties() {
        idName = R.string.item_eldritch_seal_name
        idDescription = R.string.item_eldritch_seal_description
        idImage = R.drawable.eldritch_seal
        price = 893L
    }
}
