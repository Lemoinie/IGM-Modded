package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow

class CursedBow : Bow() {
    override fun configureProperties() {
        idName = R.string.weapon_bow_cursed_bow_name
        idDescription = R.string.weapon_bow_cursed_bow_description
        idEffect = R.string.weapon_bow_cursed_bow_effect
        idImage = R.drawable.cursed_bow
        price = 7683L
        endOfTurnAction = EndOfTurnAction.EXTRA_ATTACK
        dexterity = 26
    }
}
