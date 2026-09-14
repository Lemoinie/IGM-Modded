package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class DinoRibs : Food() {
    override fun configureProperties() {
        idName = R.string.food_dino_ribs_name
        idDescription = R.string.food_dino_ribs_description
        idImage = R.drawable.dino_ribs
        source.add(R.string.dungeon_name_lost_lands)
        price = 20L
        feedPower = 30
    }
}
