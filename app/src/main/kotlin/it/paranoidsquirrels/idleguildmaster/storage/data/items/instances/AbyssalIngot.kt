package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class AbyssalIngot : Item() {
    override fun configureProperties() {
        idName = R.string.item_abyssal_ingot_name
        idDescription = R.string.item_abyssal_ingot_description
        idImage = R.drawable.abyssal_ingot
        price = 1811L
    }
}
