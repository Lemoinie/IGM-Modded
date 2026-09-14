package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Potion

class PotionOfHealth : Potion() {
    override fun configureProperties() {
        idName = R.string.consumable_potion_of_health_name
        idDescription = R.string.consumable_potion_of_health_description
        idImage = R.drawable.potion_of_health
        source.add(R.string.dungeon_name_frostbite_peaks)
        price = 10L
    }

    override fun getPotionType(): Int = 3
}
