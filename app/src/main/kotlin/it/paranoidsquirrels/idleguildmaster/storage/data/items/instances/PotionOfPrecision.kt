package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Potion

class PotionOfPrecision : Potion() {
    override fun configureProperties() {
        idName = R.string.consumable_potion_of_precision_name
        idDescription = R.string.consumable_potion_of_precision_description
        idImage = R.drawable.potion_of_precision
        source.add(R.string.dungeon_name_the_desert)
        price = 10L
    }

    override fun getPotionType(): Int = 6
}
