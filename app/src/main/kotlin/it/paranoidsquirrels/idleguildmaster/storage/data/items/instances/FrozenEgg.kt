package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class FrozenEgg : Item() {
    override fun configureProperties() {
        idName = R.string.item_frozen_egg_name
        idDescription = R.string.item_frozen_egg_description
        idImage = R.drawable.frozen_egg
        source.add(R.string.dungeon_name_frostbite_peaks)
        price = 160L
    }
}
