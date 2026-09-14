package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class PrimordialEssence : Item() {
    override fun configureProperties() {
        idName = R.string.item_primordial_essence_name
        idDescription = R.string.item_primordial_essence_description
        idImage = R.drawable.primordial_essence
        source.add(R.string.dungeon_name_enchanted_forest)
        price = 30L
    }
}
