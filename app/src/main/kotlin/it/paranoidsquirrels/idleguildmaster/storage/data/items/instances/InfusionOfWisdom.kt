package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class InfusionOfWisdom : Item() {
    override fun configureProperties() {
        idName = R.string.item_infusion_of_wisdom_name
        idDescription = R.string.item_infusion_of_wisdom_description
        idImage = R.drawable.infusion_of_wisdom
        price = 1965L
    }
}
