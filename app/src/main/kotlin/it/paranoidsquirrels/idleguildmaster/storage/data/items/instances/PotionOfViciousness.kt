package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Potion

class PotionOfViciousness : Potion() {
    override fun configureProperties() {
        idName = R.string.consumable_potion_of_viciousness_name
        idDescription = R.string.consumable_potion_of_viciousness_description
        idImage = R.drawable.potion_of_viciousness
        source.add(R.string.raid_name_ancient_grave_digging)
        price = 10L
    }

    override fun getPotionType(): Int = 7
}
