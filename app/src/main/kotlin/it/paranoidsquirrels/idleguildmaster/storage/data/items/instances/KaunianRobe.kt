package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor

class KaunianRobe : LightArmor() {
    override fun configureProperties() {
        idName = R.string.armor_light_kaunian_robe_name
        idDescription = R.string.armor_light_kaunian_robe_description
        idImage = R.drawable.kaunian_robe
        price = 900L
        maxHp = 206
        intelligence = 20
    }
}
