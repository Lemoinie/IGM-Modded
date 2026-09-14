package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor

class ClothRobe : LightArmor() {
    override fun configureProperties() {
        idName = R.string.armor_light_cloth_robe_name
        idDescription = R.string.armor_light_cloth_robe_description
        idImage = R.drawable.cloth_robe
        price = 54L
        maxHp = 10
        intelligence = 3
    }
}
