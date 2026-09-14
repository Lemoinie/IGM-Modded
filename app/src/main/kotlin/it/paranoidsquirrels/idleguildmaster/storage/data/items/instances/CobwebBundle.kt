package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class CobwebBundle : Item() {
    override fun configureProperties() {
        idName = R.string.item_cobweb_bundle_name
        idDescription = R.string.item_cobweb_bundle_description
        idImage = R.drawable.cobweb_bundle
        source.add(R.string.dungeon_name_obsidian_mines)
        price = 3L
    }
}
