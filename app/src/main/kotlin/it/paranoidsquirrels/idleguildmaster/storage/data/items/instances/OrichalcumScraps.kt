package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class OrichalcumScraps : Item() {
    override fun configureProperties() {
        idName = R.string.item_orichalcum_scraps_name
        idDescription = R.string.item_orichalcum_scraps_description
        idImage = R.drawable.orichalcum_scraps
        source.add(R.string.raid_name_kaunis)
        price = 5L
    }
}
