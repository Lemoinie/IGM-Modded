package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor

class CottontailJacket : MediumArmor() {
    override fun configureProperties() {
        idName = R.string.armor_medium_cottontail_jacket_name
        idDescription = R.string.armor_medium_cottontail_jacket_description
        idEffect = R.string.armor_medium_cottontail_jacket_effect
        idImage = R.drawable.cottontail_jacket
        price = 345L
        maxHp = 20
        constitution = 1
        dexterity = 1
        bonusExperience = 35
    }
}
