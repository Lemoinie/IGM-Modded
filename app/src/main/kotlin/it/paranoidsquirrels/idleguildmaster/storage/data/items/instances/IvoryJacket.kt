package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor

class IvoryJacket : MediumArmor() {
    override fun configureProperties() {
        idName = R.string.armor_medium_ivory_jacket_name
        idDescription = R.string.armor_medium_ivory_jacket_description
        idEffect = R.string.armor_medium_ivory_jacket_effect
        idImage = R.drawable.ivory_jacket
        price = 678L
        maxHp = 90
        constitution = 8
        dexterity = 4
        criticalChance = 0.12
    }
}
