package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Axe

class Zapper : Axe() {
    override fun configureProperties() {
        idName = R.string.weapon_axe_zapper_name
        idDescription = R.string.weapon_axe_zapper_description
        idEffect = R.string.weapon_axe_zapper_effect
        idImage = R.drawable.zapper
        price = 2100L
        constitution = 19
        dexterity = 10
        intelligence = 19
        onTargetHit = StatusEffect(StatusEffectType.STUN, null, 1, 0.10)
    }
}