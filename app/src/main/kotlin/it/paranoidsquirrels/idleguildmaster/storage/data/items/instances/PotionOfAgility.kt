package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Potion

class PotionOfAgility : Potion() {
    override fun configureProperties() {
        idName = R.string.consumable_potion_of_agility_name
        idDescription = R.string.consumable_potion_of_agility_description
        idImage = R.drawable.potion_of_agility
        source.add(R.string.dungeon_name_the_southern_grove)
        price = 10L
    }

    override fun getPotionType(): Int = 10
}
