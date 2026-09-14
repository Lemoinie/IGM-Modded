package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor

class SilkRobe : LightArmor() {
    override fun configureProperties() {
        idName = R.string.armor_light_silk_robe_name
        idDescription = R.string.armor_light_silk_robe_description
        idImage = R.drawable.silk_robe
        price = 216L
        maxHp = 40
        intelligence = 12
    }
}
