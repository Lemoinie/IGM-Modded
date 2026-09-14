package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class AnimatedScraps : Item() {
    override fun configureProperties() {
        idName = R.string.item_animated_scraps_name
        idDescription = R.string.item_animated_scraps_description
        idImage = R.drawable.animated_scraps
        source.add(R.string.dungeon_name_hidden_city_of_larox)
        price = 2L
    }
}
