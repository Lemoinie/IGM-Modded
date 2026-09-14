package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class SpellwovenHide : Item() {
    override fun configureProperties() {
        idName = R.string.item_spellwoven_hide_name
        idDescription = R.string.item_spellwoven_hide_description
        idImage = R.drawable.spellwoven_hide
        source.add(R.string.dungeon_name_hidden_city_of_larox)
        price = 2L
    }
}
