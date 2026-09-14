package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class OrbOfEctoplasm : Item() {
    override fun configureProperties() {
        idName = R.string.item_orb_of_ectoplasm_name
        idDescription = R.string.item_orb_of_ectoplasm_description
        idImage = R.drawable.orb_of_ectoplasm
        source.add(R.string.dungeon_name_eternal_battlefield)
        price = 50L
    }
}
