package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class PoisonousFlesh : Item() {
    override fun configureProperties() {
        idName = R.string.item_poisonous_flesh_name
        idDescription = R.string.item_poisonous_flesh_description
        idImage = R.drawable.poisonous_flesh
        source.add(R.string.dungeon_name_lost_lands)
        price = 42L
    }
}
