package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor

class CloakOfRedemption : LightArmor() {
    override fun configureProperties() {
        idName = R.string.armor_light_cloak_of_redemption_name
        idDescription = R.string.armor_light_cloak_of_redemption_description
        idEffect = R.string.armor_light_cloak_of_redemption_effect
        idImage = R.drawable.cloak_of_redemption
        price = 4203L
        onFireBonusDamage = 2
        maxHp = 110
        defense = 20
        magicDefense = 10
    }
}
