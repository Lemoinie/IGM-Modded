package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class FluxLimiter : Item() {
    override fun configureProperties() {
        idName = R.string.item_flux_limiter_name
        idDescription = R.string.item_flux_limiter_description
        idImage = R.drawable.flux_limiter
        source.add(R.string.dungeon_name_barren_wastelands)
        source.add(R.string.raid_name_celestial_mothership)
        price = 38L
    }
}
