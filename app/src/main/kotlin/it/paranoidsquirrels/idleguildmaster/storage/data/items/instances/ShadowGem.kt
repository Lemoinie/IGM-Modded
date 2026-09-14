package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class ShadowGem : Item() {
    override fun configureProperties() {
        idName = R.string.item_shadow_gem_name
        idDescription = R.string.item_shadow_gem_description
        idImage = R.drawable.shadow_gem
        source.add(R.string.dungeon_name_obsidian_mines)
        source.add(R.string.raid_name_the_lost_expedition)
        price = 34L
    }
}
