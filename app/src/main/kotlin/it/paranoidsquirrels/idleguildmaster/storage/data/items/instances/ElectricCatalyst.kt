package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class ElectricCatalyst : Item() {
    override fun configureProperties() {
        idName = R.string.item_electric_catalyst_name
        idDescription = R.string.item_electric_catalyst_description
        idImage = R.drawable.electric_catalyst
        price = 173L
    }
}
