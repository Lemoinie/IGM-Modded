package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class AncientSeed : Item() {
    override fun configureProperties() {
        idName = R.string.item_ancient_seed_name
        idDescription = R.string.item_ancient_seed_description
        idImage = R.drawable.ancient_seed
        source.add(R.string.dungeon_name_enchanted_forest)
        price = 20L
    }
}
