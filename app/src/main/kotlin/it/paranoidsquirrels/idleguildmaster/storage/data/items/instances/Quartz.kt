package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class Quartz : Item() {
    override fun configureProperties() {
        idName = R.string.item_quartz_name
        idDescription = R.string.item_quartz_description
        idImage = R.drawable.quartz
        source.add(R.string.dungeon_name_the_desert)
        source.add(R.string.raid_name_divine_archeology)
        price = 5L
    }
}
