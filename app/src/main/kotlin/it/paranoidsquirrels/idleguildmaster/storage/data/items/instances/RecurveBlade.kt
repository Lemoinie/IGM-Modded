package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class RecurveBlade : Item() {
    override fun configureProperties() {
        idName = R.string.item_recurve_blade_name
        idDescription = R.string.item_recurve_blade_description
        idImage = R.drawable.recurve_blade
        source.add(R.string.dungeon_name_the_desert)
        source.add(R.string.raid_name_divine_archeology)
        price = 5L
    }
}
