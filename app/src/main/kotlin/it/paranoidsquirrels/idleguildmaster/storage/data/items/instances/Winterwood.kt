package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class Winterwood : Item() {
    override fun configureProperties() {
        idName = R.string.item_winterwood_name
        idDescription = R.string.item_winterwood_description
        idImage = R.drawable.winterwood
        source.add(R.string.dungeon_name_frostbite_peaks)
        price = 3L
    }
}
