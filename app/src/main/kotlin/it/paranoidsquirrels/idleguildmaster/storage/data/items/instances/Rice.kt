package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class Rice : Food() {
    override fun configureProperties() {
        idName = R.string.food_rice_name
        idDescription = R.string.food_rice_description
        idImage = R.drawable.rice
        source.add(R.string.dungeon_name_eternal_battlefield)
        source.add(R.string.raid_name_ancient_grave_digging)
        source.add(R.string.dungeon_name_frostbite_peaks)
        price = 1L
        feedPower = 3
    }
}
