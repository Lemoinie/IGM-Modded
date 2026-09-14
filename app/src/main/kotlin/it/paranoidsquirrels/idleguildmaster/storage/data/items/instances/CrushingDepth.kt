package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow

class CrushingDepth : Bow() {
    override fun configureProperties() {
        idName = R.string.weapon_bow_crushing_depth_name
        idDescription = R.string.weapon_bow_crushing_depth_description
        idEffect = R.string.weapon_bow_crushing_depth_effect
        idImage = R.drawable.crushing_depth
        price = 4596L
        onTargetHit = StatusEffect(StatusEffectType.STUN, null, 1, 0.1)
        dexterity = 18
        intelligence = 13
    }
}
