package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class LivingVine : Item() {
    override fun configureProperties() {
        idName = R.string.item_living_vine_name
        idDescription = R.string.item_living_vine_description
        idImage = R.drawable.living_vine
        source.add(R.string.dungeon_name_the_southern_grove)
        price = 18L
    }
}
