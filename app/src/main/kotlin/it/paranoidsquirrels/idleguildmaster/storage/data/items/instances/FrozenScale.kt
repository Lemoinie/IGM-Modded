package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class FrozenScale : Item() {
    override fun configureProperties() {
        idName = R.string.item_frozen_scale_name
        idDescription = R.string.item_frozen_scale_description
        idImage = R.drawable.frozen_scale
        source.add(R.string.dungeon_name_frostbite_peaks)
        price = 16L
    }
}
