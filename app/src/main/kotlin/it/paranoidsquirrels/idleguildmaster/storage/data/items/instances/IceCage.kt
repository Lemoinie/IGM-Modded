package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor

class IceCage : HeavyArmor() {
    override fun configureProperties() {
        idName = R.string.armor_heavy_ice_cage_name
        idDescription = R.string.armor_heavy_ice_cage_description
        idEffect = R.string.armor_heavy_ice_cage_effect
        idImage = R.drawable.ice_cage
        price = 3926L
        onSelfHit = StatusEffect(StatusEffectType.FROZEN, null, 1, 1.0)
        maxHp = 215
        defense = 16
    }
}
