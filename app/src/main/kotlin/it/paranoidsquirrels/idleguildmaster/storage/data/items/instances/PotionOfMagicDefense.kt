package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Potion

class PotionOfMagicDefense : Potion() {
    override fun configureProperties() {
        idName = R.string.consumable_potion_of_magic_defense_name
        idDescription = R.string.consumable_potion_of_magic_defense_description
        idImage = R.drawable.potion_of_magic_defense
        source.add(R.string.raid_name_the_cultist_rebels)
        price = 10L
    }

    override fun getPotionType(): Int = 5
}
