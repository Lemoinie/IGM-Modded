package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor

class BeltJacket : MediumArmor() {
    override fun configureProperties() {
        idName = R.string.armor_medium_belt_jacket_name
        idDescription = R.string.armor_medium_belt_jacket_description
        idImage = R.drawable.belt_jacket
        price = 312L
        maxHp = 80
        constitution = 4
        dexterity = 4
    }
}
