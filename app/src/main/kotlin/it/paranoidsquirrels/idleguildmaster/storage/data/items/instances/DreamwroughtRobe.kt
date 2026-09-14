package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor

class DreamwroughtRobe : LightArmor() {
    override fun configureProperties() {
        idName = R.string.armor_light_dreamwrought_robe_name
        idDescription = R.string.armor_light_dreamwrought_robe_description
        idImage = R.drawable.dreamwrought_robe
        price = 690L
        maxHp = 46
        intelligence = 60
    }
}
