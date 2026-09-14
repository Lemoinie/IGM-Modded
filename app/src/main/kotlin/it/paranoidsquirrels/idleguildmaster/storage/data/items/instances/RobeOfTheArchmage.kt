package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor

class RobeOfTheArchmage : LightArmor() {
    override fun configureProperties() {
        idName = R.string.armor_light_robe_of_the_archmage_name
        idDescription = R.string.armor_light_robe_of_the_archmage_description
        idImage = R.drawable.robe_of_the_archmage
        price = 966L
        maxHp = 120
        intelligence = 40
        magicDefense = 6
    }
}
