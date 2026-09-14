package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class ElasticMembrane : Item() {
    override fun configureProperties() {
        idName = R.string.item_elastic_membrane_name
        idDescription = R.string.item_elastic_membrane_description
        idImage = R.drawable.elastic_membrane
        source.add(R.string.dungeon_name_barren_wastelands)
        source.add(R.string.raid_name_celestial_mothership)
        price = 2L
    }
}
