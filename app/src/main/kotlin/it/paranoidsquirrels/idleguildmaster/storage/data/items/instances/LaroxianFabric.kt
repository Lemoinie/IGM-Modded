package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class LaroxianFabric : Item() {
    override fun configureProperties() {
        idName = R.string.item_laroxian_fabric_name
        idDescription = R.string.item_laroxian_fabric_description
        idImage = R.drawable.laroxian_fabric
        source.add(R.string.dungeon_name_hidden_city_of_larox)
        price = 2L
    }
}
