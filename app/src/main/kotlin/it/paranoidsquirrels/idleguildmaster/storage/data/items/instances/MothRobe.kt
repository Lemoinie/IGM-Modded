package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor

class MothRobe : LightArmor() {
    override fun configureProperties() {
        idName = R.string.armor_light_moth_robe_name
        idDescription = R.string.armor_light_moth_robe_description
        idImage = R.drawable.moth_robe
        price = 783L
        maxHp = 80
        intelligence = 24
    }
}
