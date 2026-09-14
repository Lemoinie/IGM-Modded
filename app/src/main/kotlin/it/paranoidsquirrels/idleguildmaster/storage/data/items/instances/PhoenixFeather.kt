package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class PhoenixFeather : Item() {
    override fun configureProperties() {
        idName = R.string.item_phoenix_feather_name
        idDescription = R.string.item_phoenix_feather_description
        idImage = R.drawable.phoenix_feather
        source.add(R.string.raid_name_the_tower)
        price = 825L
    }
}
