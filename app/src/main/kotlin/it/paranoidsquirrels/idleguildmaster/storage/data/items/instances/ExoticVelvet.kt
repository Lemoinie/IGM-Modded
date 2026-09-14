package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class ExoticVelvet : Item() {
    override fun configureProperties() {
        idName = R.string.item_exotic_velvet_name
        idDescription = R.string.item_exotic_velvet_description
        idImage = R.drawable.exotic_velvet
        source.add(R.string.dungeon_name_blackwater_port)
        price = 30L
    }
}
