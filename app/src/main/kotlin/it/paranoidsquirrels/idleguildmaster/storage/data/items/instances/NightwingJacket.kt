package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor

class NightwingJacket : MediumArmor() {
    override fun configureProperties() {
        idName = R.string.armor_medium_nightwing_jacket_name
        idDescription = R.string.armor_medium_nightwing_jacket_description
        idImage = R.drawable.nightwing_jacket
        price = 567L
        maxHp = 140
        constitution = 7
        dexterity = 7
    }
}
