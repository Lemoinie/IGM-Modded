package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class UnstableGem : Item() {
    override fun configureProperties() {
        idName = R.string.item_unstable_gem_name
        idDescription = R.string.item_unstable_gem_description
        idImage = R.drawable.unstable_gem
        source.add(R.string.dungeon_name_hidden_city_of_larox)
        price = 10L
    }
}
