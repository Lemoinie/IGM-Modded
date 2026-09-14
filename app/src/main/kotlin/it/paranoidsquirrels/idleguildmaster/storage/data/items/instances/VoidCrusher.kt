package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword

class VoidCrusher : Sword() {
    override fun configureProperties() {
        idName = R.string.weapon_sword_void_crusher_name
        idDescription = R.string.weapon_sword_void_crusher_description
        idEffect = R.string.weapon_sword_void_crusher_effect
        idImage = R.drawable.void_crusher
        price = 21750L
        constitution = 100
    }

    override fun getDamageModifier(i: Int, i2: Int, i3: Int): Int = if (i >= 275) i else i / 2
}
