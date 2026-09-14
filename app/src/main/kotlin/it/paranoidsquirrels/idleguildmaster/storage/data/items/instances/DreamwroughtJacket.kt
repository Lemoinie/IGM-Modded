package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor

class DreamwroughtJacket : MediumArmor() {
    override fun configureProperties() {
        idName = R.string.armor_medium_dreamwrought_jacket_name
        idDescription = R.string.armor_medium_dreamwrought_jacket_description
        idImage = R.drawable.dreamwrought_jacket
        price = 435L
        maxHp = 208
        constitution = 26
        dexterity = 26
    }
}
