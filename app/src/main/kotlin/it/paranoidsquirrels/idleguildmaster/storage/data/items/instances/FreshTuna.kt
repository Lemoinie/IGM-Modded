package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class FreshTuna : Food() {
    override fun configureProperties() {
        idName = R.string.food_fresh_tuna_name
        idDescription = R.string.food_fresh_tuna_description
        idImage = R.drawable.fresh_tuna
        source.add(R.string.dungeon_name_blackwater_port)
        price = 15L
        feedPower = 25
    }
}
