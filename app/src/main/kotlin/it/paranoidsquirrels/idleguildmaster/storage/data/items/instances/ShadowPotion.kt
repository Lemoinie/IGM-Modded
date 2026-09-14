package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class ShadowPotion : Item() {
    override fun configureProperties() {
        idName = R.string.item_shadow_potion_name
        idDescription = R.string.item_shadow_potion_description
        idImage = R.drawable.shadow_potion
        price = 591L
    }
}
