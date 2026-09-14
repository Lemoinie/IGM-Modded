package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Potion

class PotionOfIntelligence : Potion() {
    override fun configureProperties() {
        idName = R.string.consumable_potion_of_intelligence_name
        idDescription = R.string.consumable_potion_of_intelligence_description
        idImage = R.drawable.potion_of_intelligence
        source.add(R.string.dungeon_name_the_golden_city)
        source.add(R.string.raid_name_imperial_rescue)
        price = 10L
    }

    override fun getPotionType(): Int = 2
}
