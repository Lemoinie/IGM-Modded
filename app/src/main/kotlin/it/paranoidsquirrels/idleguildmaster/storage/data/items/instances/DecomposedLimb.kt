package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword

class DecomposedLimb : Sword() {
    override fun configureProperties() {
        idName = R.string.weapon_sword_decomposed_limb_name
        idDescription = R.string.weapon_sword_decomposed_limb_description
        idImage = R.drawable.decomposed_limb
        price = 0L
        constitution = 1
    }
}
