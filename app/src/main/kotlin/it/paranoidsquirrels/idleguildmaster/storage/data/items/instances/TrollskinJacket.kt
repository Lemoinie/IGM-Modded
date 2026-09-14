package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor

class TrollskinJacket : MediumArmor() {
    override fun configureProperties() {
        idName = R.string.armor_medium_trollskin_jacket_name
        idDescription = R.string.armor_medium_trollskin_jacket_description
        idEffect = R.string.armor_medium_trollskin_jacket_effect
        idImage = R.drawable.trollskin_jacket
        price = 306L
        maxHp = 120
        constitution = 5
        dexterity = 5
        regeneration = 6
    }
}
