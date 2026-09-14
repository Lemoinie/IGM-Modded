package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class Ruby : Item() {
    override fun configureProperties() {
        idName = R.string.item_ruby_name
        idDescription = R.string.item_ruby_description
        idImage = R.drawable.ruby
        source.add(R.string.dungeon_name_the_golden_city)
        source.add(R.string.raid_name_imperial_rescue)
        price = 70L
    }
}
