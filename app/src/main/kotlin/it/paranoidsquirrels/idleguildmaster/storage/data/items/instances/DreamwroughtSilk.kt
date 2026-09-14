package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class DreamwroughtSilk : Item() {
    override fun configureProperties() {
        idName = R.string.item_dreamwrought_silk_name
        idDescription = R.string.item_dreamwrought_silk_description
        idImage = R.drawable.dreamwrought_silk
        price = 23L
    }
}
