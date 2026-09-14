package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor

class AncientJacket : MediumArmor() {
    override fun configureProperties() {
        idName = R.string.armor_medium_ancient_jacket_name
        idDescription = R.string.armor_medium_ancient_jacket_description
        idImage = R.drawable.ancient_jacket
        price = 600L
        maxHp = 220
        constitution = 11
        dexterity = 11
    }
}
