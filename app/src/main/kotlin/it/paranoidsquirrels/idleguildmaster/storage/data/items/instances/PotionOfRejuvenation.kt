package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable

class PotionOfRejuvenation : Consumable() {
    override fun configureProperties() {
        idName = R.string.consumable_potion_of_rejuvenation_name
        idDescription = R.string.consumable_potion_of_rejuvenation_description
        idImage = R.drawable.potion_of_rejuvenation
        price = 26L
    }

    override fun printConsumeImage(): Int = R.drawable.consume_potion_of_rejuvenation
}
