package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class GoldScraps : Item() {
    override fun configureProperties() {
        idName = R.string.item_gold_scraps_name
        idDescription = R.string.item_gold_scraps_description
        idImage = R.drawable.gold_scraps
        source.add(R.string.dungeon_name_the_golden_city)
        source.add(R.string.raid_name_imperial_rescue)
        price = 5L
    }
}
