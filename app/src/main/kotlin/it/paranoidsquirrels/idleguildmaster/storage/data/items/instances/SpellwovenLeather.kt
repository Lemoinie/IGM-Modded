package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class SpellwovenLeather : Item() {
    override fun configureProperties() {
        idName = R.string.item_spellwoven_leather_name
        idDescription = R.string.item_spellwoven_leather_description
        idImage = R.drawable.spellwoven_leather
        price = 6L
    }
}
