package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class Redwood : Item() {
    override fun configureProperties() {
        idName = R.string.item_redwood_name
        idDescription = R.string.item_redwood_description
        idImage = R.drawable.redwood
        source.add(R.string.dungeon_name_the_golden_city)
        source.add(R.string.raid_name_imperial_rescue)
        price = 2L
    }
}
