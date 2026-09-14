package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class EssenceOfCorruption : Item() {
    override fun configureProperties() {
        idName = R.string.item_essence_of_corruption_name
        idDescription = R.string.item_essence_of_corruption_description
        idImage = R.drawable.essence_of_corruption
        price = 180L
    }
}
