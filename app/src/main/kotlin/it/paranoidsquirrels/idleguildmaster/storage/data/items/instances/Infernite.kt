package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class Infernite : Item() {
    override fun configureProperties() {
        idName = R.string.item_infernite_name
        idDescription = R.string.item_infernite_description
        idImage = R.drawable.infernite
        source.add(R.string.dungeon_name_lost_lands)
        price = 125L
    }
}
