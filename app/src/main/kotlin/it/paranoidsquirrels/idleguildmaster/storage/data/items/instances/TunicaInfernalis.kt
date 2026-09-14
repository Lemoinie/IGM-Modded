package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor

class TunicaInfernalis : LightArmor() {
    override fun configureProperties() {
        idName = R.string.armor_light_tunica_infernalis_name
        idDescription = R.string.armor_light_tunica_infernalis_description
        idEffect = R.string.armor_light_tunica_infernalis_effect
        idImage = R.drawable.tunica_infernalis
        price = 7205L
        onFireBonusDamage = 2
        maxHp = 150
        defense = 20
        magicDefense = 12
    }
}
