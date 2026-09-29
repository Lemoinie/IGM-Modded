package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Axe

class BerserkersAxe : Axe() {
    override fun configureProperties() {
        idName = R.string.weapon_axe_berserkers_axe_name
        idDescription = R.string.weapon_axe_berserkers_axe_description
        idEffect = R.string.weapon_axe_berserkers_axe_effect
        idImage = R.drawable.berserkers_axe
        price = 2600L
        constitution = 40
        endOfTurnAction = EndOfTurnAction.EXTRA_ATTACK
        endOfTurnActionProbability = 0.10
    }
}