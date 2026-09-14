package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class ChainOfRedemption : Item() {
    override fun configureProperties() {
        idName = R.string.item_chain_of_redemption_name
        idDescription = R.string.item_chain_of_redemption_description
        idImage = R.drawable.chain_of_redemption
        price = 108L
    }
}
