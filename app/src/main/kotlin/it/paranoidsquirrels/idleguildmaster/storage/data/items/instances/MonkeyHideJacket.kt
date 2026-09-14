package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor

class MonkeyHideJacket : MediumArmor() {
    override fun configureProperties() {
        idName = R.string.armor_medium_monkey_hide_jacket_name
        idDescription = R.string.armor_medium_monkey_hide_jacket_description
        idImage = R.drawable.monkey_hide_jacket
        price = 828L
        maxHp = 100
        constitution = 5
        dexterity = 5
    }
}
