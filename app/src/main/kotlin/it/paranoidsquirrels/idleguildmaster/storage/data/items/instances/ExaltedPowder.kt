package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class ExaltedPowder : Item() {
    override fun configureProperties() {
        idName = R.string.item_exalted_powder_name
        idDescription = R.string.item_exalted_powder_description
        idImage = R.drawable.exalted_powder
        source.add(R.string.raid_name_the_cultist_rebels)
        price = 5000L
    }
}
