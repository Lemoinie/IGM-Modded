package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class VeilBreaker : Item() {
    override fun configureProperties() {
        idName = R.string.item_veil_breaker_name
        idDescription = R.string.item_veil_breaker_description
        idImage = R.drawable.veil_breaker
        source.add(R.string.dungeon_name_hidden_city_of_larox)
        price = 20L
    }
}
