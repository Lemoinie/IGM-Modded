package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor

class ScarletSigil : LightArmor() {
    override fun configureProperties() {
        idName = R.string.armor_light_scarlet_sigil_name
        idDescription = R.string.armor_light_scarlet_sigil_description
        idEffect = R.string.armor_light_scarlet_sigil_effect
        idImage = R.drawable.scarlet_sigil
        price = 60893L
        maxHp = 200
        intelligence = 62
        criticalChance = 0.20
        manaRegen = 2
    }
}