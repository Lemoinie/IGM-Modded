package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class MetamorphicSand : Item() {
    override fun configureProperties() {
        idName = R.string.item_metamorphic_sand_name
        idDescription = R.string.item_metamorphic_sand_description
        idImage = R.drawable.metamorphic_sand
        source.add(R.string.dungeon_name_the_desert)
        source.add(R.string.raid_name_divine_archeology)
        price = 2L
    }
}
