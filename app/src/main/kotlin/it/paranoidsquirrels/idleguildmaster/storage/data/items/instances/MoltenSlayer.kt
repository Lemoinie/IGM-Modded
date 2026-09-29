package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Axe

class MoltenSlayer : Axe() {
    override fun configureProperties() {
        idName = R.string.weapon_axe_molten_slayer_name
        idDescription = R.string.weapon_axe_molten_slayer_description
        idEffect = R.string.weapon_axe_molten_slayer_effect
        idImage = R.drawable.molten_slayer
        price = 5200L
        constitution = 50
        endOfTurnAction = EndOfTurnAction.EXTRA_ATTACK
        endOfTurnActionProbability = 0.10
        onTargetHit = StatusEffect(StatusEffectType.ABLAZE, null, 1, 1.0)
    }
}