package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class CrusaderInsigna : Item() {
    override fun configureProperties() {
        idName = R.string.item_crusader_insigna_name
        idDescription = R.string.item_crusader_insigna_description
        idImage = R.drawable.crusader_insigna
        source.add(R.string.raid_name_the_cultist_rebels)
        price = 52L
    }
}
