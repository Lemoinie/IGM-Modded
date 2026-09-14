package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class PrehistoricMixture : Item() {
    override fun configureProperties() {
        idName = R.string.item_prehistoric_mixture_name
        idDescription = R.string.item_prehistoric_mixture_description
        idImage = R.drawable.prehistoric_mixture
        source.add(R.string.dungeon_name_lost_lands)
        price = 315L
    }
}
