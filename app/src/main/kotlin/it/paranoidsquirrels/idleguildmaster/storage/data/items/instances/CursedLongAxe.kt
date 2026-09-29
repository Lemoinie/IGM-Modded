package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Axe

class CursedLongAxe : Axe() {
    override fun configureProperties() {
        idName = R.string.weapon_axe_cursed_long_axe_name
        idDescription = R.string.weapon_axe_cursed_long_axe_description
        idEffect = R.string.weapon_axe_cursed_long_axe_effect
        idImage = R.drawable.cursed_long_axe
        price = 2800L
        constitution = 10
        intelligence = 25
        onTargetHit = StatusEffect(StatusEffectType.POISON, null, 2, 1.0)
    }
}