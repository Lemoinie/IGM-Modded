package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor

class CursedJacket : MediumArmor() {
    override fun configureProperties() {
        idName = R.string.armor_medium_cursed_jacket_name
        idDescription = R.string.armor_medium_cursed_jacket_description
        idEffect = R.string.armor_medium_cursed_jacket_effect
        idImage = R.drawable.cursed_jacket
        price = 1440L
        maxHp = 100
        constitution = 10
        criticalDamage = 0.5
    }
}
