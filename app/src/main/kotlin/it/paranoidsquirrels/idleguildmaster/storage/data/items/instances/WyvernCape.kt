package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor

class WyvernCape : LightArmor() {
    override fun configureProperties() {
        idName = R.string.armor_light_wyvern_cape_name
        idDescription = R.string.armor_light_wyvern_cape_description
        idEffect = R.string.armor_light_wyvern_cape_effect
        idImage = R.drawable.wyvern_cape
        price = 630L
        maxHp = 80
        intelligence = 15
        healingModifier = 0.15
    }
}
