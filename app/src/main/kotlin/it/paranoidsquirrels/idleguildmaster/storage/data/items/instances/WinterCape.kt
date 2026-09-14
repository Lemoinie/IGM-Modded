package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor

class WinterCape : LightArmor() {
    override fun configureProperties() {
        idName = R.string.armor_light_winter_cape_name
        idDescription = R.string.armor_light_winter_cape_description
        idImage = R.drawable.winter_cape
        price = 486L
        maxHp = 60
        intelligence = 18
    }
}
