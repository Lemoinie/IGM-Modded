package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class HeartOfDarkness : Item() {
    override fun configureProperties() {
        idName = R.string.item_heart_of_darkness_name
        idDescription = R.string.item_heart_of_darkness_description
        idImage = R.drawable.heart_of_darkness
        source.add(R.string.raid_name_the_tower)
        price = 1500L
    }
}
