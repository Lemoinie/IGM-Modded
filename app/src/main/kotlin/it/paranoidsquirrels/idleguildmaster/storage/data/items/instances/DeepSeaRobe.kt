package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor

class DeepSeaRobe : LightArmor() {
    override fun configureProperties() {
        idName = R.string.armor_light_deep_sea_robe_name
        idDescription = R.string.armor_light_deep_sea_robe_description
        idEffect = R.string.armor_light_deep_sea_robe_effect
        idImage = R.drawable.deep_sea_robe
        price = 5505L
        maxHp = 50
        intelligence = 15
        immunityToStatus = 0.4
    }
}
