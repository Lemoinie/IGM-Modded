package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class Scanner : Item() {
    override fun configureProperties() {
        idName = R.string.item_scanner_name
        idDescription = R.string.item_scanner_description
        idImage = R.drawable.scanner
        source.add(R.string.dungeon_name_barren_wastelands)
        source.add(R.string.raid_name_celestial_mothership)
        price = 90L
    }
}
