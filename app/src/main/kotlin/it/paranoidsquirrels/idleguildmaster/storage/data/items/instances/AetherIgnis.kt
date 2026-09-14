package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class AetherIgnis : Item() {
    override fun configureProperties() {
        idName = R.string.item_aether_ignis_name
        idDescription = R.string.item_aether_ignis_description
        idImage = R.drawable.aether_ignis
        source.add(R.string.dungeon_name_barren_wastelands)
        source.add(R.string.raid_name_celestial_mothership)
        price = 19L
    }
}
