package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class GiantMothWing : Item() {
    override fun configureProperties() {
        idName = R.string.item_giant_moth_wing_name
        idDescription = R.string.item_giant_moth_wing_description
        idImage = R.drawable.giant_moth_wing
        source.add(R.string.dungeon_name_the_southern_grove)
        price = 3L
    }
}
