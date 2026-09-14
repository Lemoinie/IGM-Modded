package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor

class AncientRobe : LightArmor() {
    override fun configureProperties() {
        idName = R.string.armor_light_ancient_robe_name
        idDescription = R.string.armor_light_ancient_robe_description
        idImage = R.drawable.ancient_robe
        price = 600L
        maxHp = 110
        intelligence = 33
    }
}
