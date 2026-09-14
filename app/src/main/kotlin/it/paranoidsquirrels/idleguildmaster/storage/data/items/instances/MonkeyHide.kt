package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class MonkeyHide : Item() {
    override fun configureProperties() {
        idName = R.string.item_monkey_hide_name
        idDescription = R.string.item_monkey_hide_description
        idImage = R.drawable.monkey_hide
        source.add(R.string.dungeon_name_blackwater_port)
        price = 3L
    }
}
