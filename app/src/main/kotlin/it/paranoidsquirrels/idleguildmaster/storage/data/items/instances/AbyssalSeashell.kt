package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class AbyssalSeashell : Item() {
    override fun configureProperties() {
        idName = R.string.item_abyssal_seashell_name
        idDescription = R.string.item_abyssal_seashell_description
        idImage = R.drawable.abyssal_seashell
        source.add(R.string.dungeon_name_blackwater_port)
        price = 12L
    }
}
