package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class MysteriousCog : Item() {
    override fun configureProperties() {
        idName = R.string.item_mysterious_cog_name
        idDescription = R.string.item_mysterious_cog_description
        idImage = R.drawable.mysterious_cog
        source.add(R.string.raid_name_the_tower)
        price = 2000L
    }
}
