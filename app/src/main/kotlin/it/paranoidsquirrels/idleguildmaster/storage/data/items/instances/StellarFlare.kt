package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow

class StellarFlare : Bow() {
    override fun configureProperties() {
        idName = R.string.weapon_bow_stellar_flare_name
        idDescription = R.string.weapon_bow_stellar_flare_description
        idEffect = R.string.weapon_bow_stellar_flare_effect
        idImage = R.drawable.stellar_flare
        price = 37350L
        onTargetHit = StatusEffect(StatusEffectType.STUN, null, 1, 0.13)
        dexterity = 55
        intelligence = 34
    }
}
