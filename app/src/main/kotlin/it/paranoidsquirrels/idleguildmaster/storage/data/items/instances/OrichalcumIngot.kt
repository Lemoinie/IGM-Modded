package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class OrichalcumIngot : Item() {
    override fun configureProperties() {
        idName = R.string.item_orichalcum_ingot_name
        idDescription = R.string.item_orichalcum_ingot_description
        idImage = R.drawable.orichalcum_ingot
        price = 30L
    }
}
