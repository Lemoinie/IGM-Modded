package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class GiftOfLight : Item() {
    override fun configureProperties() {
        idName = R.string.item_gift_of_light_name
        idDescription = R.string.item_gift_of_light_description
        idImage = R.drawable.gift_of_light
        source.add(R.string.raid_name_the_tower)
        price = 1250L
    }
}
