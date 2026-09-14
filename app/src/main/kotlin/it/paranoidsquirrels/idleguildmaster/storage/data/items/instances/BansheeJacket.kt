package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor

class BansheeJacket : MediumArmor() {
    override fun configureProperties() {
        idName = R.string.armor_medium_banshee_jacket_name
        idDescription = R.string.armor_medium_banshee_jacket_description
        idImage = R.drawable.banshee_jacket
        price = 666L
        maxHp = 180
        constitution = 9
        dexterity = 9
    }
}
