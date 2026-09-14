package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor

class UndeadJacket : MediumArmor() {
    override fun configureProperties() {
        idName = R.string.armor_medium_undead_jacket_name
        idDescription = R.string.armor_medium_undead_jacket_description
        idImage = R.drawable.undead_jacket
        price = 72L
        maxHp = 60
        constitution = 3
        dexterity = 3
    }
}
