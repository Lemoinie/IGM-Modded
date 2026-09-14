package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor

class ExoticRobe : LightArmor() {
    override fun configureProperties() {
        idName = R.string.armor_light_exotic_robe_name
        idDescription = R.string.armor_light_exotic_robe_description
        idImage = R.drawable.exotic_robe
        price = 1350L
        maxHp = 50
        intelligence = 15
    }
}
