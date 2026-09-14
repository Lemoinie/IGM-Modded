package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class WhiteSlime : Item() {
    override fun configureProperties() {
        idName = R.string.item_white_slime_name
        idDescription = R.string.item_white_slime_description
        idImage = R.drawable.white_slime
        source.add(R.string.raid_name_the_tower)
        price = 650L
    }
}
