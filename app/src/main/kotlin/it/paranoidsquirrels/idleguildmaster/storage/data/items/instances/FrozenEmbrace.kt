package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor

class FrozenEmbrace : HeavyArmor() {
    override fun configureProperties() {
        idName = R.string.armor_heavy_frozen_embrace_name
        idDescription = R.string.armor_heavy_frozen_embrace_description
        idEffect = R.string.armor_heavy_frozen_embrace_effect
        idImage = R.drawable.frozen_embrace
        price = 2457L
        onSelfHit = StatusEffect(StatusEffectType.FROZEN, null, 1, 1.0)
        maxHp = 200
        defense = 12
    }
}
