package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor

class LaroxianRobe : LightArmor() {
    override fun configureProperties() {
        idName = R.string.armor_light_laroxian_robe_name
        idDescription = R.string.armor_light_laroxian_robe_description
        idImage = R.drawable.laroxian_robe
        price = 504L
        maxHp = 100
        intelligence = 30
    }
}
