package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor

class FeatherRobe : LightArmor() {
    override fun configureProperties() {
        idName = R.string.armor_light_feather_robe_name
        idDescription = R.string.armor_light_feather_robe_description
        idImage = R.drawable.feather_robe
        price = 72L
        maxHp = 20
        intelligence = 6
    }
}
