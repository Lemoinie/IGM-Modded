package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor

class BreathtakingRobe : LightArmor() {
    override fun configureProperties() {
        idName = R.string.armor_light_breathtaking_robe_name
        idDescription = R.string.armor_light_breathtaking_robe_description
        idEffect = R.string.armor_light_breathtaking_robe_effect
        idImage = R.drawable.breathtaking_robe
        price = 1859L
        onSelfHit = StatusEffect(StatusEffectType.SILENCE, null, 2, 1.0)
        maxHp = 100
        intelligence = 25
    }
}
