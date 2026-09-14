package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class Algae : Food() {
    override fun configureProperties() {
        idName = R.string.food_algae_name
        idDescription = R.string.food_algae_description
        idImage = R.drawable.algae
        source.add(R.string.dungeon_name_blackwater_port)
        price = 1L
        feedPower = 1
    }
}
