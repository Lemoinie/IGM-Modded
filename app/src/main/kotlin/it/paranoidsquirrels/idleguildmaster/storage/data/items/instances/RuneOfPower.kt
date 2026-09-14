package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class RuneOfPower : Item() {
    override fun configureProperties() {
        idName = R.string.item_rune_of_power_name
        idDescription = R.string.item_rune_of_power_description
        idImage = R.drawable.rune_of_power
        source.add(R.string.dungeon_name_hidden_city_of_larox)
        price = 100L
    }
}
