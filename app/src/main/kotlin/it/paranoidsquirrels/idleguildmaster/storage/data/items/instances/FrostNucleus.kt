package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class FrostNucleus : Item() {
    override fun configureProperties() {
        idName = R.string.item_frost_nucleus_name
        idDescription = R.string.item_frost_nucleus_description
        idImage = R.drawable.frost_nucleus
        source.add(R.string.dungeon_name_frostbite_peaks)
        price = 80L
    }
}
