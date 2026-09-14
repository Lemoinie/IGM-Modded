package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor

class SpitfangJacket : MediumArmor() {
    override fun configureProperties() {
        idName = R.string.armor_medium_spitfang_jacket_name
        idDescription = R.string.armor_medium_spitfang_jacket_description
        idImage = R.drawable.spitfang_jacket
        price = 288L
        maxHp = 160
        constitution = 8
        dexterity = 8
    }
}
