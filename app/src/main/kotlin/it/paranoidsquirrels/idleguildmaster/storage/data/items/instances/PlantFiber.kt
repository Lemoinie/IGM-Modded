package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class PlantFiber : Item() {
    override fun configureProperties() {
        idName = R.string.item_plant_fiber_name
        idDescription = R.string.item_plant_fiber_description
        idImage = R.drawable.plant_fiber
        source.add(R.string.dungeon_name_enchanted_forest)
        price = 2L
    }
}
