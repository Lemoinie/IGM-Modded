package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class Salt : Food() {
    override fun configureProperties() {
        idName = R.string.food_salt_name
        idDescription = R.string.food_salt_description
        idImage = R.drawable.salt
        source.add(R.string.dungeon_name_eternal_battlefield)
        source.add(R.string.raid_name_ancient_grave_digging)
        source.add(R.string.dungeon_name_the_golden_city)
        source.add(R.string.raid_name_imperial_rescue)
        price = 5L
        feedPower = 1
    }
}
