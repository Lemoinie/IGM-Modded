package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor

class LeatherJacket : MediumArmor() {
    override fun configureProperties() {
        idName = R.string.armor_medium_leather_jacket_name
        idDescription = R.string.armor_medium_leather_jacket_description
        idImage = R.drawable.leather_jacket
        price = 45L
        maxHp = 20
        constitution = 1
        dexterity = 1
    }
}
