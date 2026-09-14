package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class FleetfootFabric : Item() {
    override fun configureProperties() {
        idName = R.string.item_fleetfoot_fabric_name
        idDescription = R.string.item_fleetfoot_fabric_description
        idImage = R.drawable.fleetfoot_fabric
        source.add(R.string.dungeon_name_the_southern_grove)
        price = 9L
    }
}
