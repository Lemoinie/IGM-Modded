package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class IceFiber : Item() {
    override fun configureProperties() {
        idName = R.string.item_ice_fiber_name
        idDescription = R.string.item_ice_fiber_description
        idImage = R.drawable.ice_fiber
        source.add(R.string.dungeon_name_frostbite_peaks)
        price = 3L
    }
}
