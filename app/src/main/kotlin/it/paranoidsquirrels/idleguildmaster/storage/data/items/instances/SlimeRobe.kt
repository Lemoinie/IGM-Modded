package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor

class SlimeRobe : LightArmor() {
    override fun configureProperties() {
        idName = R.string.armor_light_slime_robe_name
        idDescription = R.string.armor_light_slime_robe_description
        idImage = R.drawable.slime_robe
        price = 630L
        maxHp = 80
        defense = 5
    }
}
