package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Axe

class AbhorrentLongAxe : Axe() {
    override fun configureProperties() {
        idName = R.string.weapon_axe_abhorrent_long_axe_name
        idDescription = R.string.weapon_axe_abhorrent_long_axe_description
        idEffect = R.string.weapon_axe_abhorrent_long_axe_effect
        idImage = R.drawable.abhorrent_long_axe
        price = 9500L
        constitution = 30
        intelligence = 45
        onTargetHitList = mutableListOf(
            StatusEffect(StatusEffectType.POISON, null, 2, 1.0),
            StatusEffect(StatusEffectType.ABLAZE, null, 2, 1.0),
            StatusEffect(StatusEffectType.STUN, null, 1, 0.10),
            StatusEffect(StatusEffectType.SILENCE, null, 1, 0.10)
        )
    }
}