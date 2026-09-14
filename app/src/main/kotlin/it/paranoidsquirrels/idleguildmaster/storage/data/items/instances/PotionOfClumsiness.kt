package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable

class PotionOfClumsiness : Consumable() {
    override fun configureProperties() {
        idName = R.string.consumable_potion_of_clumsiness_name
        idDescription = R.string.consumable_potion_of_clumsiness_description
        idImage = R.drawable.potion_of_clumsiness
        source.add(R.string.raid_name_kaunis)
        price = 10000L
    }

    override fun printConsumeImage(): Int = R.drawable.consume_potion
}
