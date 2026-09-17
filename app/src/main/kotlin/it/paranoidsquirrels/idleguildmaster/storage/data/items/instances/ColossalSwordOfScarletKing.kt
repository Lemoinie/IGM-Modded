package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword

class ColossalSwordOfScarletKing : Sword() {
    override fun configureProperties() {
        idName = R.string.weapon_sword_colossal_sword_of_scarlet_king_name
        idDescription = R.string.weapon_sword_colossal_sword_of_scarlet_king_description
        idEffect = R.string.weapon_sword_colossal_sword_of_scarlet_king_effect
        idImage = R.drawable.colossal_sword_of_scarlet_king
        price = 50000L
        constitution = 124
        dexterity = 7
        bloodflameDamageBonus = 50 // Bloodflame deals +50% damage when this sword inflicts it
    }

    override fun getDamageModifier(i: Int, i2: Int, i3: Int): Int = if (i >= 120) i else i / 2
}