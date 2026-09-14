package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class LargeIris : Item() {
    override fun configureProperties() {
        idName = R.string.item_large_iris_name
        idDescription = R.string.item_large_iris_description
        idImage = R.drawable.large_iris
        source.add(R.string.dungeon_name_obsidian_mines)
        price = 17L
    }
}
