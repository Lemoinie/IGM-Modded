package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class KabelianMetal : Item() {
    override fun configureProperties() {
        idName = R.string.item_kabelian_metal_name
        idDescription = R.string.item_kabelian_metal_description
        idImage = R.drawable.kabelian_metal
        source.add(R.string.raid_name_the_cultist_rebels)
        price = 80L
    }
}
