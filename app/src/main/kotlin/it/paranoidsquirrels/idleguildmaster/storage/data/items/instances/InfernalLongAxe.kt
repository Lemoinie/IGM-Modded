package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Axe

class InfernalLongAxe : Axe() {
    override fun configureProperties() {
        idName = R.string.weapon_axe_infernal_long_axe_name
        idDescription = R.string.weapon_axe_infernal_long_axe_description
        idEffect = R.string.weapon_axe_infernal_long_axe_effect
        idImage = R.drawable.infernal_long_axe
        price = 5400L
        constitution = 20
        intelligence = 35
        onTargetHitList = mutableListOf(
            StatusEffect(StatusEffectType.POISON, null, 2, 1.0),
            StatusEffect(StatusEffectType.ABLAZE, null, 2, 1.0)
        )
    }
}