package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor

class DeepSeaJacket : MediumArmor() {
    override fun configureProperties() {
        idName = R.string.armor_medium_deep_sea_jacket_name
        idDescription = R.string.armor_medium_deep_sea_jacket_description
        idEffect = R.string.armor_medium_deep_sea_jacket_effect
        idImage = R.drawable.deep_sea_jacket
        price = 5883L
        maxHp = 100
        constitution = 5
        dexterity = 5
        immunityToStatus = 0.4
    }
}
