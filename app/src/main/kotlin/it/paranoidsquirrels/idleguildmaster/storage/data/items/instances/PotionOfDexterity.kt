package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Potion

class PotionOfDexterity : Potion() {
    override fun configureProperties() {
        idName = R.string.consumable_potion_of_dexterity_name
        idDescription = R.string.consumable_potion_of_dexterity_description
        idImage = R.drawable.potion_of_dexterity
        source.add(R.string.dungeon_name_blackwater_port)
        price = 10L
    }

    override fun getPotionType(): Int = 1
}
