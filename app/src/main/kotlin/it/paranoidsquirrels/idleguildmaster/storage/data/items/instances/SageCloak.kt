package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor

class SageCloak : LightArmor() {
    override fun configureProperties() {
        idName = R.string.armor_light_sage_cloak_name
        idDescription = R.string.armor_light_sage_cloak_description
        idEffect = R.string.armor_light_sage_cloak_effect
        idImage = R.drawable.sage_cloak
        price = 3533L
        maxHp = 70
        intelligence = 21
        bonusExperience = 60
    }
}
