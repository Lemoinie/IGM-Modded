package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor

class MutantJacket : MediumArmor() {
    override fun configureProperties() {
        idName = R.string.armor_medium_mutant_jacket_name
        idDescription = R.string.armor_medium_mutant_jacket_description
        idImage = R.drawable.mutant_jacket
        price = 2280L
        maxHp = 316
        constitution = 6
        dexterity = 6
    }
}
