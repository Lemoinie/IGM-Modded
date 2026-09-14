package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class FireCatalyst : Item() {
    override fun configureProperties() {
        idName = R.string.item_fire_catalyst_name
        idDescription = R.string.item_fire_catalyst_description
        idImage = R.drawable.fire_catalyst
        price = 173L
    }
}
