package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor

class GhostRabbitCloak : LightArmor() {
    override fun configureProperties() {
        idName = R.string.armor_light_ghost_rabbit_cloak_name
        idDescription = R.string.armor_light_ghost_rabbit_cloak_description
        idEffect = R.string.armor_light_ghost_rabbit_cloak_effect
        idImage = R.drawable.ghost_rabbit_cloak
        price = 390L
        maxHp = 30
        intelligence = 9
        bonusExperience = 35
    }
}
