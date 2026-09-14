package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class GreenSlime : Item() {
    override fun configureProperties() {
        idName = R.string.item_green_slime_name
        idDescription = R.string.item_green_slime_description
        idImage = R.drawable.green_slime
        source.add(R.string.raid_name_the_slime_pond)
        price = 3L
    }
}
