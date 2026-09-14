package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class FrostCrystal : Item() {
    override fun configureProperties() {
        idName = R.string.item_frost_crystal_name
        idDescription = R.string.item_frost_crystal_description
        idImage = R.drawable.frost_crystal
        source.add(R.string.dungeon_name_frostbite_peaks)
        price = 16L
    }
}
