package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor

class AbsoluteZero : HeavyArmor() {
    override fun configureProperties() {
        idName = R.string.armor_heavy_absolute_zero_name
        idDescription = R.string.armor_heavy_absolute_zero_description
        idEffect = R.string.armor_heavy_absolute_zero_effect
        idImage = R.drawable.absolute_zero
        price = 8889L
        onSelfHit = StatusEffect(StatusEffectType.FROZEN, null, 1, 1.0)
        maxHp = 310
        defense = 16
    }
}
