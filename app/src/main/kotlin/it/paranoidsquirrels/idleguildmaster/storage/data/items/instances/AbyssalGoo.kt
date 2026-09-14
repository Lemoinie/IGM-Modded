package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class AbyssalGoo : Item() {
    override fun configureProperties() {
        idName = R.string.item_abyssal_goo_name
        idDescription = R.string.item_abyssal_goo_description
        idImage = R.drawable.abyssal_goo
        price = 1193L
    }
}
