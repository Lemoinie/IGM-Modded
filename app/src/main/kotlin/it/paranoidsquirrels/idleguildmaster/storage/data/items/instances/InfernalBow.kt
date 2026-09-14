package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow

class InfernalBow : Bow() {
    override fun configureProperties() {
        idName = R.string.weapon_bow_infernal_bow_name
        idDescription = R.string.weapon_bow_infernal_bow_description
        idEffect = R.string.weapon_bow_infernal_bow_effect
        idImage = R.drawable.infernal_bow
        price = 13400L
        endOfTurnAction = EndOfTurnAction.EXTRA_ATTACK
        dexterity = 38
    }
}
