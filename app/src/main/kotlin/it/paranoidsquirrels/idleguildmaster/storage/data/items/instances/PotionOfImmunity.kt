package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Potion

class PotionOfImmunity : Potion() {
    override fun configureProperties() {
        idName = R.string.consumable_potion_of_immunity_name
        idDescription = R.string.consumable_potion_of_immunity_description
        idImage = R.drawable.potion_of_immunity
        source.add(R.string.raid_name_the_slime_pond)
        price = 10L
    }

    override fun getPotionType(): Int = 9
}
