package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor

class SlimeJacket : MediumArmor() {
    override fun configureProperties() {
        idName = R.string.armor_medium_slime_jacket_name
        idDescription = R.string.armor_medium_slime_jacket_description
        idImage = R.drawable.slime_jacket
        price = 630L
        maxHp = 130
        defense = 5
    }
}
