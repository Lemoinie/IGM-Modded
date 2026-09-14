package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow

class Oblivion : Bow() {
    override fun configureProperties() {
        idName = R.string.weapon_bow_oblivion_name
        idDescription = R.string.weapon_bow_oblivion_description
        idEffect = R.string.weapon_bow_oblivion_effect
        idImage = R.drawable.oblivion
        price = 67200L
        onTargetHit = StatusEffect(StatusEffectType.STUN, null, 1, 0.14)
        dexterity = 70
        intelligence = 42
    }
}
