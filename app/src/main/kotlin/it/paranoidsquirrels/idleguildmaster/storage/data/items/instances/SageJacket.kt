package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor

class SageJacket : MediumArmor() {
    override fun configureProperties() {
        idName = R.string.armor_medium_sage_jacket_name
        idDescription = R.string.armor_medium_sage_jacket_description
        idEffect = R.string.armor_medium_sage_jacket_effect
        idImage = R.drawable.sage_jacket
        price = 3465L
        maxHp = 140
        constitution = 7
        dexterity = 7
        bonusExperience = 60
    }
}
