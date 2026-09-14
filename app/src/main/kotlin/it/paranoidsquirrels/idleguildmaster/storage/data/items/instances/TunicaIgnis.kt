package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor

class TunicaIgnis : LightArmor() {
    override fun configureProperties() {
        idName = R.string.armor_light_tunica_ignis_name
        idDescription = R.string.armor_light_tunica_ignis_description
        idEffect = R.string.armor_light_tunica_ignis_effect
        idImage = R.drawable.tunica_ignis
        price = 2370L
        onFireBonusDamage = 2
        maxHp = 100
        defense = 10
    }
}
