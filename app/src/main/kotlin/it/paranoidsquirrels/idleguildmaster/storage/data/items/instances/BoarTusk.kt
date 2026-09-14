package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class BoarTusk : Item() {
    override fun configureProperties() {
        idName = R.string.item_boar_tusk_name
        idDescription = R.string.item_boar_tusk_description
        idImage = R.drawable.boar_tusk
        source.add(R.string.dungeon_name_enchanted_forest)
        price = 2L
    }
}
