package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Potion

class PotionOfConstitution : Potion() {
    override fun configureProperties() {
        idName = R.string.consumable_potion_of_constitution_name
        idDescription = R.string.consumable_potion_of_constitution_description
        idImage = R.drawable.potion_of_constitution
        source.add(R.string.dungeon_name_eternal_battlefield)
        source.add(R.string.raid_name_ancient_grave_digging)
        price = 100L
    }

    override fun getPotionType(): Int = 0
}
