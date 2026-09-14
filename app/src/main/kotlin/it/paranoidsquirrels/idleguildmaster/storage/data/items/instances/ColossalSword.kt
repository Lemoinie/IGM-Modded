package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword

class ColossalSword : Sword() {
    override fun configureProperties() {
        idName = R.string.weapon_sword_colossal_sword_name
        idDescription = R.string.weapon_sword_colossal_sword_description
        idEffect = R.string.weapon_sword_colossal_sword_effect
        idImage = R.drawable.colossal_sword
        source.add(R.string.raid_name_the_cultist_rebels)
        price = 10000L
        constitution = 50
    }

    override fun getDamageModifier(i: Int, i2: Int, i3: Int): Int = if (i >= 120) i else i / 2
}
