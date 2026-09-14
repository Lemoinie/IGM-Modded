package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow

class ShahuriBow : Bow() {
    override fun configureProperties() {
        idName = R.string.weapon_bow_shahuri_bow_name
        idDescription = R.string.weapon_bow_shahuri_bow_description
        idImage = R.drawable.shahuri_bow
        idEffect = R.string.weapon_bow_shahuri_bow_effect
        price = 86L
        onTargetHit = StatusEffect(StatusEffectType.STUN, null, 1, 0.05)
        dexterity = 6
        intelligence = 2
    }
}
