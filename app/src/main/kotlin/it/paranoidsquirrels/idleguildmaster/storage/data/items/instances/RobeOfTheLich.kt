package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor

class RobeOfTheLich : LightArmor() {
    override fun configureProperties() {
        idName = R.string.armor_light_robe_of_the_lich_name
        idDescription = R.string.armor_light_robe_of_the_lich_description
        idEffect = R.string.armor_light_robe_of_the_lich_effect
        idImage = R.drawable.robe_of_the_lich
        source.add(R.string.raid_name_ancient_grave_digging)
        price = 42500L
        maxHp = 75
        intelligence = 27
        lifestealWithMinion = 35
    }
}
