package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class PrimevalScale : Item() {
    override fun configureProperties() {
        idName = R.string.item_primeval_scale_name
        idDescription = R.string.item_primeval_scale_description
        idImage = R.drawable.primeval_scale
        source.add(R.string.dungeon_name_the_southern_grove)
        price = 90L
    }
}
