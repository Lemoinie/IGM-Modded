package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor

class SpellwovenJacket : MediumArmor() {
    override fun configureProperties() {
        idName = R.string.armor_medium_spellwoven_jacket_name
        idDescription = R.string.armor_medium_spellwoven_jacket_description
        idImage = R.drawable.spellwoven_jacket
        price = 741L
        maxHp = 200
        constitution = 10
        dexterity = 10
    }
}
