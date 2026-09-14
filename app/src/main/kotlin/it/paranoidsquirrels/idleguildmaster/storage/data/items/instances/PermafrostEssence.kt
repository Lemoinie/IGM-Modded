package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class PermafrostEssence : Item() {
    override fun configureProperties() {
        idName = R.string.item_permafrost_essence_name
        idDescription = R.string.item_permafrost_essence_description
        idImage = R.drawable.permafrost_essence
        price = 1008L
    }
}
