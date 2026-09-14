package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class CrimsonBrew : Item() {
    override fun configureProperties() {
        idName = R.string.item_crimson_brew_name
        idDescription = R.string.item_crimson_brew_description
        idImage = R.drawable.crimson_brew
        price = 360L
    }
}
