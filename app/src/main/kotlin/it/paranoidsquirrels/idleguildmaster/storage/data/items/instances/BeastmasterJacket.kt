package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor

class BeastmasterJacket : MediumArmor() {
    override fun configureProperties() {
        idName = R.string.armor_medium_beastmaster_jacket_name
        idDescription = R.string.armor_medium_beastmaster_jacket_description
        idEffect = R.string.armor_medium_beastmaster_jacket_effect
        idImage = R.drawable.beastmaster_jacket
        price = 2250L
        maxHp = 220
        constitution = 10
        dexterity = 10
        livingCompanionBonusDamage = 50
    }
}
