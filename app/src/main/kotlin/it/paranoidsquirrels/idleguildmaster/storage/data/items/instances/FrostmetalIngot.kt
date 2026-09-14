package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class FrostmetalIngot : Item() {
    override fun configureProperties() {
        idName = R.string.item_frostmetal_ingot_name
        idDescription = R.string.item_frostmetal_ingot_description
        idImage = R.drawable.frostmetal_ingot
        price = 18L
    }
}
