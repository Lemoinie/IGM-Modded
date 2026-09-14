package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class FreshSalmon : Food() {
    override fun configureProperties() {
        idName = R.string.food_fresh_salmon_name
        idDescription = R.string.food_fresh_salmon_description
        idImage = R.drawable.fresh_salmon
        source.add(R.string.dungeon_name_blackwater_port)
        price = 10L
        feedPower = 18
    }
}
