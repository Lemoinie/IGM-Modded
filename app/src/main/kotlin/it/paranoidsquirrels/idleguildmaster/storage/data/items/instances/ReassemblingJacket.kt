package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor

class ReassemblingJacket : MediumArmor() {
    override fun configureProperties() {
        idName = R.string.armor_medium_reassembling_jacket_name
        idDescription = R.string.armor_medium_reassembling_jacket_description
        idEffect = R.string.armor_medium_reassembling_jacket_effect
        idImage = R.drawable.reassembling_jacket
        price = 2088L
        immunityToStatus = 0.3
        regeneration = 40
        maxHp = 200
        constitution = 25
        dexterity = 7
    }
}
