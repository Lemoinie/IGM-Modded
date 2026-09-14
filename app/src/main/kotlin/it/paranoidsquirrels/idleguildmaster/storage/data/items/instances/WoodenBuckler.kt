package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class WoodenBuckler : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_wooden_buckler_name
        idDescription = R.string.accessory_wooden_buckler_description
        idImage = R.drawable.wooden_buckler
        price = 9L
        constitution = 3
    }
}
