package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class WerewolfFang : Item() {
    override fun configureProperties() {
        idName = R.string.item_werewolf_fang_name
        idDescription = R.string.item_werewolf_fang_description
        idImage = R.drawable.werewolf_fang
        source.add(R.string.dungeon_name_enchanted_forest)
        price = 24L
    }
}
