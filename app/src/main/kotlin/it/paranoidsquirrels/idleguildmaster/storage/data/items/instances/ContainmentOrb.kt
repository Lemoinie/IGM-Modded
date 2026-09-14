package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class ContainmentOrb : Item() {
    override fun configureProperties() {
        idName = R.string.item_containment_orb_name
        idDescription = R.string.item_containment_orb_description
        idImage = R.drawable.containment_orb
        price = 210L
    }
}
