package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class AlphaWolfFang : Item() {
    override fun configureProperties() {
        idName = R.string.item_alpha_wolf_fang_name
        idDescription = R.string.item_alpha_wolf_fang_description
        idImage = R.drawable.alpha_wolf_fang
        source.add(R.string.dungeon_name_enchanted_forest)
        price = 5L
    }
}
