package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class CelestialScraps : Item() {
    override fun configureProperties() {
        idName = R.string.item_celestial_scraps_name
        idDescription = R.string.item_celestial_scraps_description
        idImage = R.drawable.celestial_scraps
        source.add(R.string.dungeon_name_barren_wastelands)
        source.add(R.string.raid_name_celestial_mothership)
        price = 2L
    }
}
