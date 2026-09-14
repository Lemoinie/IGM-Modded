package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class SealOfClaris : Item() {
    override fun configureProperties() {
        idName = R.string.item_seal_of_claris_name
        idDescription = R.string.item_seal_of_claris_description
        idImage = R.drawable.seal_of_claris
        source.add(R.string.raid_name_the_cultist_rebels)
        price = 6500L
    }
}
