package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow

class AscendedBow : Bow() {
    override fun configureProperties() {
        idName = R.string.weapon_bow_ascended_bow_name
        idDescription = R.string.weapon_bow_ascended_bow_description
        idEffect = R.string.weapon_bow_ascended_bow_effect
        idImage = R.drawable.ascended_bow
        price = 279L
        onTargetHit = StatusEffect(StatusEffectType.STUN, null, 1, 0.075)
        dexterity = 8
        intelligence = 6
    }
}
