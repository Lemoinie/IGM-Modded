package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Axe

class OmniSever : Axe() {
    override fun configureProperties() {
        idName = R.string.weapon_axe_omni_sever_name
        idDescription = R.string.weapon_axe_omni_sever_description
        idEffect = R.string.weapon_axe_omni_sever_effect
        idImage = R.drawable.omni_sever
        price = 6800L
        constitution = 30
        intelligence = 30
        onTargetHitList = mutableListOf(
            StatusEffect(StatusEffectType.FROZEN, null, 1, 0.20),
            StatusEffect(StatusEffectType.ABLAZE, null, 1, 0.15),
            StatusEffect(StatusEffectType.STUN, null, 1, 0.10)
        )
    }
}