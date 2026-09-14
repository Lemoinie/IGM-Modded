package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor

class WurmscalesJacket : MediumArmor() {
    override fun configureProperties() {
        idName = R.string.armor_medium_wurmscales_jacket_name
        idDescription = R.string.armor_medium_wurmscales_jacket_description
        idImage = R.drawable.wurmscales_jacket
        price = 45L
        maxHp = 40
        constitution = 2
        dexterity = 2
    }
}
