package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Potion

class PotionOfDarkness : Potion() {
    override fun configureProperties() {
        idName = R.string.consumable_potion_of_darkness_name
        idDescription = R.string.consumable_potion_of_darkness_description
        idImage = R.drawable.potion_of_darkness
        source.add(R.string.dungeon_name_obsidian_mines)
        source.add(R.string.raid_name_the_lost_expedition)
        price = 10L
    }

    override fun getPotionType(): Int = 8
}
