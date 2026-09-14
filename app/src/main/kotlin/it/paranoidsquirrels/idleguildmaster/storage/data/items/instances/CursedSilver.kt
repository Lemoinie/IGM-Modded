package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class CursedSilver : Item() {
    override fun configureProperties() {
        idName = R.string.item_cursed_silver_name
        idDescription = R.string.item_cursed_silver_description
        idImage = R.drawable.cursed_silver
        source.add(R.string.raid_name_ancient_grave_digging)
        price = 160L
    }
}
